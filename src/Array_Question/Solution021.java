package Array_Question;

import java.util.Arrays;
import java.util.Collections;

public class Solution021 {

    /**
     * 调整数组顺序使奇数位于偶数前面。(无序输出)
     *
     * @param array
     */
    public static void reOrderArray1(int[] array) {
        int len = array.length;
        int left = 0;
        int right = len - 1;
        if (len <= 1) return;
        while (left < right) {
            //确定偶数
            while (left < right && array[left] % 2 != 0) {
                left++;
            }
            while (left < right && array[right] % 2 == 0) {
                right--;
            }
            if (left < right) {
                int temp = array[left];
                array[left] = array[right];
                array[right] = temp;
            }
        }
    }

    /**
     * 调整数组顺序使奇数位于偶数前面。(保持相对顺序输出)
     *
     * @param array
     */
    public static void reOrderArray2(int[] array) {
        //设置一前一后的指针
        int len = array.length;
        int left = 0;
        if (len <= 1) return;
        while (left < len) {
            if (array[left] % 2 != 0) {
                left++;
            } else {
                int right = left + 1;
                while (array[right] % 2 == 0){
                    if(right == len-1) return;
                    right++;
                }
                //right为奇数，left为偶数，交换
                int temp = array[right];
                while(right>left){
                    array[right] = array[right-1];
                    right--;
                }
                array[left] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution021 solution = new Solution021();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        reOrderArray2(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
