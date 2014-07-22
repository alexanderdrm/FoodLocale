package com.mobiquity.localdel;

import org.junit.Test;

import static org.junit.Assert.*;

public class InfoFactoryTest {

    @Test
    public void testCreateCity() throws Exception {
        CityInfo ci = InfoFactory.createCity("name1", "country1", "description1");
        assertEquals(0, ci.id);
        CityInfo ci2 = InfoFactory.createCity("name2", "country2", "description2");
        assertEquals(0, ci.id);
        assertEquals(1, ci2.id);
        assertEquals(ci, InfoFactory.getInfo(0));
    }

    @Test
    public void testCreateDelicacy() throws Exception {
        DelicacyInfo di = InfoFactory.createDelicacy("del_name1", "del_description1");
        assertEquals(0, di.id);
        CityInfo ci = InfoFactory.createCity("name1", "country1", "description1");
        assertEquals(1, ci.id);
        DelicacyInfo di2 = InfoFactory.createDelicacy("del_name2", "del_description2");
        assertEquals(0, di.id);
        assertEquals(2, di2.id);
        assertEquals(di, InfoFactory.getInfo(0));
    }

    @Test
    public void testGetInfo() throws Exception {

    }
}