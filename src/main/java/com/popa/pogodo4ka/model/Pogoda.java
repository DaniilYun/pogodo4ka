package com.popa.pogodo4ka.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"id"})
public class Pogoda {

    private long id;
    private int temperature;
    private String cloudy;
    private int wind;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getCloudy() {
        return cloudy;
    }

    public void setCloudy(String cloudy) {
        this.cloudy = cloudy;
    }

    public int getWind() {
        return wind;
    }

    public void setWind(int wind) {
        this.wind = wind;
    }

    public Pogoda( int temperature, String cloudy, int wind) {
        this.temperature = temperature;
        this.cloudy = cloudy;
        this.wind = wind;
    }

    public Pogoda() {

    }

    @Override
    public String toString() {
        return "Pogoda{" +
                "temperature=" + temperature +
                ", cloudy='" + cloudy + '\'' +
                ", wind=" + wind +
                '}';
    }
}
