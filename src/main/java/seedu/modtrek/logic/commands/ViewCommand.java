package seedu.modtrek.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.modtrek.model.Model;

/**
 * View the data progress or module list
 */
public class ViewCommand extends Command {

    public static final String COMMAND_WORD = "view";

    public static final String MESSAGE_PROGRESS_SUCCESS = "Displaying the progress,\n"
            + "Here is an overview:\n\n";

    public static final String MESSAGE_MODULES_SUCCESS = "Listed all modules";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Switches between different viewing screens.\n\n"
            + "Parameters: progress or modules\n\n"
            + "Example 1: view progress\n"
            + "Example 2: view modules";

    private final boolean isProgress;

    public ViewCommand(boolean isProgress) {
        this.isProgress = isProgress;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        if (isProgress) {
            String details = model.getDegreeProgression().getProgressionData().getFullDetails();
            return new CommandResult(MESSAGE_PROGRESS_SUCCESS + details, false, true, false, false);
        } else {
            return new CommandResult(MESSAGE_MODULES_SUCCESS);
        }
    }
}
