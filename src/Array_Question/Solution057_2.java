package Array_Question;

import java.util.ArrayList;

public class Solution057_2 {

    /**
     * 和为S的连续正数序列
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum){
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(sum<=0) return null;
        for(int i = 1;i<sum;i++){
            int temp =0;
            int j = i;
            while(temp < sum){
                temp += j;
                j++;
            }
            if(temp == sum){
                ArrayList<Integer> list = new ArrayList<>();
                for(int k = i;k<j;k++){
                    list.add(k);
                }
                result.add(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution057_2 solution = new Solution057_2();
        ArrayList<ArrayList<Integer>> result = solution.FindContinuousSequence(15);
        for(ArrayList<Integer> list:result){
            System.out.print(list+" ");
        }
    }
}
