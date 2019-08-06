
package Modelo;

/**
 *
 * @author Samlml
 */
public class EditarUsuarios {
    private String name;
    private String last_name;
    private String email;
    private String street;
    private String outside_number;
    private String neighborhood;
    private int cellphone;

    public EditarUsuarios(String name, String last_name, String email, String street, String outside_number, String neighborhood, int cellphone) {
        this.name = name;
        this.last_name = last_name;
        this.email = email;
        this.street = street;
        this.outside_number = outside_number;
        this.neighborhood = neighborhood;
        this.cellphone = cellphone;
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

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public int getCellphone() {
        return cellphone;
    }

    public void setCellphone(int cellphone) {
        this.cellphone = cellphone;
    }
    
    
}
