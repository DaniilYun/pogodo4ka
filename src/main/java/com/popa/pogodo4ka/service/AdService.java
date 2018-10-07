package com.popa.pogodo4ka.service;

import com.popa.pogodo4ka.model.Ad;
import com.popa.pogodo4ka.model.City;
import com.popa.pogodo4ka.model.Pogoda;

import java.util.List;

public interface AdService {
    void createAd(Ad ad);
    List<Ad> getAllAds();
    Pogoda findByCityAndData(City city, String data);

}
