class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Only start DFS if the first character matches
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, n, m, board, word, 0, visited)) {
                        return true; // ✅ Propagate success up
                    }
                }
            }
        }
        return false;
    }

    private boolean dfs(int x, int y, int n, int m, char[][] board,
                        String word, int index, boolean[][] visited) {

        // ✅ Base case: all characters matched
        if (index == word.length()) return true;

        // ✅ Bounds + match + visited check at the top
        if (x < 0 || x >= n || y < 0 || y >= m) return false;
        if (visited[x][y]) return false;
        if (board[x][y] != word.charAt(index)) return false;

        // Mark before going deeper
        visited[x][y] = true;

        int[] rows = {0, -1, 0, 1};
        int[] cols = {-1, 0, 1, 0};

        for (int k = 0; k < 4; k++) {
            int newX = x + rows[k];
            int newY = y + cols[k];

            // ✅ Pass index+1, let recursion handle bounds/match checks
            if (dfs(newX, newY, n, m, board, word, index + 1, visited)) {
                visited[x][y] = false; // optional cleanup, but good practice
                return true;
            }
        }

        // ✅ Backtrack: unmark so other paths can use this cell
        visited[x][y] = false;
        return false;
    }
}