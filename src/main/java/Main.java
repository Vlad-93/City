import city.City;
import city.CityComparator;
import city.CityHandler;

import java.io.File;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        File file = new File("src/main/resources/cities.txt");

        // Модуль 1
        CityHandler cityHandler = new CityHandler();

        List<City> citiesList = cityHandler.readCitiesInFile(file);
        Collections.shuffle(citiesList);   // перемешивание, т.к. изначально список городов отсортирован по алфавиту

        // Модуль 2
        Collections.sort(citiesList);
        cityHandler.printCities();

        citiesList.sort(new CityComparator());
        citiesList.sort((city1, city2) -> city1.getDistrict().equals(city2.getDistrict()) ?
                city1.getName().compareTo(city2.getName()) : city1.getDistrict().compareTo(city2.getDistrict()));

        // после сортировки по округам
        System.out.println("------------------------------------------------");
        cityHandler.printCities();

        // Модуль 3
        City[] cities = citiesList.toArray(City[]::new);
        int index = cityHandler.searchIndexCityWithMaxPopulation(cities);
        System.out.println("[" + index + "]" + " = " + cities[index].getPopulation());  // Москва

        // Модуль 4
        System.out.println(cityHandler.citiesInRegion());
    }

}


