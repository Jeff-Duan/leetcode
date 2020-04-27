package com.company.common;

public class P200 {

    boolean[][] flag;
    int r = 0;

    public void dfs(char[][] array, int i, int j) {
        flag[i][j] = true;
        if (i > 0 && !flag[i - 1][j] && array[i - 1][j] == '1') {
            dfs(array, i - 1, j);
        }
        if (j < array[i].length - 1 && !flag[i][j + 1] && array[i][j + 1] == '1') {
            dfs(array, i, j + 1);
        }
        if (i < array.length - 1 && !flag[i + 1][j] && array[i + 1][j] == '1') {
            dfs(array, i + 1, j);
        }
        if (j > 0 && !flag[i][j - 1] && array[i][j - 1] == '1') {
            dfs(array, i, j - 1);
        }
        array[i][j] = '0';
        flag[i][j] = false;
    }

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }

        flag = new boolean[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!flag[i][j] && grid[i][j] == '1') {
                    dfs(grid, i, j);
                    r++;
                }
            }
        }

        return r;
    }

}
