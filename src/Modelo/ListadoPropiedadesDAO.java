
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
    private AllEstates allEstates = null;
    private User[] allUsers = null;
    private EstateType[] allEstatesTypes;
    
    public ListadoPropiedadesDAO() {
        
    }
    
    public HttpResponse allEstates() throws UnirestException{
        HttpResponse request = null;
        String path = "/estates";
        request = PeticionHTTP.get(path,BYRN.getAuth().getToken());
            
        this.allEstates = BYRN.gson.fromJson(request.getBody().toString(), AllEstates.class);
        
        HashMap<String, ArrayList> n = BYRN.gson.fromJson(request.getBody().toString(), HashMap.class);
        //System.out.println(n.get("data").toString());
        ArrayList l = n.get("data");
        System.out.println(l.get(0));
        return request;
        
    }
    
    public HttpResponse allUsers() throws UnirestException{
        HttpResponse request = null;
        String path = "/users";
        request = PeticionHTTP.get(path,BYRN.getAuth().getToken());
        this.allUsers = BYRN.gson.fromJson(request.getBody().toString(), User[].class);
        return request;
    }
    
    public HttpResponse allTypes() throws UnirestException{
        HttpResponse request = null;
        String path = "/estate-types";
        request = PeticionHTTP.get(path,BYRN.getAuth().getToken());
        this.allEstatesTypes = BYRN.gson.fromJson(request.getBody().toString(), EstateType[].class);
        return request;
    }
    
    public String getOwnerName(int owner_id){
        String ownerName = null;
        int length = allUsers.length;
        for (int i = 0; i < length; i++) {
            if (allUsers[i].getId()==owner_id) {
                ownerName = allUsers[i].getName()+" "+allUsers[i].getLast_name();
                break;
            }
        }
        return ownerName;
    }

    public AllEstates getAllEstates() {
        return allEstates;
    }

    public void setAllEstates(AllEstates allEstates) {
        this.allEstates = allEstates;
    }

    public User[] getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(User[] allUsers) {
        this.allUsers = allUsers;
    }

    public EstateType[] getAllEstatesTypes() {
        return allEstatesTypes;
    }

    public void setAllEstatesTypes(EstateType[] allEstatesTypes) {
        this.allEstatesTypes = allEstatesTypes;
    }
    
}
