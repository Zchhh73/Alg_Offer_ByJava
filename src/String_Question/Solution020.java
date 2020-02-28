package String_Question;

public class Solution020 {

    public boolean isNumeric(char[] str) {
        boolean sign = false, decimal = false, hasE = false;
        for (int i = 0; i < str.length; i++) {
            //判断指数
            if (str[i] == 'e' || str[i] == 'E') {
                //E后面一定有数字，且不能有e
                if (i == str.length - 1) return false;
                if (hasE) return false;
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                //第二次出现±是在e后
                if (sign && str[i - 1] != 'e' && str[i - 1] != 'E')return false;
                //第一次出现在开头或是e后
                if(!sign && i>0 && str[i - 1] != 'e' && str[i - 1] != 'E') return false;
                sign = true;
            }else if (str[i]=='.'){
                //e后面无小数点，且不能重复出现
                if(hasE || decimal) return false;
                decimal = true;
            }else if (str[i]<'0'||str[i]>'9'){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String str = "+-16";
        char[] strarray = str.toCharArray();
//        System.out.print(strarray[2]);
        Solution020 solution = new Solution020();
        System.out.print(solution.isNumeric(strarray));
    }
}
