import java.io.BufferedInputStream;
import java.util.Scanner;

class SetEmptyException extends Exception {
    public SetEmptyException(String message) {
        super(message);
    }
}

public class SortedSet extends Set {
    /**
     * Returns the largest element of the set.
     * @return last element of the set.
     */
    public int last() throws Exception {
        if (size() == 0) {
            throw new SetEmptyException("Set Empty Exception");
        } else {
            return get(size() - 1);
        }
    }

    /**
     * Inserts the item into the index returned by the rank method. After insertion,
     * the set is sorted.
     * @param item to be insertd into this set.
     */
    public void add(int item) {
        if (size() == length()) {
            resize();
        } else {
            if (!contains(item)) {
                try {
                    int index = rank(item);
                    add(index, item);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    /**
     * Finds the headset of all the elements that are strictly less than toElement.
     * @param  toElement up to this element (exclusive)
     * @return           the set that are less than to element.
     */
    public Set headSet(int toElement) throws Exception {
        int toIndex = rank(toElement);
        if (toIndex == 0) {
            throw new Exception("Set Empty Exception");
        } else {
            int fromElement = get(0);
            return subSet(fromElement, toElement);
        }
    }

    /**
     * returns the subset of this set based on fromElement and toElement.
     * @param  fromElement from this element.
     * @param  toElement   to this element.
     * @return             subset of the set.
     */
    public Set subSet(int fromElement, int toElement)
    throws Exception {
        if (fromElement > toElement) {
            throw new IllegalArgumentException(
                "Invalid Arguments to Subset Exception");
        } else {
            int fromIndex = rank(fromElement);
            int toIndex = rank(toElement);
            Set subSet = new Set();
            for (int i = fromIndex; i < toIndex; i++) {
                subSet.add(this.get(i));
            }
            return subSet;
        }
    }

    /**
     * Returns the index of the element to be inserted.
     * @param  item as a parameter
     * @return      the index of the new item to be inserted.
     */
    public int rank(int item) throws Exception {
        int lo = 0, hi = this.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = item - this.get(mid);
            if      (cmp < 0) hi = mid - 1;
            else if (cmp > 0) lo = mid + 1;
            else return mid;
        }
        return lo;
    }
}
