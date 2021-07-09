package Singleton;
import java.util.*;

public class SingletonClass {

    static class Country {
        private static Country ObjectCounty = null;
        private static String listCountry = "... List Country ...\n";
        //прячем конструктор
        private Country() {
        }
        public static synchronized Country getCountry() {
            //если у нас объекта "страна" нет, то создаём, если есть, то запрещаем
            if (ObjectCounty == null) {
                ObjectCounty = new Country();
            }
            return ObjectCounty;
        }
        public static void addnewCountry(String newCountry){
            listCountry += newCountry + "\n";
        }
        public void CountryShow() {
            System.out.println(listCountry);
        }
    }

    public static void main(String[] args) {

        Map<String, Integer> dictionaryCountry = new HashMap<>();

        dictionaryCountry.put("USA", 320_500_000);
        dictionaryCountry.put("Tajikistan", 17_250_500);
        dictionaryCountry.put("Russian", 141_050_550);
        dictionaryCountry.put("China", 1_275_400_000);
        dictionaryCountry.put("Sri Lanka", 9_900_000);
        dictionaryCountry.put("Japan", 120_550_000);
        dictionaryCountry.put("India", 1_150_000_000);
        dictionaryCountry.put("Indonesia", 210_090_000);
        dictionaryCountry.put("Pakistan", 121_070_000);
        dictionaryCountry.put("Brazil", 78_880_000);

        for (Map.Entry entry: dictionaryCountry.entrySet()) {
            String item = String.format("%-13s: %-10s", entry.getKey().toString(), entry.getValue().toString());
            Country.addnewCountry(item);
        }
        Country.getCountry().CountryShow();

        //Country country1 = new Country();
        //country1.addnewCountry("newCountry1");
        //Country country2 = new Country();
        //country2.addnewCountry("newCountry2");
    }
}
