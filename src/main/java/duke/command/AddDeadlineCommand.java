package duke.command;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import duke.Storage;
import duke.Ui;
import duke.exception.EmptyDescriptionException;
import duke.task.Deadline;
import duke.task.TaskList;

/**
 * Represents a command to add a deadline task to the task list.
 */
public class AddDeadlineCommand extends Command {
    private String description;
    private LocalDateTime dateTime;

    /**
     * Constructs an AddDeadlineCommand with the provided description and date-time.
     *
     * @param description The description of the deadline task.
     * @param dateTime The date and time associated with the deadline task.
     */
    public AddDeadlineCommand(String description, LocalDateTime dateTime) {
        this.description = description;
        this.dateTime = dateTime;
    }

    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        assert taskList != null;
        assert ui != null;
        assert storage != null;
        try {
            if (description.trim().isEmpty()) {
                throw new EmptyDescriptionException("deadline");
            }

            Deadline newDeadline = new Deadline(description, dateTime);
            taskList.addTask(newDeadline);
            return ui.showAdd(newDeadline, taskList.getLength());
        } catch (EmptyDescriptionException e) {
            return ui.showDukeException(e);
        } catch (DateTimeParseException e) {
            return ui.showInvalidDateTimeFormat();
        }
    }
}
