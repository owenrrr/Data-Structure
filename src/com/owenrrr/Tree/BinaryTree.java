package com.owenrrr.Tree;

import com.sun.deploy.panel.ITreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: Owen
 * @Date: 2021/3/13 20:57
 * @Description:
 */
public class BinaryTree {

    private TreeNode root;

    public BinaryTree(){

    }

    public BinaryTree(TreeNode root){
        this.root = root;
    }

    public void cycle(){
        System.out.print("perOrder: ");
        preOrder(this.root);
        System.out.println();
        System.out.print("inOrder: ");
        inOrder(this.root);
        System.out.println();
        System.out.print("postOrder: ");
        postOrder(this.root);
        System.out.println();
        System.out.print("Level Order: ");
        levelOrder(this.root);
        System.out.println();
    }

    // 前序遍历
    private void preOrder(TreeNode node){
        node.print();
        if (node.leftChild != null){
            preOrder(node.leftChild);
        }
        if (node.rightChild != null){
            preOrder(node.rightChild);
        }
    }

    // 中序遍历
    private void inOrder(TreeNode node){
        if (node.leftChild != null){
            inOrder(node.leftChild);
        }
        node.print();
        if (node.rightChild != null){
            inOrder(node.rightChild);
        }
    }

    // 后序遍历
    private void postOrder(TreeNode node){
        if (node.leftChild != null){
            postOrder(node.leftChild);
        }
        if (node.rightChild != null){
            postOrder(node.rightChild);
        }
        node.print();
    }

    // 广度优先搜索
    private void levelOrder(TreeNode node){
        if (node == null){
            return ;
        }
        TreeNode popNode;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            popNode = queue.poll();
            popNode.print();
            if (popNode.leftChild != null){
                queue.add(popNode.leftChild);
            }
            if (popNode.rightChild != null){
                queue.add(popNode.rightChild);
            }
        }
    }

    public static class TreeNode{

        private Integer data;

        private TreeNode leftChild;

        private TreeNode rightChild;

        public TreeNode(){

        }

        public TreeNode(Integer data){
            this.data = data;
        }

        public TreeNode(Integer data, TreeNode leftChild, TreeNode rightChild){
            this.data = data;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        public void print(){
            System.out.print(this.data);
        }
    }
}
