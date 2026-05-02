package String;

public class hayKeyProblem {
    public static void main(String[] args) {
        String str = "mississippi";
        String key = "issip";

        int i = 0; // pointer for str
        int j = 0; // pointer for key
        int matchStart = -1; // tracks where the current match attempt started

        while (i < str.length() && j < key.length()) {
            if (str.charAt(i) == key.charAt(j)) {
                if (j == 0) {
                    matchStart = i; // record start of a potential match
                }
                j++;
                i++;
            } else {
                // Mismatch: backtrack i to one past where match started, reset j
                if (matchStart != -1) {
                    i = matchStart + 1;
                } else {
                    i++;
                }
                j = 0;
                matchStart = -1;
            }
        }

        if (j == key.length()) {
            System.out.println("Key found at index: " + matchStart);
        } else {
            System.out.println("Key not found.");
        }
    }
}