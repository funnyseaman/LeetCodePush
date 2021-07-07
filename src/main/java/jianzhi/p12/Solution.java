package jianzhi.p12;

import org.junit.Test;

public class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    /*
        在board[i][j]时往上下左右四个方向遍历
        以下情况进行剪枝：
        1）下标越界
        2）board[i][j]!=words[k]
        3）遍历到上一个board上的字符
     */
    private boolean dfs(char[][] board, char[] words, int i, int j, int k) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] != words[k]) {
            return false;
        }
        if (k == words.length - 1) {
            return true;
        }
        board[i][j] = '\0';
        boolean res = dfs(board, words, i + 1, j, k + 1) ||
                dfs(board, words, i - 1, j, k + 1) ||
                dfs(board, words, i, j + 1, k + 1) ||
                dfs(board, words, i, j - 1, k + 1);
        board[i][j] = words[k];
        return res;
    }

    @Test
    public void test() {

    }
}
