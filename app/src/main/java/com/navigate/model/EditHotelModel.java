package com.navigate.model;

public class EditHotelModel {


    private String id;
    private String hotelname;
    private String locationhotel;

    public EditHotelModel(String id, String hotelname, String locationhotel) {
        this.id = id;
        this.hotelname = hotelname;
        this.locationhotel = locationhotel;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHotelname() {
        return hotelname;
    }

    public void setHotelname(String hotelname) {
        this.hotelname = hotelname;
    }

    public String getLocationhotel() {
        return locationhotel;
    }

    public void setLocationhotel(String locationhotel) {
        this.locationhotel = locationhotel;
    }
}
