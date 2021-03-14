package com.owenrrr;

import com.owenrrr.Tree.BinaryTree;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        // 排序算法
//        List<Integer> list = Arrays.asList(1,5,3,6,8,9,4,10,-1);
//        mergeSortEx(list);
//        insertSortEx(list);
//        switchSort(list);

        // 树
        binaryTree();

    }

    public static void mergeSortEx(List<Integer> list) throws Exception{
        List<Integer> result;
        Class mergeClass = Class.forName("com.owenrrr.Calculation.MergeSort");
        Object mergeOb = mergeClass.getConstructor().newInstance();
        Method mergeMethod = mergeClass.getDeclaredMethod("split", List.class);
        result = (List) mergeMethod.invoke(mergeOb, list);
        System.out.print("归并排序：");
        printList(result);
    }

    public static void insertSortEx(List<Integer> list) throws Exception {
        List<Integer> result;
        Class clazz = Class.forName("com.owenrrr.Calculation.InsertSort");
        Object object = clazz.getConstructor().newInstance();
        Method straightInsertSort = clazz.getDeclaredMethod("straightInsertSort", List.class);
        result = (List) straightInsertSort.invoke(object, list);
        System.out.print("直接插入排序：");
        printList(result);

        clazz = Class.forName("com.owenrrr.Calculation.InsertSort");
        object = clazz.getConstructor().newInstance();
        straightInsertSort = clazz.getDeclaredMethod("binaryInsertSort", List.class);
        result = (List) straightInsertSort.invoke(object, list);
        System.out.print("折半插入排序：");
        printList(result);

        clazz = Class.forName("com.owenrrr.Calculation.InsertSort");
        object = clazz.getConstructor().newInstance();
        straightInsertSort = clazz.getDeclaredMethod("shellInsertSort", List.class);
        result = (List) straightInsertSort.invoke(object, list);
        System.out.print("希尔插入排序：");
        printList(result);
    }

    public static void switchSort(List<Integer> list) throws Exception{
        List<Integer> result;
        Class clazz = Class.forName("com.owenrrr.Calculation.SwitchSort");
        Object object = clazz.getConstructor().newInstance();
        Method straightInsertSort = clazz.getDeclaredMethod("bubbleSort", List.class);
        result = (List) straightInsertSort.invoke(object, list);
        System.out.print("冒泡排序：");
        printList(result);

        clazz = Class.forName("com.owenrrr.Calculation.SwitchSort");
        object = clazz.getConstructor().newInstance();
        straightInsertSort = clazz.getDeclaredMethod("quickSort", List.class);
        result = (List) straightInsertSort.invoke(object, list);
        System.out.print("快速排序：");
        printList(result);
    }

    public static void binaryTree(){
        BinaryTree.TreeNode node8 = new BinaryTree.TreeNode(8);
        BinaryTree.TreeNode node7 = new BinaryTree.TreeNode(7);
        BinaryTree.TreeNode node5 = new BinaryTree.TreeNode(5, null, node8);
        BinaryTree.TreeNode node6 = new BinaryTree.TreeNode(6);
        BinaryTree.TreeNode node4 = new BinaryTree.TreeNode(4, null, node7);
        BinaryTree.TreeNode node3 = new BinaryTree.TreeNode(3, node5, node6);
        BinaryTree.TreeNode node2 = new BinaryTree.TreeNode(2, node4, null);
        BinaryTree.TreeNode node1 = new BinaryTree.TreeNode(1, node2, node3);

        BinaryTree tree = new BinaryTree(node1);
        tree.cycle();

    }

    public static void printList(List<Integer> list){
        for (int i: list){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
