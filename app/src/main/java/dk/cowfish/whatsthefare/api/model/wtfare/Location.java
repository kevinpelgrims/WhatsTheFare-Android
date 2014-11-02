package dk.cowfish.whatsthefare.api.model.wtfare;

import com.google.gson.annotations.SerializedName;

import org.parceler.Parcel;

@Parcel
public class Location {
    @SerializedName("lat") double latitude;
    @SerializedName("lng") double longitude;

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}