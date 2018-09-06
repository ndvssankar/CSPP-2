import java.io.BufferedInputStream;
import java.util.Scanner;

/**
 * Class Student.
 */

class Student {
    /**
     * name of the student.
     */
    private String name;
    /**
     * parameterized constructor.
     * @param  name1 of the student.
     * @return       nothing.
     */
    protected Student(final String name1) {
        this.name = name1;
    }

    /**
     * returns the name of the student.
     * @return name of the student.
     */
    public String getName() {
        return this.name;
    }


    /**
     * equals method.
     * @param  other Student Object.
     * @return       false if it doesn't match.
     */
    // @Override
    public boolean equals(final Object other) {
        if (!(other instanceof Student)) {
            return false;
        }

        Student that = (Student) other;
        return this.getName().equals(that.getName());
    }

    /**
     * String version of student object.
     * @return String.
     */
    public String toString() {
        return this.name;
    }
}

/**
 * Solution Client.
 */
public final class Solution {
    
    /**
     * Constructor.
     * @return nothing.
     */
    private Solution() {

    }
    /**
     * main method.
     * @param args command line args.
     */
    public static void main(final String[] args) {
        // create an object of the list to invoke methods on it
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        String objectType = stdin.nextLine();

        switch (objectType) {
            case "S"://This case will be executed for String type list
                List<String> listString = new List();
                while (stdin.hasNext()) {
                    // read the line
                    String line = stdin.nextLine();
                    // split the line using space
                    String[] tokens = line.split(" ");
                    // based on the list operation invoke
                    // the corresponding method
                    switch (tokens[0]) {
                        case "add":
                            listString.add(tokens[1]);
                        break;
                        case "addAll":
                        if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        listString.addAll(t1);
                        }
                        break;
                        case "size":
                        // invoke size method and print the list size
                        // BTW, list size is not the array size
                        // it is the number of items in the list
                        System.out.println(listString.size());
                        break;
                        case "print":
                        // print the list (implement toString in List class
                        //for this to work)
                        // expected format is [item-1,item-2,...,item-n]
                        // review the output testcase file
                        System.out.println(listString);
                        break;
                        case "remove":
                        listString.remove(Integer.parseInt(tokens[1]));
                        break;
                        case "indexOf":
                        System.out.println(listString.indexOf(tokens[1]));
                        break;
                        case "get":
                        System.out.println(listString.get(
                            Integer.parseInt(tokens[1])));
                        break;
                        case "contains":
                        System.out.println(listString.contains(tokens[1]));
                        break;
                        default:
                        break;
                    }
                }
            break;

            case "I"://This case will be executed for Integer type list
                List<Integer> listInteger = new List<Integer>();
                while (stdin.hasNext()) {
                    // read the line
                    String line = stdin.nextLine();
                    // split the line using space
                    String[] tokens = line.split(" ");
                    // based on the list operation invoke the
                    // corresponding method
                    switch (tokens[0]) {
                        case "add":
                            listInteger.add(Integer.parseInt(tokens[1]));
                        break;
                        case "addAll":
                        if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        Integer[] temp = new Integer[t1.length];
                        for (int i = 0; i < temp.length; i++) {
                            temp[i] = Integer.parseInt(t1[i]);
                        }
                        listInteger.addAll(temp);
                        }
                        break;
                        case "size":
                        // invoke size method and print the list size
                        // BTW, list size is not the array size
                        // it is the number of items in the list
                        System.out.println(listInteger.size());
                        break;
                        case "print":
                        // print the list (implement toString in List class
                        //for this to work)
                        // expected format is [item-1,item-2,...,item-n]
                        // review the output testcase file
                        System.out.println(listInteger);
                        break;
                        case "remove":
                        listInteger.remove(Integer.parseInt(tokens[1]));
                        break;
                        case "indexOf":
                        System.out.println(listInteger.indexOf(
                            Integer.parseInt((tokens[1]))));
                        break;
                        case "get":
                        System.out.println(listInteger.get(
                            Integer.parseInt(tokens[1])));
                        break;
                        case "contains":
                        System.out.println(listInteger.contains(
                            Integer.parseInt((tokens[1]))));
                        break;
                        default:
                        break;
                    }
                }
            break;

            case "F"://This case will be executed for Float type list
                List<Float> listFloat = new List<Float>();
                while (stdin.hasNext()) {
                    // read the line
                    String line = stdin.nextLine();
                    // split the line using space
                    String[] tokens = line.split(" ");
                    // based on the list operation invoke
                    // the corresponding method
                    switch (tokens[0]) {
                        case "add":
                            listFloat.add(Float.parseFloat(tokens[1]));
                        break;
                        case "addAll":
                        if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        Float[] temp = new Float[t1.length];
                        for (int i = 0; i < t1.length; i++) {
                            temp[i] = Float.parseFloat(t1[i]);
                        }
                        listFloat.addAll(temp);
                        }
                        break;
                        case "size":
                        // invoke size method and print the list size
                        // BTW, list size is not the array size
                        // it is the number of items in the list
                        System.out.println(listFloat.size());
                        break;
                        case "print":
                        // print the list (implement toString in List class
                        //for this to work)
                        // expected format is [item-1,item-2,...,item-n]
                        // review the output testcase file
                        System.out.println(listFloat);
                        break;
                        case "remove":
                        listFloat.remove(Integer.parseInt(tokens[1]));
                        break;
                        case "indexOf":
                        System.out.println(listFloat.indexOf(
                            Float.parseFloat(tokens[1])));
                        break;
                        case "get":
                        System.out.println(listFloat.get(
                            Integer.parseInt(tokens[1])));
                        break;
                        case "contains":
                        System.out.println(listFloat.contains(
                            Float.parseFloat(tokens[1])));
                        break;
                        default:
                        break;
                    }
                }
            break;

            case "C"://This case will be executed for Character type list
                List<Character> listCharacter = new List();
                while (stdin.hasNext()) {
                    // read the line
                    String line = stdin.nextLine();
                    // split the line using space
                    String[] tokens = line.split(" ");
                    // based on the list operation invoke
                    // the corresponding method
                    switch (tokens[0]) {
                        case "add":
                            listCharacter.add(tokens[1].charAt(0));
                        break;
                        case "addAll":
                        if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        Character[] temp = new Character[t1.length];
                        for (int i = 0; i < t1.length; i++) {
                            temp[i] = t1[i].charAt(0);
                        }
                        listCharacter.addAll(temp);
                        }
                        break;
                        case "size":
                        // invoke size method and print the list size
                        // BTW, list size is not the array size
                        // it is the number of items in the list
                        System.out.println(listCharacter.size());
                        break;
                        case "print":
                        // print the list (implement toString in List class
                        //for this to work)
                        // expected format is [item-1,item-2,...,item-n]
                        // review the output testcase file
                        System.out.println(listCharacter);
                        break;
                        case "remove":
                        listCharacter.remove(Integer.parseInt(tokens[1]));
                        break;
                        case "indexOf":
                        System.out.println(
                            listCharacter.indexOf(tokens[1].charAt(0)));
                        break;
                        case "get":
                        System.out.println(
                            listCharacter.get(Integer.parseInt(tokens[1])));
                        break;
                        case "contains":
                        System.out.println(
                            listCharacter.contains(tokens[1].charAt(0)));
                        break;
                        default:
                        break;
                    }
                }
            break;

            case "D"://This case will be executed for Double type list
                List<Double> listDouble = new List();
                while (stdin.hasNext()) {
                    // read the line
                    String line = stdin.nextLine();
                    // split the line using space
                    String[] tokens = line.split(" ");
                    switch (tokens[0]) {
                        default:
                        break;
                        case "add":
                            listDouble.add(Double.parseDouble(tokens[1]));
                        break;
                        case "addAll":
                        if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        Double[] temp = new Double[t1.length];
                        for (int i = 0; i < t1.length; i++) {
                            temp[i] = Double.parseDouble(t1[i]);
                        }
                        listDouble.addAll(temp);
                        }
                        break;
                        case "size":
                        // invoke size method and print the list size
                        // BTW, list size is not the array size
                        // it is the number of items in the list
                        System.out.println(listDouble.size());
                        break;
                        case "print":
                        // print the list (implement toString in
                        // StringList class
                        //for this to work)
                        // expected format is [item-1,item-2,...,item-n]
                        // review the output testcase file
                        System.out.println(listDouble);
                        break;
                        case "remove":
                        listDouble.remove(Integer.parseInt(tokens[1]));
                        break;
                        case "indexOf":
                        System.out.println(listDouble.indexOf(
                            Double.parseDouble(tokens[1])));
                        break;
                        case "get":
                        System.out.println(listDouble.get(
                            Integer.parseInt(tokens[1])));
                        break;
                        case "contains":
                        System.out.println(listDouble.contains(
                            Double.parseDouble(tokens[1])));
                        break;
                    }
                }
            break;

            case "O":
                List<Student> listStudent = new List<Student>();
                while (stdin.hasNext()) {
                    // read the line
                    String line = stdin.nextLine();
                    // split the line using space
                    String[] tokens = line.split(" ");
                    switch (tokens[0]) {
                        default:
                        break;
                        case "add":
                            listStudent.add(new Student(tokens[1]));
                        break;
                        case "addAll":
                        if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        Student[] temp = new Student[t1.length];
                        for (int i = 0; i < t1.length; i++) {
                            temp[i] = new Student(t1[i]);
                        }
                        listStudent.addAll(temp);
                        }
                        break;
                        case "size":
                        // invoke size method and print the list size
                        // BTW, list size is not the array size
                        // it is the number of items in the list
                        System.out.println(listStudent.size());
                        break;
                        case "print":
                        // print the list (implement toString in List class
                        //for this to work)
                        // expected format is [item-1,item-2,...,item-n]
                        // review the output testcase file
                        System.out.println(listStudent);
                        break;
                        case "remove":
                        listStudent.remove(Integer.parseInt(tokens[1]));
                        break;
                        case "indexOf":
                        System.out.println(
                            listStudent.indexOf(new Student(tokens[1])));
                        break;
                        case "get":
                        System.out.println(
                            listStudent.get(Integer.parseInt(tokens[1])));
                        break;
                        case "contains":
                        Student st = new Student(tokens[1]);
                        System.out.println(listStudent.contains(st));
                        break;
                    }
                }
                break;
            default:
            break;
        }
    }
}

