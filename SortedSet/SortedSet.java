import java.io.BufferedInputStream;
import java.util.Scanner;

public class SortedSet extends Set {

    public Set headSet(int toElement) {
         return subSet(get(0), toElement);
    }

    public Set subSet(int fromElement, int toElement) {
        if (fromElement > toElement) {
            System.out.println("Invalid Arguments to SubSet Exception");
            return null;
        }
        int fromIndex = getIndex(fromElement);
        int toIndex = getIndex(toElement);
        Set subSet = new Set();
        for(int i = fromIndex; i < toIndex; i++) {
            subSet.add(this.get(i));
        }
        return subSet;
    }

    public int last() {
        if (size() == 0) {
            System.out.println("Set Empty Exception");
            return -1;
        }
        return get(size()-1);
    }

    public void add(int item) {
        if(!contains(item)) {
            int index = getIndex(item);
            add(index, item);
        }
    }

    public int getIndex(int item) {
        for(int i = 0; i < size(); i++) {
            if (item < this.get(i)) {
                return i;
            }
        }
        return size();
    }

    public static void main(String[] args) {
        SortedSet ss = new SortedSet();
        System.out.println(ss);

        // ss.add(10);
        // System.out.println(ss);
        // ss.add(11);
        // System.out.println(ss);
        // ss.add(9);
        // System.out.println(ss);
        // int arr[] = {5, 13, 0, 12, 9, 10, -1, 11, -2, 26};
        // ss.addAll(arr);
        // System.out.println(ss);
        // System.out.println("SubSet : " + ss.subSet(0, 12));
        System.out.println("Head Set : " + ss.headSet(12));
    }
}
