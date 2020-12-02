package com.city.path.route.domain;


import java.util.ArrayList;
import java.util.List;

public class City {

    private String cityName;

    private boolean visited;

    private City originCity;

    private List<City> neighborCities = new ArrayList<>();

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public City getOriginCity() {
        return originCity;
    }

    public void setOriginCity(City originCity) {
        this.originCity = originCity;
    }

    public void setNeighborCities(List<City> neighborCities) {
        this.neighborCities = neighborCities;
    }

    public List<City> getNeighborCities() {
        return neighborCities;
    }

}
