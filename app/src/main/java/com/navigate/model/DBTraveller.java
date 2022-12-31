package com.navigate.model;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DBTraveller extends SQLiteOpenHelper {

    //Traveller
    private static final String DB_NAME = "traveller";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME = "traveller_details";
    private static final String ID_COL = "id";
    private static final String NAME_COL = "name";
    private static final String MOBILE_NO_COL = "mobile_no";
    private static final String EMAIL_COL = "email";
    private static final String TRAVELLER_PASSWORD = "traveller_password";

    //Traveller hotels
    private static final String TRAVELLER_HOTELS = "traveller_hotels";
    private static final String ID_COL1 = "id";
    private static final String HOTEL_NAME_COL = "hotel_name";
    private static final String HOTEL_LOCATION = "hotel_location";
    private static final String HOTEL_IMAGE_URL = "hotel_image_url";
    private static final String HOTEL_RATINGS = "hotels_ratings";
    private static final String HOTEL_PRICE = "hotels_price";

    public DBTraveller(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + NAME_COL + " TEXT,"
                + MOBILE_NO_COL + " TEXT,"
                + EMAIL_COL + " TEXT,"
                + TRAVELLER_PASSWORD + " TEXT)";
        db.execSQL(query);

        String query1 = "CREATE TABLE " + TRAVELLER_HOTELS + " ("
                + ID_COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HOTEL_NAME_COL + " TEXT,"
                + HOTEL_LOCATION + " TEXT,"
                + HOTEL_IMAGE_URL + " VARCHAR(255),"
                + HOTEL_RATINGS + " TEXT,"
                + HOTEL_PRICE + " TEXT)";
        db.execSQL(query1);
    }

    // start traveller
    public void addNewTraveller(String name, String mobile_no, String email, String traveller_password) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(NAME_COL, name);
        values.put(MOBILE_NO_COL, mobile_no);
        values.put(EMAIL_COL, email);
        values.put(TRAVELLER_PASSWORD, traveller_password);

        db.insert(TABLE_NAME, null, values);

        db.close();
    }

    @SuppressLint("Range")
    public ArrayList<String> getData(String id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from traveller_details where " + EMAIL_COL + "='" + id + "'", null );
        ArrayList <String> travellerD = new ArrayList<>();
        while(res.moveToNext()){
            travellerD.add(res.getString(1));
            travellerD.add(res.getString(2));
            travellerD.add(res.getString(3));
            travellerD.add(res.getString(4));
        }

        return travellerD;
    }
// end traveller

    // start traveller hotels
    public void addNewHotel(String hotel_name_col, String hotel_location, String hotel_image_url,String hotel_ratings, String hotel_price) {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(HOTEL_NAME_COL, hotel_name_col);
        values.put(HOTEL_LOCATION, hotel_location);
        values.put(HOTEL_IMAGE_URL, hotel_image_url);
        values.put(HOTEL_RATINGS, hotel_ratings);
        values.put(HOTEL_PRICE, hotel_price);

        db.insert(TRAVELLER_HOTELS, null, values);

        db.close();
    }


    @SuppressLint("Range")
    public  ArrayList <Hoteldata> getDataHotel() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from traveller_hotels", null );

        ArrayList <Hoteldata> travellerHD = new ArrayList<>();
        while(res.moveToNext()){

           travellerHD.add(
                   new Hoteldata(
                           res.getString(0),
                           res.getString(1),
                           res.getString(2),
                           res.getString(3),
                           res.getString(4),
                           res.getString(5)
                   )
           );

        }

        return travellerHD;
    }
    // end traveller hotels




    @SuppressLint("Range")
    public ArrayList<String> getEditData(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res =  db.rawQuery( "select * from traveller_hotels where " + ID_COL1 + "='" + id + "'", null );
        ArrayList <String> userD = new ArrayList<>();
        while(res.moveToNext()){
            userD.add(res.getString(1));
            userD.add(res.getString(2));
            userD.add(res.getString(3));
            userD.add(res.getString(4));
            userD.add(res.getString(5));
        }

        return userD;
    }


    public void update(String id, String ratings, String price){
        SQLiteDatabase db = this.getReadableDatabase();
//        String sql = "UPDATE traveller_hotels" +
//                "SET"+ HOTEL_RATINGS +"= " + ratings + "AND" + HOTEL_PRICE +"="+ price +
//                "WHERE id = " + id +";";

        ContentValues cv = new ContentValues();
        cv.put(HOTEL_RATINGS, ratings);
        cv.put(HOTEL_PRICE, price);


        db.update(TRAVELLER_HOTELS, cv, "id = ?",  new String[]{id} );

    }


    public void remove(String id){
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(TRAVELLER_HOTELS, "id = ?", new String[]{id});
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
