package dk.cowfish.whatsthefare.api.model.places;

import com.google.gson.annotations.SerializedName;

import java.util.Locale;

public class Location {
    @SerializedName("lat") double latitude;
    @SerializedName("lng") double longitude;

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public String toString() {
        return String.format(Locale.ENGLISH, "%f,%f", latitude, longitude);
    }
}