package com.ecomhack.oa;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class MasterVariant {
    private String sku;
    private List<Image> images;

    private List<Map> attributes;

    public String getSku() {
        return sku;
    }

    public List<Image> getImages() {
        return images;
    }

    public List<Map> getAttributes() {
        return attributes;
    }

}
