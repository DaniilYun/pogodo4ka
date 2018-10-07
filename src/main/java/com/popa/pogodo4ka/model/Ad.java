package com.popa.pogodo4ka.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(value = {"id"})
public class Ad {

    private long id;
    private User user;
    private City city;
    private String date;
    private Pogoda pogoda;

    public Ad(User user, City city, String date) {
        this.user = user;
        this.city = city;
        this.date = date;
    }

    public Ad() {
    }

    @Override
    public String toString() {
        return "Ad{" +
                "user=" + user +
                ", city=" + city +
                ", date='" + date + '\'' +
                ", pogoda=" + pogoda +
                '}';
    }

    public Ad(User user, City city, String date, Pogoda pogoda) {
        this.user = user;
        this.date = date;
        this.city = city;
        this.pogoda = pogoda;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Pogoda getPogoda() {
        return pogoda;
    }

    public void setPogoda(Pogoda pogoda) {
        this.pogoda = pogoda;
    }
}
