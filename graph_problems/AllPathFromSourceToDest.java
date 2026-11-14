// // package graph_problems;

// // import java.util.ArrayList;

// // public class AllPathFromSourceToDest{
// //     public static void main(String[] args) {
// //         ArrayList<Edge<Integer>> graph[] = new ArrayList[5];
// //         ImplementationOfUniDirectionalGraph.createGraph(graph);
// //         int Sourind ;
// //         for(int i = 0; i < graph.length; i++){
// //             if(source == graph[i].get(0).source){
// //                 Sourind = i;
// //                 break;
// //             }
// //         }
// //         // just checking the structure of the graph
// //         // for(int i = 0; i < graph.length; i++){
// //         //     System.out.print("Node " + i + " is connected to: ");
// //         //     for(int j = 0; j < graph[i].size(); j++){
// //         //         Edge<Integer> e = graph[i].get(j);
// //         //         System.out.print(e.dest + " ");
// //         //     }
// //         //     System.out.println();
// //         // }
// //     }




// //     public static void findAllPaths(int source, int dest, ArrayList<Edge<Integer>> graph[], int sourind, int current){
// //         if(current == dest){
// //             System.out.println("Found a path from " + source + " to " + dest);
// //             return;
// //         }
// //         if(sourind >= graph.length || graph[sourind] == null){
// //             return;
// //         }
// //         for(int i = 0; i < graph[sourind].size(); i++){
// //             Edge<Integer> e = graph[sourind].get(i);
// //             findAllPaths(source, dest, graph, e.dest, current);
// //         }

// //     }
// // }






// package graph_problems;

// import java.util.ArrayList;

// public class AllPathFromSourceToDest {

//     public static void main(String[] args) {

//         ArrayList<Edge<Integer>> graph[] = new ArrayList[5];

//         ImplementationOfUniDirectionalGraph.createGraph(graph);

//         int source = 0;
//         int dest = 4;

//         ArrayList<Integer> path = new ArrayList<>();

//         findAllPaths(source, dest, graph, path, source);
//     }

//     public static void findAllPaths(
//             int source,
//             int dest,
//             ArrayList<Edge<Integer>> graph[],
//             ArrayList<Integer> path,
//             int current) {

//         path.add(current);

//         // Destination reached
//         if (current == dest) {
//             System.out.println(path);
//             path.remove(path.size() - 1);
//             return;
//         }

//         // Explore all outgoing neighbors
//         for (int i = 0; i < graph[current].size(); i++) {

//             Edge<Integer> e = graph[current].get(i);

//             findAllPaths(source, dest, graph, path, e.dest);
//         }

//         // Backtracking
//         path.remove(path.size() - 1);
//     }
// }

















package graph_problems;

import java.util.ArrayList;

public class AllPathFromSourceToDest {

    public static void main(String[] args) {

        ArrayList<Edge<Integer>> graph[] = new ArrayList[5];

        ImplementationOfUniDirectionalGraph.createGraph(graph);

        int source = 0;
        int dest = 4;

        ArrayList<Integer> path = new ArrayList<>();

        boolean visited[] = new boolean[graph.length];

        findAllPaths(source, dest, graph, path, visited, source);
    }

    public static void findAllPaths(
            int source,
            int dest,
            ArrayList<Edge<Integer>> graph[],
            ArrayList<Integer> path,
            boolean visited[],
            int current) {

        // Add current vertex
        path.add(current);
        visited[current] = true;

        // Destination reached
        if (current == dest) {
            System.out.println(path);

            visited[current] = false;
            path.remove(path.size() - 1);
            return;
        }

        // Explore neighbors
        for (int i = 0; i < graph[current].size(); i++) {

            Edge<Integer> e = graph[current].get(i);

            // Don't revisit an already visited vertex
            if (!visited[e.dest]) {

                findAllPaths(
                        source,
                        dest,
                        graph,
                        path,
                        visited,
                        e.dest
                );
            }
        }

        // Backtracking
        visited[current] = false;
        path.remove(path.size() - 1);
    }
}
