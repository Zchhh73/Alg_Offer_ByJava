package Alg_Question;

public class Solution017 {

    public void printToMaxOfDigits(int n) {
        if (n <= 0) {
            System.out.println("输入的n无意义。");
            return;
        }

        char number[] = new char[n];
        for (int i = 0; i < number.length; i++) {
            number[i] = '0';
        }
        for (int i = 0; i < 10; ++i) {
            number[0] = (char) (i + '0');
            printToMaxOfDigitsRecursively(number, n, 0);
        }
    }

    public void printToMaxOfDigitsRecursively(char[] number, int n, int index) {
        if (index == n - 1) {
            printNum(number);
            return;
        }
        for (int i = 0; i < 10; ++i) {
            number[index + 1] = (char) (i + '0');
            printToMaxOfDigitsRecursively(number, n, index + 1);
        }
    }

    private void printNum(char[] number) {
        boolean isBeginning0 = true;
        int nLength = number.length;
        for (int i = 0; i < nLength; ++i) {
            if (isBeginning0 && number[i] != '0') {
                isBeginning0 = false;
            }
            if (!isBeginning0) {
                System.out.print(number[i]);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Solution017 solution = new Solution017();
        solution.printToMaxOfDigits(3);
    }
}
