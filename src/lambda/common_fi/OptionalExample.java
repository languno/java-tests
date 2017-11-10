package lambda.common_fi;

import java.util.Optional;

public class OptionalExample {

    public static Optional<Double> avarage(int... scores) {
        if (scores.length == 0)
            return Optional.empty();

        int sum = 0;
        for (int score : scores)
            sum += score;

        return Optional.of((double)sum / scores.length);
    }

    public static void main(String[] args) {
        System.out.println(avarage(90, 100));
        System.out.println(avarage());

        Optional<Double> opt = avarage(90, 100);
        if (opt.isPresent())
            System.out.println(opt.get());

        // call a consumer if value present
        opt.ifPresent(System.out::println);

        // call a supplier if no value present
        opt = Optional.empty();
        System.out.println(opt.orElseGet(() -> Math.random()));

        // define default if no value present
        System.out.println(opt.orElse(Double.NaN));
    }
}
