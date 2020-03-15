package Alg_Question;

public class Solution063 {

    public int MaxDiff(int[] prices, int length) {
        if (prices == null && length < 2) return 0;
        int min = prices[0];
        int maxDiff = prices[1] - min;
        for (int i = 2; i < length; ++i) {
            if (prices[i - 1] < min) {
                min = prices[i - 1];
            }
            int currentDiff = prices[i] - min;
            if (currentDiff > maxDiff) maxDiff = currentDiff;
        }
        return maxDiff;
    }

    public static void main(String[] args) {
        int[] val = {9,11,8,5,7,12,16,14};
        Solution063 solution063 = new Solution063();
        System.out.println(solution063.MaxDiff(val,val.length));
    }
}
