package IntegerProblem;

public class PalendromicInteger {
    public static void main(String[] args) {
        int num = 121;
        int num2 = 10;
        System.out.println( num/num2);

        int x = num;
        int digit;
        int rev = 0;
        while (x > 0) {
            digit = x % 10;
            rev = rev * 10 + digit;
            x =  x / 10;
//res
        }
        System.out.println(rev);
        if (rev == num) {
            System.out.println("The Given Number is Palendromic");
        } else {
            System.out.println("The Given Number is Not Palendromic");
        }

}
}