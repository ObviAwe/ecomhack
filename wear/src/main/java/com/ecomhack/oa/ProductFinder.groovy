package com.ecomhack.oa

import com.ecomhack.product.Product
import com.google.gson.Gson

import javax.net.ssl.HttpsURLConnection;

public class ProductFinder {
    def static foodpairingIDs = ['3999', '150', '4948', '4279', '4130']
    def static counter = 0;
    def static token;

    public static void main(String[] args) {
        token = retrieveToken()
        println getProduct([]).name
        println getProduct([]).name
        println getProduct([]).name
        println getProduct([]).name
        println getProduct([]).name
    }

    public static Product getProduct(List products) {
            def foodpairingID = foodpairingIDs[counter++]
            String response = "";
            def url = new URL("https://api.sphere.io/ecomhack-15-002-83/product-projections/search?staged=true&limit=1&filter.query=variants.attributes.foodpairingId:$foodpairingID")
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection()
            urlConnection.setRequestProperty('Authorization', "Bearer $token")
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

    public static String retrieveToken() {
        String response = "";

        def  url = new URL("https://auth.sphere.io/oauth/token?grant_type=client_credentials&scope=manage_project:ecomhack-15-002-83");
        HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
        urlConnection.setRequestMethod("POST");
        urlConnection.setRequestProperty("Authorization", "Basic emVQcUJiSXRmMU4tTXBKNng0a1dzOGZ4Ok5FU28teEZoUXFiNXE5N2R3blprMVpfcVVEYVNuMEZG");
        BufferedReader input = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        String inputLine;
        while ((inputLine = input.readLine()) != null)
            response += inputLine;
        input.close();

        Map result = new Gson().fromJson(response, Map.class)
        result.access_token
    }



}