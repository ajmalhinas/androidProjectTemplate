package school.actions;

import com.androix.FBaseAction;

public class StudentRegUIClear extends FBaseAction {
    @Override
    public void execute() throws Exception {
        updateViewModel("String_index", "index100");
        updateViewModel("String_firstName", "Jhon");
        updateViewModel("String_lastName", "Dave");
        updateViewModel("String_address", "5 NYC");
        updateViewModel("Integer_age", 17);
        addMessage("i18n", "View is updated");
    }
}
