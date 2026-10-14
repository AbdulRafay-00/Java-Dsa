import java.util.ArrayList;
import java.util.List;
// insted of total number generate the total structer and show it
public class UniquePossibilityBST_II {

    public List<TreeNode> generateTrees(int n) {
        return gen(1, n);
    }

    private List<TreeNode> gen(int rangeStart, int rangeEnd) {

        List<TreeNode> list = new ArrayList<>();

        // No values in this range
        if (rangeStart > rangeEnd) {
            list.add(null);
            return list;
        }

        // Try every value as the root
        for (int i = rangeStart; i <= rangeEnd; i++) {

            // Generate all possible left subtrees
            List<TreeNode> leftTrees = gen(rangeStart, i - 1);

            // Generate all possible right subtrees
            List<TreeNode> rightTrees = gen(i + 1, rangeEnd);

            // Combine every left subtree with every right subtree
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {

                    TreeNode root = new TreeNode(i);

                    root.left = left;
                    root.right = right;

                    list.add(root);
                }
            }
        }

        return list;
    }

}
