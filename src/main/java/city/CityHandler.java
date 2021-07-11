package city;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class CityHandler {
    private final List<City> cities;

    public CityHandler() {
        cities = new ArrayList<>();
    }

    public CityHandler(List<City> citiesList) {
        cities = citiesList;
    }

    public List<City> readCitiesInFile(File file) {
        try (Scanner scan = new Scanner(file)) {
            while (scan.hasNext())
                cities.add(new City(scan.nextLine()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return cities;
    }

    public int searchIndexCityWithMaxPopulation(City[] cities) {
        int index = 0;
        for (int i = 1; i < cities.length; i++)
            if (cities[i].getPopulation() > cities[index].getPopulation())
                index = i;

        return index;
    }

    public HashMap<String, Integer> citiesInRegion() {
        HashMap<String, Integer> map = new HashMap<>();

        for (City city : cities)
            map.put(city.getRegion(), map.getOrDefault(city.getRegion(), 0) + 1);

        return map;
    }

    public HashMap<String, Integer> citiesInRegion(City[] cities) {
        HashMap<String, Integer> map = new HashMap<>();

        for (City city : cities)
            map.put(city.getRegion(), map.getOrDefault(city.getRegion(), 0) + 1);

        return map;
    }

    public void printCities() {
        for (City city : cities)
            System.out.println(city);
    }
}
