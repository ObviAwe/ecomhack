package com.ecomhack.product;

import com.ecomhack.oa.SphereProduct;

import java.util.Map;

/**
 * Created by ckenklies on 09.05.15.
 */
public class Product {

    public String id;
    public String name;
    public String image;
    public String description;
    public String foodpairingID;

    public Product(SphereProduct sphereProduct) {
        name = sphereProduct.name.de;
        image = sphereProduct.masterVariant.images?.first().url
        id = sphereProduct.masterVariant.sku
        foodpairingID = sphereProduct.masterVariant.attributes.find{Map attribute -> attribute.name=='foodpairingId'}['value'];
        description = sphereProduct.description.de
    }
}
