import java.util.ArrayList;
import java.util.List;

/**
 * Challenge:
 * Digital root is the recursive sum of all the digits in a number.
 * Given n, take the sum of the digits of n. If that value has more than one digit,
 * continue reducing in this way until a single-digit number is produced.
 * The input will be a non-negative integer.
 *
 * Example:
 *     16  -->  1 + 6 = 7
 *    942  -->  9 + 4 + 2 = 15  -->  1 + 5 = 6
 * 132189  -->  1 + 3 + 2 + 1 + 8 + 9 = 24  -->  2 + 4 = 6
 * 493193  -->  4 + 9 + 3 + 1 + 9 + 3 = 29  -->  2 + 9 = 11  -->  1 + 1 = 2
 */

public class Sum_of_digits {

    //Created function to sum digit, and then im calling it recursively
    //till i get n<10
    public static int sum_of_digits(int n){
        return String.valueOf(n)
                .chars()
                .map(Character::getNumericValue)
                .sum();
    }
    public static int digital_root1(int n) {
        if (n<10){
            return n;
        }
        else{
            return digital_root1(sum_of_digits(n));
        }

    }
    //Whats interesting is remainder of division by 9 is exactly the same
    //as digital root so we can use that and create really simple function
    public static int digital_root2(int n){
        return (n != 0 && n % 9 == 0) ? 9 : n % 9;
        //if number is multiple of 9 then we return 9,
        //else we return remainder of division by 9
    }
}
