package TwoD_ArrayProblems;

import java.util.HashSet;

public class RecursionSearch {


    public boolean exist(char[][] board, String word) {

        int row = board.length;
        int col = board[0].length;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                if (board[i][j] == word.charAt(0)) {

                    HashSet<Integer> set = new HashSet<>();

                    // Mark starting cell
                    set.add(i * col + j);

                    if (searchFun(i, j, 1, board, row, col, word, set)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    boolean searchFun(int i, int j, int chIndex,
                      char[][] board,
                      int row,
                      int col,
                      String word,
                      HashSet<Integer> set) {

        boolean res;

        // All characters matched
        if (chIndex == word.length()) {
            return true;
        }

        // Down
        if (i < row - 1 && !set.contains((i + 1) * col + j)) {

            if (board[i + 1][j] == word.charAt(chIndex)) {

                set.add((i + 1) * col + j);

                res = searchFun(i + 1, j, chIndex + 1,
                        board, row, col, word, set);

                if (res) {
                    return true;
                }

                set.remove((i + 1) * col + j);
            }
        }

        // Up
        if (i > 0 && !set.contains((i - 1) * col + j)) {

            if (board[i - 1][j] == word.charAt(chIndex)) {

                set.add((i - 1) * col + j);

                res = searchFun(i - 1, j, chIndex + 1,
                        board, row, col, word, set);

                if (res) {
                    return true;
                }

                set.remove((i - 1) * col + j);
            }
        }

        // Right
        if (j < col - 1 && !set.contains(i * col + (j + 1))) {

            if (board[i][j + 1] == word.charAt(chIndex)) {

                set.add(i * col + (j + 1));

                res = searchFun(i, j + 1, chIndex + 1,
                        board, row, col, word, set);

                if (res) {
                    return true;
                }

                set.remove(i * col + (j + 1));
            }
        }

        // Left
        if (j > 0 && !set.contains(i * col + (j - 1))) {

            if (board[i][j - 1] == word.charAt(chIndex)) {

                set.add(i * col + (j - 1));

                res = searchFun(i, j - 1, chIndex + 1,
                        board, row, col, word, set);

                if (res) {
                    return true;
                }

                set.remove(i * col + (j - 1));
            }
        }

        return false;
    }
}

