package seedu.modtrek.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.modtrek.model.Model.PREDICATE_SHOW_ALL_ModuleS;

import seedu.modtrek.model.Model;

/**
 * Lists all modules in the module list to the user.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_SUCCESS = "Listed all modules";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredModuleList(PREDICATE_SHOW_ALL_ModuleS);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
