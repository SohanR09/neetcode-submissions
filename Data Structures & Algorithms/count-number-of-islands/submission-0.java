class Solution {
    private int n, m;
    private boolean[][] visited;
    private int[] rows = new int[] {0, -1, 0, 1};
    private int[] cols = new int[] {-1, 0, 1, 0};

    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int isLandCound = 0;

        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < m; j++)
                visited[i][j] = false;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(i, j, grid);
                    isLandCound++;
                }
            }
        }

        return isLandCound;
    }

    private void dfs (int x, int y, char[][] grid) {
        if (x >= n || y >= m) return;

        visited[x][y] = true;
        
        for (int k = 0; k < 4; k++) {
            int newX = x + rows[k];
            int newY = y + cols[k];

            if (isValidLand(newX, newY, grid)) {
                dfs(newX, newY, grid);
            }
        }
    }

    private boolean isValidLand (int x, int y, char[][] grid) {
        return x >= 0 && x < n && y >= 0 && y < m
                && grid[x][y] == '1' && !visited[x][y];
    }
}
