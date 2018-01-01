package lambda.stream;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

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

        doubleStream.limit(3).forEach(System.out::println);
    }
}
