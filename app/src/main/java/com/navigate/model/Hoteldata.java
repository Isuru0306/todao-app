package com.navigate.model;

public class Hoteldata {

    private String id;
    private String hotelname;
    private String location;
    private String urlhotel;
    private String ratingshotels;
    private String pricehotes;

    public Hoteldata(String id, String hotelname, String location, String urlhotel, String ratingshotels, String pricehotes) {
        this.id = id;
        this.hotelname = hotelname;
        this.location = location;
        this.urlhotel = urlhotel;
        this.ratingshotels = ratingshotels;
        this.pricehotes = pricehotes;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getUrlhotel() {
        return urlhotel;
    }

    public void setUrlhotel(String urlhotel) {
        this.urlhotel = urlhotel;
    }

    public String getRatingshotels() {
        return ratingshotels;
    }

    public void setRatingshotels(String ratingshotels) {
        this.ratingshotels = ratingshotels;
    }

    public String getPricehotes() {
        return pricehotes;
    }

    public void setPricehotes(String pricehotes) {
        this.pricehotes = pricehotes;
    }
}
