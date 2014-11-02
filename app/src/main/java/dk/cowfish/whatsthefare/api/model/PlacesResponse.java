package dk.cowfish.whatsthefare.api.model;

import java.util.List;

public class PlacesResponse {
    List<PlacesPrediction> predictions;

    public List<PlacesPrediction> getPredictions() {
        return predictions;
    }
}