
package Modelo;

/**
 *
 * @author CST-UTJ
 */
public class City {
    private int number;
    private String update_at;
    private String name;
    private String created_at;
    private int id;
    private int state_id;

    public City(int number, String update_at, String name, String created_at, int id, int state_id) {
        this.number = number;
        this.update_at = update_at;
        this.name = name;
        this.created_at = created_at;
        this.id = id;
        this.state_id = state_id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getState_id() {
        return state_id;
    }

    public void setState_id(int state_id) {
        this.state_id = state_id;
    }
    
}
