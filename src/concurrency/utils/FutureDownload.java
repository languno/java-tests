package concurrency.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.apache.commons.io.IOUtils;

public class FutureDownload {
	
	private final ExecutorService pool = Executors.newFixedThreadPool(10);
	
	public FutureDownload() {

		try {
			System.out.println("Start downloading...");
			Future<String> contentFuture = startDownloading(new URL("http://www.intrakey.de"));
			
			System.out.println("Wait for result...");
			String content = contentFuture.get();
			
			System.out.println(content);
		} catch (Exception e) {
			System.out.println("Error downloading: " + e);
		}
	}
	
	public Future<String> startDownloading(final URL url) throws IOException {
	    return pool.submit(new Callable<String>() {
	        @Override
	        public String call() throws Exception {
	            try (InputStream input = url.openStream()) {
	                return IOUtils.toString(input, StandardCharsets.UTF_8);
	            }
	        }
	    });
	}	
	
	public static void main(String[] args) {
		new FutureDownload();
	}
}
