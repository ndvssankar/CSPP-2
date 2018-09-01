import java.util.Scanner;
/**
 * Write a java program to round the
 * elements of a matrix to the nearest 100.
 *
 * @author : Siva Sankar
 */
final class Solution {
    /**
     * Constant HUNDRED 100.
     */
    public static final int HUNDRED = 100;
    /**
     * Constant FIFTY 50.
     */
    public static final int FIFTY = 50;
        
    /**
     * Constructs the object.
     */
    private Solution() {
        //not used
    }
    /**
     * [roundToHundered description].
     * @param  n [description]
     * @return   [description]
     */
    public static int roundToHundered(final int n) {
        int diff = HUNDRED - (n % HUNDRED);
        if (diff >= FIFTY) {
            return n - (HUNDRED - diff);
        } else {
            return n + diff;
        }
    }
    /**
     * Function to round the
     * elements of a matrix to the nearest 100.
     *
     * @param      a     Matrix of which the elements to be rounded
     * @param      rows     Number of rows
     * @param      columns     Number of columns
     *
     * @return     Matrix of the rounded elements
     */
    public static int[][] roundHundred(final int[][] a, final int rows, 
            final int columns) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                a[i][j] = roundToHundered(a[i][j]);
            }
        }
        return a;
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] a = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = scan.nextInt();
            }
        }
        int[][] b = roundHundred(a, m, n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n - 1; j++) {
                System.out.print(b[i][j] + " ");
            }
            System.out.println(b[i][n - 1]);
        }
    }
}
