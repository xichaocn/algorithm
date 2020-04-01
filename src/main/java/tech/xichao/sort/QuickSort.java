package tech.xichao.sort;

import java.util.Arrays;
import java.util.Objects;

/**
 * 快速排序
 *
 * @author xichao
 * @date 20200330
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = new int[] {67, 23, 19, 99, 27, 197, 2, 4, 1};
        System.out.println(Arrays.toString(arr));
        quickSort(arr, 0 , arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr, int low, int high) {
        if(Objects.isNull(arr) || low >= high) {
            return;
        }
        //将数组分为两部分
        int pivot = partition(arr, low, high);
        //递归排序左子数组
        quickSort(arr, low, pivot - 1);
        //递归排序右子数组
        quickSort(arr, pivot + 1, high);
    }

    private static int partition(int[] arr, int low, int high) {
        //枢轴记录
        int pivot = arr[high];
        int i = low;
        for(int j = low; j < high; j++) {
            if(arr[j] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

//    private static int partition2(int[] arr, int low, int high) {
//        //枢轴记录
//        int pivot = arr[low];
//        while (low < high) {
//            while (low < high && arr[high] >= pivot) {
//                --high;
//            }
//            //交换比枢轴小的记录到左端
//            arr[low] = arr[high];
//            while (low < high && arr[low] <= pivot) {
//                ++low;
//            }
//            //交换比枢轴小的记录到右端
//            arr[high] = arr[low];
//        }
//        //扫描完成，枢轴到位
//        arr[low] = pivot;
//        //返回的是枢轴的位置
//        return low;
//    }

}
