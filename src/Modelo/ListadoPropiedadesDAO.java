
package Modelo;

import byrn.BYRN;
import byrn.Ordenamiento;
import kong.unirest.HttpResponse;
import kong.unirest.UnirestException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author CST-UTJ
 */
public class ListadoPropiedadesDAO {
    
    private HashMap[] users;
    private HashMap[] types;
    private ArrayList<HashMap> allEstates;
    private HashMap[] arrayEstates;
    private HashMap cities;
    private HashMap[] negocio;
    
    public ListadoPropiedadesDAO() {
        
    }
    
    
    public void estatesList() throws UnirestException{
        HashMap<String,ArrayList> estates;
        allEstates = new ArrayList<>();
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
                HashMap aux = BYRN.gson.fromJson(json, HashMap.class);
                allEstates.add(aux);
            }
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
        Ordenamiento.quickSort(users, 0, users.length-1);
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
        /*int length = users.length;
        for (int i = 0; i < length; i++) {
            String json = BYRN.gson.toJson(users[i]);
            HashMap <String,Object> user = BYRN.gson.fromJson(json, HashMap.class);
            int userId = Integer.parseInt(user.get("id").toString().substring(0,user.get("id").toString().indexOf(".0")));
            if (userId==owner_id) {
                ownerName = user.get("name")+" "+user.get("last_name");
                break;
            }
        }*/
        int e = Ordenamiento.busquedaBinaria(users, owner_id);
        ownerName = users[e].get("name")+" "+users[e].get("last_name");
        return ownerName;
    }
    
    public void listarCiudadesNegocios() throws UnirestException{
        cities = BYRN.gson.fromJson(PeticionHTTP.get("/cities", BYRN.getAuth().getToken()).getBody().toString(), HashMap.class);
        negocio = BYRN.gson.fromJson(PeticionHTTP.get("/bussiness-types", BYRN.getAuth().getToken()).getBody().toString(), HashMap[].class);
    }
    
    public String oneState(int id){
        HttpResponse aux = PeticionHTTP.get("/estates/"+id, BYRN.getAuth().getToken());
        return aux.getBody().toString();
    }

    public HashMap[] getUsers() {
        return users;
    }

    public HashMap[] getTypes() {
        return types;
    }

    public ArrayList<HashMap> getAllEstates() {
        return allEstates;
    }
    
    public HashMap getCities() {
        return cities;
    }

    public HashMap[] getNegocio() {
        return negocio;
    }

    public void setNegocio(HashMap[] negocio) {
        this.negocio = negocio;
    }

    public HashMap[] getArrayEstates() {
        return arrayEstates;
    }

    public void setArrayEstates() {
        arrayEstates = new HashMap[allEstates.size()];
        for (int i = 0; i < allEstates.size(); i++) {
            arrayEstates[i] = allEstates.get(i);
        }
    }
    
}