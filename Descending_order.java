import java.util.*;

/**
 * Challenge:Your task is to make a function that can take any non-negative
 * integer as an argument and return it with its digits in descending order.
 * Essentially, rearrange the digits to create the highest possible number.
 *
 * Example:
 * Input: 42145 Output: 54421
 * Input: 145263 Output: 654321
 * Input: 123456789 Output: 987654321
 */

public class Descending_order {

    public static int sortDesc(final int num) {

        List<Integer> ints = new ArrayList<>();
        String chars_int[] = Integer.toString(num).split("");

        for(String letter: chars_int){
            ints.add(Integer.parseInt(letter));
        }

        Collections.sort(ints);

        int position=1, final_int=0;
        for (Integer element: ints){
            final_int+=(element*position);
            position*=10;
        }

        return final_int;
    }
}