package dk.cowfish.whatsthefare.api.model.wtfare;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Estimate {
    String company;
    @SerializedName("estimated_fare") Double estimatedFare;
    @SerializedName("eta_seconds") Integer eta;
    @SerializedName("is_realtime") Boolean isRealtime;
    @SerializedName("is_surge") Boolean isSurge;
    String service;
    @SerializedName("surge_multiplier") Double surgeMultiplier;

    public String getCompany() {
        return company;
    }

    public Double getEstimatedFare() {
        return estimatedFare;
    }

    public Integer getEta() {
        return eta;
    }

    public Boolean getIsRealtime() {
        return isRealtime;
    }

    public Boolean getIsSurge() {
        return isSurge;
    }

    public String getService() {
        return service;
    }

    public Double getSurgeMultiplier() {
        return surgeMultiplier;
    }
}