package Alg_Question;

public class Solution016 {

    /**
     * 数值的整数次方
     *
     * @param base
     * @param exponent
     * @return
     */
    public double Power(double base, int exponent) {
        double result = 1.0;
        double temp = 1.0;
        if (base == 0.0 && exponent < 0) return 1;
        if (base == 0) {
            return 0.0;
        } else if (exponent < 0) {
            for (int i = 1; i <= Math.abs(exponent); ++i) {
                temp = temp * base;
            }
            result = 1.0 / temp;
            return result;
        } else if (exponent > 0) {
            for (int i = 1; i <= exponent; i++) {
                result = result * base;
            }
            return result;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution016 solution = new Solution016();
        System.out.println(solution.Power(-3.0,2));
    }
}
