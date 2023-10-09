package school.actions;

import com.androix.FBaseAction;

public class StudentRegUIFind extends FBaseAction {
    @Override
    public void execute() throws Exception {
        String index= (String) getViewModel("String_index");
        String firstName= (String) getViewModel("String_firstName");
        String lastName= (String) getViewModel("String_lastName");
        String address= (String) getViewModel("String_adress");
        Integer age= (Integer) getViewModel("Integer_age");

        addMessage("msg","Details:"+index+"\n"+
                firstName+" "+lastName+" "+address+" "+age);
    }
}
