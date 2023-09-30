package Task10.src;

import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //task1
        Scanner scanner = new Scanner(System.in);
        List<String> stringList = List.of("Apple", "Banana", "Apple", "Cherry", "Mango", "Pineapple", "Apple", "Banana");
        System.out.println("Enter a word: ");
        String target = scanner.nextLine();
        System.out.println("Count of occurrences of a word " + target + " = " + ListUtils.countOccurrance(stringList, target));

        //task2
        Integer[] intArray = {1, 5, 6, 8, 7};
        List<Integer> intList1 = ListUtils.toList1(intArray);
        List<Integer> intList2 = ListUtils.toList2(intArray);
        System.out.println("Convert Array to List1: " + intList1);
        intList1.add(6);
        System.out.println(intList1);
        System.out.println("Convert Array to List2: " + intList2);

        //task3
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(4);
        System.out.println("List to change: " + numbers);

        List<Integer> uniqueNumbers = ListUtils.findUnique(numbers);
        System.out.println("A list with unique values: " + uniqueNumbers);

        //task4**
        List<String> words = List.of("Apple", "Banana", "Apple", "Cherry", "Mango", "Pineapple", "Apple", "Banana");
        ListUtils.calcOccurrance(words);
        ListUtils.calcOccurrance2(words);

        //task4***
        System.out.println(ListUtils.findOccurrence(words));

        scanner.close();

    }
}