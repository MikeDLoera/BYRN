
package Modelo;

/**
 *
 * @author CST-UTJ
 */
public class User {
    private int id;
    private String name;
    private String last_name;
    private String email;
    private String street;
    private String outside_number;
    private String interior_numbre;
    private String neighborhood;
    private String postal_code;
    private int city_id;
    private int state_id;
    private String phonenumber;
    private String cellphone;
    private String birthdate;
    private char status;
    private String created_at;
    private String updated_at;

    public User(int id, String name, String last_name, String email, String street, String outside_number, String interior_numbre, String neighborhood, String postal_code, int city_id, int state_id, String phonenumber, String cellphone, String birthdate, char status, String created_at, String updated_at) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.street = street;
        this.outside_number = outside_number;
        this.interior_numbre = interior_numbre;
        this.neighborhood = neighborhood;
        this.postal_code = postal_code;
        this.city_id = city_id;
        this.state_id = state_id;
        this.phonenumber = phonenumber;
        this.cellphone = cellphone;
        this.birthdate = birthdate;
        this.status = status;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getOutside_number() {
        return outside_number;
    }

    public void setOutside_number(String outside_number) {
        this.outside_number = outside_number;
    }

    public String getInterior_numbre() {
        return interior_numbre;
    }

    public void setInterior_numbre(String interior_numbre) {
        this.interior_numbre = interior_numbre;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public int getState_id() {
        return state_id;
    }

    public void setState_id(int state_id) {
        this.state_id = state_id;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

  
}
