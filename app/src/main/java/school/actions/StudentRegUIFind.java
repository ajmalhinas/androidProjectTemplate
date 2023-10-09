package school.actions;

import com.androix.FBaseAction;

public class StudentRegUIFind extends FBaseAction {
    @Override
    public void execute() throws Exception {
        String firstName= (String) getViewModel("String_firstName");
        addMessage("msg","The name of the student: "+firstName);
    }
}
