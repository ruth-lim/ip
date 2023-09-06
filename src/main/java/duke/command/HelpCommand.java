package duke.command;

import duke.Storage;
import duke.Ui;
import duke.task.TaskList;

/**
 * Represents a command to show the list of commands.
 */
public class HelpCommand extends Command {
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        return ui.showListOfCommands();
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
