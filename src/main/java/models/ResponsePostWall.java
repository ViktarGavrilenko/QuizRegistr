package models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties({"count", "profiles", "groups"})
public class ResponsePostWall {
    public ArrayList<Item> items;
}