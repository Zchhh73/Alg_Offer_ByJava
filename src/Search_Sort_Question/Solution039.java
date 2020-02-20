package Search_Sort_Question;

public class Solution039 {

    /**
     * 数组中出现次数超过一半的数字。
     *
     * @param array
     * @return
     */
    private int MoreThanHalfNum_Solution(int[] array) {
        if (array.length == 0 || array == null) return 0;
        int result = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == result) {
                count++;
            } else if (count == 0) {
                result = array[i];
                count = 1;
            } else {
                count--;
            }
        }
        if (!checkMoreThanHalf(array, array.length, result)) return 0;
        return result;
    }

    private boolean checkMoreThanHalf(int[] array, int length, int num) {
        int times = 0;
        for (int i = 0; i < length; ++i) {
            if(array[i]==num){
                times++;
            }
        }
        boolean isMoreThanHalf = true;
        if(times*2 <= length){
            isMoreThanHalf = false;
        }
        return isMoreThanHalf;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,2,4,3,2,2,2,1,2,2};
        Solution039 solution = new Solution039();
        System.out.println(solution.MoreThanHalfNum_Solution(arr));
    }
}
