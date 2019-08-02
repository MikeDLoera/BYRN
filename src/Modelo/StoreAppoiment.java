/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Samlml
 */
public class StoreAppoiment {
    
    private int customer_id;
    private int estate_id;
    private Date date;
    private String start_time;
    private String location;
    private String appoiment_type;

    public StoreAppoiment(int customer_id, int estate_id, Date date, String start_time, String location, String appoiment_type) {
        this.customer_id = customer_id;
        this.estate_id = estate_id;
        this.date = date;
        this.start_time = start_time;
        this.location = location;
        this.appoiment_type = appoiment_type;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getEstate_id() {
        return estate_id;
    }

    public void setEstate_id(int estate_id) {
        this.estate_id = estate_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAppoiment_type() {
        return appoiment_type;
    }

    public void setAppoiment_type(String appoiment_type) {
        this.appoiment_type = appoiment_type;
    }
    
    
    
}
