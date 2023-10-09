package school.actions;

import com.androix.FBaseAction;
import com.androix.SaveAction;

import school.app.F;
import school.model.Student;

public class StudentRegUISave extends SaveAction {
    @Override
    public void execute() throws Exception {
        Student s= (Student) getViewModel("Student");
        s.setId(1L);  //id is not available in the View
        F.persist(s);
        addMessage("msg","Student saved successfully");
    }
}
