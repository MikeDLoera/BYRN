
package Modelo;

/**
 *
 * @author CST-UTJ
 */
public class UpdateEstate {
    private String name;
    private String description;
    private int owner_id;
    private int estate_type;
    private int business_type;
    private int commision_or_advertising;
    private int surface_area;
    private double seller_price;
    private String latitude;
    private String longitude;
    private String address;
    private int city_id;

    public UpdateEstate(String name, String description, int owner_id, int estate_type, int business_type, int commision_or_advertising, int surface_area, double seller_price, String latitude, String longitude, String address, int city_id) {
        this.name = name;
        this.description = description;
        this.owner_id = owner_id;
        this.estate_type = estate_type;
        this.business_type = business_type;
        this.commision_or_advertising = commision_or_advertising;
        this.surface_area = surface_area;
        this.seller_price = seller_price;
        this.latitude = latitude;
        this.longitude = longitude;
        this.address = address;
        this.city_id = city_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(int owner_id) {
        this.owner_id = owner_id;
    }

    public int getEstate_type() {
        return estate_type;
    }

    public void setEstate_type(int estate_type) {
        this.estate_type = estate_type;
    }

    public int getBusiness_type() {
        return business_type;
    }

    public void setBusiness_type(int business_type) {
        this.business_type = business_type;
    }

    public int getCommision_or_advertising() {
        return commision_or_advertising;
    }

    public void setCommision_or_advertising(int commision_or_advertising) {
        this.commision_or_advertising = commision_or_advertising;
    }

    public int getSurface_area() {
        return surface_area;
    }

    public void setSurface_area(int surface_area) {
        this.surface_area = surface_area;
    }

    public double getSeller_price() {
        return seller_price;
    }

    public void setSeller_price(double seller_price) {
        this.seller_price = seller_price;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }
    
    
}
