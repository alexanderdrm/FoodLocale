package com.mobiquity.localdel;

/**
 * Created by dalexander on 7/18/14.
 */
public class CityInfo {

    String description;
    String shortDescription; //currently unused
    String name;

    public CityInfo() {
    }

    public CityInfo(String name, String desc) {
        description = desc;
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public String getName() {
        return name;
    }

}
