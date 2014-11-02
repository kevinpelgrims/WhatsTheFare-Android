package dk.cowfish.whatsthefare.api.model.places;

import java.util.List;

public class AutoCompleteResponse {
    List<Prediction> predictions;

    public List<Prediction> getPredictions() {
        return predictions;
    }
}