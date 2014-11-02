package dk.cowfish.whatsthefare.api;

import dk.cowfish.whatsthefare.api.model.PlacesResponse;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Query;

public class GooglePlacesApiClient {
    private static GooglePlacesService googlePlacesService;

    public static GooglePlacesService getGooglePlacesService() {
        if (googlePlacesService == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint("https://maps.googleapis.com/maps/api/place")
                    .setLogLevel(RestAdapter.LogLevel.FULL)
                    .build();
            googlePlacesService = restAdapter.create(GooglePlacesService.class);
        }

        return googlePlacesService;
    }

    public interface GooglePlacesService {
        @GET("/autocomplete/json")
        PlacesResponse getPlacesAutocomplete(@Query("key") String key, @Query("input") String input);
    }
}