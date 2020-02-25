import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Instantiate an ArrayList to hold some object, we chose Integers
        ArrayList<Integer> intList = new ArrayList<Integer>();

        // Adding elements to the list
        intList.add(0);
        intList.add(1);
        intList.add(2);
        intList.add(4);
        intList.add(5);
        intList.add(3); // duplicate 1
        intList.add(3); // duplicate 2
        System.out.println("Expecting true");
        System.out.println("Algorithm output: " + hasDuplicates(intList) + "\n");

        intList.clear();    // Clearing the list

        // Adding elements to the list
        intList.add(0);
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        intList.add(6);
        System.out.println("Expecting false");
        System.out.println("Algorithm output: " + hasDuplicates(intList) + "\n");

        intList.clear();    // Clearing the list

        // Adding elements to the list
        intList.add(0); // duplicate 1
        intList.add(0); // duplicate 2
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        intList.add(6);
        System.out.println("Expecting true");
        System.out.println("Algorithm output: " + hasDuplicates(intList) + "\n");

        intList.clear();    // Clearing the list

        // Adding elements to the list
        intList.add(0); // duplicate 1
        intList.add(1);
        intList.add(2);
        intList.add(3);
        intList.add(4);
        intList.add(5);
        intList.add(0); // duplicate 2
        System.out.println("Expecting true");
        System.out.println("Algorithm output: " + hasDuplicates(intList) + "\n");

        intList.clear();    // Clearing the list

        // Adding elements to the list
        intList.add(0);
        intList.add(1);
        intList.add(2);
        intList.add(3); // duplicate 1
        intList.add(3); // duplicate 2
        intList.add(5);
        intList.add(6);
        System.out.println("Expecting true");
        System.out.println("Algorithm output: " + hasDuplicates(intList) + "\n");

    }

    /**
     * The hasDuplicates method searches a list object for duplicates of each
     * element stored in each index.
     * @param list the list to search for duplicates in
     * @return true if there is a least one duplicate, false otherwise
     */
    public static boolean hasDuplicates(ArrayList<Integer> list){
        boolean hasDuplicates = false;
        for (int i = 0; i < list.size() - 1; i++) {
            int firstElement = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                int secondElement = list.get(j);
                if (firstElement == secondElement){
                    hasDuplicates = true;
                }
            }
        }

        return hasDuplicates;
    }
}
