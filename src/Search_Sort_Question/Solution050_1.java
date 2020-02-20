package Search_Sort_Question;



import java.util.ArrayList;

public class Solution050_1 {

    ArrayList<Character> list = new ArrayList<>();

    public void Insert(char ch) {
        boolean flag = list.contains(ch) ? list.remove(new Character(ch)) : list.add(ch);
    }

    public char FirstAppearingOnce() {
        return list.isEmpty() ? '#' : list.get(0);
    }

    public static void main(String[] args) {
        Solution050_1 solution = new Solution050_1();
        solution.Insert('g');
        solution.Insert('o');
        solution.Insert('o');
        solution.Insert('a');
        solution.Insert('l');
        solution.Insert('g');
        System.out.println(solution.FirstAppearingOnce());
    }
}
