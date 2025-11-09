package org.example.two_hundred;

/**
 * https://leetcode.com/problems/game-of-life/description/
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {

        int[][] result = new int[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                result[row][col] = board[row][col];
            }
        }

        for(int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int neighborCount = noOfNeighbors(result,i,j);
                boolean alive = board[i][j] == 1;
                if(alive) {
                    if(neighborCount <2) board[i][j] = 0;
                    else if (neighborCount <= 3) board[i][j] = 1;
                    else board[i][j] = 0;
                } else if (neighborCount == 3) board[i][j] = 1;
            }
        }
    }

    int noOfNeighbors(int[][] board, int i,int j) {
        int[][] directions = new int[][] {{1,1},{1,-1},{-1,1},{-1,-1},{1,0},{-1,0},{0,1},{0,-1}};
        int result = 0;
        for(int[] direction : directions) {
            int r = i + direction[0];
            int c = j + direction[1];
            if(r < 0 || c < 0 || r == board.length || c == board[r].length) continue;
            if(board[r][c] == 1)
                result++;
        }
        return result;
    }

}
