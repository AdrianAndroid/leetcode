package com.flannery;

import java.util.LinkedList;
import java.util.Queue;

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

    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int nums = 0;
        int n = grid.length;
        // 循环
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    nums++;
                    dfs(grid, i, j);
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i * n + j); // 记录索引
                    while (!queue.isEmpty()) {
                        Integer id = queue.remove(); // 最头的那个索引
                        int in = id / n;
                        int jn = id % n;
                        // 左上右下
                        if (in - 1 >= 0 && grid[in - 1][jn] == '1') {
                            grid[in - 1][jn] = '0';
                            queue.add((in - 1) * n + jn);
                        }
                        if (in + 1 < n && grid[in + 1][jn] == '1') {
                            grid[in + 1][jn] = '0';
                            queue.add((in + 1) * n + jn);
                        }
                        if (jn - 1 >= 0 && grid[in][jn - 1] == '1') {
                            grid[in][jn - 1] = '0';
                            queue.add(in * n + jn - 1);
                        }
                        if (jn + 1 < grid[0].length && grid[in][jn + 1] == '0') {
                            grid[in][jn + 1] = '0';
                            queue.add(in * n + jn + 1);
                        }
                    }
                }
            }
        }
        return nums;
    }
}
