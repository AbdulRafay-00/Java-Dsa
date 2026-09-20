package TwoD_ArrayProblems;

import java.util.Arrays;
import java.util.List;

public class MostEventPossible {
    public static void main(String[] args) {
List<List<Integer>> events = Arrays.asList(
    Arrays.asList(1, 9),
    Arrays.asList(0, 2),
    Arrays.asList(1, 4),
    Arrays.asList(5, 7),
    Arrays.asList(6, 9),
    Arrays.asList(1, 10),
    Arrays.asList(1, 12)
);
    events.sort((a, b) -> a.get(1) - b.get(1));

    int start = 0;
    int end = 1;
    int count = 0 ;
    int endtime = -1;
    int starttime = -1;

    for (int i =0 ; i < events.size(); i++) {
        
        if (events.get(i).get(end) > endtime && events.get(i).get(start) >= starttime) {
            endtime = events.get(i).get(start);
            starttime = events.get(i).get(end);
            count++;
        }
    }

        System.out.println("Maximum even count: " + events );
        System.out.println("Maximum even count: " + count );
    }
}
