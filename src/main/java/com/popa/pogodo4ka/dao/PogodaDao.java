package com.popa.pogodo4ka.dao;

import com.popa.pogodo4ka.model.Pogoda;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class PogodaDao implements  GenericDao<Pogoda>{

    private static List<Pogoda>pogodaList =new ArrayList<>();

    private  long countId=0;

    @Override
    public void add(Pogoda object) {
        object.setId(countId);
        countId++;
        pogodaList.add(object);
    }

    @Override
    public void update(Pogoda object) {
        for (Pogoda s:pogodaList) {
            if (s.getId()==object.getId()){
                s.setTemperature(object.getTemperature());
                s.setCloudy(object.getCloudy());
                s.setWind(object.getWind());
            }
        }
    }

    @Override
    public void delete(Pogoda object) {
        for (Pogoda s:pogodaList) {
            if (s.getId()==object.getId()){
                pogodaList.remove(s);
            }
        }
    }

    @Override
    public List<Pogoda> getAll() {
        return pogodaList;
    }
}
