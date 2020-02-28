package String_Question;

public class Solution058_2 {


    /**
     * 左旋转字符串
     * @param str
     * @param n
     * @return
     */
    private StringBuilder LeftRotateString(String str,int n){
        StringBuilder str1 = new StringBuilder(str);
        int len = str.length();
        if(len<0 && n>len && n<0){
            return null;
        }else{
            reverse(str1,0,n-1);
            reverse(str1,n,len-1);
            reverse(str1,0,len-1);
            return str1;
        }
    }

    private void reverse(StringBuilder str,int start,int end){
        if(start<0||end>str.length()-1) return;
        while(start<end){
            char temp = str.charAt(start);
            str.setCharAt(start,str.charAt(end));
            str.setCharAt(end,temp);
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        String str = "abcdefg";
        Solution058_2 solution = new Solution058_2();
        System.out.println(solution.LeftRotateString(str,3));
    }
}
