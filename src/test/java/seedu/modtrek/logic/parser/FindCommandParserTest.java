package seedu.modtrek.logic.parser;

import static seedu.modtrek.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.modtrek.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.modtrek.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.modtrek.logic.commands.FindCommand;
import seedu.modtrek.model.module.Code;
import seedu.modtrek.model.module.ModuleCodePredicate;

public class FindCommandParserTest {

    private FindCommandParser parser = new FindCommandParser();

    @Test
    public void parse_emptyArg_throwsParseException() {
        assertParseFailure(parser, "     ", String.format(MESSAGE_INVALID_COMMAND_FORMAT, FindCommand.MESSAGE_USAGE));
    }

    @Test
    public void parse_validArgs_returnsFindCommand() {
        // no leading and trailing whitespaces
        FindCommand expectedFindCommand =
                new FindCommand(new ModuleCodePredicate(new Code("CS1101S")));
        assertParseSuccess(parser, "CS1101S", expectedFindCommand);
    }

}
