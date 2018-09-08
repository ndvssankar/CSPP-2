import java.io.BufferedInputStream;
import java.util.Scanner;

public class Set {
    //Implement all the methods mentioned to build a ListADT

    /*
     * The goal for the list is to store items.
     * How are we going to store the items in the list?
     * An array would be good. Right?
     * So, assume we are only going to have ints in the list
     * We need to create an array of ints to store the items
     * added to the list.
     *
     * Create a variable of the type int[]
     * Use the private access specifier
     * Why private access specifier and why not public?
     * Well, we don't want the array to be manipulated by
     * methods that are outside the List class.
     * If you allow methods outside the List class to manipulate
     * the array then there is a possibility of having a corrupted
     * list i.e., a list with incorrect items.
     * This is not desirable and so having private access specifer
     * will protect the array such corruption.
     * This is a hard concept to understand. Discuss with your mentor.
     *
    */

    // declare a private int[]
    // don't create the array yet using new
    // that's the job of the List constructor

    /*
     * What are the other class variables needed for creating a list?
     * How about keeping track of the size of the list?
     * If you add 2 items to the list then the size should be 2.
     * Let's think about the size of the list by comparing it to the
     * length of the array. Do they mean the same?
     * No, Array length signifies the maximum number of items
     * you can store in the list. Whereas, the size of the list
     * denotes the number of items in the list. Makes sense?
     * Here is an example:
     * array = [1,2,3,0,0,0,0,0,0,0]
     * The length of the array is 10 and size is 3.
     * This means you can store 10 items in the list and
     * currently it has 3 items.
     * So, to keep track of the size we need a variable called size
     * Again, we use private as we don't want that size variable
     * to be accessed by the methods that are outside of the List class.
     *
     */

    // declare a private int size
    // again, don't initialize it here
    // variable initialization should be done in the constructor

    /*
     * The purpose of the constructor is to initialize the
     * class variables with some default values.
     */

    private int[] set;
    private int size;

    public Set() {

        // what are the two variables to be initialized here?
        // think about the private variables described above.
        // What should be the default values?
        // In the case of the list, it should be empty but
        // it should be initialized with an array size like 10

        // Think about the initial value for size.
        // How many items do we have in the list when you create it?
        // An empty list has how many items?
        // That is the initial value to use for size.
        set = new int[10];
        size = 0;
    }

    /*
     * The add method does what the name suggests.
     * Add an int item to the list.
     * The assumption is to store the item at the end of the list
     * What is the end of the list?
     * Is it the same as the end of the array?
     * Think about how you can use the size variable to add item
     * to the list.
     *
     * The method returns void (nothing)
     */
    public void add(int item) {
        // Inserts the specified element at the end of the list.
        if (size == set.length) {
            resize();
        }
        if (!contains(item)) {
            set[size++] = item;
        }
    }

    private void resize() {
        set = java.util.Arrays.copyOf(set, size * 2);
    }

    public void add(int[] set) {
        for (int i = 0; i < set.length; i++) {
            add(set[i]);
        }
    }

    public Set intersection(Set other) {
        Set result = new Set();
        for (int i = 0; i < this.size; i++) {
            if (other.contains(this.get(i))) {
                result.add(this.get(i));
            }
        }
        return result;
    }

    public Set retainAll(int[] arr) {
        Set other = new Set();
        for(int item : arr)
            other.add(item);
        return intersection(other);
    }

    public int[][] cartesianProduct(Set other) {
        int [][] result = new int[this.size() * other.size()][2];
        int k = -1;
        for(int i=0; i<this.size(); i++) {
            for(int j=0; j<other.size(); j++) {
                result[++k][0] = this.get(i);
                result[k][1] = other.get(j);
            }
        }
        return result;
    }

    /*
     * The size method returns the value of the size.
     * The purpose of the method is to announce the size of the list
     * to the objects outside the list
     *
     * The method returns an int. Empty list should return 0.
     */
    public int size() {
        // replace the code below to implement the size method
        return size;
    }

    /*
     * Get method has to return the items that is
     * at the index position passed as an argument to the method.
     * If the item doesn't exist then return a -1 to indicate that
     * there is no element at that index.
     * How can an element not be there at a given position?
     * Well, if the position is greater than the number of items
     * in the list then that would mean the item doesn't exist.
     * How do we check if the position is greater than the
     * number of items in the list? Would size variable be useful?
     */
    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;
        else
            return set[index];
    }

    /*
     * What happens when you print an object using println?
     * Java provides a method named toString that is internally
     * invoked when an object variable is used in println.
     * For example:
     * List l = new List();
     * System.out.println(l);
     * This statement is a shortcut for
     * System.out.println(l.toString());
     *
     * So, implement the toString method to display the items
     * in the list in the square brackets notation.
     * i.e., if the list has numbers 1, 2, 3
     * return the string [1,2,3]
     * Caution: The array may be having other elements
     * Example: [1,2,3,0,0,0,0,0,0,0]
     * toString should only return the items in the list and
     * not all the elements of the array.
     *
     */
    public String toString() {
        if (size == 0) {
            return "{}";
        }
        StringBuffer sb = new StringBuffer("{");
        for (int i = 0; i < size - 1; i++)
            sb.append(set[i] + ", ");
        sb.append(set[size - 1] + "}");
        return sb.toString();
    }

    /*
     * Contains return true if the list has
     * the item passed as an argument to the method
     * So, iterate through the list and return true if
     * the item exists and otherwise false
     */
    public boolean contains(int item) {
        return indexOf(item) != -1;
    }

    /*
     * Returns the index of the first occurrence
     * of the specified element in this list,
     * or -1 if this list does not contain the element.
     */
    public int indexOf(int item) {
        for (int i = 0; i < size; i++)
            if (set[i] == item)
                return i;
        return -1;
    }

    public static void main(String[] args) {
        // create an object of the list to invoke methods on it
        Set set = new Set();

        // code to read the test cases input file
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        // check if there is one more line to process
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "add":
                String[] vals = tokens[1].split(",");
                if (vals.length == 1) {
                    set.add(Integer.parseInt(tokens[1]));
                } else {
                    int[] ints = new int[vals.length];
                    for (int i = 0; i < vals.length; i++) {
                        ints[i] = Integer.parseInt(vals[i]);
                    }
                    set.add(ints);
                }
                break;
            case "size":
                // invoke size method and print the list size
                // BTW, list size is not the array size
                // it is the number of items in the list
                System.out.println(set.size());
                break;
            case "print":
                System.out.println(set);
                break;
            case "indexOf":
                System.out.println(set.indexOf(Integer.parseInt(tokens[1])));
                break;
            case "get":
                System.out.println(set.get(Integer.parseInt(tokens[1])));
                break;
            case "contains":
                System.out.println(set.contains(
                                       Integer.parseInt(tokens[1])));
                break;
            case "intersection":
                vals = tokens[1].split(",");
                if (vals.length == 2) {
                    Set that = new Set();
                    for (int i = 0; i < vals.length; i++)
                        that.add(Integer.parseInt(vals[i]));
                    System.out.println(set.intersection(that));
                }
                break;
            case "cp":
                vals = tokens[1].split(",");
                Set that = new Set();
                for (int i = 0; i < vals.length; i++)
                    that.add(Integer.parseInt(vals[i]));
                int[][] arr = set.cartesianProduct(that);
                System.out.println(java.util.Arrays.deepToString(arr));
                break;
            // case "retainsAll":
            //     vals = tokens[1].split(",");
            //     that = new Set();
            //     for (int i = 0; i < vals.length; i++)
            //         that.add(Integer.parseInt(vals[i]));
            //     System.out.println(set.retainsAll(that));
            }
        }
    }
}
