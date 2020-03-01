package Array_Question;


public class Solution053_2 {


    public int GetMissingNum(int[] nums, int length) {
        if (nums == null || length <= 0) return -1;
        int left = 0;
        int right = length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] != mid) {
                if (nums[mid - 1] == mid - 1 || mid == 0) return mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if (left == length) return length;
        return -1;
    }

    public static void main(String[] args) {
        Solution053_2 solution = new Solution053_2();
        int[] arr = {0, 2, 3, 4, 5, 6};
        System.out.println(solution.GetMissingNum(arr, 6));
    }
}
