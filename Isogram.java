/**
 * Challenge: An isogram is a word that has no repeating letters, consecutive or non-consecutive.
 * Implement a function that determines whether a string that contains only letters is an isogram.
 * Assume the empty string is an isogram. Ignore letter case.
 * Example: (Input --> Output)
 * "Dermatoglyphics" --> true
 * "aba" --> false
 * "moOse" --> false (ignore letter case)
 */

import java.util.HashSet;
import java.util.Set;
public class Isogram {
    public static boolean  isIsogram(String str) {

        String lower_case_str = str.toLowerCase();
        Set<Character> letters = new HashSet<>();

        for(int i=0; i<lower_case_str.length();i++){
            letters.add(lower_case_str.charAt(i));
        }

        return letters.size() >= lower_case_str.length();
        /*solution is all about comparing length of
        set and length of given string. The trick
        is we use non-duplicate set*/
    }
}
