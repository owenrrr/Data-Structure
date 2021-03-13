package com.owenrrr;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        List<Integer> list = Arrays.asList(1,5,3,6,8,9,4,10,-1);
        mergeSortEx(list);
        insertSortEx(list);
        switchSort(list);
    }

    public static void mergeSortEx(List<Integer> list) throws Exception{
        List<Integer> result;
        Class mergeClass = Class.forName("owenrrr.Calculation.MergeSort");
        Object mergeOb = mergeClass.getConstructor().newInstance();
        Method mergeMethod = mergeClass.getDeclaredMethod("split", List.class);
        result = (List) mergeMethod.invoke(mergeOb, list);
        System.out.print("归并排序：");
        printList(result);
    }

    public static void insertSortEx(List<Integer> list) throws Exception {
        List<Integer> result;
        Class clazz = Class.forName("owenrrr.Calculation.InsertSort");
        Object object = clazz.getConstructor().newInstance();
        Method straightInsertSort = clazz.getDeclaredMethod("straightInsertSort", List.class);
        result = (List) straightInsertSort.invoke(object, list);
        System.out.print("直接插入排序：");
        printList(result);

        clazz = Class.forName("owenrrr.Calculation.InsertSort");
        object = clazz.getConstructor().newInstance();
        straightInsertSort = clazz.getDeclaredMethod("binaryInsertSort", List.class);
        result = (List) straightInsertSort.invoke(object, list);
        System.out.print("折半插入排序：");
        printList(result);

        clazz = Class.forName("owenrrr.Calculation.InsertSort");
        object = clazz.getConstructor().newInstance();
        straightInsertSort = clazz.getDeclaredMethod("shellInsertSort", List.class);
        result = (List) straightInsertSort.invoke(object, list);
        System.out.print("希尔插入排序：");
        printList(result);
    }

    public static void switchSort(List<Integer> list) throws Exception{
        List<Integer> result;
        Class clazz = Class.forName("owenrrr.Calculation.SwitchSort");
        Object object = clazz.getConstructor().newInstance();
        Method straightInsertSort = clazz.getDeclaredMethod("bubbleSort", List.class);
        result = (List) straightInsertSort.invoke(object, list);
        System.out.print("冒泡排序：");
        printList(result);

        clazz = Class.forName("owenrrr.Calculation.SwitchSort");
        object = clazz.getConstructor().newInstance();
        straightInsertSort = clazz.getDeclaredMethod("quickSort", List.class);
        result = (List) straightInsertSort.invoke(object, list);
        System.out.print("快速排序：");
        printList(result);
    }

    public static void printList(List<Integer> list){
        for (int i: list){
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
