package dk.cowfish.whatsthefare.adapters;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;
import java.util.List;

import dk.cowfish.whatsthefare.api.GooglePlacesApiClient;
import dk.cowfish.whatsthefare.api.model.PlacesPrediction;
import dk.cowfish.whatsthefare.api.model.PlacesResponse;
import dk.cowfish.whatsthefare.config.Config;

public class PlacesAutoCompleteAdapter extends ArrayAdapter<String> implements Filterable {
    private List<PlacesPrediction> resultList = new ArrayList<PlacesPrediction>();

    public PlacesAutoCompleteAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public int getCount() {
        return resultList.size();
    }

    @Override
    public String getItem(int position) {
        return resultList.get(position).getDescription();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                FilterResults filterResults = new FilterResults();
                if (constraint != null) {
                    resultList = autoComplete(constraint.toString());

                    filterResults.values = resultList;
                    filterResults.count = resultList.size();
                }
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                if (results != null && results.count > 0) {
                    notifyDataSetChanged();
                }
                else {
                    notifyDataSetInvalidated();
                }
            }
        };
    }

    private List<PlacesPrediction> autoComplete(String input) {
        PlacesResponse response = GooglePlacesApiClient.getGooglePlacesService().getPlacesAutocomplete(Config.GOOGLE_PLACES_API_KEY, input);
        if (response != null) {
            return response.getPredictions();
        }
        else {
            return new ArrayList<PlacesPrediction>();
        }
    }
}