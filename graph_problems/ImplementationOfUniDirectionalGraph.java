package graph_problems;
import java.util.ArrayList;


public class ImplementationOfUniDirectionalGraph {

    public static void createGraph(ArrayList<Edge<Integer>> graph[]){
        for(int i = 0; i < graph.length; i++){
            graph[i] = new ArrayList<Edge<Integer>>();
        }
graph[0].add(new Edge<>(0, 1));
graph[0].add(new Edge<>(0, 2));

graph[1].add(new Edge<>(1, 3));
graph[1].add(new Edge<>(1, 4));

graph[2].add(new Edge<>(2, 4));

graph[3].add(new Edge<>(3, 0));

graph[4].add(new Edge<>(4, 3));
    }
    public static void main (String [] args){
        int V = 5;
        @SuppressWarnings("unchecked")
        ArrayList<Edge<Integer>> graph[] = new ArrayList[V];
        createGraph(graph);

        for(int i = 0; i < graph[0].size(); i++){
            Edge e = graph[0].get(i);
            System.out.println(e.sour + " -> " + e.dest);
        }
    }
}
