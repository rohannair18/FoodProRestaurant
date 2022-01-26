package com.example.foodprorestaurant;

public class Restaurant {
    String s_name;
    String s_email;
    String s_restaurantname;
    String s_location;


    public Restaurant(String s_name, String s_email, String s_restaurantname, String s_location) {
        this.s_name = s_name;
        this.s_email = s_email;
        this.s_restaurantname = s_restaurantname;
        this.s_location = s_location;
    }

    public Restaurant( ) {}



    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getS_email() {
        return s_email;
    }

    public void setS_email(String s_email) {
        this.s_email = s_email;
    }

    public String getS_restaurantname() {
        return s_restaurantname;
    }

    public void setS_restaurantname(String s_restaurantname) {
        this.s_restaurantname = s_restaurantname;
    }

    public String getS_location() {
        return s_location;
    }

    public void setS_location(String s_location) {
        this.s_location = s_location;
    }
}
