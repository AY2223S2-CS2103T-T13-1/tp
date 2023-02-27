package seedu.address.logic.commands;

import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class EchoCommand extends Command {
    public static final String COMMAND_WORD = "echo";

    public static String MESSAGE_ECHO = "";

    private final String[] toEcho;

    public EchoCommand(String[] toEcho) {
        this.toEcho = toEcho;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        buildMessage();

        return new CommandResult(MESSAGE_ECHO);
    }

    public void buildMessage() {
        StringBuilder message = new StringBuilder();

        message.append("Echoing:");

        for (int i = 0; i < toEcho.length; i++) {
            message.append(" ");
            String word = toEcho[i];
            message.append(word);
        }

        MESSAGE_ECHO = message.toString();
    }
}
