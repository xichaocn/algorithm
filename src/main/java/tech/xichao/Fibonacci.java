package tech.xichao;

/**
 * 打印斐波那契序列
 *
 * @author xichao
 * @date 20200404
 */
public class Fibonacci {

    public static void main(String[] args) {
        printFib1(8);
        printFib2(8);
    }

    /**
     * 非递归方式打印小于n的斐波那契序列
     */
    private static void printFib1(int n) {
        int a=1, b=1;
        while (a < n) {
            System.out.print(" " + a + " " + b);
            a = a + b;
            b = a + b;
        }
        System.out.println();
    }

    /**
     * 递归方式打印小于n的斐波那契序列
     */
    private static void printFib2(int n) {
        int ret = 1;
        for (int i=1; i< n && ret<n; i++) {
            ret = fib(i);
            System.out.print(" " + ret);
        }
        System.out.println();
    }

    private static int fib(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 2) + fib(n-1);
    }

}
