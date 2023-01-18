package Home_Tasks.HT_16;

import java.util.Arrays;

public class HT_1 {

    public static void main(String[] args) {
        System.out.println(fiboRecursion(7));
        System.out.println(fibo(7));
        int[][] twoDimArray = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}};
        System.out.println(findMainDiagonalSum(twoDimArray));
        System.out.println(findSecondaryDiagonalSum(twoDimArray));
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        shift(array, 3);
        System.out.println(Arrays.toString(array));
    }

    //1. Рекурсивно найти n-ое число Фибоначчи. Определить сложность. (fn[0] = 0 или 1) [fn(n) = (fn(n - 1) + fn(n - 2)]
    // Сложность - O(2^n)
    public static int fiboRecursion(int num) {
        if (num == 0) return 0;
        else if (num == 1) return 1;
        else return fiboRecursion(num - 1) + fiboRecursion(num - 2);
    }

    //2. Найти n-ое число Фибоначчи за O(n).
    public static int fibo(int num) {
        int a = 0, b = 1;
        for (int i = 0; i < num; i++) {
            int tmp = a;
            a = b;
            b = tmp + b;
        }
        return a;
    }

    /*3. Найти сумму элементов главной диагонали в двумерном массиве.
     Найти сумму элементов побочной диагонали в двумерном массиве.
     1 2 3 4 5
     1 2 3 4 5
     1 2 3 4 5
     1 2 3 4 5
     1 2 3 4 5
    */
    public static int findMainDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum += matrix[i][i];
        }
        return sum;
    }

    public static int findSecondaryDiagonalSum(int[][] matrix) {
        int sum = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            sum += matrix[i][i];
        }
        return sum;
    }

    /*4. Реализовать сдвиг элементов в массиве на n влево или вправо.
     [1, 2, 3, 4, 5, 6, 7], n = 5 => [3, 4, 5, 6, 7, 1, 2]
    */

    public static void shift(int[] array, int n) {
        for (int i = 0; i < n; i++) {
            int first = array[0];
            System.arraycopy(array, 1, array, 0, array.length - 1);
            array[array.length - 1] = first;
        }
    }
}