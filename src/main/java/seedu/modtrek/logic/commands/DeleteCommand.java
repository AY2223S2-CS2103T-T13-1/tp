package seedu.modtrek.logic.commands;

import static java.util.Objects.requireNonNull;

import javafx.collections.ObservableList;
import seedu.modtrek.logic.commands.exceptions.CommandException;
import seedu.modtrek.model.Model;
import seedu.modtrek.model.module.Code;
import seedu.modtrek.model.module.Module;

/**
 * Deletes a person identified using it's displayed index from the address book.
 */
public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the module identified by the module code\n"
            + "Parameters: MODULE CODE\n"
            + "Example: " + COMMAND_WORD + " CS1101S";

    public static final String MESSAGE_DELETE_PERSON_SUCCESS = "Deleted Module: %1$s";

    private final Code targetCode;

    public DeleteCommand(Code targetCode) {
        this.targetCode = targetCode;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        ObservableList<Module> lastShownList = model.getFilteredModuleList();
        Module moduleToDelete = new Module(targetCode);
        if (lastShownList.contains(moduleToDelete)) {
            model.deleteModule(moduleToDelete);
        }
        return new CommandResult(String.format(MESSAGE_DELETE_PERSON_SUCCESS, moduleToDelete));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteCommand // instanceof handles nulls
                && targetCode.equals(((DeleteCommand) other).targetCode)); // state check
    }
}