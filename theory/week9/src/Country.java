package theory.week9.src;
import java.util.HashMap;
import java.util.Map;
public class Country {
    private Map<String,Integer> map = new HashMap<>();
    public void addPopulation(String cityName, int population) {
        map.put(cityName, population);
    }
    public void listCountry(int n){
        System.out.println("Cities with population greater than " + n);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }
    public static void main(String[] args){
        Country country = new Country();
        country.addPopulation("Phillipine", 109);
        country.addPopulation("United States", 330);
        country.addPopulation("Indonesia", 273);
        country.addPopulation("Russia",145);
        country.addPopulation("Vietnam",98);
        country.listCountry(200);
    }
  
}

