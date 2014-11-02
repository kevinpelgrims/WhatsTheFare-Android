package dk.cowfish.whatsthefare.api.model.places;

import com.google.gson.annotations.SerializedName;

public class DetailsResponse {
    @SerializedName("result")
    Details result;

    public Details getResult() {
        return result;
    }
}