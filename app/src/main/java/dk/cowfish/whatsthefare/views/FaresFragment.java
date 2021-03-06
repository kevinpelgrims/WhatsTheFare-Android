package dk.cowfish.whatsthefare.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.parceler.Parcels;

import dk.cowfish.whatsthefare.R;
import dk.cowfish.whatsthefare.adapters.FareEstimatesAdapter;
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

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setupFareEstimateInfo(view);
        setupFareEstimatesList(view);
    }

    private void setupFareEstimateInfo(View view) {
        ((TextView) view.findViewById(R.id.fare_estimate_pickup_address)).setText(getString(R.string.label_pickup_address, estimateResponse.getPickupAddress()));
        ((TextView) view.findViewById(R.id.fare_estimate_destination_address)).setText(getString(R.string.label_destination_address, estimateResponse.getDestinationAddress()));
        String timeDistance = "~ " + estimateResponse.getDistance() + "m, " + estimateResponse.getDuration() / 60 + "mins";
        ((TextView) view.findViewById(R.id.fare_estimate_time_distance)).setText(timeDistance);
    }

    private void setupFareEstimatesList(View view) {
        RecyclerView fareEstimatesList = (RecyclerView) view.findViewById(R.id.fare_estimates_list);
        // This setting improves performance and the size of the view will not change when content changes
        fareEstimatesList.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        fareEstimatesList.setLayoutManager(layoutManager);

        RecyclerView.Adapter adapter = new FareEstimatesAdapter(getActivity(), estimateResponse.getEstimates());
        fareEstimatesList.setAdapter(adapter);
    }
}