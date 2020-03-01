package Array_Question;

public class Solution056 {

    public void FindNumsAppearOnce(int[] array) {

        if (array == null || array.length <= 1) return;
        int orResult = 0;
        for (int i = 0; i < array.length; i++){
            orResult ^= array[i];
        }

        int indexOf1 = FindFirst1(orResult);
        int num1 = 0;
        int num2 = 0;
        for(int i = 0;i<array.length;i++){
            if(bitIs1(array[i],indexOf1)){
                num1 ^= array[i];
            }else{
                num2 ^= array[i];
            }
        }
        System.out.printf("只出现一次的两个数字为：%d,%d.",num1,num2);

    }

    private int FindFirst1(int orResult){
        int moveSteps = 0;
        while((orResult & 1)==0 && moveSteps<32){
            orResult = orResult >> 1;
            moveSteps++;
        }
        return moveSteps;
    }

    private static boolean bitIs1(int number,int movestep){
        for(int i=0;i<movestep;i++){
            number = number >>1;
        }
        return (number & 1) == 1;
    }

    public static void main(String[] args) {
        Solution056 solution = new Solution056();
        int[] arr = {2,4,3,8,3,2,5,5};
        solution.FindNumsAppearOnce(arr);
    }
}
