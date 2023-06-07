package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntersectionOfArrays {

    // Define a public method named 'intersect' which takes two integer arrays as input and returns an integer array.
    public int[] intersect(int[] nums1, int[] nums2) {

        // Create a new HashMap to store the numbers from 'nums1' and their counts.
        Map<Integer, Integer> map = new HashMap<>();

        // Iterate over each number in 'nums1'
        for (int num : nums1) {
            // For each number, put the number in the map as a key and either create a new entry with a value of 1
            // or increment the count of an existing entry by 1.
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Create a new ArrayList to store the numbers that are common to 'nums1' and 'nums2'
        List<Integer> result = new ArrayList<>();

        // Iterate over each number in 'nums2'
        for (int num : nums2) {

            // If the number exists in 'nums1' (i.e., is a key in the map) and the count associated with it is
            // more than 0 (i.e., there is at least one more occurrence of this number in 'nums1' that we haven't matched yet)
            if (map.containsKey(num) && map.get(num) > 0) {

                // Add the number to the result list
                result.add(num);

                // Decrease the count associated with the number in the map. This represents using up one occurrence of
                // the number from 'nums1'.
                map.put(num, map.get(num) - 1);
            }
        }

        // Convert the ArrayList 'result' to an array and return it.
        // Note that we need to convert the Integer objects in the ArrayList to primitive ints.
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
