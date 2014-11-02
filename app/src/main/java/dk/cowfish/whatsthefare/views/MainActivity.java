package dk.cowfish.whatsthefare.views;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import dk.cowfish.whatsthefare.R;
import dk.cowfish.whatsthefare.api.model.wtfare.EstimateResponse;

public class MainActivity extends ActionBarActivity implements SearchFragment.OnSearchFragmentInteractionListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, SearchFragment.newInstance())
                    .commit();
        }
    }

    @Override
    public void onGetFareEstimates(EstimateResponse estimateResponse) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.container, FaresFragment.newInstance(estimateResponse))
                .commit();
    }
}
