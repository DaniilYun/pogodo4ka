package com.popa.pogodo4ka.dao;

import com.popa.pogodo4ka.model.Ad;
import com.popa.pogodo4ka.model.City;
import com.popa.pogodo4ka.model.Pogoda;
import com.popa.pogodo4ka.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class AdDao implements GenericDao<Ad> {

    private static long count=0;
    private static List<Ad> ads= new ArrayList<>();

    static {
        Ad ad = new Ad(new User("sanya","loh"),new City("Moscow"),
                "04.10",new Pogoda(37,"облачно с прояснениями", 6));
        ads.add(ad);
    }



    @Override
    public List<Ad> getAll() {
        return ads;
    }
    @Override
    public void add(Ad ad){
       ad.setId(count);
        ads.add(ad);
        count++;
    }

    public Pogoda getAdByCityAndData(City city, String data) {
        for (Ad c:ads) {
            if (c.getCity().getName().equals(city.getName())){
                if (c.getDate().equals(data)){
                    return c.getPogoda();
                }
            }
        }
        return null;
    }


    @Override
    public void update(Ad object) {
        for (Ad c:ads) {
            if (c.getId()==object.getId()){
               c.setCity(object.getCity());
               c.setDate(object.getDate());
               c.setPogoda(object.getPogoda());
               c.setUser(object.getUser());

            }
        }
    }

    @Override
    public void delete(Ad object) {
        for (Ad c:ads) {
            if (c.getId()==object.getId()){
               ads.remove(c);
            }
        }
    }

}
