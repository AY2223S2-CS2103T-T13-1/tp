package seedu.modtrek.model.module;

import static java.util.Objects.requireNonNull;
import static seedu.modtrek.commons.util.AppUtil.checkArgument;

/**
 * Credit denotes the Modular Credit (MC) associated with each module.
 */
public class Credit implements Comparable<Credit> {

    public static final String MESSAGE_CONSTRAINTS =
            "Credit should only be a number and only 1-2 digits long";

    private static final String VALIDATION_REGEX = "\\d{1,2}";

    protected final String value;

    /**
     * Instantiates a new Credit. Credit cannot be null and must be valid.
     *
     * @param value the value
     */
    public Credit(String value) {
        requireNonNull(value);
        checkArgument(isValidCredit(value), MESSAGE_CONSTRAINTS);
        this.value = value;
    }

    /**
     * Checks if the Credit is valid.
     *
     * @param test the test
     * @return the boolean
     */
    public static boolean isValidCredit(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj
                || (obj instanceof Credit
                && value.equals(((Credit) obj).value));
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
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object
     *      is less than, equal to, or greater than the specified object.
     * @throws NullPointerException if the specified object is null
     * @throws ClassCastException   if the specified object's type prevents it
     *                              from being compared to this object.
     */
    @Override
    public int compareTo(Credit o) {
        return Integer.valueOf(o.toString()) - Integer.valueOf(this.toString());
    }
}
