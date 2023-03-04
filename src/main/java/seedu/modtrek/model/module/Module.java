package seedu.modtrek.model.module;

import static seedu.modtrek.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.modtrek.model.tag.Tag;

/**
 * Represents a module in ModTrek
 */
public class Module {
    // Identity fields
    private final Code code;

    // Data fields
    private final Credit credits;
    private final SemYear semesterYear;
    private final Set<Tag> tags = new HashSet<>();
    private final Grade grade;

    public Module(Code code, Credit credits, SemYear semesterYear, Set<Tag> tags, Grade grade) {
        requireAllNonNull(code, credits, semesterYear, tags);
        this.code = code;
        this.credits = credits;
        this.semesterYear = semesterYear;
        this.tags.addAll(tags);
        this.grade = grade;
    }

    public Module(Code code) {
        requireAllNonNull(code);
        this.code = code;
        this.credits = new Credit("4");
        this.semesterYear = new SemYear("Y1S1");
        this.grade = new Grade("S");
    }

    public Code getCode() {
        return code;
    }

    public Credit getCredit() {
        return credits;
    }

    public SemYear getSemYear() {
        return semesterYear;
    }

    public Grade getGrade() {
        assert grade != null;
        return grade;
    }

    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    public boolean isSameModule(Module otherModule) {
        return code.equals(otherModule.code);
    }

    @Override
    public boolean equals(Object other) {

        if (other == this) {
            return true;
        }

        if (!(other instanceof Module)) {
                    return false;
        }

        Module otherModule = (Module) other;

        return otherModule.code.equals(this.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, credits, semesterYear, tags);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(code)
                .append("; Credits: ")
                .append(credits)
                .append("; Year-Semester: ")
                .append(semesterYear);

        if (!tags.isEmpty()) {
            builder.append("; Tags: ");
            tags.forEach(builder::append);
        }

        if (grade != null) {
            builder.append("; Grade: ")
                    .append(grade);
        }

        return builder.toString();
    }

}
