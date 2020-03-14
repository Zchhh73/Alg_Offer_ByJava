package Alg_Question;

import java.util.Scanner;

public class Solution043 {

    /**
     * 1~n整数中1出现的次数
     * @param n
     * @return
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        //采用阶梯式统计，例如十位上1出现的个数。设k=n%100
        // 归纳式为(n/100)*10+if(k>19) 10 else if(k<10) 0 else k-10+1
        if (n < 0) return 0;
        int count = 0;
        for (long i = 1; i <= n; i *= 10) {
            long diviver = i * 10;
            count += (n / diviver) * i + Math.min(Math.max(n % diviver - i + 1, 0), i);

        }

        return count;
    }

    public static void main(String[] args) {
        Scanner in  = new Scanner(System.in);
        System.out.println("请输入n：");
        int n = in.nextInt();
        Solution043 solution = new Solution043();
        System.out.println("1~"+n+"中1出现的次数为："+solution.NumberOf1Between1AndN_Solution(n));

    }
}
