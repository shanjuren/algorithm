package com.algorithm.backtracking;

/**
 * @description: 79. 单词搜索
 * https://leetcode.cn/problems/word-search/description/
 * <p>
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 * <p>
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 * @Author: ght
 * @Date: 2024/6/28 10:38
 */
public class SearchWord {

    public boolean exist(char[][] board, String word) {

        char[] target = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean exist = travel(board, i, j, target, 0);
                if (exist) return true;
            }
        }
        return false;
    }

    private boolean travel(char[][] board, int i, int j, char[] target, int sameIndex) {

        if (board[i][j] != target[sameIndex]) {
            return false;
        } else if (sameIndex == target.length - 1) {
            return true;
        }
        char tmp = board[i][j];
        board[i][j] = ' ';
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        boolean result = false;
        for (int[] dir : directions) {
            int newi = i + dir[0], newj = j + dir[1];
            if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                if(board[newi][newj] != ' ') {
                    boolean flag = travel(board, newi, newj, target, sameIndex+1);
                    if (flag) {
                        result = true;
                        break;
                    }
                }
            }
        }
        board[i][j] = tmp;
        return result;
    }


    public static void main(String[] args) {
        char[][] test = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        SearchWord searchWord = new SearchWord();
        System.out.println(searchWord.exist(test, word));
    }

}
