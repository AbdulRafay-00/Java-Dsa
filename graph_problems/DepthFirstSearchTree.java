package geraph_problems;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
public class DepthFirstSearchTree {
    static Stack<Integer> eleStack = new Stack<Integer>();
    HashSet<Integer> visited = new HashSet<Integer>();
    public static void main(String[] args){
        ArrayList <Edge<Integer>> graph[] = new ArrayList[];
  
        
        if(graph == null || graph.length == 0){
            System.out.println("Graph is empty or starting point is null");
        }else{
            for (int i = 0 ; i< graph.length; i++){
                if(graph[i].get(0).source == stp) {
                    ind = i;
                    present = true;
                    eleStack.push(stp);
                    break;
                }
            }
            ImplementationOfUniDirectionalGraph.createGraph(graph, 99);
        }

    }
    



    public static void createDFS(ArrayList<Edge<Integer>>[] graph, Integer stp){
        int ind;
        boolean present = false;

        int curr = eleStack.pop();
        for(int i =0 ; i < graph[i].size(); i++){
            eleStack.push(graph[i].get(i).dest);
        }
        
        
        if(present){
            if(visited.contains(curr)){
                continue;
            }else{
                visited.add(curr);
                System.out.println("Visiting node: " + curr);
                createDFS(graph, eleStack.pop());
            }
        }


    }
}
