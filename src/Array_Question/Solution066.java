package Array_Question;

public class Solution066 {


    /**
     * 构建乘积数组
     *
     * @param arrayA
     * @return
     */
    public int[] multiply(int[] arrayA) {
        if (arrayA == null || arrayA.length < 1) return null;
        int[] arrayC = new int[arrayA.length];
        arrayC[0] = 1;
        for (int i = 1; i < arrayC.length; i++) {
            arrayC[i] = arrayC[i - 1] * arrayA[i - 1];
        }

        int[] arrayD = new int[arrayA.length];
        arrayD[arrayD.length - 1] = 1;
        for (int i = arrayD.length - 2; i >= 0; i--) {
            arrayD[i] = arrayD[i + 1] * arrayA[i + 1];
        }
        int[] result = new int[arrayA.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = arrayC[i] * arrayD[i];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        Solution066 solution = new Solution066();
        int[] result = solution.multiply(arr);
        for(int num:result){
            System.out.print(num+",");
        }
    }
}
