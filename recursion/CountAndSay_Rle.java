package recursion;

public class CountAndSay_Rle {

    public String countAndSay(int n) {
        int curr = 1;
        return Rle("1", curr, n);
    }

    public String Rle(String str, int curr, int finalint) {

        if (curr == finalint) {
            return str;
        }

        String newstr = "";
        int count = 1;

        for (int i = 0; i < str.length(); i++) {

            if (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } 
            else {
                newstr = newstr + count + str.charAt(i);
                count = 1;
            }
        }

        return Rle(newstr, curr + 1, finalint);
    }

}
