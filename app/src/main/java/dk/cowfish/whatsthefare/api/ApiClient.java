package dk.cowfish.whatsthefare.api;

import dk.cowfish.whatsthefare.api.model.wtfare.EstimateResponse;
import dk.cowfish.whatsthefare.api.model.wtfare.Location;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Query;

public class ApiClient {
    private static WtfService wtfService;

    public static WtfService getWtfApiClient() {
        if (wtfService == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint("http://whatsthefare.com")
                    .build();
            wtfService = restAdapter.create(WtfService.class);
        }

        return wtfService;
    }

    public interface WtfService {
        @GET("/estimate")
        void getEstimate(@Query("start") Location pickup, @Query("dest") Location destination, Callback<EstimateResponse> response);
    }

}