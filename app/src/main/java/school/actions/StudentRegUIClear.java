package school.actions;

import com.androix.FBaseAction;

import school.model.Student;

public class StudentRegUIClear extends FBaseAction {
    @Override
    public void execute() throws Exception {
        updateViewModel("Student", null);
        addMessage("i18n", "View is cleared");
    }
}
