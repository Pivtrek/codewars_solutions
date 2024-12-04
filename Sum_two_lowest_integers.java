import java.util.Arrays;

/**
 * Challenge:Create a function that returns the sum of the two lowest positive numbers
 * given an array of minimum 4 positive integers.
 * No floats or non-positive integers will be passed.
 * For Java, those integers will come as double precision (long).
 *
 * Example:
 * [19, 5, 42, 2, 77], the output should be 7.
 *
 * [10, 343445353, 3453445, 3453545353453] should return 3453455.
 *
 */

public class Sum_two_lowest_integers {

    //This is the obvious one, sort array and return sum of two first elements
    // Takes O(nlogn)
    public static long sumTwoSmallestNumbers1(long[] numbers) {
        Arrays.sort(numbers);
        return numbers[0]+numbers[1];
    }

    //We can do it in O(n), by looping once through the array, and comparing elements
    public static long sumTwoSmallestNumbers2(long[] numbers) {

        long min1 = Long.MAX_VALUE;
        long min2 = Long.MAX_VALUE;

        for(long num: numbers){
            if (num < min1){
                min2 = min1;
                min1 = num;
            }else if (num < min2){
                min2 = num;
            }

        }
        return min1 + min2;
    }

}
