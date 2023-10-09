package school.actions;

import com.androix.FBaseAction;

public class StudentRegUIClear extends FBaseAction {
    @Override
    public void execute() throws Exception {
        updateViewModel("String_index", "");
        updateViewModel("String_firstName", "");
        updateViewModel("String_lastName", "");
        updateViewModel("String_address", "");
        updateViewModel("Integer_age", null);
        addMessage("i18n", "View is cleared");
    }
}
