```
// 左->右 全部打印
// 上->下 第一个不打印(已经打印)
// 右->左 两边不打印
// 下->上 最顶上不打印(已经打印)
```

```
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
```