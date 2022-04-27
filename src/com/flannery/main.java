package com.flannery;

import java.util.*;

public class main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        List<String> strings = letterCombinations("23");
        System.out.println(strings);
    }

    public static List<String> letterCombinations(String digits) {
        Queue<String> queue = new LinkedList<String>();
        if (digits == null || digits.length() == 0) return new ArrayList<>(queue);
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        queue.add(""); // 先放入一个空字符串
        for (int i = 0; i < digits.length(); i++) {
            char ch = digits.charAt(i);
            String str = phoneMap.get(ch);// 获取字符串
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                String first = queue.remove();
                for (int k = 0; k < str.length(); k++) { // 遍历每个数字下所有的字符
                    queue.add(first + str.charAt(k));
                }
            }
        }
        return new ArrayList<>(queue);
    }

}
