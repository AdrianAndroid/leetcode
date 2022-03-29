package com.flannery;

import java.util.LinkedList;
import java.util.Queue;

public class er_cha_shu_de_zui_da_shen_du_by_leetcode_solution {


    public static void main(String[] args) {
        er_cha_shu_de_zui_da_shen_du_by_leetcode_solution e = new er_cha_shu_de_zui_da_shen_du_by_leetcode_solution();
        System.out.println(e.maxDepth(Const.initTreeNode()));
    }


    public int maxDepth(TreeNode root) {
        int depth = 0;
        // BFS
        if(root == null) return depth;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll();
                if(n == null) continue;
                if(n.left != null) queue.offer(n.left);
                if(n.right != null) queue.offer(n.right);
            }
        }
        return depth;
    }

}
