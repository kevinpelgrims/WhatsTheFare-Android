package dk.cowfish.whatsthefare.api.model.wtfare;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EstimateResponse {
    @SerializedName("start_addr")
    String pickupAddress;
    @SerializedName("start_latlng")
    Location pickupLocation;
    @SerializedName("dest_addr")
    String destinationAddress;
    @SerializedName("dest_latlng")
    Location destinationLocation;
    List<Estimate> estimates;
    @SerializedName("distance_meters")
    Integer distance;
    @SerializedName("duration_seconds")
    Integer duration;
    //TODO: directions
}