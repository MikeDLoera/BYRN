
package Modelo;

/**
 *
 * @author CST-UTJ
 */
public class StoreEstate {
    private String name;
    private String description;
    private int owner_id;
    private int estate_type;
    private int business_type;
    private int commision_or_advertising;
    private String surface_area=null;
    private int meter_price;
    private int seller_price;
    
    private String latitude=null;
    private String longitude=null;
    
    private String address;
    private int city_id;
      private long created_at;

    public StoreEstate() {
        
    }

    public StoreEstate(String name, String description, int owner_id, int estate_type, int business_type, int commision_or_advertising, String surface_area, int meter_price, int seller_price, String latitude, String longitude, String address, int city_id, long created_at) {
        this.name = name;
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
        this.address = address;
        this.city_id = city_id;
        this.created_at = created_at;
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

    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }
    
    
    
    

   
    
    
    
    
}
