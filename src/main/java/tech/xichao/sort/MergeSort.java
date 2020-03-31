package tech.xichao.sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * MergeSort
 *
 * @author xichao
 * @date 20200330
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[] {67, 23, 19, 99, 27, 197, 2, 4, 1};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr, 0 , arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if(Objects.isNull(arr) || low >= high) {
            return;
        }
        //获取中间位置
        int mid = low + (high - low) / 2;
        //递归排序左子数组
        mergeSort(arr, low, mid);
        //递归排序右子数组
        mergeSort(arr, mid + 1, high);
        //合并两个子数组
        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int[] tempArr = new int[arr.length];
        int i = low, j = mid+1, k = 0;
        while(i <= mid && j <= high) {
            if(arr[i] <= arr[j]) {
                tempArr[k++] = arr[i++];
            } else {
                tempArr[k++] = arr[j++];
            }
        }

        int start = i, end = mid;
        if(j <= high) {
            start = j;
            end = high;
        }
        while (start <= end){
            tempArr[k++] = arr[start++];
        }

        for(int ii=0, len = high - low + 1; ii < len; ii++) {
            arr[low + ii] = tempArr[ii];
        }
    }

}
