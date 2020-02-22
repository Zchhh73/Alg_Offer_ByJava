package Search_Sort_Question;

public class Solution051 {

    private int cnt;

    /**
     * 归并排序
     *
     * @param array
     * @param start
     * @param end
     */
    private void MergeSort(int[] array, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) / 2;
        MergeSort(array, start, mid);
        MergeSort(array, mid + 1, end);
        merge(array, start, mid, end);
    }

    /**
     * 排序一个子数组
     *
     * @param array
     * @param start
     * @param mid
     * @param end
     */
    private void merge(int[] array, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int k = 0, i = start, j = mid + 1;
        while (i <= mid && j <= end) {
            //如果前面的元素小于后面的不能构成逆序对
            if (array[i] <= array[j]) {
                temp[k++] = array[i++];
            } else {
                //如果前面的元素大于后面的，那么在前面元素之后的元素都能和后面的元素构成逆序对
                temp[k++] = array[j++];
                cnt = (cnt + (mid - i + 1)) % 1000000007;
            }
        }
        while (i <= mid)
            temp[k++] = array[i++];
        while (j <= end)
            temp[k++] = array[j++];
        for (int l = 0; l < k; l++){
            array[start+l] = temp[l];
        }
    }



    /**
     * 统计数组中的逆序对
     *
     * @param array
     * @return
     */
    private int InversePairs(int[] array) {
        MergeSort(array,0,array.length-1);
        return cnt;
    }

    public static void main(String[] args) {
        int[] arr={7,5,6,4};
        Solution051 solution = new Solution051();
        System.out.println("逆序对数有："+solution.InversePairs(arr)+"个");

    }
}
