package IntegerProblem;

public class BinaryAddition {

    public static void main(String[] args) {

        String a = "1010";
        String b = "1011";

        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {

        StringBuilder str = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry != 0) {

            int sum = 0;
            int sum1 = 0;

            if (i >= 0) {
                sum = a.charAt(i) - '0';
                i--;
            }

            if (j >= 0) {
                sum1 = b.charAt(j) - '0';
                j--;
            }

            int res = sum + sum1 + carry;

            switch (res) {
                case 0:
                    str.append('0');
                    carry = 0;
                    break;

                case 1:
                    str.append('1');
                    carry = 0;
                    break;

                case 2:
                    str.append('0');
                    carry = 1;
                    break;

                case 3:
                    str.append('1');
                    carry = 1;
                    break;
            }
        }

        return str.reverse().toString();
    }
}