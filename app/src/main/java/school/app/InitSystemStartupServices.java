package school.app;

import android.content.Intent;

import com.androix.AbstractInitStartup;
import com.androix.AbstractMainActivity;


public class InitSystemStartupServices extends AbstractInitStartup {

    @Override
    public void setup(Intent intent) {
        AbstractMainActivity.setup(MainActivity.app,1,R.id.fragmentContainer,InitSystemStartupServices.class, R.id.class,context,Registration.class);
    }
}
