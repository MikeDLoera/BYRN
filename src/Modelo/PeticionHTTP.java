/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 *
 * @author CST-UTJ
 */
public class PeticionHTTP {
    private static String url = "https://83c788c2-0e93-44dd-8806-3f41bd0b65eb.mock.pstmn.io";
    
    public static HttpResponse get(String path) throws UnirestException {
        HttpResponse response = Unirest . get(url+path)
        //.queryString("key", "43432254")
        .asJson();
        return response;
    }
    
    public static HttpResponse post(String path, String json) throws UnirestException{
        HttpResponse response =  Unirest . post(url+path)
        .header ("accept" , "application / json")
        .body(json)
        .asJson ();
        return response;
    }
    
    public static HttpResponse delete(String path) throws Exception{
        HttpResponse response = Unirest . delete(url+path)
        .header("accept", "application/json")
        .asJson();
        return response;
    }
    
    public static HttpResponse put(String path, String json) throws UnirestException{
        HttpResponse response =  Unirest . put(url+path)
        .header ("accept" , "application/json")
        .body(json)
        .asJson ();
        return response;
    }
    
}
