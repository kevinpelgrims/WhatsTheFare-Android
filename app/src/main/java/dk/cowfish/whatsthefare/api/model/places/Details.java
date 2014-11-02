package dk.cowfish.whatsthefare.api.model.places;

import com.google.gson.annotations.SerializedName;

public class Details {
    @SerializedName("formatted_address") String formattedAddress;
    Geometry geometry;

    public String getFormattedAddress() {
        return formattedAddress;
    }

    public Geometry getGeometry() {
        return geometry;
    }
}