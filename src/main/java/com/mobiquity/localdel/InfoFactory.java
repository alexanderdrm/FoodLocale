package com.mobiquity.localdel;

import java.util.ArrayList;

/**
 * Created by dalexander on 7/21/14.
 */
public class InfoFactory{
    private static volatile int id = 0;
    private static ArrayList<BaseInfo> infos = new ArrayList<BaseInfo>();

    public static CityInfo createCity(String name, String country, String description){

        CityInfo cityInfo = new CityInfo(name, country, description,id++);
        infos.add(cityInfo);

        return cityInfo;
    }

    public static DelicacyInfo createDelicacy(String name,  String description){

        DelicacyInfo delicacyInfo = new DelicacyInfo(name,  description,id++);
        infos.add(delicacyInfo);

        return delicacyInfo;
    }

    public static BaseInfo getInfo(int id) {
        assert infos.size() > id;
        return infos.get(id);
    }
}
