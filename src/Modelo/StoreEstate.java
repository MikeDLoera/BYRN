
package Modelo;

/**
 *
 * @author CST-UTJ
 */
public class StoreEstate {
    private String name;
    private int image_url;
    private String description;
    private int owner_id;
    private int estate_type;
    private int business_type;
    private int commision_or_advertising;
    private String surface_area;
    private int meter_price;
    private int seller_price;
    private double latitude;
    private double longitude;
    private String street;
    private String outside_number;
    private String neighborhood;
    private int postal_code;
    private int city_id;

    public StoreEstate(String name, int image_url, String description, int owner_id, int estate_type, int business_type, int commision_or_advertising, String surface_area, int meter_price, int seller_price, double latitude, double longitude, String street, String outside_number, String neighborhood, int postal_code, int city_id) {
        this.name = name;
        this.image_url = image_url;
        this.description = description;
        this.owner_id = owner_id;
        this.estate_type = estate_type;
        this.business_type = business_type;
        this.commision_or_advertising = commision_or_advertising;
        this.surface_area = surface_area;
        this.meter_price = meter_price;
        this.seller_price = seller_price;
        this.latitude = latitude;
        this.longitude = longitude;
        this.street = street;
        this.outside_number = outside_number;
        this.neighborhood = neighborhood;
        this.postal_code = postal_code;
        this.city_id = city_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage_url() {
        return image_url;
    }

    public void setImage_url(int image_url) {
        this.image_url = image_url;
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

    public String getSurface_area() {
        return surface_area;
    }

    public void setSurface_area(String surface_area) {
        this.surface_area = surface_area;
    }

    public int getMeter_price() {
        return meter_price;
    }

    public void setMeter_price(int meter_price) {
        this.meter_price = meter_price;
    }

    public int getSeller_price() {
        return seller_price;
    }

    public void setSeller_price(int seller_price) {
        this.seller_price = seller_price;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
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

    public int getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }

    public int getCity_id() {
        return city_id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }
    
    
    
    
    
}
