
package Modelo;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 *
 * @author CST-UTJ
 */
public class PeticionHTTP {
    private static String url = "https://byrn-dev.herokuapp.com/api";
    
    public static HttpResponse get(String path) throws UnirestException {
        HttpResponse response = Unirest . get(url+path)
        .header("Content-type", "application/json")
        .header("Accept", "application/json")
        .header("Authorization", "Bearer")
        .asJson();
        return response;
    }
    
    public static HttpResponse post(String path, String json) throws UnirestException{
        HttpResponse response =  Unirest . post(url+path)
        .header ("Content-type" , "application/json")
        .header("Accept", "application/json")
        .header("Authorization", "Bearer")
        .body(json)
        .asJson();
        return response;
    }
    
    public static HttpResponse delete(String path) throws Exception{
        HttpResponse response = Unirest . delete(url+path)
        .header ("Content-type" , "application/json")
        .header("Accept", "application/json")
        .header("Authorization", "Bearer")
        .asJson();
        return response;
    }
    
    public static HttpResponse put(String path, String json) throws UnirestException{
        HttpResponse response =  Unirest . put(url+path)
        .header ("Content-type" , "application/json")
        .header("Accept", "application/json")
        .header("Authorization", "Bearer")
        .body(json)
        .asJson ();
        return response;
    }
    
}
