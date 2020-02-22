package Search_Sort_Question;

import java.util.ArrayList;

public class Solution040 {

    //父节点
    static int parent(int i) {
        return (i - 1) / 2;
    }

    //左孩子
    static int left(int i) {
        return 2 * i + 1;
    }

    //右孩子
    static int right(int i) {
        return 2 * i + 2;
    }

    /**
     * 堆排序
     * 初始化堆后将arr[0]与arr[n-1]交换,对arr[0]和arr[n-2]排序
     * @param array
     * @return
     */
    private static void heapSort(int[] array){
        int len = array.length;
        buildMaxHeap(array,len);
        //交换
        array[len-1] = array[len-1]^array[0];
        array[0] = array[len-1]^array[0];
        array[len-1] = array[len-1]^array[0];
        for(int i = 1;i<len-1;i++){
            maxHeapfy(array,0,len-i);
            array[len-1-i] = array[0]^array[len-1-i];
            array[0] = array[0]^array[len-1-i];
            array[len-1-i] = array[0]^array[len-1-i];
        }
    }

    /**
     * 创建大根堆
     * @param a
     * @param heapSize
     */
    private static void buildMaxHeap(int[] a,int heapSize){
        for(int i =(heapSize-1)/2;i>=0;i--){
            maxHeapfy(a,i,heapSize);
        }
    }

    /**
     * 维持大根堆性质
     * @param array 数组
     * @param i      i个节点
     * @param heapSize  数组中实际排序元素的长度。
     */
    private static void maxHeapfy(int[] array,int i,int heapSize){
        //left:左孩子、right:右孩子、largest:父节点
        int left = left(i);
        int right = right(i);
        int largest = i;
        if(left<heapSize && array[left]>array[largest]){
            largest = left;
        }
        if(right<heapSize&&array[right]>array[largest]){
            largest = right;
        }
        if(largest!=i){
            array[largest] = array[largest] ^ array[i];
            array[i] = array[largest] ^ array[i];
            array[largest] = array[largest] ^ array[i];
            maxHeapfy(array,largest,heapSize);
        }
    }

    /**
     * 最小的k个数
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input,int k){
        ArrayList<Integer> list = new ArrayList<>();
        if(k<=0||k>input.length) return list;
        heapSort(input);
        for(int i = 0;i<k;i++){
            list.add(input[i]);
        }
        return list;
    }

    public static void main(String[] args) {
        int[] arr = {4,5,1,6,2,7,3,8};
        Solution040 solution = new Solution040();
        System.out.println(solution.GetLeastNumbers_Solution(arr,5));
    }
}
