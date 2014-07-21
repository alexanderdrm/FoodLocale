package com.mobiquity.localdel;

import java.util.ArrayList;

/**
 * Created by rsampath on 7/21/14.
 */
public class DelicacyFactory {

    private static int delicacyCount = 0;
    private static ArrayList<DelicacyInfo> delicacies = new ArrayList<DelicacyInfo>();

    public static DelicacyInfo createDelicacy(String name,  String description){

        DelicacyInfo delicacyInfo = new DelicacyInfo(name,  description,delicacyCount++);
        delicacies.add(delicacyInfo);

        return delicacyInfo;
    }

    public static DelicacyInfo getDelicacyById(int id){
        return delicacies.get(id);
    }

}
