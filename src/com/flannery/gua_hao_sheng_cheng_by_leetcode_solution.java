package com.flannery;

import java.util.ArrayList;
import java.util.List;

public class gua_hao_sheng_cheng_by_leetcode_solution {
    public static void main(String[] args) {
        System.out.println("Hello World!");
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backstrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }

    // 使用回溯法
    public void backstrack(List<String> result, StringBuilder sb, int open, int close, int n) {
        if (sb.length() == n * 2) {
            result.add(sb.toString());
            return;
        }
        if (open < n) {
            sb.append("(");
            backstrack(result, sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            sb.append(")");
            backstrack(result, sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
