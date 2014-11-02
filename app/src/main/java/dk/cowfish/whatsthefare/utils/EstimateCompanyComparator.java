package dk.cowfish.whatsthefare.utils;

import java.util.Comparator;

import dk.cowfish.whatsthefare.api.model.wtfare.Estimate;

public class EstimateCompanyComparator implements Comparator<Estimate> {
    @Override
    public int compare(Estimate estimate, Estimate estimate2) {
        if (estimate != null && estimate2 != null
                && estimate.getCompany() != null && estimate2.getCompany() != null) {
            return estimate.getCompany().compareTo(estimate2.getCompany());
        }
        return 0;
    }
}