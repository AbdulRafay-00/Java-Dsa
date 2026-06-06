package String;
import java.util.*;

public class sunstringfromstringleethard {
   public static void main(String[] args) {

    String s = "barfoofoobar";

    String[] words = {"bar", "foo"};

    HashMap<String, Integer> targetMap = new HashMap<>();

    // Store frequencies of words
    for (String word : words) {
        targetMap.put(word,
                targetMap.getOrDefault(word, 0) + 1);
    }

    int wordLen = words[0].length();
    int totalWords = words.length;

    // Try every offset
    for (int offset = 0; offset < wordLen; offset++) {

        int left = offset;
        int count = 0;

        HashMap<String, Integer> windowMap = new HashMap<>();

        // Move right pointer word by word
        for (int right = offset;
             right + wordLen <= s.length();
             right += wordLen) {

            String word =
                    s.substring(right, right + wordLen);

            // If valid word
            if (targetMap.containsKey(word)) {

                // Add word into current window
                windowMap.put(word,
                        windowMap.getOrDefault(word, 0) + 1);

                count++;

                // If duplicate frequency exceeded
                while (windowMap.get(word)
                        > targetMap.get(word)) {

                    String leftWord =
                            s.substring(left,
                                    left + wordLen);

                    windowMap.put(leftWord,
                            windowMap.get(leftWord) - 1);

                    left += wordLen;

                    count--;
                }

                // Valid window found
                if (count == totalWords) {

                    System.out.println(
                            "Found at index: " + left
                    );

                    // Slide window forward
                    String leftWord =
                            s.substring(left,
                                    left + wordLen);

                    windowMap.put(leftWord,
                            windowMap.get(leftWord) - 1);

                    left += wordLen;

                    count--;
                }

            } else {
                windowMap.clear();

                count = 0;

                left = right + wordLen;
            }
        }
    }
}

    }






    // // own brute force approach
    //     public static void main(String[] args) {


    //     List<Integer> result = new ArrayList<>();
    //     List<Integer> words = new ArrayList<>();
    //     String s = "barfoothefoobarman";
    //     if (s == null || s.length() == 0 || words.length == 0) {
    //         // return result;
    //     }

    //     // Frequency map of words
    //     HashMap<String, Integer> targetMap = new HashMap<>();

    //     for (String word : words) {
    //         targetMap.put(word, targetMap.getOrDefault(word, 0) + 1);
    //     }

    //     int wordLen = words[0].length();
    //     int totalWords = words.length;

    //     // Try every offset
    //     for (int offset = 0; offset < wordLen; offset++) {

    //         int left = offset;
    //         int count = 0;

    //         HashMap<String, Integer> windowMap = new HashMap<>();

    //         // Move right pointer word by word
    //         for (int right = offset;
    //              right + wordLen <= s.length();
    //              right += wordLen) {

    //             String word = s.substring(right, right + wordLen);

    //             // Valid word
    //             if (targetMap.containsKey(word)) {

    //                 windowMap.put(word,
    //                         windowMap.getOrDefault(word, 0) + 1);

    //                 count++;

    //                 // Too many duplicates
    //                 while (windowMap.get(word) > targetMap.get(word)) {

    //                     String leftWord =
    //                             s.substring(left, left + wordLen);

    //                     windowMap.put(leftWord,
    //                             windowMap.get(leftWord) - 1);

    //                     left += wordLen;
    //                     count--;
    //                 }

    //                 // Found valid window
    //                 if (count == totalWords) {

    //                     result.add(left);

    //                     // Slide forward
    //                     String leftWord =
    //                             s.substring(left, left + wordLen);

    //                     windowMap.put(leftWord,
    //                             windowMap.get(leftWord) - 1);

    //                     left += wordLen;
    //                     count--;
    //                 }

    //             } else {

    //                 // Invalid word → reset window
    //                 windowMap.clear();
    //                 count = 0;
    //                 left = right + wordLen;
    //             }
    //         }
    //     }

    //     return result;
    // }


