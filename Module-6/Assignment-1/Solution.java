import java.util.Scanner;
/**
 * Write a java program to find the odd composite numbers
 * between 2 and n where n is given as an input.
 *
 * @author : 
 */
public final class Solution {
    /**
    * Empty constructor.
    */
    private Solution() {
        //not used
    }

    /**
     * [isOddComposite description]
     * @param  n [description]
     * @return   [description]
     */
    public static boolean isOddComposite(int n) {
        if(n%2 == 0)
            return true;
        for(int i=2; i<n; i++)
            if(n%i==0)
                return false;
        return true;
    }
    /**
     * Prints the odd composite numbers between 2 and n.
     *
     * @param      n     n value
     */
    public static void oddComposites(final int n) {
       for(int i=9; i<=n; i++) {
            if(!isOddComposite(i)) {
                System.out.println(i);
            }
       }
    }
    /**
    * main method as driver program.
    * @param args is the parameter for this method
    */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        oddComposites(n);
    }
}

