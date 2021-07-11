package city;

public class City implements Comparable<City> {
    private final long ID;
    private String name;
    private String region;
    private String district;
    private int population;
    private int foundation;

    private static long currentId = 1;

    @Override
    public int compareTo(City city) {
        return name.compareToIgnoreCase(city.name);
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", region='" + region + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                ", foundation=" + foundation +
                '}';
    }

    public City(String city) {
        String[] attributes = city.split(";");

        this.ID = currentId++;

        this.name = attributes[0];
        this.region = attributes[1];
        this.district = attributes[2];
        this.population = Integer.parseInt(attributes[3]);
        this.foundation = Integer.parseInt(attributes[4]);
    }

    public long getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getFoundation() {
        return foundation;
    }

    public void setFoundation(int foundation) {
        this.foundation = foundation;
    }
}
