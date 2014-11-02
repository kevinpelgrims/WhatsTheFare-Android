package dk.cowfish.whatsthefare.views;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;

import dk.cowfish.whatsthefare.R;
import dk.cowfish.whatsthefare.adapters.PlacesAutoCompleteAdapter;

public class SearchFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_search, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        AutoCompleteTextView pickup = (AutoCompleteTextView) view.findViewById(R.id.pickup);
        pickup.setAdapter(new PlacesAutoCompleteAdapter(getActivity(), R.layout.list_item_search));

        AutoCompleteTextView destination = (AutoCompleteTextView) view.findViewById(R.id.destination);
        destination.setAdapter(new PlacesAutoCompleteAdapter(getActivity(), R.layout.list_item_search));
    }
}