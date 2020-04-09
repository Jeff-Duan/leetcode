package com.company.common;

public class P289 {


    public final static int[] X = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
    public final static int[] Y = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};

    public void gameOfLife(int[][] board) {
        if (board.length == 0) {
            return;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int active = 0;

                for (int k = 0; k < 8; k++) {
                    int x = i + X[k];
                    int y = j + Y[k];
                    if (x >= 0 && x < board.length && y >= 0 && y < board[i].length) {
                        active += board[x][y] & 1;

                    }
                }

                if ((board[i][j] & 1) == 1) {
                    if (active == 2 || active == 3) {
                        // 活细胞存活
                        board[i][j] = 0b11;
                    }
                } else {
                    if (active == 3) {
                        // 死细胞复活
                        board[i][j] = 0b10;
                    }
                }
            }
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }

}
