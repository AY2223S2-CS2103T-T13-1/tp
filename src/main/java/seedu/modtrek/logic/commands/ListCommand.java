package seedu.modtrek.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.modtrek.model.Model.PREDICATE_SHOW_ALL_MODULES;

import seedu.modtrek.model.Model;

/**
 * Lists all modules in degree progression.
 */
public class ListCommand extends Command {

    public static final String COMMAND_WORD = "list";

    public static final String MESSAGE_SUCCESS = "Listed all modules";


    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredModuleList(PREDICATE_SHOW_ALL_MODULES);
        return new CommandResult(MESSAGE_SUCCESS);
    }
}
