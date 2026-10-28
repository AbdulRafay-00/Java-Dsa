package graph_problems;
import java.util.ArrayList;
@SuppressWarnings("unchecked")
public class BreadthFirstSearchUnwaighted {
    public static void main(String [] args){
        
        ImplementationOfUniDirectionalGraph graphObj = new ImplementationOfUniDirectionalGraph();
        ArrayList<Edge<Integer>> graph[] = new ArrayList[5];
        graphObj.createGraph(graph);
        for(int i = 0; i < graph[0].size(); i++){
        Edge e = graph[0].get(i);
        System.out.println(e.sour + " -> " + e.dest);
        }
    }
}
