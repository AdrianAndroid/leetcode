package com.flannery;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class binary_tree_level_order_traversal {


    public static void main(String[] args) {
        binary_tree_level_order_traversal b = new binary_tree_level_order_traversal();
        var lists = b.levelOrder(Const.initTreeNode());
        System.out.println(lists);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size(); // 需要全部取出来
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode n = queue.poll(); //取头
                if (n == null) continue;
                level.add(n.val);
                if (n.left != null) queue.offer(n.left);
                if (n.right != null) queue.offer(n.right);
            }
            result.add(level);
        }
        return result;
    }
}