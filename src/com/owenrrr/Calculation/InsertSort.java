package owenrrr.Calculation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Owen
 * @Date: 2021/3/13 15:30
 * @Description: 插入排序
 */
public class InsertSort {

    /*   直接插入排序   */
    public List<Integer> straightInsertSort(List<Integer> list){
        List<Integer> result = new ArrayList<>();
        for (Integer i: list){
            if (result.size() == 0) {
                result.add(i);
                continue;
            }
            for (int j=0; j <= result.size(); j++){
                if (j == result.size()) {
                    result.add(i);
                    break;
                } else if (i < result.get(j)){
                    result.add(j, i);
                    break;
                }
            }
        }
        return result;
    }

    /*   折半插入排序、二分法插入排序   */
    public List<Integer> binaryInsertSort(List<Integer> list){

        List<Integer> result = new ArrayList<>();
        result.add(list.get(0));
        int left = 0, right = 0, mid = 0;

        for (int i=1; i<list.size(); i++){
            left = 0;
            right = i - 1;
            mid = (right + left) / 2;
            while (left <= right){
                if (list.get(i) > list.get(mid)){
                    left = mid + 1;
                    mid = (right + left) / 2;
                }else if(list.get(i) < list.get(mid)){
                    right = mid - 1;
                    mid = (right + left) / 2;
                }
            }
            if (left == result.size()) {
                result.add(list.get(i));
            } else{
                result.add(left, list.get(i));
            }
        }
        return result;
    }

    /*   希尔插入排序   */
    public List<Integer> shellInsertSort(List<Integer> list){
        int size = list.size();
        Integer[] arr = new Integer[size];
        list.toArray(arr);
        int gap = size / 2, tmp = 0;

        while (gap >= 1){
            for (int i=0; i < size - gap; i++){
                if (arr[i] > arr[i + gap]){
                    tmp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = tmp;
                }
            }
            gap--;
        }
        list = Arrays.asList(arr);
        return list;
    }
}
