package Search_Sort_Question;

public class Solution053 {

    public int getNumberOfK(int[] array, int k) {
        // 找到第一个k
        int index = BinarySearch(array, k);
        if (index < 0) return 0;
        int count = 1;
        //顺序查找
        //右边
        for (int i = index + 1; i < array.length && array[i] == k; i++) count++;
        //左边
        for (int i = index - 1; i >= 0 && array[i] == k; i--) count++;
        return count;
    }

    private static int BinarySearch(int[] array, int target) {
        if (array == null || array.length <= 0) return -1;
        if (array.length == 1 && array[0] == target) return 0;
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target == array[mid]) return mid;
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,3,3,3,4,5};
        Solution053 solution = new Solution053();
        System.out.print(solution.getNumberOfK(arr,3));
    }
}
