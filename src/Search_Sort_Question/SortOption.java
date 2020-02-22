package Search_Sort_Question;

import java.util.Arrays;

/*
    常见排序方法总结
 */
public class SortOption {


    /**
     * 冒泡排序:比较相邻的元素。如果第一个比第二个大，就交换它们。
     *
     * @param array
     * @return
     */
    private static int[] BubbleSort(int[] array) {
        if (array.length == 0) return array;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    /**
     * 选择排序：将未排序序列的最小存放在排序序列的起始，依次类推得到有序数组。
     *
     * @param array
     * @return
     */
    private static int[] selectionSort(int[] array) {
        if (array.length == 0) return array;
        for (int i = 0; i < array.length; i++) {
            int minindex = i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[minindex]) {//找到最小的数
                    minindex = j;//保存索引
                }
            }
            int temp = array[minindex];
            array[minindex] = array[i];
            array[i] = temp;
        }
        return array;
    }

    /**
     * 插入排序：构建有序序列，将未排序的数据，在已排序序列中从后向前扫描，
     * 找到相应位置并插入。
     *
     * @param array
     * @return
     */
    private static int[] insertionSort(int[] array) {
        if (array.length == 0) return array;
        int current;
        for (int i = 0; i < array.length - 1; i++) {
            current = array[i + 1];
            int preIndex = i;
            while (preIndex >= 0 && current < array[preIndex]) {
                array[preIndex + 1] = array[preIndex];
                preIndex--;
            }
            array[preIndex + 1] = current;
        }
        return array;
    }

    /**
     * 希尔排序：选用增量gap=len/2，缩小增量为gap=gap/2排序。
     *
     * @param array
     * @return
     */
    public static int[] shellSort(int[] array) {
        if (array.length == 0) return array;
        int len = array.length;
        int temp, gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                //存后值
                temp = array[i];
                //前一个索引大，则交换
                int preIndex = i - gap;
                while (preIndex >= 0 && array[preIndex] > temp) {
                    array[preIndex + gap] = array[preIndex];
                    preIndex -= gap;
                }
                //交换
                array[preIndex + gap] = temp;
            }
            gap = gap / 2;
        }
        return array;
    }

    /**
     * 归并排序:不受输入数据的影响。
     *
     * @param array
     * @return
     */
    public static int[] mergeSort(int[] array) {
        if (array.length < 2) return array;
        int mid = array.length / 2;
        int[] left = Arrays.copyOfRange(array, 0, mid);
        int[] right = Arrays.copyOfRange(array, mid, array.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    /**
     * 二路归并
     *
     * @param left
     * @param right
     * @return
     */
    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }

    /**
     * 快速排序：通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小
     *
     * @param array
     * @param start
     * @param end
     * @return
     */
    private static int[] QuickSort(int[] array, int start, int end) {
        if (array.length < 1 || start < 0 || end >= array.length || start > end) return null;
        //设基值
        int key = array[start];
        int i = start;
        int j = end;
        while (i < j) {
            //j向左移，
            while (array[j] >= key && i < j) {
                j--;
            }
            //i向右移，
            while (array[i] <= key && i < j) {
                i++;
            }
            //i和j元素交换
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        array[start] = array[i];
        array[i] = key;

        QuickSort(array, start, i - 1);
        QuickSort(array, i + 1, end);
        return array;
    }

    /*
        堆排序
     */

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
    private static int[] heapSort(int[] array){
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
        return array;
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





    public static void main(String[] args) {
        int[] array = {3, 44, 56, 1, 78, 15, 16, 9, 19, 25};
//        int[] array2 = {3, 1, 2, 4};
//        int[] result = BubbleSort(array);
//        int[] result = selectionSort(array);
//        int[] result = insertionSort(array);
//        int[] result = shellSort(array);
//        int[] result = mergeSort(array2);
//        int[] result = QuickSort(array, 0, array.length - 1);
        int[] result = heapSort(array);
        for (int a : result) {
            System.out.print(a + " ");
        }
    }
}
