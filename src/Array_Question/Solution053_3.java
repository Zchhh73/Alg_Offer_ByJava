package Array_Question;

public class Solution053_3 {

    public int GetNumberSameAsIndex(int[] nums){
        if(nums==null||nums.length<=0) return -1;
        int left = 0;
        int right = nums.length-1;
        while(left <= right){
            int mid = left + ((right-left) >> 1);
            if(nums[mid]==mid) return mid;
            if(nums[mid]>mid){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {-3,-1,0,3,5};
        Solution053_3 solution = new Solution053_3();
        System.out.println(solution.GetNumberSameAsIndex(arr));
    }
}
