package com.flannery;

public class shun_shi_zhen_da_yin_ju_zhen_by_leetcode_solution {

    // 1 2 3
    // 4 5 6
    // 7 8 9


    public static void main(String[] args) {
        //输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
        //输出：[1,2,3,6,9,8,7,4,5]
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int r : spiralOrder(matrix)) {
            System.out.print(r);
            System.out.print(",");
        }
        System.out.println();
        System.out.println("1,2,3,6,9,8,7,4,5");
        //输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
        //输出：[1,2,3,4,8,12,11,10,9,5,6,7]
        matrix = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        for (int r : spiralOrder(matrix)) {
            System.out.print(r);
            System.out.print(",");
        }
        System.out.println();
        System.out.println("1,2,3,4,8,12,11,10,9,5,6,7");
    }

    public static int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
            return new int[0];
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[] order = new int[rows * columns];
        int index = 0;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom) {
            // 左->右
            for (int i = left; i <= right; i++) {
                order[index++] = matrix[top][i];
            }
            // 上->下
            for (int i = top + 1; i <= bottom; i++) {
                order[index++] = matrix[i][right];
            }
            if (left < right && top < bottom) {
                // 右->左
                for (int i = right - 1; i > left; i--) {
                    order[index++] = matrix[bottom][i];
                }
                // 下->上
                for (int i = bottom; i > top; i--) {
                    order[index++] = matrix[i][left];
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }

//    public static int[] spiralOrder(int[][] matrix) {
//        if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0) {
//            return new int[]{};
//        }
//        // 算出又几行几列
//        int rows = matrix.length, columns = matrix[0].length;
//        int[] order = new int[rows * columns];
//        int index = 0; //数组的索引
//        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
//        while (left <= right && top <= bottom) {
//            // 从左往右
//            for (int i = left; i <= right; i++) {
//                order[index++] = matrix[top][i];
//                System.out.print(matrix[top][i]);
//            }
//            System.out.println();
//            // 从上到下
//            for (int i = top + 1; i <= bottom; i++) {
//                order[index++] = matrix[i][right];
//                System.out.print(matrix[i][right]);
//            }
//            System.out.println();
//            if (left < right && top < bottom) {
//                // 从右往左
//                for (int i = right - 1; i > left; i--) {
//                    order[index++] = matrix[bottom][i];
//                    System.out.print(matrix[bottom][i]);
//                }
//                System.out.println();
//                // 从下到上
//                for (int i = bottom; i > top; i--) {
//                    order[index++] = matrix[i][left];
//                    System.out.print(matrix[i][left]);
//                }
//                System.out.println();
//            }
//            // 不断的缩小循环
//            left++;
//            right--;
//            top++;
//            bottom--;
//        }
//        return order;
//    }


//    public static int[] spiralOrder(int[][] matrix) {
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//            return new int[0];
//        }
//        int rows = matrix.length, columns = matrix[0].length;
//        int[] order = new int[rows * columns];
//        int index = 0;
//        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
//        while (left <= right && top <= bottom) {
//            for (int i = left; i <= right; i++) {
//                order[index++] = matrix[top][i];
//            }
//            for (int i = top + 1; i <= bottom; i++) {
//                order[index++] = matrix[i][right];
//            }
//            if (left < right && top < bottom) {
//                for (int i = right - 1; i > left; i--) {
//                    order[index++] = matrix[bottom][i];
//                }
//                for (int i = bottom; i > top; i--) {
//                    order[index++] = matrix[i][left];
//                }
//            }
//            left++;
//            right--;
//            top++;
//            bottom--;
//        }
//        return order;
//    }

}
