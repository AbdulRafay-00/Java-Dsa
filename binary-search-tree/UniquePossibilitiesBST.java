import java.util.HashMap;

public class UniquePossibilitiesBST {
    HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int numTrees(int n) {
        return ways(n);
    }

private int ways(int n) {
    if (n == 0) return 1;
    if (n == 1) return 1;
    if(map.containsKey(n)){
        int val = map.get(n);
        return val ;
        
        }
        
    int total = 0;

    for (int root = 1; root <= n; root++) {

        int left = root - 1;
        int right = n - root;
        int leftSto = ways(left);
        int rightSto= ways(right);

        total += leftSto * rightSto;
        map.put(n , total);
       
    }

    return total;
}
}
