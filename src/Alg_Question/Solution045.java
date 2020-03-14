package Alg_Question;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;
import java.util.Scanner;

public class Solution045 {

    public String PrintMinNumber(int[] numbers){
        if(numbers==null || numbers.length<1) return "";
        if(numbers.length==1) return Arrays.toString(numbers);
        for(int i = 0;i<numbers.length;i++){
            for(int j = i+1;j<numbers.length;j++){
                //拼接
                int sum1 = Integer.valueOf(numbers[i]+""+numbers[j]);
                int sum2 = Integer.valueOf(numbers[j]+""+numbers[i]);
                if(sum1>sum2){
                    int temp = numbers[j];
                    numbers[j] = numbers[i];
                    numbers[i] = temp;
                }
            }
        }
        String str = "";
        for(int i = 0;i<numbers.length;i++){
            str += numbers[i];
        }

        return str;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("输入数组个数：");
        int n = in.nextInt();
        int[] arr = new int[n];
        System.out.println("输入数组元素:");
        for(int i = 0;i<arr.length;i++){
            arr[i] = in.nextInt();
        }
        Solution045 solution045 = new Solution045();
        System.out.println(solution045.PrintMinNumber(arr));
    }
}
