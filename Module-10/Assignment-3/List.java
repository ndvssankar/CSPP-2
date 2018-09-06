import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

/*
     * The goal for the list is to store items.
     * How are we going to store the items in the list?
     * An array would be good. Right?
     * So, when we do not what we are going to have in the list
     * We need to create a Generic list to store the items

     * Here E is a type parameter, and it will be replaced with 
        actual type when the object got created. 
     */
public class List<E> {
    private E[] list;
    private int size;
    
    /**
     * which is used to create an element array.
     * @return Nothing.
     */
    public List() {
        // Create a variable of the type Object[]
        list = ((E[])new Object[10]);
        size = 0;
    }

    /**
     * This is an overloaded constructor which takes the initial capacity to create a Generic array.
     * @param  param [description]
     * @return       [description]
     */
    public List(int param) {
        list = ((E[])new Object[param]);
        size = 0;
    }
    /* The add method does what the name suggests.
     * Add a generic type item to the list.
     * The assumption is to store the item at the end of the list
     * What is the end of the list?
     * Is it the same as the end of the array?
     * Think about how you can use the size variable to add item
     * to the list.
     */
    public void add(E item) {
        if(size == list.length)
            resize();
        list[size++] = item;
    }

    private void resize() {
        list = Arrays.copyOf(list, size*2);
    }

    /**
     * Adds all the elements to the end of the list from the items array.
     * @param items to be added to the ListADT.
     */
    public void addAll(E[] items) {
        for(int i=0; i<items.length; i++)
            add(items[i]);
    }

    /**
     * Adding an element at a particular index.
     * @param index, the element to be inserted at this index.
     * @param item, to be inserted in the list.
     */
    
    // list = [1,2,3,4,5,6,7,8,0,0]
    // index = 2
    // item = 9
    //         0,1,2,3,4,5,6,7,8,9
    // list = [1,2,9,3,4,5,6,7,8,0]
    public void add(int index, E item) {
        for(int i=size; i > index; i--)
            list[i] = list[i-1];
        list[index] = item;
        size++;
    }

    /**
     * Count the number of occurances of the item in the list.
     * @param  item to be counted
     * @return the number of occurances of the item.
     */
    public int count(E item) {
        int count = 0;
        for(E element : list)
            if(element.equals(item))
                count++;
        return count;
    }

    /*
     * The size method returns the value of the size.
     * The purpose of the method is to announce the size of the list
     * to the objects outside the list
     * 
     * The method returns an int. Empty list should return 0.
     */
    public int size() {
        return size;
    }

    /*
     * The remove method does what the name suggests.
     * Removes a String item, specified by the index argument, from the list
     * It also does an additional step.
     * Think about what happens when 
     * an item is removed from the middle of the list
     * It creates a hole in the list, right?
     * This would mean, all the items that are
     * to the right side of the removed item should be
     * moved to the left by one position.
     * Here is an example:
     * array = [1,2,3,0,0,0,0,0,0,0]
     * remove(1) would remove the item 2 which is at index position 1.
     * But how do you remove the item from an array?
     * Well, the way to remove it is to move all
     * the items, that are to the right of the removed item, to the left
     * So, the new array looks like this.
     * array = [1,3,0,0,0,0,0,0,0,0]
     * The method returns void (nothing)
     */
    public void remove(int idex) {
        if(idex < 0 || idex >= size) {
            System.out.println("Invalid Position Exception");
            return;
        }
        for(int i = size; i > idex; i--)
            list[i] = list[i-1];
        list[size-1] = null;
        size--;
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
    public E get(int index) {
        if(index < 0 || index >= size) {
            return null;
        } else {
            return list[index];
        }
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
        if(size == 0)
            return "[]";
        else {
            StringBuffer sb = new StringBuffer("[");
            for(int i=0; i<size-1; i++)
                sb.append(list[i] + ",");
            sb.append(list[size-1] + "]");
            return sb.toString();
        }
    }
    /*
     * Contains return true if the list has
     * the item passed as an argument to the method
     * So, iterate through the list and return true if
     * the item exists and otherwise false
     */
    public boolean contains(E item) {
        return indexOf(item) >= 0;
    }
    /*
     * Returns the index of the first occurrence 
     * of the specified element in this list,
     * or -1 if this list does not contain the element.
     */
    public int indexOf(E item) {
        for(int i=0; i<size; i++)
            if(item.equals(list[i]))
                return i;
        return -1;
    }
}
