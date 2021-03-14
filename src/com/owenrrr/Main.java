package com.owenrrr;

import com.owenrrr.Heap.Heap;
import com.owenrrr.Tree.BinaryTree;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        // 排序算法
        mergeSortEx();
        insertSortEx();
        switchSort();

        // 树
        binaryTree();

        // 堆
        heaps();
    }

    public static void mergeSortEx() throws Exception{
        List<Integer> list = Arrays.asList(1,5,3,6,8,9,4,10,-1);

        List<Integer> result;
        Class mergeClass = Class.forName("com.owenrrr.Calculation.MergeSort");
        Object mergeOb = mergeClass.getConstructor().newInstance();
        Method mergeMethod = mergeClass.getDeclaredMethod("split", List.class);
        result = (List) mergeMethod.invoke(mergeOb, list);
        System.out.print("归并排序：");
        printList(result);
    }

    public static void insertSortEx() throws Exception {
        List<Integer> list = Arrays.asList(1,5,3,6,8,9,4,10,-1);

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

    public static void switchSort() throws Exception{
        List<Integer> list = Arrays.asList(1,5,3,6,8,9,4,10,-1);

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

    public static void heaps(){
        Heap.Node node10 = new Heap.Node(4);
        Heap.Node node9 = new Heap.Node(37);
        Heap.Node node8 = new Heap.Node(1);
        Heap.Node node7 = new Heap.Node(29);
        Heap.Node node6 = new Heap.Node(12);
        Heap.Node node5 = new Heap.Node(23, node10, null);
        Heap.Node node4 = new Heap.Node(60, node8, node9);
        Heap.Node node3 = new Heap.Node(71, node6, node7);
        Heap.Node node2 = new Heap.Node(84, node4, node5);
        Heap.Node node1 = new Heap.Node(100, node2, node3);

        Heap.Node[] heaps = new Heap.Node[10];
        heaps[0] = node4;
        heaps[1] = node2;
        heaps[2] = node3;
        heaps[3] = node1;
        heaps[4] = node10;
        heaps[5] = node6;
        heaps[6] = node8;
        heaps[7] = node7;
        heaps[8] = node9;
        heaps[9] = node5;
        Heap heap = new Heap(heaps, true);

        heap.printHeaps();
    }

    public static void printList(List<Integer> list){
        for (int i: list){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
