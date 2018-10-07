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

import static org.junit.Assert.assertTrue;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidServiceTest {

    @Autowired
    ValidService validService;


    @Autowired
    AdService adService;

    @Test
    public void whenValidServiceReturnSuccess() {
        Ad ad = new Ad(new User("valera", "valera"), new City("Chelyabinsk"),
                "04.15",new Pogoda(-12,"снег",5));
        String result = validService.isValid(ad);
        assertTrue(result.equals("success"));
    }


    @Test
    public void whenValidServiceReturnNotRoot() {
        Ad ad = new Ad(new User("admin", "admin"), new City("Chelyabinsk"),
                "04.15",new Pogoda(-12,"снег",5));
        String result = validService.isValid(ad);
        assertTrue(result.equals("not root"));
    }

    @Test
    public void whenValidServiceReturnWrongPassword() {
        Ad ad = new Ad(new User("admin", "admina"), new City("Chelyabinsk"),
                "04.15",new Pogoda(-12,"снег",5));
        String result = validService.isValid(ad);
        assertTrue(result.equals("wrong password"));
    }

    @Test
    public void whenValidServiceReturnWrongUserName() {
        Ad ad = new Ad(new User("oleg", "admin"), new City("Chelyabinsk"),
                "04.15",new Pogoda(-12,"снег",5));
        String result = validService.isValid(ad);
        assertTrue(result.equals("wrong username"));
    }

    @Test
    public void whenValidServiceReturnEnterAllWeatherConditions() {
        Ad ad = new Ad(new User("valera", "valera"), new City("Chelyabinsk"),
                "04.15",null);
        String result = validService.isValid(ad);
        assertTrue(result.equals("enter all weather conditions"));
    }
}