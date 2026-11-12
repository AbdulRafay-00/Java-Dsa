
import java.util.*;

public class FindIfPathExistsInGraph {

    public static boolean validPath(int n, int[][] edges,
                                    int source, int destination) {

        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(source);
        visited[source] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == destination) {
                return true;
            }

            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int n = 6;

        int[][] edges = {
            {0, 1},
            {0, 2},
            {3, 5},
            {5, 4},
            {4, 3}
        };

        int source = 0;
        int destination = 2;

        System.out.println(
            validPath(n, edges, source, destination)
        );
    }
}
