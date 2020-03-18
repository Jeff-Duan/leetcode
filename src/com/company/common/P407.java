package com.company.common;

public class P407 {

    int[][] array;

    public int helper(int i, int j, String v) {
        int max = 0;
        switch (v) {
            case "up":
                while (i >= 0) {
                    max = Math.max(array[i--][j], max);
                }
                break;
            case "down":
                while (i < array.length) {
                    max = Math.max(array[i++][j], max);
                }
                break;
            case "left":
                while (j >= 0) {
                    max = Math.max(array[i][j--], max);
                }
                break;
            case "right":
                while (j < array[i].length) {
                    max = Math.max(array[i][j++], max);
                }
                break;
        }
        return max;
    }

    public int trapRainWater(int[][] heightMap) {
        array = heightMap;
        int r = 0;

        if (array.length < 3 || array[0].length < 3) {
            return r;
        }

        for (int i = 1; i < array.length - 1; i++) {
            for (int j = 1; j < array[i].length - 1; j++) {
                int a = helper(i, j, "up");
                int b = helper(i, j, "down");
                int c = helper(i, j, "left");
                int d = helper(i, j, "right");
                int min = Math.min(a, b);
                min = Math.min(min, c);
                min = Math.min(min, d);
                System.out.println(min);
                r += min - array[i][j];
            }
        }

        return r;
    }

}
