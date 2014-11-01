package dk.cowfish.whatsthefare.api;

import dk.cowfish.whatsthefare.api.model.EstimateResponse;
import dk.cowfish.whatsthefare.api.model.Position;
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
        void getEstimate(@Query("start") Position pickup, @Query("dest") Position destination, Callback<EstimateResponse> response);
    }

}