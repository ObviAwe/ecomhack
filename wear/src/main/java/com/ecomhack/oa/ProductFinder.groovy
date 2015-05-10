package com.ecomhack.oa

import com.ecomhack.product.Product
import com.google.gson.Gson

import javax.net.ssl.HttpsURLConnection;

public class ProductFinder {
    def static foodpairingIDs = ['3999', '150', '4948', '4279', '4130']
    def static counter = 0;

    public static void main(String[] args) {
        println getProduct([]).name
        println getProduct([]).name
        println getProduct([]).name
        println getProduct([]).name
        println getProduct([]).name
    }

    public static Product getProduct(List products) {
            def foodpairingID = foodpairingIDs[counter++]
            String response = "";
            def url = new URL('https://api.sphere.io/ecomhack-15-002-83/product-projections/search?staged=true&limit=1&filter.query=variants.attributes.foodpairingId:'+foodpairingID)
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection()
            urlConnection.setRequestProperty('Authorization', 'Bearer 673kjspXv-_JpPcd-S9lw-6oeKjMwiTS')
            BufferedReader input = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String inputLine
            while ((inputLine = input.readLine()) != null)
                response += inputLine;
            input.close();
            def gson = new Gson()
            def productSearchResult = gson.fromJson(response, ProductSearchResult.class)

            def sphereProduct = productSearchResult.products.first()
            def product = new Product(sphereProduct)

            return product
    }



}