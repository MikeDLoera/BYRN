
package Modelo;

import byrn.BYRN;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.exceptions.UnirestException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author CST-UTJ
 */
public class ListadoPropiedadesDAO {
    private AllEstates allEstates;
    private EstateType[] allEstatesType;
    private User[] allUsers;
    
    public ListadoPropiedadesDAO() {
        allEstates();
        //allEstatesType();
        allUsers();
    }
    
    private void allEstates(){
        try {
            HttpResponse request = null;
            String path = "/estates?email="+BYRN.getSesion().getEmail()+"&password="+BYRN.getSesion().getPassword();
            String token = BYRN.getAuth().getToken();
            request = PeticionHTTP.get(path, token);
            
            this.allEstates = BYRN.gson.fromJson(request.getBody().toString(), AllEstates.class);
        } catch (UnirestException ex) {
            Logger.getLogger(ListadoPropiedadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void allEstatesType(){
        try {
            HttpResponse request = null;
            String path = "/estate-types";
            String token = BYRN.getAuth().getToken();
            request = PeticionHTTP.get(path, token);
            this.allEstatesType = BYRN.gson.fromJson(request.getBody().toString(), EstateType[].class);
        } catch (UnirestException ex) {
            Logger.getLogger(ListadoPropiedadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void allUsers(){
        try {
            HttpResponse request = null;
            String path = "/users?email="+BYRN.getSesion().getEmail()+"&password="+BYRN.getSesion().getPassword();
            String token = BYRN.getAuth().getToken();
            request = PeticionHTTP.get(path, token);
            this.allUsers = BYRN.gson.fromJson(request.getBody().toString(), User[].class);
        } catch (UnirestException ex) {
            Logger.getLogger(ListadoPropiedadesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    
    public String getEstateTypeName(int estate_type_id){
        String estateTypeName = null;
        int length = allEstatesType.length;
        for (int i = 0; i < length; i++) {
            if (allEstatesType[i].getId()==estate_type_id) {
                estateTypeName = allEstatesType[i].getName();
                break;
            }
        }
        return estateTypeName;
    }

    public AllEstates getAllEstates() {
        return allEstates;
    }

    public void setAllEstates(AllEstates allEstates) {
        this.allEstates = allEstates;
    }

    public EstateType[] getAllEstatesType() {
        return allEstatesType;
    }

    public void setAllEstatesType(EstateType[] allEstatesType) {
        this.allEstatesType = allEstatesType;
    }

    public User[] getAllUsers() {
        return allUsers;
    }

    public void setAllUsers(User[] allUsers) {
        this.allUsers = allUsers;
    }
    
}
