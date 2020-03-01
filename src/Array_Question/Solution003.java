package Array_Question;

public class Solution003 {

    /**
     * 数组中重复的数字（修改数组）
     *
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int[] numbers, int length, int[] duplication) {
        //数值与同数值下标的数字交换，直到找到第一个重复数字。
        if (numbers == null || length == 0) return false;
        for (int j = 0; j < length; j++) {
            if (numbers[j] >= length) {
                System.out.println("输入有误,请输入小于长度的值");
                return false;
            }
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                int temp = numbers[i];
                numbers[i] = numbers[temp];
                numbers[temp] = temp;
            }
        }
        return false;
    }


    /**
     * 不修改数组找出重复数字
     *
     * @param arr
     * @return
     */
    public int getDuplicate(int[] arr) {
        if (arr == null || arr.length <= 0) return -1;
        for (int a : arr) {
            if (a < 1 || a > arr.length - 1) {
                System.out.println("数字大小超出范围");
                return -1;
            }
        }
        int low = 1;
        int high = arr.length - 1;
        int mid, count;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            count = countRange(arr, low, mid);
            if (low == high) {
                if (count > 1) return low;
                else break;
            }
            if (count > mid - low + 1) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int countRange(int[] arr, int low, int high) {
        if (arr == null) return 0;
        int count = 0;
        for (int a : arr) {
            if (a >= low && a <= high) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 4, 3, 2, 6, 7};
        int[] duplication = new int[nums.length];
        Solution003 solution = new Solution003();
        /*
        if (solution.duplicate(nums, 6, duplication)) {
            System.out.println(duplication[0]);
        } else {
            System.out.println("没有重复数字");
        }
         */
        System.out.println(solution.getDuplicate(nums));
    }
}
