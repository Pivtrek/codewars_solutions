import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * Challenge: If we list all the natural numbers below 10 that are multiples of 3 or 5,
 * we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in.
 * Note: If the number is a multiple of both 3 and 5, only count it once.
 */
public class Multiples_of_3_5 {
    public int solution1(int number) {

        Set<Integer> numbers = new HashSet<>();

        int n3 = number/3;
        int n5 = number/5;

        if (number%3 == 0){
            n3-=1;
        }

        if (number%5 == 0){
            n5-=1;
        }


        for (int i = 1; i<n3;i++){
            numbers.add(3*i);
        }
        for (int j=1; j<n5;j++){
            numbers.add(j*5);
        }
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

    public int solution2(int number){
        return IntStream.range(0,number)
                .filter(i -> i%3 == 0 || i%5 == 0)
                .sum();
    }

}
