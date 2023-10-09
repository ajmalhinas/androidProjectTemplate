package school.actions;

import com.androix.FBaseAction;

import school.model.Student;

public class StudentRegUIFind extends FBaseAction {
    @Override
    public void execute() throws Exception {
        Student s= (Student) getViewModel("Student");
        addMessage("msg","Details:"+s.getIndex()+"\n"+
                s.getFName()+" "+s.getFName()+" "+s.getAddress()+" "+s.getAge());
    }
}
