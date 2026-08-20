package TwoD_ArrayProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> curr = new ArrayList<>(List.of(1, 1));
        List<Integer> prev = new ArrayList<>(List.of(1));

        if (rowIndex == 0) return prev;
        if (rowIndex == 1) return curr;

        for (int i = 2; i <= rowIndex; i++) {
            prev = curr;
            curr = new ArrayList<>(Collections.nCopies(prev.size() + 1, 1));
            for (int j = 1; j < curr.size() - 1; j++) {
                curr.set(j, prev.get(j) + prev.get(j - 1));
            }
        }
        return curr;
    }

    public static void main(String[] args) {
        PascalTriangleII solution = new PascalTriangleII();

        int[] testCases = {0, 1, 2, 3, 4, 5, 7};

        for (int rowIndex : testCases) {
            List<Integer> result = solution.getRow(rowIndex);
            System.out.println("rowIndex = " + rowIndex + " -> " + result);
        }
    }
}