package dk.cowfish.whatsthefare.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import dk.cowfish.whatsthefare.R;
import dk.cowfish.whatsthefare.api.model.wtfare.Estimate;

public class FareEstimatesAdapter extends RecyclerView.Adapter<FareEstimatesAdapter.ViewHolder> {
    private List<Estimate> estimates;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView serviceLogo;
        public TextView serviceName, serviceFare;

        public ViewHolder(View itemView) {
            super(itemView);
            serviceLogo = (ImageView) itemView.findViewById(R.id.service_logo);
            serviceName = (TextView) itemView.findViewById(R.id.service_name);
            serviceFare = (TextView) itemView.findViewById(R.id.service_fare);
        }
    }

    public FareEstimatesAdapter(List<Estimate> estimates) {
        this.estimates = estimates != null ? estimates : new ArrayList<Estimate>();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                                  .inflate(R.layout.list_item_fare_estimate, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Estimate estimate = estimates.get(position);
        holder.serviceName.setText(estimate.getService());
        holder.serviceFare.setText("$" + estimate.getEstimatedFare());
    }

    @Override
    public int getItemCount() {
        return estimates.size();
    }
}