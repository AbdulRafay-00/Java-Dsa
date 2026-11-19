
package graph_problems;

import java.util.ArrayList;

public class ImplementationOfBiDirectedGraph {

    public static void createGraph(ArrayList<Edge<Integer>> graph[]) {

        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<Edge<Integer>>();
        }

        graph[0].add(new Edge<>(0, 1));
        graph[1].add(new Edge<>(1, 0));

        graph[0].add(new Edge<>(0, 2));
        graph[2].add(new Edge<>(2, 0));

        graph[1].add(new Edge<>(1, 3));
        graph[3].add(new Edge<>(3, 1));

        graph[1].add(new Edge<>(1, 4));
        graph[4].add(new Edge<>(4, 1));

        graph[2].add(new Edge<>(2, 4));
        graph[4].add(new Edge<>(4, 2));

        graph[3].add(new Edge<>(3, 0));
        graph[0].add(new Edge<>(0, 3));

        graph[4].add(new Edge<>(4, 3));
        graph[3].add(new Edge<>(3, 4));
    }

    public static void main(String[] args) {

        int V = 5;

        @SuppressWarnings("unchecked")
        ArrayList<Edge<Integer>> graph[] = new ArrayList[V];

        createGraph(graph);

        for(int i = 0; i < graph.length; i++){
            for(int j = 0; j < graph[i].size(); j++){

                Edge<Integer> e = graph[i].get(j);

                System.out.println(e.sour + " -> " + e.dest);
            }
        }
    }
}
