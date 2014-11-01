package dk.cowfish.whatsthefare.views;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import dk.cowfish.whatsthefare.R;

public class MainActivity extends ActionBarActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new SearchFragment())
                    .commit();
        }
    }
}
