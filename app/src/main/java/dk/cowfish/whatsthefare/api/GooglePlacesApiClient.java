package dk.cowfish.whatsthefare.api;

import dk.cowfish.whatsthefare.api.model.places.AutoCompleteResponse;
import dk.cowfish.whatsthefare.api.model.places.DetailsResponse;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Query;

public class GooglePlacesApiClient {
    private static GooglePlacesService googlePlacesService;

    public static GooglePlacesService getGooglePlacesService() {
        if (googlePlacesService == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint("https://maps.googleapis.com/maps/api/place")
                    .build();
            googlePlacesService = restAdapter.create(GooglePlacesService.class);
        }

        return googlePlacesService;
    }

    public interface GooglePlacesService {
        @GET("/autocomplete/json")
        AutoCompleteResponse getPlacesAutocomplete(@Query("key") String key, @Query("input") String input);

        @GET("/details/json")
        void getPlacesDetails(@Query("key") String key, @Query("reference") String reference, Callback<DetailsResponse> callback);
    }
}