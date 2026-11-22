
public class IsGraphBiPartial {
public static boolean isCycle(ArrayList<Edge<Integer>> graph[], boolean visited[], int curr, int parent) {

    visited[curr] = true;

    for(int i = 0; i < graph[curr].size(); i++){

        Edge<Integer> e = graph[curr].get(i);

        // If neighbor is already visited and is not the parent
        if(visited[e.dest] && e.dest != parent){
            return true;
        }

        // If neighbor is not visited, visit it
        else if(!visited[e.dest]){
            if(isCycle(graph, visited, e.dest, curr)){
                return true;
            }
        }
    }

    return false;
}
}
