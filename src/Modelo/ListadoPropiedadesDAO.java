
package Modelo;

import byrn.BYRN;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;

/**
 *
 * @author CST-UTJ
 */
public class ListadoPropiedadesDAO {
    private AllEstates allEstates = null;
    private User[] allUsers = null;
    
    public ListadoPropiedadesDAO() {
        
    }
    
    public HttpResponse allEstates() throws UnirestException{
            HttpResponse request = null;
            String path = "/estates";
            String token = BYRN.getAuth().getToken();
            request = PeticionHTTP.get(path, token);
            
            this.allEstates = BYRN.gson.fromJson(request.getBody().toString(), AllEstates.class);
            return request;
        
    }
    
    public HttpResponse allUsers() throws UnirestException{
            HttpResponse request = null;
            String path = "/users";
            String token = BYRN.getAuth().getToken();
            request = PeticionHTTP.get(path, token);
            this.allUsers = BYRN.gson.fromJson(request.getBody().toString(), User[].class);
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
    
}
