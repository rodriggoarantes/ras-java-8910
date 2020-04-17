package br.com.ras.java.codechallenge.week3;

/**
 * Number of Islands
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 *
 * Example 1:
 *
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * Output: 1
 *
 * Example 2:
 *
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * Output: 3
 */
public class NumberOfIslands {

    private int maxRow = 0;
    private int maxCol = 0;

    private void setup(char[][] grid) {
        maxRow = grid.length;
        maxCol = grid[0].length;
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        } else if (grid.length == 1 && grid[0].length == 1 && grid[0][0] == '1') {
            return 1;
        }

        this.setup(grid);
        int islands = 0;
        for (int row = 0; row < maxRow; row++) {
            for (int col = 0; col < maxCol; col++) {
                if (grid[row][col] == '1') {
                    islands += 1;
                    explore(grid, row, col);
                }
            }
        }
        return islands;
    }

    private void explore(char[][] grid, int row, int col) {
        grid[row][col] = 0;
        // UP
        if (isOk(grid, row - 1, col)) {
            explore(grid, row - 1, col);
        }
        // LEFT
        if (isOk(grid, row, col - 1)) {
            explore(grid, row, col - 1);
        }
        // RIGHT
        if (isOk(grid, row, col + 1)) {
            explore(grid, row, col + 1);
        }
        // DOWN
        if (isOk(grid, row + 1, col)) {
            explore(grid, row + 1, col);
        }
    }

    private boolean isOk(char[][] grid, int row, int col) {
        return (row >= 0) && (row < maxRow) && (col >= 0) && (col < maxCol) && grid[row][col] == '1';
    }

}
