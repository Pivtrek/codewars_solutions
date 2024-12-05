/**
 * Challenge:Given two integers a and b, which can be positive or negative,
 * find the sum of all the integers between and including them and return
 * it. If the two numbers are equal return a or b.
 *
 * Note: a and b are not ordered!
 *
 * Example:
 * (1, 0) --> 1 (1 + 0 = 1)
 * (1, 2) --> 3 (1 + 2 = 3)
 * (0, 1) --> 1 (0 + 1 = 1)
 * (1, 1) --> 1 (1 since both are same)
 * (-1, 0) --> -1 (-1 + 0 = -1)
 * (-1, 2) --> 2 (-1 + 0 + 1 + 2 = 2)
 */
public class Sum_integers_in_range {

    //obvious one, iterate and add each element in range<a,b>
    public int GetSum1(int a, int b)
    {
        if (b>a){
            int temp = a;
            a = b;
            b = temp;
        }

        int result = 0;

        for (int i = b; i<=a;i++){
            result+=i;
        }

        return result;
    }

    //Use formula for arithmetic series
    public int GetSum2(int a, int b)
    {
        return ((a+b)*(Math.abs(a-b)+1))/2;
    }

}
