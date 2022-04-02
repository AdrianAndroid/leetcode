package com.flannery;

public class Main extends IArraySort {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Main m = new Main();
        System.out.println("原始数组：");
        m.printArray(Main.ARRARY);
        System.out.println("排序后：");
        m.printArray(m.sort());
    }


    @Override
    public int[] sort() {
        return sor_selct();
    }

    // 选择排序
    // 找到最小的索引
    // 交换
    private int[] sor_selct() {
        int[] res = ARRARY;
        int min;
        for (int i = 0; i < res.length; i++) {
            min = i; // 默认当前是做小的
            // 找到最小的那个索引
            for (int j = i; j < res.length; j++) {
                if (res[min] > res[j]) {
                    min = j;
                }
            }
            if(min != i) {
                swap(res, i, min);
            }
        }


        return res;
    }

    // 冒泡算法
    // 比较相邻的的元素。
    // 如果顺序不对，就交换顺序
    private int[] sort_bubble() {
        int[] res = ARRARY;
        // 从第一个开始
        for (int i = 0; i < res.length; i++) {
            for (int j = i; j < res.length - 1; j++) {
                if (res[j] > res[j + 1]) {
                    swap(res, j, j + 1);
                }
            }
        }
        return res;
    }
}

abstract class IArraySort {
    static int[] ARRARY = new int[]{3, 38, 44, 5, 47, 15, 36, 26, 27, 2, 46, 19, 50, 48};

    public void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i);
            System.out.print(",");
        }
        System.out.println("数组大小：" + arr.length);
    }

    void swap(int[] array, int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public abstract int[] sort();
}
