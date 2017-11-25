package lambda.stream;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TerminalOperations {
    public static void main(String[] args) {

        Supplier<Stream> sup = () -> Stream.of("banana", "apple", "lemon", "pear", "2");
        System.out.println("stream: " + sup.get().collect(Collectors.toList()));

        // count
        long c = sup.get().count();
        System.out.println("stream count: " + c);

        System.out.println("# comparator");
        //Comparator<String> comparator = (s1, s2) -> s1.length() - s2.length();
        Comparator<String> comparator = Comparator.comparing(String::length);
        System.out.println("shortest: " + sup.get().min(comparator));
        System.out.println("longest: " + sup.get().max(comparator));

        // findAny, get one element, order ignored, useful for parallel streams
        // findFirst, get the first element of the stream
        System.out.println("# find*");
        System.out.println("findAny: " + sup.get().findAny());
        System.out.println("findFirst: " + sup.get().findFirst());

        System.out.println("# match");
        Predicate<String> startWithLetter = x -> Character.isLetter(x.charAt(0));
        System.out.println("anyMatch starts with letter: " + sup.get().anyMatch(startWithLetter));
        System.out.println("allMatch starts with letter: " + sup.get().allMatch(startWithLetter));
        System.out.println("noneMatch starts with letter: " + sup.get().noneMatch(startWithLetter));

        System.out.println("# forEach");
        sup.get().forEach(System.out::println);

        // reduction: concat
        System.out.println("# reduction");
        Stream<String> wolfStream = Stream.of("w", "o", "l", "f");
        //String word = wolfStream.reduce("", (s, t) -> s + t);
        String word = wolfStream.reduce("", String::concat);
        System.out.println("reduction concatenation: " + word);

        // reduction: multiply all elements
        Stream<Integer> numSream = Stream.of(1, 2, 3, 4);
        int mul = numSream.reduce(1, (x, y) -> x * y);
        System.out.println("reduction multiplication: " + mul);

        // now with optional. processed with empty stream, with one and many elements
        BinaryOperator<Integer> op = (a, b) -> a * b;
        Stream<Integer> emptyIntStream = Stream.empty(); // empty optional is returned
        Stream<Integer> oneElemIntStream = Stream.of(1); // first element is returned, without exec accumulator
        Stream<Integer> manyElemIntStream = Stream.of(1, 2, 3); // accumulator gets applied

        System.out.println("reduce empty stream: " + emptyIntStream.reduce(op));
        System.out.println("reduce one element stream: " + oneElemIntStream.reduce(op));
        System.out.println("reduce many element stream: " + manyElemIntStream.reduce(op));

        // with intermediate operations for parallel streams
        Stream<Integer> largeElemIntStream = Stream.of(1, 2, 3, 4, 5, 6); // accumulator gets applied
        System.out.println("reduce with intermediate operation: " + largeElemIntStream.parallel().reduce(1, op, op));

        // collect: the mutable reduction
        System.out.println("# collect");
        Supplier<Stream<String>> wolfSupplier = () -> Stream.of("w", "o", "l", "f");

        StringBuilder sb = wolfSupplier.get().collect(StringBuilder::new, StringBuilder::append, StringBuilder::append);
        System.out.println("StringBuilder: " + sb);

        //TreeSet<String> treeSet = wolfSupplier.get().collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        TreeSet<String> treeSet = wolfSupplier.get().collect(Collectors.toCollection(TreeSet::new));
        System.out.println("TreeSet: " + treeSet);

        Set<String> unsortedSet = wolfSupplier.get().collect(Collectors.toSet());
        System.out.println("Unsorted set: " + unsortedSet);
    }
}
