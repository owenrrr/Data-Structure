package owenrrr.Calculation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: Owen
 * @Date: 2021/3/13 14:55
 * @Description: 归并排序
 */
public class MergeSort {

    public List<Integer> split(List<Integer> list){
        if (list.size() <= 2){
            if (list.size() == 1) return list;
            else{
                if (list.get(0) > list.get(1)){
                    List<Integer> result = Arrays.asList(list.get(1), list.get(0));
                    return result;
                }
                return list;
            }
        }
        List<Integer> left, right, result;
        left = split(list.subList(0, list.size() / 2));
        right = split(list.subList(list.size() / 2, list.size()));
        result = combine(left, right);
        return result;
    }

    public List<Integer> combine(List<Integer> left, List<Integer> right){
        List<Integer> list = new ArrayList<>();
        int lLen = left.size(), rLen = right.size();
        int lptr = 0, rptr = 0;
        while (lptr < lLen || rptr < rLen){
            if (rptr == rLen || lptr == lLen){
                if (rptr == rLen) {
                    list.add(left.get(lptr));
                    lptr++;
                }else{
                    list.add(right.get(rptr));
                    rptr++;
                }
            } else if (left.get(lptr) < right.get(rptr)){
                list.add(left.get(lptr));
                lptr++;
            }else{
                list.add(right.get(rptr));
                rptr++;
            }
        }
        return list;
    }
}
