package Linklist_Question;

import java.util.LinkedList;
import java.util.List;

public class Solution062 {


    /**
     * 圆圈中剩下的最后一个数字
     * @param n
     * @param m
     * @return
     */
    public static int lastRemaining(int n,int m){
        if(n<1 || m<1) return -1;
        List<Integer> list = new LinkedList<>();
        for(int i = 0;i<n;i++){
            list.add(i);
        }
        //要删除的位置
        int index = 0;
        //开始节点
        int start = 0;
        while(list.size()>1){
            //移动m-1次就可以到删除节点上
            for(int i = 1;i<m;i++){
                index = (index + 1) % list.size();
            }
            list.remove(index);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(lastRemaining(5,3));

    }
}
