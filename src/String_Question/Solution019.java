package String_Question;

public class Solution019 {


    /**
     * 正则表达式的匹配
     *
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern) {
        return matchstr(str, 0, pattern, 0);
    }


    public boolean matchstr(char[] str, int i, char[] pattern, int j) {
        //都走完了说明匹配成功返回true
        if (i == str.length && j == pattern.length) {
            return true;
        } else if (j == pattern.length) {//只有样式走完了，没有匹配成功
            return false;
        }

        //*模式，表示*前字符出现任意次数
        boolean next = (j + 1 < pattern.length && pattern[j + 1] == '*');
        // 如果是*模式
        if (next) {
            //若*前是.或是str和模式中字符匹配，
            if (i < str.length && (pattern[j] == '.' || str[i] == pattern[j])) {
                // *可能匹配0次||字符串出现连续字符，模式保持不变。
                return matchstr(str, i, pattern, j + 2) || matchstr(str, i + 1, pattern, j);
            } else {//若样式和字符串字符不匹配，则往下走。
                return matchstr(str, i, pattern, j + 2);
            }
        } else {
            //.模式
            if (i < str.length && (pattern[j] == '.') || str[i] == pattern[j]) {
                return matchstr(str, i + 1, pattern, j + 1);
            }else {
                return false;
            }
        }
    }


    public static void main(String[] args) {
        char[] str = {'a', 'c', 'a'};
        char[] pattern = {'.','*'};
        Solution019 solution = new Solution019();
        System.out.print(solution.match(str, pattern));
    }


}
