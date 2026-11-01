package geraph_problems;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Stack;
public class DepthFirstSearchTree {
    static Stack<Integer> eleStack = new Stack<Integer>();
    HashSet<Integer> visited = new HashSet<Integer>();
    public static void main(String[] args){
        ArrayList <Edge<Integer>> graph[] = new ArrayList[];
        ImplementationOfUniDirectionalGraph.createGraph(graph);

    }

    public void createDFS(ArrayList<Edge<Integer>>[] graph, Integer stp){
        if(graph == null || graph.length == 0 || stp == null){
            return;
        }
        int ind;
        boolean present = false;

        for (int i =0 ; i< graph.length; i++){
            if(graph[i].get(0).source == stp) {
                ind = i;
                present = true;
                eleStack.push(stp);
                break;
            }
        }
        if(present){
            while(!eleStack.isEmpty()){
                int curr = eleStack.pop();
                if(visited.contains(curr)){
                    continue;
                }else{
                    visited.add(curr);
                    System.out.println("Visiting node: " + curr);
                    for(int i =0 ; i < graph[i].size(); i++){
                        eleStack.push(graph[i].get(i).dest);
                        createDFS(graph, eleStack.peek());
                    }
                }

            }
        }


    }
}
