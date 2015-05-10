package com.ecomhack.oa;

import java.util.List;

public class ProductSearchResult {
    private int total;
    private List<SphereProduct> results;

    public int getTotal() {
        return total;
    }

    public List<SphereProduct> getProducts() {
        return results;
    }
}
