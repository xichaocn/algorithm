package tech.xichao.number;

/**
 * CanThreePartsEqualSum
 *
 * 给你一个整数数组 A，只有可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 * 形式上，如果可以找出索引 i+1 < j 且满足 
 *      (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 
 * 就可以将数组三等分。
 *
 * 示例 1：
 * 输出：[0,2,1,-6,6,-7,9,1,2,0,1]
 * 输出：true
 * 解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 *
 * 示例 2：
 * 输入：[0,2,1,-6,6,7,9,-1,2,0,1]
 * 输出：false
 *
 * 示例 3：
 * 输入：[3,3,6,5,-2,2,5,1,-9,4]
 * 输出：true
 * 解释：3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
 *  
 * 提示：
 * 3 <= A.length <= 50000
 * -10^4 <= A[i] <= 10^4
 *
 * @author xichao
 * @date 20200411
 */
public class CanThreePartsEqualSum {

    public static void main(String[] args) {
        int[] arr1 = {3,3,6,5,-2,2,5,1,-9,4};
        System.out.println(canThreePartsEqualSum(arr1));

        int[] arr2 = {3,3,6,5,-2,2,5,1,-9};
        System.out.println(canThreePartsEqualSum(arr2));

        int[] arr3 = {0,0,0,0};
        System.out.println(canThreePartsEqualSum(arr3));
    }

    /**
     * 输入：正整数数组
     * 输出：布尔值，表示输入的数组能不能被等分成和相等的三部分（原地分割）
     * [3,3,6,5,-2,2,5,1,-9,4]
     * 3 + 3 = 6 = 5 - 2 + 2 + 5 + 1 - 9 + 4
     */
    private static boolean canThreePartsEqualSum(int[] arr) {
        int total = 0;
        for (int num : arr) {
            total += num;
        }
        int part = 3;
        if (total % part != 0) {
            return false;
        }

        int tmp = 0;
        int cnt = 0;
        int avg = total / part;
        for (int num : arr) {
            tmp += num;
            if (tmp == avg) {
                tmp = 0;
                cnt ++;
            }
        }
        return tmp == 0 && cnt >= part;
    }

}
