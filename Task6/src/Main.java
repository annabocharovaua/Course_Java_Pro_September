package Task6.src;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        workWithTask1();
        workWithTask2();
        workWithTask3();
        workWithTask4();
        workWithTask5();
    }

    public static int findSymbolOccurance(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) count++;
        }
        return count;
    }

    public static int findWordPosition(String source, String target) {
        int index = source.indexOf(target);
        return index >= 0 ? index : -1;
    }

    public static String stringReverse(String str) {
        StringBuffer sb = new StringBuffer(str);
        return sb.reverse().toString();
    }

    public static boolean isPalindrome(String str) {
        String reversed = stringReverse(str);
        return str.equals(reversed);
    }


    public static void workWithTask1() {
        Scanner scanner = new Scanner(System.in);

        System.out.println('\n' + "Task findSymbolOccurance");
        System.out.print("Введіть рядок: ");

        String str = scanner.nextLine();
        System.out.print("Введіть символ: ");

        char symbol = scanner.next().charAt(0);
        int occurrence = findSymbolOccurance(str, symbol);

        System.out.println("Кількість входження символу " + symbol + " = " + occurrence);
        scanner.close();
    }

    public static void workWithTask2() {
        Scanner scanner = new Scanner(System.in);

        System.out.println('\n' + "Task findWordPosition");
        System.out.print("Введіть рядок в якому ви бажаєте шукати входження: ");
        String source = scanner.nextLine();

        System.out.print("Введіть шуканий рядок: ");
        String target = scanner.nextLine();

        int pos = findWordPosition(source, target);

        System.out.println("Номер позиції (індекс) першого елемента підрядка" + source + "у рядку " + "= " + pos);
        scanner.close();
    }

    public static void workWithTask3() {
        Scanner scanner = new Scanner(System.in);

        System.out.println('\n' + "Task stringReverse");
        System.out.print("Введіть рядок, який хоче розвернути: ");
        String str = scanner.nextLine();

        System.out.println("Розвурнутий рядок " + str + " : " + stringReverse(str));
        scanner.close();
    }

    public static void workWithTask4() {
        Scanner scanner = new Scanner(System.in);

        System.out.println('\n' + "Task isPalindrome");
        System.out.print("Введіть рядок, який хочете перевірити: ");
        String str = scanner.nextLine();

        System.out.println("Рядок " + str + " поліндром? - " + isPalindrome(str));
        scanner.close();
    }

    public static void workWithTask5() {
        Scanner scanner = new Scanner(System.in);

        String[] words = {"apple", "orange", "lemon", "banana", "apricot",
                "avocado", "broccoli", "carrot", "cherry", "garlic",
                "grape", "melon", "leak", "kiwi", "mango", "mushroom",
                "nut", "olive", " pea", "peanut", "pear", "pepper",
                "pineapple", "pumpkin", "potato"};

        Random random = new Random();
        int randomIndex = random.nextInt(words.length);

        String currentString = words[randomIndex];

        while (true) {
            System.out.print("Вгадайте слово: ");
            String guess = scanner.nextLine().toLowerCase();

            if (currentString.equals(guess)) {
                System.out.print("Ви вгадали слово!");
                break;
            } else {
                StringBuffer result = new StringBuffer("################");
                int minLength = Math.min(currentString.length(), guess.length());
                for (int i = 0; i < minLength; i++) {
                    if (currentString.charAt(i) == guess.charAt(i)) {
                        result.setCharAt(i, currentString.charAt(i));
                    }
                }
                System.out.println("Спробуйте ще раз: " + result);
            }

        }


    }


}