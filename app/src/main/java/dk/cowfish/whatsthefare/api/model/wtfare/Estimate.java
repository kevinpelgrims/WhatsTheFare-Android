package dk.cowfish.whatsthefare.api.model.wtfare;

import com.google.gson.annotations.SerializedName;

public class Estimate {
    String company;
    @SerializedName("estimated_fare")
    Double estimatedFare;
    @SerializedName("eta_seconds")
    Integer eta;
    @SerializedName("is_realtime")
    Boolean isRealtime;
    @SerializedName("is_surge")
    Boolean isSurge;
    String service;
    @SerializedName("surge_multiplier")
    Double surgeMultiplier;
}