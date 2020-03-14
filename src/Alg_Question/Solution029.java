package Alg_Question;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution029 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("输入行数和列数：");
        int a = in.nextInt();
        int b = in.nextInt();
        int[][] matrix = new int[a][b];
        System.out.println("请输入矩阵元素");
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++){
                matrix[i][j] = in.nextInt();
            }
        }

        ArrayList result = printMatrix(matrix);
        System.out.println(result.toString());

    }

    private static ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return list;
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (true) {
            for (int col = left; col <= right; col++) {
                list.add(matrix[up][col]);
            }
            up++;
            if (up > down) {
                break;
            }
            for (int row = up; row <= down; row++) {
                list.add(matrix[row][right]);
            }
            right--;
            if (left > right) {
                break;
            }
            for (int col = right; col >= left; col--) {
                list.add(matrix[down][col]);
            }
            down--;
            if (up > down) {
                break;
            }
            for (int row = down; row >= up; row--) {
                list.add(matrix[row][left]);
            }
            left++;
            if (left > right) {
                break;
            }
        }
        return list;
    }


}
