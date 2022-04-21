package com.flannery;

public class main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
    }


    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int nums = 0;
        // 循环
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    nums++;
                    dfs(grid, i, j);
                }
            }
        }
        return nums;
    }

    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') { // 判断边界
            return; // 不符合要求
        }
        grid[i][j] = '0'; // 染色
        // 左上右下
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j - 1);
        dfs(grid, i, j + 1);
    }
}
