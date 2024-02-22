package TestScriptJava;

import java.util.*;

public class sortTheMap {

        public static void main(String[] args) {
            // Create a sample map
            Map<String, Integer> unsortedMap = new HashMap<>();
            unsortedMap.put("Alice", 30);
            unsortedMap.put("Bob", 20);
            unsortedMap.put("Charlie", 25);
            unsortedMap.put("David", 35);

            // Convert the Map to a list of Map.Entry objects
            List<Map.Entry<String, Integer>> entryList = new ArrayList<>(unsortedMap.entrySet());

            // Use a custom comparator to compare values
            Comparator<Map.Entry<String, Integer>> valueComparator = Map.Entry.comparingByValue();



            // Sort the list using the comparator
            entryList.sort(valueComparator);

            // Create a new LinkedHashMap to preserve the order of the sorted entries
            Map<String, Integer> sortedMap = new LinkedHashMap<>();
            for (Map.Entry<String, Integer> entry : entryList) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }

            // Display the sorted map
            System.out.println("Sorted Map by Value: " + sortedMap);
        }


}
