package seedu.modtrek.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.modtrek.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.modtrek.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.modtrek.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.modtrek.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.modtrek.logic.parser.CliSyntax.PREFIX_TAG;

import seedu.modtrek.logic.commands.exceptions.CommandException;
import seedu.modtrek.model.Model;
import seedu.modtrek.model.person.Person;

/**
 * Adds a module to the module list.
 */
public class AddCommand extends Command {

    public static final String COMMAND_WORD = "add";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds a module to the module list. "
            + "Parameters: "
            + PREFIX_CODE + "CODE "
            + PREFIX_CREDITS + "CREDITS "
            + PREFIX_YEAR_SEMESTER + "YEAR-SEMESTER "
            + PREFIX_GRADE + "GRADE \n"
            + "Example: " + COMMAND_WORD + " "
            + PREFIX_CODE + "CS2103T "
            + PREFIX_CREDITS + "4 "
            + PREFIX_YEAR_SEMESTER + "Y2S2 "
            + PREFIX_GRADE + "A+";

    public static final String MESSAGE_SUCCESS = "New module added: %1$s";
    public static final String MESSAGE_DUPLICATE_PERSON = "This module already exists in the module list";

    private final Module toAdd;

    /**
     * Creates an AddCommand to add the specified {@code Module}
     */
    public AddCommand(Module module) {
        requireNonNull(module);
        toAdd = module;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (model.hasModule(toAdd)) {
            throw new CommandException(MESSAGE_DUPLICATE_MODULE);
        }

        model.addModule(toAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, toAdd));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof AddCommand // instanceof handles nulls
                && toAdd.equals(((AddCommand) other).toAdd));
    }
}
