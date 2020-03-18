package com.company.lcof;

public class LCOF12 {

    char[][] board;
    char[] word;

    boolean[][] flag;
    boolean bool = false;

    public boolean helper(int i, int j, int k) {
        flag[i][j] = true;
        boolean r = false;
        if (board[i][j] == word[k]) {
            k++;
            if (k == word.length) {
                bool = true;
                return true;
            }
            if (!bool) {
                boolean a = false;
                boolean b = false;
                boolean c = false;
                boolean d = false;
                if (i > 0 && !flag[i - 1][j]) {
                    a = helper(i - 1, j, k);
                }
                if (i < board.length - 1 && !flag[i + 1][j]) {
                    b = helper(i + 1, j, k);
                }
                if (j < board[i].length - 1 && !flag[i][j + 1]) {
                    c = helper(i, j + 1, k);
                }
                if (j > 0 && !flag[i][j - 1]) {
                    d = helper(i, j - 1, k);
                }
                r = a || b || c || d;
            } else {
                r = true;
            }
        }
        flag[i][j] = false;
        return r;
    }

    public boolean exist(char[][] board, String word) {
        this.board = board;
        this.word = word.toCharArray();
        this.flag = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean r = helper(i, j, 0);
                if (r) {
                    return true;
                }
            }
        }
        return false;
    }

}
