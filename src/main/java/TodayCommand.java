import java.time.LocalDate;

public class TodayCommand extends Command {

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        LocalDate today = LocalDate.now();
        ui.showTasksForToday(today, taskList);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
