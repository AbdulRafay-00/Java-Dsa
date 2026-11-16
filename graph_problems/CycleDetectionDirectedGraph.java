// package graph_problems;
// import java.util.ArrayList;
// public class CycleDetectionUndirectedGraph{
//     public static void main(String [] args){
//         ArrayList<Edge<Integer>> graph[] = new ArrayList[5];
//         ImplementationOfUniDirectionalGraph.createGraph(graph);
//         boolean visited[] = new boolean[graph.length];

//         System.out.println("Graph created successfully.");
//         boolean hasCycle = cycleDetection(graph, 0, false, visited);

//         System.out.println(hasCycle ? "Cycle found" : "No cycle");
//     }

//     public static boolean cycleDetection(ArrayList<Edge<Integer>>graph, int curr, boolean cycle, boolean visited[]){
//         // base case
//         if(visited[curr]){
//             return true;
//         }
//         if(cycle){
//             return true;
//         }
//         visited[curr] = true;

//         for(int i = curr; i < graph[curr].size(); i++){
//             Edge e = graph[i].get(i);
//             if(!visited[e.dest]){
//                 cycle = cycleDetection(graph, e.dest, cycle, visited);
//                 if(cycle){
//                     return true;
//                 }
//             }
//         }
//         // Implementation for cycle detection in an undirected graph
//         return false;
//     }
// }









package graph_problems;

import java.util.ArrayList;

public class CycleDetectiondirectedGraph {

    public static void main(String[] args) {

        ArrayList<Edge<Integer>> graph[] = new ArrayList[5];

        ImplementationOfUniDirectionalGraph.createGraph(graph);

        boolean visited[] = new boolean[graph.length];
        boolean recStack[] = new boolean[graph.length];

        System.out.println("Graph created successfully.");

        boolean hasCycle = false;

        // Check all vertices (including disconnected components)
        for (int i = 0; i < graph.length; i++) {

            if (!visited[i]) {
                hasCycle = cycleDetection(graph, i, visited, recStack);

                if (hasCycle) {
                    break;
                }
            }
        }

        System.out.println(hasCycle ? "Cycle found" : "No cycle");
    }

    public static boolean cycleDetection(
            ArrayList<Edge<Integer>> graph[],
            int curr,
            boolean visited[],
            boolean recStack[]) {

        visited[curr] = true;
        recStack[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {

            Edge<Integer> e = graph[curr].get(i);

            if (!visited[e.dest]) {

                if (cycleDetection(graph, e.dest, visited, recStack)) {
                    return true;
                }

            } else if (recStack[e.dest]) {
                return true;
            }
        }

        recStack[curr] = false;

        return false;
    }
}
