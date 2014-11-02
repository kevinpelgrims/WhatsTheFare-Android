package dk.cowfish.whatsthefare.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;

import dk.cowfish.whatsthefare.R;
import dk.cowfish.whatsthefare.adapters.PlacesAutoCompleteAdapter;
import dk.cowfish.whatsthefare.api.ApiClient;
import dk.cowfish.whatsthefare.api.GooglePlacesApiClient;
import dk.cowfish.whatsthefare.api.model.places.Details;
import dk.cowfish.whatsthefare.api.model.places.DetailsResponse;
import dk.cowfish.whatsthefare.api.model.places.Location;
import dk.cowfish.whatsthefare.api.model.wtfare.EstimateResponse;
import dk.cowfish.whatsthefare.config.Config;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class SearchFragment extends Fragment {
    Details pickupDetails, destinationDetails;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AutoCompleteTextView pickup = (AutoCompleteTextView) view.findViewById(R.id.pickup_picker);
        pickup.setAdapter(new PlacesAutoCompleteAdapter(getActivity(), R.layout.list_item_search));
        pickup.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                handleOnItemClick(adapterView, position, true);
            }
        });

        final AutoCompleteTextView destination = (AutoCompleteTextView) view.findViewById(R.id.destination_picker);
        destination.setAdapter(new PlacesAutoCompleteAdapter(getActivity(), R.layout.list_item_search));
        destination.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                handleOnItemClick(adapterView, position, false);
            }
        });

        view.findViewById(R.id.get_fare_estimates).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pickupDetails != null && destinationDetails != null) {
                    Location pickupLocation = pickupDetails.getGeometry().getLocation();
                    Location destinationLocation = destinationDetails.getGeometry().getLocation();
                    ApiClient.getWtfApiClient().getEstimate(pickupLocation, destinationLocation, new Callback<EstimateResponse>() {
                        @Override
                        public void success(EstimateResponse estimateResponse, Response response) {
                            //TODO
                            estimateResponse.getEstimates();
                        }

                        @Override
                        public void failure(RetrofitError error) {
                            //TODO
                        }
                    });
                }
            }
        });
    }

    private void handleOnItemClick(AdapterView<?> adapterView, int position, final boolean isPickup) {
        String selectedReference = ((PlacesAutoCompleteAdapter) adapterView.getAdapter()).getItemReference(position);
        GooglePlacesApiClient.getGooglePlacesService().getPlacesDetails(Config.GOOGLE_PLACES_API_KEY, selectedReference, new Callback<DetailsResponse>() {
            @Override
            public void success(DetailsResponse detailsResponse, Response response) {
                if (detailsResponse != null && detailsResponse.getResult() != null) {
                    if (isPickup) {
                        pickupDetails = detailsResponse.getResult();
                    }
                    else {
                        destinationDetails = detailsResponse.getResult();
                    }
                }
            }

            @Override
            public void failure(RetrofitError error) {
                //TODO
            }
        });
    }
}