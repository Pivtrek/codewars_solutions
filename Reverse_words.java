/**
 * Challenge: Complete the function that accepts a string parameter,
 * and reverses each word in the string. All spaces in the string should be retained.
 *
 * Example:"
 * This is an example!" ==> "sihT si na !elpmaxe"
 * "double  spaces"      ==> "elbuod  secaps"
 *
 */

public class Reverse_words {
    public static String reverseWords(final String original){

        String[] words = original.split("\\s+"); //split by white spaces, otherwise it cant pass any test
        String return_string = original;

        for (String word : words){
            String reversed = new StringBuilder(word).reverse().toString();
            return_string = return_string.replaceAll(word, reversed);
        }

        return return_string;
    }
}
