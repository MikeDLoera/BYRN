
package Modelo;

import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import kong.unirest.UnirestException;

/**
 *
 * @author CST-UTJ
 */
public class PeticionHTTP {
    private static String baseurl = "https://byrn-dev.herokuapp.com/";
    private static String url = baseurl+"/api";
    
    public static HttpResponse get(String path, String token) throws UnirestException {
        HttpResponse response = Unirest . get(url+path)
        .header("Content-type", "application/json")
        .header("Accept", "application/json")
        .header("Authorization", "Bearer"+token)
        .asJson();
        return response;
    }
    
    public static HttpResponse post(String path, String json, String token) throws UnirestException{
        HttpResponse response =  Unirest . post(url+path)
        .header("Content-type" , "application/json")
        .header("Accept", "application/json")
        .header("Authorization", "Bearer"+token)
        .body(json)
        .asJson();
        return response;
    }
    
    public static HttpResponse delete(String path, String token) throws UnirestException {
        HttpResponse response = Unirest . delete(url+path)
        .header("Content-type" , "application/json")
        .header("Accept", "application/json")
        .header("Authorization", "Bearer"+token)
        .asJson();
        return response;
    }
    
    public static HttpResponse put(String path, String json, String token) throws UnirestException{
        HttpResponse response =  Unirest . put(url+path)
        .header("Content-type" , "application/json")
        .header("Accept", "application/json")
        .header("Authorization", "Bearer"+token)
        .body(json)
        .asJson ();
        return response;
    }

    public static String getBaseurl() {
        return baseurl;
    }

    public static String getUrl() {
        return url;
    }

    
}
