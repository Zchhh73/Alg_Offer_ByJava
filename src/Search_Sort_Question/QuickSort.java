package Search_Sort_Question;

public class QuickSort {

    private static int count = 0;//循环次数

    /**
     * 快速排序
     *
     * @param nums
     * @param left
     * @param right
     */
    private static void QuickSort(int[] nums, int left, int right) {
        if (left > right) return;
        //设基值
        int key = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            //j向左移，
            while (nums[j] >= key && i < j) {
                j--;
            }
            //i向右移，
            while (nums[i] <= key && i < j) {
                i++;
            }
            //i和j元素交换
            if (i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        nums[left] = nums[i];
        nums[i] = key;
        count++;
        QuickSort(nums, left, i - 1);
        QuickSort(nums, i + 1, right);
    }

    /**
     * 转化为字符串
     *
     * @param arr
     * @param flag
     * @return
     */
    private static String arrayToString(int[] arr, String flag) {
        String str = "数组为（" + flag + "）：";
        for (int a : arr) {
            str += a + ",";
        }
        return str;
    }

    public static void main(String[] args) {
        int[] nums = {5, 9, 7, 20, 4, 13, 8, 6, 3};
        System.out.println(arrayToString(nums, "未排序"));
        QuickSort(nums, 0, nums.length - 1);
        System.out.println(arrayToString(nums, "排序后"));
        System.out.print("循环次数：" + count);
    }


}
