package Array_Question;

public class Solution056_2 {

    public static int findNumber(int[] nums) {
        if (nums == null || nums.length <= 0) return -1;
        //辅助数组存储二进制表示的每一位的和。
        int[] bits = new int[32];
        int bitMark = 1;
        //最后一位开始
        for(int i = 31;i>=0;i--){
            for(int j = 0;j<nums.length;j++){
                if((nums[j] & bitMark) != 0 )
                    bits[i] += 1;
            }
            bitMark = bitMark << 1;
        }
        int targetNumber = 0;
        for(int i = 0;i<32;i++){
            targetNumber = targetNumber<<1;
            targetNumber += (bits[i]%3);
        }
        return targetNumber;
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,7};
        Solution056_2 solution = new Solution056_2();
        System.out.println(findNumber(nums));
    }
}
