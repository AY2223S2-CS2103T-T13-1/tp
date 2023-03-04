package seedu.modtrek.logic.parser;

import static java.util.Objects.requireNonNull;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import seedu.modtrek.logic.parser.exceptions.ParseException;
import seedu.modtrek.model.module.Code;
import seedu.modtrek.model.module.Credit;
import seedu.modtrek.model.module.Grade;
import seedu.modtrek.model.module.SemYear;
import seedu.modtrek.model.tag.Tag;

/**
 * Contains utility methods used for parsing strings in the various *Parser classes.
 */
public class ParserUtil {

    public static final String MESSAGE_INVALID_INDEX = "Index is not a non-zero unsigned integer.";

    /**
     * Parses a {@code String code} into a {@code Code}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code code} is invalid.
     */
    public static Code parseCode(String code) throws ParseException {
        requireNonNull(code);
        String trimmedName = code.trim();
        if (!Code.isValidCode(trimmedName)) {
            throw new ParseException(Code.MESSAGE_CONSTRAINTS);
        }
        return new Code(trimmedName);
    }

    /**
     * Parses a {@code String credit} into a {@code Credit}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code credit} is invalid.
     */
    public static Credit parseCredit(String credit) throws ParseException {
        requireNonNull(credit);
        String trimmedCredit = credit.trim();
        if (!Credit.isValidCredit(trimmedCredit)) {
            throw new ParseException(Credit.MESSAGE_CONSTRAINTS);
        }
        return new Credit(trimmedCredit);
    }

    /**
     * Parses a {@code String semYear} into an {@code SemYear}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code semYear} is invalid.
     */
    public static SemYear parseSemYear(String semYear) throws ParseException {
        requireNonNull(semYear);
        String trimmedAddress = semYear.trim();
        if (!SemYear.isValidSemYear(trimmedAddress)) {
            throw new ParseException(SemYear.MESSAGE_CONSTRAINTS);
        }
        return new SemYear(trimmedAddress);
    }

    /**
     * Parses a {@code String grade} into an {@code Grade}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code grade} is invalid.
     */
    public static Grade parseGrade(String grade) throws ParseException {
        requireNonNull(grade);
        String trimmedGrade = grade.trim();
        if (!Grade.isValidGrade(trimmedGrade)) {
            throw new ParseException(Grade.MESSAGE_CONSTRAINTS);
        }
        return new Grade(trimmedGrade);
    }

    /**
     * Parses a {@code String tag} into a {@code Tag}.
     * Leading and trailing whitespaces will be trimmed.
     *
     * @throws ParseException if the given {@code tag} is invalid.
     */
    public static Tag parseTag(String tag) throws ParseException {
        requireNonNull(tag);
        String trimmedTag = tag.trim();
        if (!Tag.isValidTagName(trimmedTag)) {
            throw new ParseException(Tag.MESSAGE_CONSTRAINTS);
        }
        return new Tag(trimmedTag);
    }

    /**
     * Parses {@code Collection<String> tags} into a {@code Set<Tag>}.
     */
    public static Set<Tag> parseTags(Collection<String> tags) throws ParseException {
        requireNonNull(tags);
        final Set<Tag> tagSet = new HashSet<>();
        for (String tagName : tags) {
            tagSet.add(parseTag(tagName));
        }
        return tagSet;
    }
}
