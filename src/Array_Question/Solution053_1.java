package Array_Question;

public class Solution053_1 {

    public int GetNumberOfK(int[] array, int k) {
        int index = BinarySearch(array, k);
        if (index < 0) return 0;
        int count = 1;
        for(int i = index+1;i<array.length && array[i]==k;i++) count++;
        for(int i = index-1;i>=0 && array[i]==k;i--) count++;
        return count;
    }

    public static int BinarySearch(int[] array, int target) {
        if (array == null || array.length <= 0) return -1;
        if (array.length == 1 && array[0] == target) return 0;
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            int mid = left + ((right - left) >> 1);
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
        int[] arr = {1,2,2,3,3,3,3,4,5};
        Solution053_1 solution053 = new Solution053_1();
        System.out.println(solution053.GetNumberOfK(arr,3));
    }
}
