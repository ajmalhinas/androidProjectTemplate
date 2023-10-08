package school.app;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;

import com.androix.AbstractMainActivity;
import com.androix.NPersistence;
import com.androix.U;


public final class MainActivity extends AbstractMainActivity {
    public static final String app = "school";

    public void init() {
        init(R.layout.activity_main);
        F.init(this);
        NPersistence.createDBIfNotExist(app+".sql", "1");
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Intent intent = this.getIntent();
        U.checkAndRequestPermissions(MainActivity.this);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        AbstractMainActivity.setup(app, this, R.id.fragmentContainer, InitSystemStartupServices.class, R.id.class);
        // To apply dark theme here and style.xml should be enabled Theme.AppCompat.DayNight
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        super.onCreate(savedInstanceState);
        init();
        navigate(StudentRegUI.class);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;

    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
                return super.onOptionsItemSelected(item);
    }
}