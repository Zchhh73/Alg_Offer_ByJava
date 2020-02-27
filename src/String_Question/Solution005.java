package String_Question;

public class Solution005 {


    /**
     * 替换空格
     * @param str
     * @return
     */
    public String replaceSpace(StringBuffer str) {
        //设置两个指针，一个指向旧长度末尾，一个指向新长度末尾，同时向前移动，遇到空格替换。
        int spacenum = 0;
        for(int i = 0;i<str.length();i++){
            if(str.charAt(i)==' '){
                spacenum++;
            }
        }
        int oldlength = str.length();
        int oldIndex = oldlength-1;
        int newlength = oldlength + spacenum * 2;
        str.setLength(newlength);
        int newIndex = newlength-1;
        for(;oldIndex>=0 && oldlength<newlength;oldIndex--){
            if(str.charAt(oldIndex)==' '){
                str.setCharAt(newIndex--,'0');
                str.setCharAt(newIndex--,'2');
                str.setCharAt(newIndex--,'%');

            }else{
                str.setCharAt(newIndex--,str.charAt(oldIndex));
            }
        }
        return str.toString();
    }


    public static void main(String[] args) {
        StringBuffer str = new StringBuffer();
        str.append("we are family ");
        Solution005 solution = new Solution005();
        System.out.print(solution.replaceSpace(str));
    }
}
