package com.mobiquity.localdel;

import java.util.ArrayList;

/**
 * Created by rsampath on 7/18/14.
 */
public class CityFactory {
    private static int cityCount = 0;
    private static ArrayList<CityInfo> cities = new ArrayList<CityInfo>();

    public static CityInfo createCity(String name, String country, String description){

        CityInfo cityInfo = new CityInfo(name, country, description,cityCount++);
        cities.add(cityInfo);

        return cityInfo;
    }

    public static CityInfo getCityById(int id){
        return cities.get(id);
    }

}
