package arraylist;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        // Add elements to the ArrayList.
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        // Access the elements in the ArrayList.
        System.out.println("The elements in the ArrayList are:");
        for (int i = 0; i < numbers.size(); i++) {
            System.out.println("numbers[" + i + "] = " + numbers.get(i));
        }

        // Remove the element at index 1.
        numbers.remove(1);

        // Replace the element at index 0.
        int replacement = 57;
        numbers.set(0, replacement);

        // Check whether the ArrayList contains a specific element.
        int numberToFind = 100;
        boolean containsElement = numbers.contains(numberToFind);
        System.out.println("Does the ArrayList contain " + numberToFind + "? "
                + containsElement);

        // Iterate through the list using an enhanced for loop.
        int index = 0;
        System.out.println("The elements in the ArrayList are:");
        for (int element : numbers) {
            System.out.println("numbers[" + index + "] = " + element);
            index++;
        }

        // Remove all elements from the ArrayList.
        System.out.println("Clearing the ArrayList.");
        numbers.clear();

        // Check whether the ArrayList is empty.
        boolean isEmpty = numbers.isEmpty();
        System.out.println("Is the ArrayList empty? " + isEmpty);
    }
}
