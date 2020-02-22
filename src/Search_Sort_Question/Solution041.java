package Search_Sort_Question;

import java.util.ArrayList;

public class Solution041 {

    ArrayList<Integer> list = new ArrayList<>();

    /**
     * 读取数据流:插入排序
     * @param num
     */
    private void Insert(Integer num){
        if(list.isEmpty()){
            list.add(num);
        }else{
            int i = 0;
            while(i<list.size() && list.get(i)<num){
                i++;
            }
            if(i == list.size()){
                list.add(num);
            }else{
                list.add(i,num);
            }
        }
    }

    /**
     * 读取数据流的中位数
     */
    private Double GetMedian(){
        int len = list.size();
        int mid = len / 2;
        if(len%2==0){
            return (double)(list.get(mid-1)+list.get(mid))/2;
        }else{
            return (double)(list.get((len-1)/2));
        }
    }

    public static void main(String[] args) {
        Solution041 solution = new Solution041();
        solution.Insert(5);
        solution.Insert(8);
        solution.Insert(6);
        solution.Insert(2);
        System.out.println(solution.GetMedian());

    }
}
