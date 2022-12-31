package com.navigate.model;

public class ItemData {

    String placeName;
    String rating;
    String price;
    String imageUrl;
    String about;
    String qty;
    String location;
    String id;

    public String getQty() {
        return qty;
    }

    public ItemData(String placeName, String rating, String price, String imageUrl, String about, String qty) {
        this.placeName = placeName;
        this.rating = rating;
        this.price = price;
        this.imageUrl = imageUrl;
        this.about = about;
        this.qty = qty;
    }

    public ItemData(String placeName, String location, String id) {
        this.placeName = placeName;
        this.location = location;
        this.id = id;
    }

    public ItemData(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setQty(String qty) {
        this.qty = qty;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }



    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
