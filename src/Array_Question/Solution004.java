package Array_Question;

public class Solution004 {

    /**
     * 二维数组的查找
     *
     * @param target
     * @param array
     * @return
     */
    public boolean Find(int target, int[][] array) {
        //从右上到左下的遍历
        int rows = array.length;
        int cols = array[0].length;
        if (rows == 0 || cols == 0) return false;
        int row = 0;
        int col = cols - 1;
        while (row < rows - 1 && col >= 0) {
            if (array[row][col] < target) {
                row++;
            } else if (array[row][col] > target) {
                col--;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] arrays = new int[][]{{1, 3, 5, 7}, {2, 4, 6, 7}, {4, 6, 8, 10}, {7, 8, 12, 20}};
        int target = 13;
        Solution004 solution004 = new Solution004();
        System.out.println(solution004.Find(target, arrays));

    }
}
