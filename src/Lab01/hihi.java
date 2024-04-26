package Lab01;

import java.util.HashMap;
import java.util.Map;

public class hihi {
    public static void main(String[] args) {
        Map<String, Integer> countryPopulationMap = new HashMap<>();

        // Thêm các ánh xạ vào Map
        countryPopulationMap.put("Philipine", 109);
        countryPopulationMap.put("United States", 330);
        countryPopulationMap.put("Indonesia", 273);
        countryPopulationMap.put("Russia", 145);
        countryPopulationMap.put("Vietnam", 98);


        System.out.println("Các quốc gia có dân số lớn hơn 200:");
        for (Map.Entry<String, Integer> entry : countryPopulationMap.entrySet()) {
            if (entry.getValue() > 200) {
                System.out.println(entry.getKey());
            }
        }
    }
}
