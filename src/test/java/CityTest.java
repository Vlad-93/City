import city.City;
import city.CityComparator;
import city.CityHandler;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CityTest {
    private List<City> list = new ArrayList<>();
    private CityHandler cityHandler = new CityHandler(list);

    public CityTest() {
        list.add(new City("Санкт-Петербург;Санкт-Петербург;Северо-Западный;4848742;1703"));
        list.add(new City("Краснодар;Краснодарский край;Южный;744933;1793"));
        list.add(new City("Анапа;Краснодарский край;Южный;58983;1781"));
        list.add(new City("Москва;Москва;Центральный;11514330;1147"));
    }

    @Test
    public void constructorTest() {
        String s = "Москва;Москва;Центральный;11514330;1147";
        City city = new City(s);

        assertNotNull(city);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void constructorTestEmptyString() {
        String s = "";
        new City(s);
    }

    @Test(expected = NumberFormatException.class)
    public void constructorTestNoNumber() {
        String s = "Москва;Москва;Центральный;11514330;ASD";
        new City(s);
    }

    @Test
    public void sortTest() {
        Collections.sort(list);
        assertEquals(list.get(0).getName(), "Анапа");
        assertEquals(list.get(1).getName(), "Краснодар");
        assertEquals(list.get(2).getName(), "Москва");
        assertEquals(list.get(3).getName(), "Санкт-Петербург");

        list.sort(new CityComparator());
        assertEquals(list.get(0).getName(), "Санкт-Петербург");     // Северо-Западный
        assertEquals(list.get(1).getName(), "Москва");              // Центральный
        assertEquals(list.get(2).getName(), "Анапа");               // Южный
        assertEquals(list.get(3).getName(), "Краснодар");           //Южный
    }

    @Test
    public void searchTest() {
        int index = cityHandler.searchIndexCityWithMaxPopulation(list.toArray(new City[0]));
        assertEquals(list.get(index).getName(), "Москва");
    }

    @Test
    public void numberCitiesInRegionTest() {
        HashMap<String, Integer> map = cityHandler.citiesInRegion(list.toArray(City[]::new));

        assertEquals(map.get("Краснодарский край"), Integer.valueOf(2));
        assertEquals(map.get("Москва"), Integer.valueOf(1));
        assertEquals(map.get("Санкт-Петербург"), Integer.valueOf(1));
    }
}
