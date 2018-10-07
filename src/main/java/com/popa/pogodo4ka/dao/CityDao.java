package com.popa.pogodo4ka.dao;

import com.popa.pogodo4ka.model.City;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Component
public class CityDao implements GenericDao<City>{

    private static List<City> cities = new ArrayList<>();


    @Override
    public void add(City object) {
        cities.add(object);
    }

    @Override
    public void update(City object) {
        for (City s:cities) {
            if (s.getName().equals(object.getName())){
                s.setName(object.getName());
            }
        }
    }

    @Override
    public void delete(City object) {
        for (City s:cities) {
            if (s.getName().equals(object.getName())){
                cities.remove(s);
            }
        }
    }

    @Override
    public List<City> getAll() {
        return cities;
    }
}
