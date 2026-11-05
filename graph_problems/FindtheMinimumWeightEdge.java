public class MinimumWeightEdge {

    public static void main(String[] args) {

        int[][] edges = {
            {0, 1, 4},
            {0, 2, 2},
            {1, 2, 7},
            {1, 3, 3},
            {2, 3, 5}
        };

        int minWeight = Integer.MAX_VALUE;
        int[] minEdge = null;

        for (int[] edge : edges) {

            if (edge[2] < minWeight) {
                minWeight = edge[2];
                minEdge = edge;
            }
        }

        System.out.println(
            "Minimum Edge: " +
            minEdge[0] + " - " + minEdge[1]
        );

        System.out.println(
            "Minimum Weight: " + minWeight
        );
    }
}
