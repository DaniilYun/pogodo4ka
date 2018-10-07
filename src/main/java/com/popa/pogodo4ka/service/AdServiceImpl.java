package com.popa.pogodo4ka.service;

import com.popa.pogodo4ka.dao.AdDao;
import com.popa.pogodo4ka.model.Ad;
import com.popa.pogodo4ka.model.City;
import com.popa.pogodo4ka.model.Pogoda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdServiceImpl implements AdService {

    @Autowired
    AdDao adDao;


    @Override
    public void createAd(Ad ad) {
        adDao.add(ad);
    }

    public List<Ad> getAllAds(){
        return adDao.getAll();
    }

    @Override
    public Pogoda findByCityAndData(City city, String data) {
       return adDao.getAdByCityAndData(city,data);
    }

}
