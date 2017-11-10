package lambda.common_fi;

import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class OperatorExample {
    public static void main(String[] args) {
        UnaryOperator<String> u1 = String::toUpperCase;
        UnaryOperator<String> u2 = x -> x.toUpperCase();

        System.out.println(u1.apply("chuck"));
        System.out.println(u2.apply("chuck"));

        BinaryOperator<String> b1 = String::concat;
        BinaryOperator<String> b2 = (string, toAdd) -> string.concat(toAdd);

        System.out.println(b1.apply("yellow", " banana"));
        System.out.println(b2.apply("yellow", " banana"));
    }
}
