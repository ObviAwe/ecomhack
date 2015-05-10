package com.ecomhack.api;

import com.ecomhack.product.Product;

import java.util.List;

/**
 * Created by ckenklies on 09.05.15.
 */
public interface Storage {

    public Product getProduct(List<Product> products);

}
