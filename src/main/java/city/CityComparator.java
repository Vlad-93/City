package city;

import java.util.Comparator;

public class CityComparator implements Comparator<City> {
    @Override
    public int compare(City city1, City city2) {
        if (city1.getDistrict().equals(city2.getDistrict()))
            return city1.getName().compareTo(city2.getName());

        return city1.getDistrict().compareTo(city2.getDistrict());
    }
}
