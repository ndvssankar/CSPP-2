import java.io.BufferedInputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Scanner;

public class List<E> {
    private E[] list;
    private int size;

    public List() {
        list = ((E[])new Object[10]);
        size = 0;
    }

    public List(int paramInt) {
        list = ((E[])new Object[paramInt]);
        size = 0;
    }

    public void add(E paramE) {
        if (size == list.length) {
            resize();
        }
        list[(size++)] = paramE;
    }

    private void resize() {
        list = Arrays.copyOf(list, size * 2);
    }

    public void addAll(E[] paramArrayOfE) {
        for (int i = 0; i < paramArrayOfE.length; i++) {
           add(paramArrayOfE[i]);
        }
    }

    public void add(int paramInt, E paramE) {
        if (paramInt < 0) {
            System.out.println("Negative Index Exception");
            return;
        }
        if (size == list.length - 1)
            resize();
        for (int i = size; i > paramInt; i--)
            list[i] = list[(i - 1)];
        list[paramInt] = paramE;
        size += 1;
    }

    public int count(E paramE) {
        int count = 0;
        for (int j = 0; j < size; j++) {
            if (list[j].equals(paramE)) {
               count++;
            }
        }
        return count;
    }

    public int size() {
        return size;
    }

    public void remove(int paramInt) {
        if ((paramInt >= 0) && (paramInt < size)) {
            for (int i = paramInt; i < size - 1; i++) {
                list[i] = list[(i + 1)];
            }
            size -= 1;
        } else {
            System.out.println("Invalid Position Exception");
        }
    }

    public E get(int paramInt) {
        if ((paramInt < 0) || (paramInt >= size)) {
           return null;
        }
        return list[paramInt];
    }

    public String toString() {
        if (size == 0)
            return "[]";
        StringBuffer localStringBuffer = new StringBuffer("[");
        int i = 0;
        for (i = 0; i < size - 1; i++) {
            localStringBuffer.append(list[i] + ",");
        }
        localStringBuffer.append(list[i] + "]");
        return localStringBuffer.toString();
    }

    public boolean contains(E paramE) {
		for (int i = 0; i < size; i++) {
	        if (list[i].equals(paramE)){
	            return true;
	        }
        }
        return false;
    }

    public int indexOf(E paramE) {
        for (int i = 0; i < size; i++) {
        if (list[i].equals(paramE))
            return i;
        }
        return -1;
    }
}
