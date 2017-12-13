package lambda.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class IntermediateOperations {
    public static void main(String[] args) {
        Supplier<Stream<String>> sup = () -> Stream.of("banana", "apple", "lemon", "pear", "2");

        // filter
        System.out.println("# filter starts with \"p\": ");
        sup.get().filter(x -> x.startsWith("p")).forEach(System.out::println);

        // remove duplicates
        System.out.println("# distinct:");
        Stream<String> fruits = Stream.of("apple", "apple", "lemon", "apple");
        fruits.distinct().forEach(System.out::println);

        // limit and skip elements
        System.out.println("# limit and skip:");
        Stream<Integer> ints = Stream.iterate(1, n -> n + 2); // infinite stream
        ints.skip(2).limit(3).forEach(System.out::println);

        // map elements
        System.out.println("# map:");
        sup.get().map(String::length).forEach(System.out::println);

        // flatMap
        System.out.println("# flatMap:");
        List<String> zero = Arrays.asList();
        List<String> one = Arrays.asList("one");
        List<String> two = Arrays.asList("two", "three");
        Stream<List<String>> streamOfLists = Stream.of(zero, one, two);
        streamOfLists.flatMap(l -> l.stream()).forEach(System.out::println);

        // sort
        System.out.println("# sorted in natural order:");
        sup.get().sorted().forEach(System.out::println);

        System.out.println("# sorted in reverse natural order:");
        sup.get().sorted(Comparator.reverseOrder()).forEach(System.out::println);

        System.out.println("# sorted by length:");
        sup.get().sorted(Comparator.comparing(String::length)).forEach(System.out::println);

        // peek element without changing the stream, useful for debugging
        System.out.println("# peek");
        long count = sup.get().distinct().filter(s -> s.startsWith("a")).peek(s -> System.out.print(s + ":")).count();
        System.out.println(count);
    }
}
