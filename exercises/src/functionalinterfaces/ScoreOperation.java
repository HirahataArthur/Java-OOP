package functionalinterfaces;

@FunctionalInterface
interface ScoreOperation {
    // A functional interface has exactly one abstract method, which a lambda can implement.
    int apply(int score);
}
