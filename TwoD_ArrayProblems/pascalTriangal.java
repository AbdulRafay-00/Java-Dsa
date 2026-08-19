package TwoD_ArrayProblems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class pascalTriangal {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(Collections.nCopies(i + 1, 1));

            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, triangle.get(i - 1).get(j) + triangle.get(i - 1).get(j - 1));
            }

            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        int numRows = 5;

        List<List<Integer>> result = generate(numRows);

        System.out.println(result);
    }
}