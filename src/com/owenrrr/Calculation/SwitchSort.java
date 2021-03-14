package com.owenrrr.Calculation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Owen
 * @Date: 2021/3/13 16:29
 * @Description: 交换排序
 */
public class SwitchSort {

    // 冒泡
    public List<Integer> bubbleSort(List<Integer> list){
        Integer[] arr = new Integer[list.size()];
        list.toArray(arr);
        int size = list.size(), tmp = 0;
        for (int i=1; i < size; i++){
            for (int j=0; j < size - i; j++){
                if (arr[j] > arr[j + 1]){
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        list = Arrays.asList(arr);
        return list;
    }

    public List<Integer> quickSort(List<Integer> list){
        int size = list.size(), lptr = 0, rptr = size -1, tmp = 0;

        if (size == 1) return list;
        if (size == 2){
            if (list.get(0) > list.get(1)){
                List<Integer> result = Arrays.asList(list.get(1), list.get(0));
                return result;
            }
            return list;
        }

        Integer[] arr = new Integer[size];
        list.toArray(arr);

        Integer pivot = arr[size / 2];
        boolean rowRight = true;

        // 直接先互换，使得pivot在最后一位
        tmp = arr[size - 1];
        arr[size - 1] = pivot;
        arr[size / 2] = tmp;

        if (pivot < arr[0]){
            rowRight = false;
            arr[size - 1] = arr[0];
            lptr++;
        }

        while (lptr < rptr){
            if (rowRight){
                if (arr[lptr] > pivot){
                    arr[rptr] = arr[lptr];
                    rowRight = !rowRight;
                    rptr--;
                }else{
                    lptr++;
                }
            }else{
                if (arr[rptr] < pivot){
                    arr[lptr] = arr[rptr];
                    rowRight = !rowRight;
                    lptr++;
                }else{
                    rptr--;
                }
            }
        }

        arr[lptr] = pivot;

        List<Integer> after = Arrays.asList(arr);
        List<Integer> left = after.subList(0, lptr);
        List<Integer> right = after.subList(lptr , after.size());
        left = quickSort(left);
        right = quickSort(right);
        return combine(left, right);
    }

    public List<Integer> combine(List<Integer> left, List<Integer> right){
        List<Integer> list = new ArrayList<>();

        for (int i=0; i<left.size(); i++){
            list.add(left.get(i));
        }
        for (int i=0; i<right.size(); i++){
            list.add(right.get(i));
        }
        return list;
    }

}
