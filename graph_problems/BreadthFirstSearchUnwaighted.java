package graph_problems;

import java.util.ArrayList;
import java.util.Queue;
import java.util.HashSet;
import java.util.LinkedList;

public class BreadthFirstSearchUnwaighted {
    static Queue<Integer> eleQueue = new LinkedList<Integer>();
    static HashSet<Integer> visited = new HashSet<Integer>();

    public static void main(String[] args) {

        ImplementationOfUniDirectionalGraph graphObj = new ImplementationOfUniDirectionalGraph();
        @SuppressWarnings("unchecked")
        ArrayList<Edge<Integer>> graph[] = new ArrayList[5];
        graphObj.createGraph(graph);
        createBST(graph);
        // for(int i = 0; i < graph[0].size(); i++){
        // Edge e = graph[0].get(i);
        // System.out.println(e.sour + " -> " + e.dest);
        // }
    }

public static void createBST(ArrayList<Edge<Integer>> graph[]) {

    if (graph == null || graph.length == 0) {
        return;
    }

    if (eleQueue.isEmpty()) {
        eleQueue.offer(graph[0].get(0).sour);
    }

    while (!eleQueue.isEmpty()) {

        int current = eleQueue.poll();

        if (visited.contains(current)) {
            continue;
        }

        visited.add(current);

        System.out.println("Visiting node: " + current);

        // Search for the row belonging to the current vertex
        for (int i = 0; i < graph.length; i++) {

            if (graph[i].isEmpty()) {
                continue;
            }

            if (graph[i].get(0).sour == current) {

                // Traverse all outgoing edges of this vertex
                for (int j = 0; j < graph[i].size(); j++) {

                    Edge<Integer> e = graph[i].get(j);

                    if (!visited.contains(e.dest)) {
                        eleQueue.offer(e.dest);
                    }
                }

                break;
            }
        }
    }
}
}
