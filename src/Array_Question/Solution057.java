package Array_Question;

import java.util.ArrayList;

public class Solution057 {


    /**
     * 和为S的数字
     *
     * @param array
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindNumOfSum(int[] array, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (array == null || array.length<= 0) return null;
        int left = 0;
        int right = array.length-1;
        while(left<right){
            int curSum = array[left] + array[right];
            if(curSum==sum){
                ArrayList<Integer> list = new ArrayList<>();
                list.add(array[left]);
                list.add(array[right]);
                result.add(list);
                right--;
            }else if(curSum > sum){
                right--;
            }else{
                left++;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 4, 6, 9, 11, 13};
        Solution057 solution057 = new Solution057();
        System.out.println(solution057.FindNumOfSum(array,14));
    }
}
