package com.popa.pogodo4ka.service;

import com.popa.pogodo4ka.model.Ad;
import com.popa.pogodo4ka.model.City;
import com.popa.pogodo4ka.model.Pogoda;
import com.popa.pogodo4ka.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AdServiceTest {

    @Autowired
    AdService adService;

    @Test
    public void createAdAndGetAllAds() {
        Ad ad = new Ad(new User("vasya","password"),new City("Moscow"),
                "07.10", new Pogoda(25,"Облачно",2));
        adService.createAd(ad);
        List<Ad> result= adService.getAllAds();
        assertTrue(result.contains(ad));
    }


    @Test
    public void findByCityAndDataTest() {
        Ad ad = new Ad(new User("vasya","password"),new City("Moscow"),
                "07.10", new Pogoda(25,"Облачно",2));
        adService.createAd(ad);
        Pogoda result= adService.findByCityAndData(ad.getCity(),ad.getDate());
        assertTrue(result.equals(ad.getPogoda()));
    }
}