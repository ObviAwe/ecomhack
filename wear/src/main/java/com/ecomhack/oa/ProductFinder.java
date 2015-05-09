package com.ecomhack.oa;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.Proxy;
import java.net.InetSocketAddress;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class ProductFinder {

    public static void main(String[] args) {
        String response = "";

        URL url;
        try {
            url = new URL("https://auth.sphere.io/oauth/token?grant_type=client_credentials&scope=manage_project:ecomhack-15-002-83");
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestMethod("POST");
            urlConnection.setRequestProperty("Authorization", "Basic emVQcUJiSXRmMU4tTXBKNng0a1dzOGZ4Ok5FU28teEZoUXFiNXE5N2R3blprMVpfcVVEYVNuMEZG");
            BufferedReader input = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String inputLine;
            while ((inputLine = input.readLine()) != null)
                response += inputLine;
            input.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(response);
    }

}