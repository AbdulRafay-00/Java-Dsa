package TwoD_ArrayProblems;

public class StringSearch {

    public static boolean searchStringIn2DArray(String[][] array, String target) {
        int rows = array.length;
        int cols = array[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (array[i][j].equals(target)) {
                    return true;
                }
            }
        }

        return false;
    }
}