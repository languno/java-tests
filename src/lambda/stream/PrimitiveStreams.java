package lambda.stream;

import java.util.OptionalDouble;
import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class PrimitiveStreams {
    public static void main(String[] args) {

        // int, short, byte, char
        IntStream intStream = IntStream.iterate(1, x -> x * 2);

        // long
        LongStream longStream = LongStream.of(1L, 2L, 3L, 4L);

        // double, float
        DoubleStream doubleStream = DoubleStream.generate(Math::random);

        int intSum = intStream.limit(3).sum();
        System.out.println("int sum: " + intSum);

        OptionalDouble od = longStream.average();
        System.out.println("double avg: " + od.getAsDouble());

        System.out.println("double randoms");
        doubleStream.limit(3).forEach(System.out::println);

        System.out.println("range 0-5:");
        IntStream.range(0, 5).forEach(System.out::println);

        System.out.println("rangeClosed 0-5:");
        IntStream.rangeClosed(0, 5).forEach(System.out::println);

        System.out.println("Random() ints:");
        new Random().ints().limit(3).forEach(System.out::println);

        // map to primitive streams
        System.out.println("map stream to primitive stream");
        Stream<String> stringStream = Stream.of("apple", "orange", "banana");
        IntStream stringInts = stringStream.peek(System.out::println    ).mapToInt(String::length);
        stringInts.forEach(System.out::println);
    }
}
