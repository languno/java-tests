package lambda.stream;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitiveStreams {
    public static void main(String[] args) {

        // int, short, byte, char
        IntStream intStream = IntStream.iterate(1, x -> x * 2);

        // long
        LongStream longStream = LongStream.of(1L, 2L, 3L);

        // double, float
        DoubleStream doubleStream = DoubleStream.generate(Math::random);

        intStream.limit(3).forEach(System.out::println);
        longStream.limit(3).forEach(System.out::println);
        doubleStream.limit(3).forEach(System.out::println);
    }
}
