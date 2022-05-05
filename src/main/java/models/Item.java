package models;

import java.util.ArrayList;

public class Item {
    public int id;
    public String from_id;
    public String owner_id;
    public String date;
    public String marked_as_ads;
    public String is_favorite;
    public String post_type;
    public String text;
    public String is_pinned;
    public ArrayList<Attachments> attachments;
    public PostSource post_source;
    public Comments comments;
    public Likes likes;
    public Reposts reposts;
    public Views views;
    public Donut donut;
    public String short_text_rate;
    public String edited;
    public String hash;
    public String carousel_offset;
    public String can_delete;
    public String can_edit;
    public String created_by;
    public String can_pin;
    public String zoom_text;
}