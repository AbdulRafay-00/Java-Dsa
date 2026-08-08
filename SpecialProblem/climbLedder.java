package SpecialProblem;

public class climbLedder {

    public int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }

        int first = 1;
        int second = 2;

        for (int i = 3; i <= n; i++) {
            int current = first + second;

            first = second;
            second = current;
        }

        return second;
    }

    public static void main(String[] args) {

        climbLedder obj = new climbLedder();

        int answer = obj.climbStairs(5);

        System.out.println(answer);
    }
}