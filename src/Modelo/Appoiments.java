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
public class Appoiments {
    private int id;
    private int customer_id;
    private int estate_id;
    private String date;
    private String start_time;
    private int end_date;
    private String location;
    private String appoiment_type;
    private String guests;
    private String comments;
    private char status;
    private long created_at;
    private long updated_at;

    public Appoiments(int id, int customer_id, int estate_id, String date, String start_time, int end_date, String location, String appoiment_type, String guests, String comments, char status, long created_at, long updated_at) {
        this.id = id;
        this.customer_id = customer_id;
        this.estate_id = estate_id;
        this.date = date;
        this.start_time = start_time;
        this.end_date = end_date;
        this.location = location;
        this.appoiment_type = appoiment_type;
        this.guests = guests;
        this.comments = comments;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public int getEnd_date() {
        return end_date;
    }

    public void setEnd_date(int end_date) {
        this.end_date = end_date;
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

    public String getGuests() {
        return guests;
    }

    public void setGuests(String guests) {
        this.guests = guests;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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
