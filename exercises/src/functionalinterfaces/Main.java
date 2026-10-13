package functionalinterfaces;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        // Sample data that will be processed with functional interfaces
        List<Integer> scores = List.of(45, 72, 88, 59, 100);

        System.out.println("=== Custom functional interface ===");
        // A lambda provides the implementation of ScoreOperation's single abstract method
        int adjustedScore = adjustScore(72, score -> Math.min(score + 5, 100));
        System.out.println("Score after bonus: " + adjustedScore);

        System.out.println("\n=== Built-in functional interfaces ===");
        // Predicate tests a value and returns true or false.
        Predicate<Integer> isPassing = score -> score >= 60;
        // Function transforms a score into a display string.
        Function<Integer, String> describeScore = score -> score + " points";
        // Consumer accepts a value and performs an action without returning a result
        Consumer<String> printResult = System.out::println;
        // Supplier provides a value without taking any input
        Supplier<String> reportTitle = () -> "Passing scores:";

        System.out.println(reportTitle.get());
        // Stream operations filter, transform, and then print the passing scores
        scores.stream()
                .filter(isPassing)
                .map(describeScore)
                .forEach(printResult);
    }

    private static int adjustScore(int score, ScoreOperation operation) {
        // Execute the operation supplied by the caller
        return operation.apply(score);
    }
}
