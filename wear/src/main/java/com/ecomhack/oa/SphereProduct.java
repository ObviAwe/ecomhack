package com.ecomhack.oa;

import com.google.gson.annotations.SerializedName;

public class SphereProduct {
    private MasterVariant masterVariant;
    @SerializedName("name")
    private LocalizedName localizedName;
    private LocalizedName description;

    public MasterVariant getMasterVariant() {
        return masterVariant;
    }

    public LocalizedName getName() {
        return localizedName;
    }

    public LocalizedName getDescription() {
        return description;
    }
}
