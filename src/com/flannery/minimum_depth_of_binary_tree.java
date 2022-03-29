package com.flannery;

public class minimum_depth_of_binary_tree {
    public static void main(String[] args) {
        minimum_depth_of_binary_tree m = new minimum_depth_of_binary_tree();
        System.out.println(m.minDepth(Const.initTreeNode2()));
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int ml = minDepth(root.left);
        int mr = minDepth(root.right);
        if (root.left == null) return mr + 1;
        if (root.right == null) return ml + 1;
        return Math.min(ml, mr) + 1;
    }
}