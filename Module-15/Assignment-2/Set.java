import java.io.BufferedInputStream;
import java.util.Scanner;

public class Set {

    /**
     * This constant is used to create an array
     * with the initial capacity.
     */
    public static final int TEN = 10;

    /**
     * holds the elemtns in this Set array.
     */
    private int[] set;

    /**
     * indicates the number of elememnts of this set.
     */
    private int size;

    /**
     * Default constructor to create an array with the szie 10.
     */
    public Set() {
        set = new int[TEN];
        size = 0;
    }

    /**
     * adds all the elements to this set in ascending order.
     */
    public void addAll(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            add(arr[i]);
        }
    }

    /**
     * add the item to this set at the last.
     * If the set is full, resize the set to double
     * the size of the current set.
     * @param item to be inserted at the last.
     */
    public void add(int item) {
        if (size == set.length) {
            resize();
        }
        if (!contains(item)) {
            set[size++] = item;
        }
    }

    /**
     * [add description].
     * @param index [description].
     * @param item  [description].
     */
    public void add(int index, int item) {
        if (index < 0 || index > size()) {
            throw new IndexOutOfBoundsException("Invalid Index Exception");
        } else {
            if (size == set.length) {
                resize();
            }
            for (int i = size(); i > index; i--) {
                set[i] = set[i-1];
            }
            set[index] = item;
            size++;
        }
    }

    /**
     * resize the set by double, when it is full.
     */
    protected void resize() {
        set = java.util.Arrays.copyOf(set, size * 2);
    }

    /**
     * add all elements of the array to this Set.
     * @param arr as an arr to be added in this set,
     *            if the element is not present in this set.
     */
    public void add(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            add(arr[i]);
        }
    }

    /**
     * Finds the intersection of the two sets.
     * @param  other as set 2.
     * @return the result that contains the common
     * elements of the two sets.
     */
    public Set intersection(Set other) {
        Set result = new Set();
        for (int i = 0; i < this.size; i++) {
            if (other.contains(set[i])) {
                result.add(set[i]);
            }
        }
        return result;
    }

    /**
     * retains all the elements from the set.
     * @param  arr is a form of set2.
     * @return the set that contains all the elements
     * of this set.
     */
    public Set retainAll(final int[] arr) {
        Set other = new Set();
        for (int item : arr) {
            other.add(item);
        }
        return intersection(other);
    }

    /**
     * This finds out the cartesian product of two sets.
     * @param  other as a Set 2.
     * @return the cartesian product in the form of 2D array.
     */
    public int[][] cartesianProduct(final Set other) {
        int [][] result = new int[this.size() * other.size()][2];
        int k = -1;
        if (this.size() == 0 || other.size() == 0) {
            return null;
        }
        for (int i = 0; i < this.size(); i++) {
            for (int j = 0; j < other.size(); j++) {
                try {
                    result[++k][0] = this.get(i);
                    result[k][1] = other.get(j);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return result;
    }

    /**
     * returns the set length.
     * @return set length.
     */
    public int length() {
        return this.set.length;
    }

    /**
     * This methods finds out the number of elements in the set.
     * @return the integer value indicates the number of elements.
     */
    public int size() {
        return size;
    }

    /**
     * This method finds out the elements
     * at a particular index.
     * @param  index to return the element at this index.
     * @return the element at this index, otherwise return -1.
     */
    public int get(final int index) {
        if (index < 0 || index >= this.size()) {
            throw new IndexOutOfBoundsException("Invalid Index Exception");
        } else {
            return set[index];
        }
    }

    /**
     * String version of the object.
     * @return string.
     */
    public String toString() {
        if (this.size() == 0) {
            return "{}";
        }
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < size - 1; i++) {
            sb.append(set[i] + ", ");
        }
        sb.append(set[size - 1] + "}");
        return sb.toString();
    }

    /**
     * returns true if this set contains the item.
     * @param  item as a parameter to be checked in the set.
     * @return      true if the item present in the set,
     *                   otherwise false.
     */
    public boolean contains(final int item) {
        return indexOf(item) != -1;
    }

    /**
     * Finds the index of the item in this set.
     * @param  item to be find in this set.
     * @return the index if the item is found in this set,
     * otherwise false.
     */
    public int indexOf(final int item) {
        for (int i = 0; i < size; i++) {
            if (set[i] == item) {
                return i;
            }
        }
        return -1;
    }
}
