import java.io.BufferedInputStream;
import java.util.Scanner;
//A Class is implemented for Student details
class Student {
	private String name;

	public Student(String name) {//A constructor used to initialize the instance variables
		this.name = name;
	}

	public String getName() {//Getter method which returns the value of instance variable
		return this.name;
	}

	@Override
	public boolean equals(Object other) { //This method is to check if two students names are equal or not
		if (!(other instanceof Student)) {
			return false;
		}

		Student that = (Student) other;
		return this.getName().equals(that.getName());
	}

	public String toString() {
		return this.name;
	}
}

public class Solution {

	public static void executeListInteger(Scanner stdin) {
		List<Integer> l = new List();
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "add":
                    if (tokens.length == 2){
                        String[] t = tokens[1].split(",");
                        if (t.length == 1) {
                            l.add(Integer.parseInt(tokens[1]));
                        }
                    }
                break;
                case "size":
                    System.out.println(l.size());
                break;
                case "print":
                    System.out.println(l);
                break;
                case "remove":
                    if (tokens.length == 2) {
                        l.remove(Integer.parseInt(tokens[1]));
                    }
                break;
                case "indexOf":
                    if (tokens.length == 2) {
                        System.out.println(l.indexOf(Integer.parseInt(tokens[1])));
                    }
                break;
                case "get":
                    if (tokens.length == 2) {
                        System.out.println(l.get(Integer.parseInt(tokens[1])));
                    }
                break;
                case "contains":
                    if (tokens.length == 2) {
                        System.out.println(l.contains(Integer.parseInt(tokens[1])));
                    }
                break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        Integer[] temp = new Integer[t1.length];
                        for(int i = 0; i < temp.length; i++) {
                            temp[i]=Integer.parseInt(t1[i]);
                        }
                        l.addAll(temp);
                    }
                break;
                case "removeAll":
                    if (tokens.length == 2) {
                        String[] t2 = tokens[1].split(",");
                        Integer[] a = new Integer[t2.length];
                        for(int i = 0; i < t2.length; i++)
                            a[i] = Integer.parseInt(t2[i]);
                        l.removeAll(a);
                    }
                break;
                case "subList": {
                    if (tokens.length != 2) break;
                    String[] arrstring3 = tokens[1].split(",");
                    List object = l.subList(Integer.parseInt(arrstring3[0]), Integer.parseInt(arrstring3[1]));
                    if (object != null) 
                        System.out.println(object);
                    break;
                }
                case "equals":
                    if (tokens.length == 2) {
                        String[] lt = tokens[1].split(",");
                        List l2 = new List();
                        for (int k = 0; k < lt.length; k++ ) {
                            l2.add(Integer.parseInt(lt[k]));
                        }
                        System.out.println(l.equals(l2));
                    }
                break;
                case "clear":
                    l.clear();
                break;
                default:
                break;
            }
        }	
	}
	public static void executeListDouble(Scanner stdin) {
		List<Double> l = new List();
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "add":
                    if (tokens.length == 2){
                        String[] t = tokens[1].split(",");
                        if (t.length == 1) {
                            l.add(Double.parseDouble(tokens[1]));
                        }
                    }
                break;
                case "size":
                    System.out.println(l.size());
                break;
                case "print":
                    System.out.println(l);
                break;
                case "remove":
                    if (tokens.length == 2) {
                        l.remove(Integer.parseInt(tokens[1]));
                    }
                break;
                case "indexOf":
                    if (tokens.length == 2) {
                        System.out.println(l.indexOf(Double.parseDouble(tokens[1])));
                    }
                break;
                case "get":
                    if (tokens.length == 2) {
                        System.out.println(l.get(Integer.parseInt(tokens[1])));
                    }
                break;
                case "contains":
                    if (tokens.length == 2) {
                        System.out.println(l.contains(Double.parseDouble(tokens[1])));
                    }
                break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        Double[] temp = new Double[t1.length];
                        for(int i = 0; i < temp.length; i++) {
                            temp[i] = Double.parseDouble(t1[i]);
                        }
                        l.addAll(temp);
                    }
                break;
                case "removeAll":
                    if (tokens.length == 2) {
                        String[] t2 = tokens[1].split(",");
                        Double[] a = new Double[t2.length];
                        for(int i = 0; i < t2.length; i++)
                            a[i] = Double.parseDouble(t2[i]);
                        l.removeAll(a);
                    }
                break;
                case "subList": {
                    if (tokens.length != 2) break;
                    String[] arrstring3 = tokens[1].split(",");
                    List object = l.subList(Integer.parseInt(arrstring3[0]), Integer.parseInt(arrstring3[1]));
                    if (object != null) 
                        System.out.println(object);
                    break;
                }
                case "equals":
                    if (tokens.length == 2) {
                        String[] lt = tokens[1].split(",");
                        List l2 = new List();
                        for (int k = 0; k < lt.length; k++ ) {
                            l2.add(Double.parseDouble(lt[k]));
                        }
                        System.out.println(l.equals(l2));
                    }
                break;
                case "clear":
                    l.clear();
                break;
                default:
                break;
            }
        }
	}
    public static void executeListFloat(Scanner stdin) {
		List<Float> l = new List();
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "add":
                    if (tokens.length == 2){
                        String[] t = tokens[1].split(",");
                        if (t.length == 1) {
                            l.add(Float.parseFloat(tokens[1]));
                        }
                    }
                break;
                case "size":
                    System.out.println(l.size());
                break;
                case "print":
                    System.out.println(l);
                break;
                case "remove":
                    if (tokens.length == 2) {
                        l.remove(Integer.parseInt(tokens[1]));
                    }
                break;
                case "indexOf":
                    if (tokens.length == 2) {
                        System.out.println(l.indexOf(Float.parseFloat(tokens[1])));
                    }
                break;
                case "get":
                    if (tokens.length == 2) {
                        System.out.println(l.get(Integer.parseInt(tokens[1])));
                    }
                break;
                case "contains":
                    if (tokens.length == 2) {
                        System.out.println(l.contains(Float.parseFloat(tokens[1])));
                    }
                break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        Float[] temp = new Float[t1.length];
                        for(int i = 0; i < temp.length; i++) {
                            temp[i] = Float.parseFloat(t1[i]);
                        }
                        l.addAll(temp);
                    }
                break;
                case "removeAll":
                    if (tokens.length == 2) {
                        String[] t2 = tokens[1].split(",");
                        Float[] a = new Float[t2.length];
                        for(int i = 0; i < t2.length; i++)
                            a[i] = Float.parseFloat(t2[i]);
                        l.removeAll(a);
                    }
                break;
                case "subList": {
                    if (tokens.length != 2) break;
                    String[] arrstring3 = tokens[1].split(",");
                    List object = l.subList(Integer.parseInt(arrstring3[0]), Integer.parseInt(arrstring3[1]));
                    if (object != null) 
                        System.out.println(object);
                    break;
                }
                case "equals":
                    if (tokens.length == 2) {
                        String[] lt = tokens[1].split(",");
                        List l2 = new List();
                        for (int k = 0; k < lt.length; k++ ) {
                            l2.add(Float.parseFloat(lt[k]));
                        }
                        System.out.println(l.equals(l2));
                    }
                break;
                case "clear":
                    l.clear();
                break;
                default:
                break;
            }
        }	
	}

    public static void executeListString(Scanner stdin) {
		List<String> l = new List();
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "add":
                    if (tokens.length == 2){
                        String[] t = tokens[1].split(",");
                        if (t.length == 1) {
                            l.add(tokens[1]);
                        }
                    }
                break;
                case "size":
                    System.out.println(l.size());
                break;
                case "print":
                    System.out.println(l);
                break;
                case "remove":
                    if (tokens.length == 2) {
                        l.remove(Integer.parseInt(tokens[1]));
                    }
                break;
                case "indexOf":
                    if (tokens.length == 2) {
                        System.out.println(l.indexOf((tokens[1])));
                    }
                break;
                case "get":
                    if (tokens.length == 2) {
                        System.out.println(l.get(Integer.parseInt(tokens[1])));
                    }
                break;
                case "contains":
                    if (tokens.length == 2) {
                        System.out.println(l.contains((tokens[1])));
                    }
                break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        l.addAll(t1);
                    }
                break;
                case "removeAll":
                    if (tokens.length == 2) {
                        String[] t2 = tokens[1].split(",");
                        l.removeAll(t2);
                    }
                break;
                case "subList": {
                    if (tokens.length != 2) break;
                    String[] arrstring3 = tokens[1].split(",");
                    List object = l.subList(Integer.parseInt(arrstring3[0]), Integer.parseInt(arrstring3[1]));
                    if (object != null) 
                        System.out.println(object);
                    break;
                }
                case "equals":
                    if (tokens.length == 2) {
                        String[] lt = tokens[1].split(",");
                        List l2 = new List();
                        for (int k = 0; k < lt.length; k++ ) {
                            l2.add((lt[k]));
                        }
                        System.out.println(l.equals(l2));
                    }
                break;
                case "clear":
                    l.clear();
                break;
                default:
                break;
            }
        }	
	}

	public static void executeListStudent(Scanner stdin) {
		List<Student> l = new List();
        while (stdin.hasNext()) {
            // read the line
            String line = stdin.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
                case "add":
                    if (tokens.length == 2){
                        String[] t = tokens[1].split(",");
                        if (t.length == 1) {
                            l.add(new Student(tokens[1]));
                        }
                    }
                break;
                case "size":
                    System.out.println(l.size());
                break;
                case "print":
                    System.out.println(l);
                break;
                case "remove":
                    if (tokens.length == 2) {
                        l.remove(Integer.parseInt(tokens[1]));
                    }
                break;
                case "indexOf":
                    if (tokens.length == 2) {
                        System.out.println(l.indexOf(new Student(tokens[1])));
                    }
                break;
                case "get":
                    if (tokens.length == 2) {
                        System.out.println(l.get(Integer.parseInt(tokens[1])));
                    }
                break;
                case "contains":
                    if (tokens.length == 2) {
                        System.out.println(l.contains(new Student(tokens[1])));
                    }
                break;
                case "addAll":
                    if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
                        Student[] students = new Student[t1.length];
                        for (int i = 0; i < t1.length ;i++) {
                        	students[i] = new Student(t1[i]);	
                        }
                        l.addAll(students);
                    }
                break;
                case "removeAll":
                    if (tokens.length == 2) {
                        String[] t1 = tokens[1].split(",");
						Student[] students = new Student[t1.length];
						for (int i = 0; i < t1.length ;i++) {
							students[i] = new Student(t1[i]);	
						}
                        l.removeAll(students);
                    }
                break;
                case "subList": {
                    if (tokens.length != 2) break;
                    String[] arrstring3 = tokens[1].split(",");
                    List object = l.subList(Integer.parseInt(arrstring3[0]), Integer.parseInt(arrstring3[1]));
                    if (object != null) 
                        System.out.println(object);
                    break;
                }
                case "equals":
                    if (tokens.length == 2) {
                        String[] lt = tokens[1].split(",");
                        List l2 = new List();
                        for (int k = 0; k < lt.length; k++ ) {
                            l2.add((lt[k]));
                        }
                        System.out.println(l.equals(l2));
                    }
                break;
                case "clear":
                    l.clear();
                break;
                default:
                break;
            }
        }	
	}

	public static void main(String[] args) {
        // create an object of the list to invoke methods on it
        Scanner stdin = new Scanner(new BufferedInputStream(System.in));
        String objectType = stdin.nextLine();

        switch(objectType) {
        	case "S"://This case will be executed for String type list
        		executeListString(stdin);
	        break;

	        case "I"://This case will be executed for Integer type list
	        	executeListInteger(stdin);
	        break;

	        case "F"://This case will be executed for Float type list
	            executeListFloat(stdin);
	        break;

	        case "C"://This case will be executed for Character type list
        		executeListString(stdin);
	        break;

	        case "D"://This case will be executed for Double type list
        		executeListDouble(stdin);
	        break;

	        case "O"://This case will be executed for Student type list i.e to store List of Student Objects
	        	executeListStudent(stdin);
	        	break;
	        default:
	        break;
    	}
	}
}

