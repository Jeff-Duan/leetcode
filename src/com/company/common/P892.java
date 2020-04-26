package com.company.common;

public class P892 {

    public int surfaceArea(int[][] grid) {
        int r = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                r += 2 + grid[i][j] * 4;
                if (i > 0 && i < grid.length - 1) {
                    r -= Math.min(grid[i - 1][j], grid[i][j]) * 2;
                }
                if (j > 0 && j < grid[i].length - 1) {
                    r -= Math.min(grid[i][j - 1], grid[i][j]) * 2;
                }
            }
        }
        return r;
    }

}
