package Task10.src.phone;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Phonebook phonebook = new Phonebook();

        phonebook.add(new Record("Ann", "+3802458792"));
        phonebook.add(new Record("Ann", "+3807558733"));
        phonebook.add(new Record("Olya", "+38066124859"));
        phonebook.add(new Record("Olya", "+38066124857"));
        phonebook.add(new Record("Olya", "+38066124850"));
        phonebook.add(new Record("Jon", "+38099451424"));

        System.out.println("Enter a name to search for the first record found : ");
        String searchName = scanner.nextLine();
        Record foundRecord = phonebook.find(searchName);

        if (foundRecord != null) {
            System.out.println("An entry was found for " + searchName + ": " + foundRecord.getPhoneNumber());
        } else {
            System.out.println("No record found for " + searchName);
        }

        System.out.println("Enter a name to search all records : ");
        String searchNameAll = scanner.nextLine();
        List<Record> foundRecords = phonebook.findAll(searchNameAll);

        if (foundRecords != null) {
            System.out.println("The following entries were found for " + searchNameAll + ":");
            for (Record record : foundRecords) {
                System.out.println("Name : " + record.getName() + ", phoneNumber: " + record.getPhoneNumber());
            }
        } else {
            System.out.println("No record found for " + searchNameAll);
        }

        scanner.close();

    }
}