package seedu.address.logic.commands;

import seedu.address.model.Model;

/**
 * Terminates the program.
 */
public class PingCommand extends Command {

    public static final String COMMAND_WORD = "ping";

    public static final String PING_ACKNOWLEDGEMENT = "Ping ...";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(PING_ACKNOWLEDGEMENT);
    }

}
