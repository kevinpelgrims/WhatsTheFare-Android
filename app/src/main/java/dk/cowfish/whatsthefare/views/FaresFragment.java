package dk.cowfish.whatsthefare.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.parceler.Parcels;

import dk.cowfish.whatsthefare.R;
import dk.cowfish.whatsthefare.api.model.wtfare.EstimateResponse;

public class FaresFragment extends Fragment {
    private static final String ARG_ESTIMATE_RESPONSE = "estimateResponse";

    private EstimateResponse estimateResponse;

    public static FaresFragment newInstance(EstimateResponse estimateResponse) {
        FaresFragment fragment = new FaresFragment();
        Bundle args = new Bundle();
        args.putParcelable(ARG_ESTIMATE_RESPONSE, Parcels.wrap(estimateResponse));
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            estimateResponse = Parcels.unwrap(getArguments().getParcelable(ARG_ESTIMATE_RESPONSE));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fares, container, false);
    }
}