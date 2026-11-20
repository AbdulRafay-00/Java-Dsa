
package graph_problems;

public class CycleDetectionUnDirectedGraph {

    public static void main(String[] args) {

        ArrayList<Edge<Integer>> graph[] = new ArrayList[5];

        ImplementationOfBiDirectedGraph.createGraph(graph);

        boolean visited[] = new boolean[graph.length];

        System.out.println("Graph created successfully.");
        boolean hasCycle = cycleDetection(graph, 0, -1, visited);

        System.out.println(hasCycle ? "Cycle found" : "No cycle");
    }

    public static boolean cycleDetection(ArrayList<Edge<Integer>> graph[], int curr, int parent, boolean visited[]) {
        // base case
        if (visited[curr]) {
            return true;
        }
        visited[curr] = true;

        for (int i = 0; i < graph[curr].size(); i++) {
            Edge e = graph[curr].get(i);
            if (!visited[e.dest]) {
                if (cycleDetection(graph, e.dest, curr, visited)) {
                    return true;
                }
            } else if (e.dest != parent) {
                return true;
            }
        }
        return false;
    }
}