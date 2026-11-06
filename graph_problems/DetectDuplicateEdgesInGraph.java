
import java.util.*;

public class DetectDuplicateEdgesInGraph {

    public static void main(String[] args) {

        int[][] edges = {
            {0, 1},
            {0, 2},
            {1, 2},
            {1, 3},
            {1, 0}
        };

        Set<String> seen = new HashSet<>();

        boolean duplicateFound = false;

        for (int[] edge : edges) {

            int u = Math.min(edge[0], edge[1]);
            int v = Math.max(edge[0], edge[1]);

            String key = u + "-" + v;

            if (!seen.add(key)) {
                duplicateFound = true;
                System.out.println(
                    "Duplicate Edge: " + u + " - " + v
                );
            }
        }

        if (!duplicateFound) {
            System.out.println("No Duplicate Edges Found");
        }
    }
}
