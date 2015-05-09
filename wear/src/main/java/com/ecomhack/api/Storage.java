package com.ecomhack.api;

import com.ecomhack.product.AbstractProduct;

import java.util.List;

/**
 * Created by ckenklies on 09.05.15.
 */
public interface Storage {

    public AbstractProduct getProducts(List<AbstractProduct> products);

}
