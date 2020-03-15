package Alg_Question;

public class Solution064 {

    public int Sum(int n) {
        if (n <= 0) return 0;
        int sum = (int) (Math.pow(n, 2) + n);
        return sum >> 1;
    }

    public static void main(String[] args) {
        Solution064 solution064 = new Solution064();
        System.out.println(solution064.Sum(9));
    }
}
