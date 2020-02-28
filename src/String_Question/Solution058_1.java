package String_Question;

import java.util.Stack;

public class Solution058_1 {

    /**
     * 给一个句子，翻转单词顺序
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        // 遍历字符串，遇到字母加入temp.
        // 遇到空格，若temp为不为空，则组成单词入栈并清空。继续遍历
        Stack<String> stack = new Stack<>();
        StringBuilder temp = new StringBuilder();
        if (s == null || s.trim().length() == 0) return s;
        s += " ";//为统一
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                if (temp.length() != 0) {
                    stack.push(temp.toString());
                    temp = new StringBuilder();
                }
            } else {
                temp.append(s.charAt(i));
            }

        }
        if (stack.isEmpty()) {
            return "";
        }
        StringBuilder res = new StringBuilder();
        res.append(stack.pop());
        while (!stack.isEmpty()) {
            res.append(" ");
            res.append(stack.pop());
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String str1 = "I am a Student.";
        Solution058_1 str = new Solution058_1();
        System.out.println(str.reverseWords(str1));
    }
}
