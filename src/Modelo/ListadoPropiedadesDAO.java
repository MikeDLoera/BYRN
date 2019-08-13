
package Modelo;

import byrn.BYRN;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author CST-UTJ
 */
public class ListadoPropiedadesDAO {
    
    private HashMap<String,ArrayList> estates;
    private HashMap[] users;
    private HashMap[] types;
    private ArrayList<HashMap> allEstates = new ArrayList<>();
    
    public ListadoPropiedadesDAO() {
        
    }
    
    public void allEstates() throws UnirestException{
        HttpResponse request;
        String path = "/estates";
        request = PeticionHTTP.get(path,BYRN.getAuth().getToken());
        estates = BYRN.gson.fromJson(request.getBody().toString(), HashMap.class);
        //allEstates.add(estate);
        //System.out.println(estates);
    }
    
    public void getAllEstates() throws UnirestException{
        HttpResponse request;
        String path = "/estates";
        request = PeticionHTTP.get(path,BYRN.getAuth().getToken());
        boolean b = true;
        do{
            request = PeticionHTTP.get(path,BYRN.getAuth().getToken());
            estates = BYRN.gson.fromJson(request.getBody().toString(), HashMap.class);
            int l = estates.get("data").size();
            for (int i = 0; i < l; i++) {
                String json = BYRN.gson.toJson(estates.get("data").get(i));
                System.out.println(json);
                HashMap aux = BYRN.gson.fromJson(json, HashMap.class);
                allEstates.add(aux);
            }
            System.out.println(estates.get("next_page_url"));
            String next = estates.get("next_page_url")+"";
            if (next.equals("null")) {
                b = false;
            }else{
                path = next.substring(next.indexOf("/estates"));
            }
            
        }while(b);
        
    }
    
    public void allUsers() throws UnirestException{
        HttpResponse request;
        String path = "/users";
        request = PeticionHTTP.get(path,BYRN.getAuth().getToken());
        users = BYRN.gson.fromJson(request.getBody().toString(), HashMap[].class);
       
    }
    
    public void allTypes() throws UnirestException{
        HttpResponse request;
        String path = "/estate-types";
        request = PeticionHTTP.get(path,BYRN.getAuth().getToken());
        types = BYRN.gson.fromJson(request.getBody().toString(), HashMap[].class);
        
    }
    
    public String getOwnerName(String id){
        int owner_id = Integer.parseInt(id.substring(0,id.indexOf(".0")));
        String ownerName = "";
        int length = users.length;
        for (int i = 0; i < length; i++) {
            String json = BYRN.gson.toJson(users[i]);
            HashMap <String,Object> user = BYRN.gson.fromJson(json, HashMap.class);
            int userId = Integer.parseInt(user.get("id").toString().substring(0,user.get("id").toString().indexOf(".0")));
            if (userId==owner_id) {
                ownerName = user.get("name")+" "+user.get("last_name");
                break;
            }
        }
        return ownerName;
    }
    
    
    
    
    
}