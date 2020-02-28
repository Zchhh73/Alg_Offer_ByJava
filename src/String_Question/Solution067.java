package String_Question;

public class Solution067 {


    /**
     * 字符串转化为整数
     *
     * @param str
     * @return
     */
    public int StrToInt(String str) {
        if (!str.matches("[1-9,+,-]\\d+")) return 0;
        int len = str.length();
        int i = len - 1;
        long res = 0;
        while (i >= 0 && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            res += Math.pow(10, len - 1 - i) * (str.charAt(i) - '0');
            i--;
        }
        res = (str.charAt(0) == '-' ? -res : res);
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
        return (int) res;
    }

    public static void main(String[] args) {
        String strnum = "-123";
        Solution067 solution = new Solution067();
        int num = solution.StrToInt(strnum);
        System.out.print(num);
    }
}
