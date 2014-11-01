package dk.cowfish.whatsthefare.api.model;

import com.google.gson.annotations.SerializedName;

public class Position {
    @SerializedName("lat")
    double latitude;
    @SerializedName("lng")
    double longitude;

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}