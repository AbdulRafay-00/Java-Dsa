package String;

public class MultiplyString {

    public String multiply(String num1, String num2) {

        // If either number is 0
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();

        int[] result = new int[m + n];

        // Multiply digits from right to left
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                int digit1 = num1.charAt(i) - '0';
                int digit2 = num2.charAt(j) - '0';

                int product = digit1 * digit2;

                int ones = i + j + 1;
                int tens = i + j;

                int sum = product + result[ones];

                result[ones] = sum % 10;
                result[tens] += sum / 10;
            }
        }

        StringBuilder answer = new StringBuilder();

        for (int digit : result) {
            if (!(answer.length() == 0 && digit == 0)) {
                answer.append(digit);
            }
        }

        return answer.toString();
    }

    public static void main(String[] args) {

        MultiplyString obj = new MultiplyString();

        System.out.println(obj.multiply("2", "3"));          // 6
        System.out.println(obj.multiply("123", "456"));      // 56088
        System.out.println(obj.multiply("999", "999"));      // 998001
        System.out.println(obj.multiply("12", "34"));        // 408
        System.out.println(obj.multiply("100", "100"));      // 10000
        System.out.println(obj.multiply("0", "12345"));      // 0
        System.out.println(obj.multiply("9133", "0"));       // 0
        System.out.println(obj.multiply("1", "1"));          // 1
    }
}