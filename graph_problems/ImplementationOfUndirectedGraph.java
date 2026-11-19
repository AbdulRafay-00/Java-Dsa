package graph_problems;

import java.util.ArrayList;

public class ImplementationOfUndirectiedGraph {

    // Adds the edge in both directions
    public static void addEdge(ArrayList<Edge<Integer>> graph[], int u, int v) {
        graph[u].add(new Edge<>(u, v));
        graph[v].add(new Edge<>(v, u));
    }

    public static void createGraph(ArrayList<Edge<Integer>> graph[]) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<Edge<Integer>>();
        }
        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 1, 3);
        addEdge(graph, 1, 4);
        addEdge(graph, 2, 4);
        addEdge(graph, 3, 0);
        addEdge(graph, 4, 3);
    }

    public static void main(String[] args) {
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge<Integer>> graph[] = new ArrayList[V];
        createGraph(graph);

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge<Integer> e = graph[i].get(j);
                System.out.println(e.sour + " -> " + e.dest);
            }
        }
    }
}
