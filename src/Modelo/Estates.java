
package Modelo;

/**
 *
 * @author CST-UTJ
 */
public class Estates {
    	private int id;
	private String name;
	private int image_id;
	private String description;
	private int owner_id;
	private int estate_type;
	private int business_type;
	private int commision_or_advertasing;
	private char sell_or_rent;
	private char ejidal_or_private;
	private String surface_area;
	private double seller_price;
	private double seller_minimum_price;
	private int meter_price;
	private int front_meters;
	private int long_meters;
	private char has_underground_water;
	private String agent_comments;
	private String latitude;
	private String longitude;
	private char has_drinkable_water;
	private char sewer_system;
	private char public_light;
	private char is_heritage;
	private char is_needy;
	private String street;
	private String outside_number;
	private String interior_number;
	private String neighborhood;
	private String postalcode;
	private int city_id;
	private int state_id;
	private int bathrooms;
	private int parking_lots;
	private int floors;
	private int construction_area;
	private int bedrooms;
	private char status;
	private long created_at;
	private long updated_at;

    public Estates(int id, String name, int image_id, String description, int owner_id, int estate_type, int business_type, int commision_or_advertasing, char sell_or_rent, char ejidal_or_private, String surface_area, double seller_price, double seller_minimum_price, int meter_price, int front_meters, int long_meters, char has_underground_water, String agent_comments, String latitude, String longitude, char has_drinkable_water, char sewer_system, char public_light, char is_heritage, char is_needy, String street, String outside_number, String interior_number, String neighborhood, String postalcode, int city_id, int state_id, int bathrooms, int parking_lots, int floors, int construction_area, int bedrooms, char status, long created_at, long updated_at) {
        this.id = id;
        this.name = name;
        this.image_id = image_id;
        this.description = description;
        this.owner_id = owner_id;
        this.estate_type = estate_type;
        this.business_type = business_type;
        this.commision_or_advertasing = commision_or_advertasing;
        this.sell_or_rent = sell_or_rent;
        this.ejidal_or_private = ejidal_or_private;
        this.surface_area = surface_area;
        this.seller_price = seller_price;
        this.seller_minimum_price = seller_minimum_price;
        this.meter_price = meter_price;
        this.front_meters = front_meters;
        this.long_meters = long_meters;
        this.has_underground_water = has_underground_water;
        this.agent_comments = agent_comments;
        this.latitude = latitude;
        this.longitude = longitude;
        this.has_drinkable_water = has_drinkable_water;
        this.sewer_system = sewer_system;
        this.public_light = public_light;
        this.is_heritage = is_heritage;
        this.is_needy = is_needy;
        this.street = street;
        this.outside_number = outside_number;
        this.interior_number = interior_number;
        this.neighborhood = neighborhood;
        this.postalcode = postalcode;
        this.city_id = city_id;
        this.state_id = state_id;
        this.bathrooms = bathrooms;
        this.parking_lots = parking_lots;
        this.floors = floors;
        this.construction_area = construction_area;
        this.bedrooms = bedrooms;
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

    public int getImage_id() {
        return image_id;
    }

    public void setImage_id(int image_id) {
        this.image_id = image_id;
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

    public int getCommision_or_advertasing() {
        return commision_or_advertasing;
    }

    public void setCommision_or_advertasing(int commision_or_advertasing) {
        this.commision_or_advertasing = commision_or_advertasing;
    }

    public char getSell_or_rent() {
        return sell_or_rent;
    }

    public void setSell_or_rent(char sell_or_rent) {
        this.sell_or_rent = sell_or_rent;
    }

    public char getEjidal_or_private() {
        return ejidal_or_private;
    }

    public void setEjidal_or_private(char ejidal_or_private) {
        this.ejidal_or_private = ejidal_or_private;
    }

    public String getSurface_area() {
        return surface_area;
    }

    public void setSurface_area(String surface_area) {
        this.surface_area = surface_area;
    }

    public double getSeller_price() {
        return seller_price;
    }

    public void setSeller_price(double seller_price) {
        this.seller_price = seller_price;
    }

    public double getSeller_minimum_price() {
        return seller_minimum_price;
    }

    public void setSeller_minimum_price(double seller_minimum_price) {
        this.seller_minimum_price = seller_minimum_price;
    }

    public int getMeter_price() {
        return meter_price;
    }

    public void setMeter_price(int meter_price) {
        this.meter_price = meter_price;
    }

    public int getFront_meters() {
        return front_meters;
    }

    public void setFront_meters(int front_meters) {
        this.front_meters = front_meters;
    }

    public int getLong_meters() {
        return long_meters;
    }

    public void setLong_meters(int long_meters) {
        this.long_meters = long_meters;
    }

    public char getHas_underground_water() {
        return has_underground_water;
    }

    public void setHas_underground_water(char has_underground_water) {
        this.has_underground_water = has_underground_water;
    }

    public String getAgent_comments() {
        return agent_comments;
    }

    public void setAgent_comments(String agent_comments) {
        this.agent_comments = agent_comments;
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

    public char getHas_drinkable_water() {
        return has_drinkable_water;
    }

    public void setHas_drinkable_water(char has_drinkable_water) {
        this.has_drinkable_water = has_drinkable_water;
    }

    public char getSewer_system() {
        return sewer_system;
    }

    public void setSewer_system(char sewer_system) {
        this.sewer_system = sewer_system;
    }

    public char getPublic_light() {
        return public_light;
    }

    public void setPublic_light(char public_light) {
        this.public_light = public_light;
    }

    public char getIs_heritage() {
        return is_heritage;
    }

    public void setIs_heritage(char is_heritage) {
        this.is_heritage = is_heritage;
    }

    public char getIs_needy() {
        return is_needy;
    }

    public void setIs_needy(char is_needy) {
        this.is_needy = is_needy;
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

    public String getInterior_number() {
        return interior_number;
    }

    public void setInterior_number(String interior_number) {
        this.interior_number = interior_number;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
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

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public int getParking_lots() {
        return parking_lots;
    }

    public void setParking_lots(int parking_lots) {
        this.parking_lots = parking_lots;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getConstruction_area() {
        return construction_area;
    }

    public void setConstruction_area(int construction_area) {
        this.construction_area = construction_area;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public long getCreated_at() {
        return created_at;
    }

    public void setCreated_at(long created_at) {
        this.created_at = created_at;
    }

    public long getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(long updated_at) {
        this.updated_at = updated_at;
    }
    
}
