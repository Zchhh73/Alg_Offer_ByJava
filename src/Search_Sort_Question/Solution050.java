package Search_Sort_Question;

import java.util.HashMap;
import java.util.Map;

public class Solution050 {

    /**
     * 字符串中第一个只出现一次的字符
     *
     * @param str
     * @return
     */
    public char findFirstNoRepeatChar(String str) {
        //借助Hashmap，k存储字符，v存储出现次数。
        if (str == null || str.trim().length() == 0) return '#';
        Map<Character, Integer> map = new HashMap<>();
        str = str.toLowerCase();
        int len = str.length();
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (map.containsKey(str.charAt(i))) {
                count = map.get(str.charAt(i));
                map.put(str.charAt(i), ++count);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        for (int i = 0; i < len; i++) {
            if(map.get(str.charAt(i))==1){
                return str.charAt(i);
            }
        }
        return '#';
    }

    public static void main(String[] args) {
        String str = "abbccaeddff";
        Solution050 solution = new Solution050();
        System.out.println(solution.findFirstNoRepeatChar(str));
    }

}
