/**
 * Challenge:Write a function that takes in a string of one or more words,
 * and returns the same string, but with all words that have five or more
 * letters reversed (Just like the name of this Kata). Strings passed in will
 * consist of only letters and spaces.
 * Spaces will be included only when more than one word is present.
 *
 * Examples:
 * "Hey fellow warriors"  --> "Hey wollef sroirraw"
 * "This is a test        --> "This is a test"
 * "This is another test" --> "This is rehtona test"
 */
public class Reverse_string_specified_length {
    public static String spinWords(String sentence) {
        String words[] = sentence.split(" ");

        for(int i=0; i< words.length; i++){
            if (words[i].length()>5){
                words[i] = new StringBuilder(words[i]).reverse().toString();
            }
        }

        return String.join(" ", words);
    }

    public static void main(String[] args) {
        System.out.println(spinWords("Welcome to the jungle"));
    }
}
