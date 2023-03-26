package seedu.modtrek.model.module;

import static java.util.Objects.requireNonNull;
import static seedu.modtrek.commons.util.AppUtil.checkArgument;

import java.util.Map;
import java.util.Set;

/**
 * Grade denotes the grading based on NUS system for each module.
 */
public class Grade implements Comparable<Grade> {

    public static final String MESSAGE_CONSTRAINTS =
            "Grade should be either one of [A+, A, A-, B+, B, B-, C+, C, D+, D, F, S, U]";

    private static Map<String, Double> gradeToPoints = Map.ofEntries(
        Map.entry("A+", 5.0),
        Map.entry("A", 5.0),
        Map.entry("A-", 4.5),
        Map.entry("B+", 4.0),
        Map.entry("B", 3.5),
        Map.entry("B-", 3.0),
        Map.entry("C+", 2.5),
        Map.entry("C", 2.0),
        Map.entry("D+", 1.5),
        Map.entry("D", 1.0),
        Map.entry("F", 0.0),
        Map.entry("S", 5.0),
        Map.entry("U", 0.0),
        Map.entry("", -1.0) // Empty grade
    );

    private static final Set<String> VALID_GRADES = gradeToPoints.keySet();

    protected final String value;

    /**
     * Instantiates a new Grade. Grade cannot be null and must be valid.
     *
     * @param value the value
     */
    public Grade(String value) {
        requireNonNull(value);
        checkArgument(isValidGrade(value), MESSAGE_CONSTRAINTS);
        this.value = value;
    }

    /**
     * Checks if the Grade is valid based on a list of valid grades.
     *
     * @param test the test
     * @return the boolean
     */
    public static boolean isValidGrade(String test) {
        requireNonNull(test);
        return VALID_GRADES.contains(test);
    }

    public double toPoints() {
        return gradeToPoints.get(value);
    }

    public boolean isEmpty() {
        return value.equals("");
    }

    public boolean isGradeable() {
        return !value.equals("U");
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj
                || (obj instanceof Grade
                && value.equals(((Grade) obj).value));
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    /**
     * Compares this object with the specified object for order.  Returns a
     * negative integer, zero, or a positive integer as this object is less
     * than, equal to, or greater than the specified object.
     *
     * <p>The implementor must ensure
     * {@code sgn(x.compareTo(y)) == -sgn(y.compareTo(x))}
     * for all {@code x} and {@code y}.  (This
     * implies that {@code x.compareTo(y)} must throw an exception iff
     * {@code y.compareTo(x)} throws an exception.)
     *
     * <p>The implementor must also ensure that the relation is transitive:
     * {@code (x.compareTo(y) > 0 && y.compareTo(z) > 0)} implies
     * {@code x.compareTo(z) > 0}.
     *
     * <p>Finally, the implementor must ensure that {@code x.compareTo(y)==0}
     * implies that {@code sgn(x.compareTo(z)) == sgn(y.compareTo(z))}, for
     * all {@code z}.
     *
     * <p>It is strongly recommended, but <i>not</i> strictly required that
     * {@code (x.compareTo(y)==0) == (x.equals(y))}.  Generally speaking, any
     * class that implements the {@code Comparable} interface and violates
     * this condition should clearly indicate this fact.  The recommended
     * language is "Note: this class has a natural ordering that is
     * inconsistent with equals."
     *
     * <p>In the foregoing description, the notation
     * {@code sgn(}<i>expression</i>{@code )} designates the mathematical
     * <i>signum</i> function, which is defined to return one of {@code -1},
     * {@code 0}, or {@code 1} according to whether the value of
     * <i>expression</i> is negative, zero, or positive, respectively.
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Grade o) {
        return (int) (o.toPoints() - this.toPoints());
    }
}
