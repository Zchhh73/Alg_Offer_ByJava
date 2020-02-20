package Search_Sort_Question;

public class Solution011 {


    /**
     * 旋转数组的最小数字
     * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
     * 例如{3,4,5,1,2}为{1,2,3,4,5}的一个旋转
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        //二分查找
        if (array.length == 1) return array[0];
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            //原序
            if (array[left] < array[right]) {
                return array[left];
            }
            //边界
            if (array[mid] > array[mid + 1]) {
                return array[mid + 1];
            }
            if(array[mid] < array[mid-1]){
                return array[mid];
            }
            //二分
            if(array[mid]>array[0]){
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        //测试用例
        int[] arr1 = {1,1,1,0,1,0,1,0};
        Solution011 solution = new Solution011();
        int min = solution.minNumberInRotateArray(arr1);
        System.out.print("最小元素为："+min);
    }
}
