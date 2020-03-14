package Alg_Question;

import java.util.Scanner;

public class Solution044 {

    public int digitAtIndex(int index) {
        //以第15位数字2为例。
        // (1)确认几位数：n<9;n<189
        // (2)确定数字内容:10+(15-10)/2 = 12
        // (3)确定是该数字的哪一位。15-10-(12-10)*2 = 1
        if (index < 0) return -1;
        if (index < 10) return index;
        int curIndex = 10, length = 2;
        int boundNum = 10;
        //(1)
        while (curIndex + lengthSum(length) < index) {
                curIndex += lengthSum(length);
                boundNum *= 10;
                length++;
        }
        //(2)
        int addNum = (index - curIndex) / length;
        int curNum = boundNum + addNum;
        //(3)
        return Integer.toString(curNum).charAt(index - curIndex - addNum * length) - '0';
    }

    public static int lengthSum(int length) {
        int count = 9;
        for (int i = 1; i < length; i++) {
            count *= 10;
        }
        return count * length;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("输入n:");
        int n = in.nextInt();
        Solution044 solution = new Solution044();
        System.out.println("第n位对应的数字为："+solution.digitAtIndex(n));
    }
}
