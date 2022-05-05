package models;

import java.util.ArrayList;

public class Photo {
    public int album_id;
    public int date;
    public int id;
    public int owner_id;
    public boolean has_tags;
    public String access_key;
    public int user_id;
    public String text;
    public ArrayList<SizePhoto> sizes;
    public int width;
    public int height;
    public String post_id;
    public String lat;
    public String longitude;
}
