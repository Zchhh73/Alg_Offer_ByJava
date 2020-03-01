package Array_Question;

import java.util.Arrays;

public class Solution061 {

    /**
     * 扑克牌中的顺子
     * 从扑克牌抽5张牌，判断是不是顺子。
     *
     * @param numbers
     * @return
     */
    public boolean isContinuous(int[] numbers) {
        if (numbers == null || numbers.length < 1) return false;
        //排序
        Arrays.sort(numbers);
        int numberOfZero = 0;
        int numberOfGap = 0;
        //统计0的个数
        for (int i = 0; i < numbers.length && numbers[i] == 0; i++)
            ++numberOfZero;

        //统计数组间隔数目
        int small = numberOfZero;
        int big = small + 1;
        while (big < numbers.length) {
            //有对子
            if (numbers[small] == numbers[big]) return false;
            numberOfGap += numbers[big] - numbers[small] - 1;
            small = big;
            big++;
        }
        return numberOfGap <= numberOfZero;
    }

    public static void main(String[] args) {
        int[] array ={3,6,7,0,0};
        Solution061 solution = new Solution061();
        System.out.println(solution.isContinuous(array));
    }
}
