import java.util.HashMap;
import java.util.Map;

/**
 * Challenge:
 * Given an array of integers, find the one that appears an odd number of times.
 *
 * There will always be only one integer that appears an odd number of times.
 *
 * Example:
 * [7] should return 7, because it occurs 1 time (which is odd).
 * [0] should return 0, because it occurs 1 time (which is odd).
 * [1,1,2] should return 2, because it occurs 1 time (which is odd).
 * [0,1,0,1,0] should return 0, because it occurs 3 times (which is odd).
 * [1,2,2,3,3,3,4,3,3,3,2,2,1] should return 4, because it appears 1 time (which is odd).
 *
 */

public class Find_the_odd_int {
    public static int findIt1(int[] a) {
        HashMap<Integer, Integer> count = new HashMap<>();
        int result = 0;

        for (int number : a) {
            if (count.containsKey(number)) {
                count.put(number, count.get(number) + 1);
            } else {
                count.put(number, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            if (entry.getValue() % 2 == 1) {
                result = entry.getKey();
                break;
            }
        }
        
        return result;
    }

    public static int findIt2(int[] a){
        //very clever way to find out which number occurs odd times
        //we will use xor on every element of array starting with 0
        //every xor-ed pair a^a = 0 and only one element from array
        //wont give 0, because it doesnt have pair
        int xor = 0;
        for (int number: a){
            xor^=number;
        }
        return xor;
    }
}