import java.util.function.*;

/**
 * Implement a ternaryOperator method that accepts a predicate condition,
 * and two functions ifTrue and ifFalse and returns a function.
 * The returning function takes an argument, checks if condition predicate is true
 * for this argument, and if it is — applies ifTrue function to the argument,
 * otherwise, it applies ifFalse function.
 */

class Operator {

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }

    public static void main(String[] args) {
        String s = "whaaat?";
        String empty = "";

        Predicate<String> isNotEmpty = str -> !str.isEmpty();
        Function<String, Integer> ifTrue = String::length;
        Function<String, Integer> ifFalse = str -> 0;

        Function<String, Integer> tuFunction = ternaryOperator(isNotEmpty, ifTrue, ifFalse);

        // We are building a function here we are not using actual arguments
        Function<String, Integer> singleLine =
                ternaryOperator(str -> !str.isEmpty(), String::length, str -> 0);

        int result1 = tuFunction.apply(s);
        int result2 = singleLine.apply(empty);

        System.out.println(result1);
        System.out.println(result2);
    }
}