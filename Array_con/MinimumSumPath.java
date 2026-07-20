package Array_con;

public class MinimumSumPath {

    public int minPathSum(int[][] grid) {

        int[][] copy = new int[grid.length][grid[0].length];

        // Starting cell
        copy[0][0] = grid[0][0];

        // Fill first column
        for (int i = 1; i < grid.length; i++) {
            copy[i][0] = grid[i][0] + copy[i - 1][0];
        }

        // Fill first row
        for (int j = 1; j < grid[0].length; j++) {
            copy[0][j] = grid[0][j] + copy[0][j - 1];
        }

        // Fill the remaining cells
        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                copy[i][j] = grid[i][j] + Math.min(copy[i - 1][j], copy[i][j - 1]);
            }
        }

        // Return the minimum path sum to the bottom-right cell
        return copy[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {

        MinimumSumPath obj = new MinimumSumPath();

        int[][] grid = {
            {1, 3, 1},
            {1, 5, 1},
            {4, 2, 1}
        };

        System.out.println(obj.minPathSum(grid)); // Output: 7
    }
}