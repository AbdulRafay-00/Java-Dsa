package geraph_problems;

import java.util.ArrayList;
import java.util.HashSet;

public class DepthFirstSearchTree {
    static HashSet<Integer> visited = new HashSet<Integer>();
    public static void main(String[] args) {

        ArrayList<Edge<Integer>> graph[] = new ArrayList[5];

        ImplementationOfUniDirectionalGraph.createGraph(graph, 99);

        if (graph == null || graph.length == 0) {
            System.out.println("Graph is empty or starting point is null");
            return;
        }

        createDFS(graph, 99);
    }

    public static void createDFS(ArrayList<Edge<Integer>>[] graph, Integer stp) {

        int curr = stp;

        // Base condition
        if (visited.contains(curr)) {
            return;
        }

        visited.add(curr);

        System.out.println("Visiting node: " + curr);

        // Find the adjacency list of the current node
        for (int i = 0; i < graph.length; i++) {

            if (graph[i] != null && !graph[i].isEmpty()
                    && graph[i].get(0).source.equals(curr)) {

                // Visit all neighbouring nodes recursively
                for (Edge<Integer> edge : graph[i]) {

                    createDFS(graph, edge.dest);

                }

                break;
            }
        }
    }
}