
package Modelo;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.HashMap;

/**
 *
 * @author CST-UTJ
 */
public class PeticionHTTP {
    private static String url = "http://18.224.153.86:8000/api";
    
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
    
    public static HttpResponse postFormData(String path,HashMap mapa,String token) throws UnirestException{
        HttpResponse response =  Unirest . post(url+path)
        .header("Content-type" , "application/json")
        .header("Authorization", "Bearer"+token)
        .queryString(mapa)
        .asJson();
        return response;
    }
    
    public static HttpResponse putFormData(String path,HashMap mapa,String token) throws UnirestException{
        HttpResponse response =  Unirest . post(url+path)
        .header("Content-type" , "application/json")
        .header("Authorization", "Bearer"+token)
        .queryString(mapa)
        .asJson();
        return response;
    }
}
