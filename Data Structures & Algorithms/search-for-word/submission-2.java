class Solution {
    boolean found = false;
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                visited[i][j] = true;
                findWord(board, word, i, j, String.valueOf(board[i][j]));
                visited[i][j] = false;
            }
        }
        return found;
    }

    private void findWord(char[][] board, String word, int i, int j, String curWord) {
        if (found || curWord.length() >= word.length()) {
            if (word.equals(curWord)) {
                found = true;
            }
            return;
        }


        for (int[] coord: new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}) {
            int i1 = i + coord[0];
            int j1 = j + coord[1];
            if (i1 >= 0 && i1 < board.length && j1 >= 0 && j1 < board[0].length && !visited[i1][j1]) {
                visited[i1][j1] = true;
                findWord(board, word, i1, j1, curWord + board[i1][j1]);
                visited[i1][j1] = false;
            }
        }
    }
}
