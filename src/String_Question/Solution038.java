package String_Question;

import java.util.ArrayList;
import java.util.Collections;

public class Solution038 {

    public ArrayList<String> Permutation(String str) {
        StringBuilder builder = new StringBuilder(str);
        ArrayList<String> result = PermutationHelp(builder);
        return result;
    }

    private ArrayList<String> PermutationHelp(StringBuilder str) {
        ArrayList<String> result = new ArrayList<>();
        if (str.length() == 1) {
            result.add(str.toString());
        } else {
            for (int i = 0; i < str.length(); i++) {
                if(i==0 || str.charAt(i)!=str.charAt(0)) {
                    //第一个位置交换
                    char temp = str.charAt(i);
                    str.setCharAt(i, str.charAt(0));
                    str.setCharAt(0, temp);
                    ArrayList<String> newResult = PermutationHelp(new StringBuilder(str.substring(1)));
                    for (int j = 0; j < newResult.size(); j++) {
                        result.add(str.substring(0, 1) + newResult.get(j));
                    }
                    temp = str.charAt(0);
                    str.setCharAt(0, str.charAt(i));
                    str.setCharAt(i, temp);
                }
            }
            Collections.sort(result);
        }
    return result;
    }

    public static void main(String[] args) {
        String str = "abc";
        Solution038 solution = new Solution038();
        System.out.print(solution.Permutation(str));
    }
}
