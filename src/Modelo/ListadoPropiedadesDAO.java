
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
        try {
            runDao();
        } catch (UnirestException ex) {
            
        }
    }
    
    public void allEstates() throws UnirestException{
            HttpResponse request = null;
            String path = "/estates?email="+BYRN.getSesion().getEmail()+"&password="+BYRN.getSesion().getPassword();
            String token = BYRN.getAuth().getToken();
            request = PeticionHTTP.get(path, token);
            
            this.allEstates = BYRN.gson.fromJson(request.getBody().toString(), AllEstates.class);
        
    }
    
    public void allUsers() throws UnirestException{
            HttpResponse request = null;
            String path = "/users?email="+BYRN.getSesion().getEmail()+"&password="+BYRN.getSesion().getPassword();
            String token = BYRN.getAuth().getToken();
            request = PeticionHTTP.get(path, token);
            this.allUsers = BYRN.gson.fromJson(request.getBody().toString(), User[].class);
    }
    
    private void runDao() throws UnirestException{
        allEstates();
        allUsers();
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
