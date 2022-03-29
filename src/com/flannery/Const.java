package com.flannery;

public class Const {


    static TreeNode initTreeNode() {
        TreeNode treeNode = new TreeNode(
                3,
                new TreeNode(9),
                new TreeNode(
                        20,
                        new TreeNode(15),
                        new TreeNode(7)
                )
        );
        return treeNode;
    }

    // [2,null,3,null,4,null,5,null,6]
    static TreeNode initTreeNode2() {
        TreeNode treeNode = new TreeNode(
                2,
                null,
                new TreeNode(
                        3,
                        null,
                        new TreeNode(
                                4,
                                null,
                                new TreeNode(
                                        5,
                                        null,
                                        new TreeNode(6)
                                )
                        )
                )
        );

        return treeNode;
    }

}
