package com.city.path.route.business;

import com.city.path.route.domain.City;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.io.*;
import java.util.*;

@Service
public class PathFinderServiceImpl implements PathFinderService {

    public enum Status {
        yes,

        no

    }

    public String pathBetweenCities(String city1, String city2) {

        Map<String, City> cities = new HashMap<>();
        InputStream fileInputStream = null;
        BufferedReader reader = null;

        if (StringUtils.isBlank(city1) || StringUtils.isBlank(city2)) {
            return Status.no.toString();
        } else if (StringUtils.equalsIgnoreCase(city1, city2)) {
            return Status.yes.toString();
        }
        try {
            fileInputStream = new FileInputStream("city.txt");
            reader = new BufferedReader(new InputStreamReader(fileInputStream));
            String data = reader.readLine();
            while (data != null) {
                implementGraphDataStructure(data, cities);
                data = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return findPathBetweenCities(cities.get(city1.toUpperCase()), city2.toUpperCase());
    }

    private void implementGraphDataStructure(String citiesPath, Map<String, City> cities) {
        String[] citiesArray = citiesPath.split(",");
        String origin = citiesArray[0].trim().toUpperCase();
        String destination = citiesArray[1].trim().toUpperCase();
        City originCity;
        City destinationCity;
        if (cities.get(origin) == null) {
            originCity = new City(origin);
        } else {
            originCity = cities.get(origin);
        }
        if (cities.get(destination) == null) {
            destinationCity = new City(destination);
        } else {
            destinationCity = cities.get(destination);
        }
        if (cities.get(origin) == null) {
            cities.put(origin, originCity);
        }
        cities.get(origin).getNeighborCities().add(destinationCity);
        if (cities.get(destination) == null) {
            cities.put(destination, destinationCity);
        }
        cities.get(destination).getNeighborCities().add(originCity);
    }

    private String findPathBetweenCities(City origin, String destination) {
        LinkedList<City> queue = new LinkedList<>();
        queue.add(origin);
        while (!queue.isEmpty()) {
            City presentCity = queue.remove(0);
            if (presentCity == null) {
                break;
            }
            presentCity.setVisited(true);
            if (StringUtils.equalsIgnoreCase(presentCity.getCityName(), destination)) {
                return Status.yes.toString();
            }
            //Iterate over neighbour cities to get possible paths between Cities
            for (City neighbor : presentCity.getNeighborCities()) {
                if (!neighbor.isVisited()) {
                    queue.add(neighbor);
                    neighbor.setVisited(true);
                }
            }
        }
        return Status.no.toString();
    }
}
