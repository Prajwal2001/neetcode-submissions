class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set = new HashSet<>();

        for (char[] row: board) {
            set = new HashSet<>();
            for (char c: row) {
                if (c != '.' && !set.add(c)) {
                    return false;
                }
            }
        }

        for (int i = 0; i < 9; i++) {
            set = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.' && !set.add(board[j][i])) {
                    return false;
                }
            }
        }

        for (int[] coord: new int[][] {{0, 0}, {0, 3}, {0, 6}, {3, 0}, {3, 3}, {3, 6}, {6, 0}, {6, 3}, {6, 6}}) {
            set = new HashSet<>();
            for (int i = coord[0]; i < coord[0] + 3; i++) {
                for (int j = coord[1]; j < coord[1] + 3; j++) {
                    if (board[i][j] != '.' && !set.add(board[i][j])) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
