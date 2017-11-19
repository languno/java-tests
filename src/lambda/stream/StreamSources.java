package lambda.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamSources {
    public static void main(String[] args) {

        Stream<Integer> intStream = Stream.of(1, 2, 3);
        List<Integer> intList = Arrays.asList(1, 2, 3);
        Stream<Integer> intStream2 = intList.stream();

        Stream<Double> randoms = Stream.generate(Math::random);
        Stream<Integer> oddNumbers = Stream.iterate(1, n -> n + 1);
    }
}
