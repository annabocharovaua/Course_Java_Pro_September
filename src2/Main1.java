public class Main {
    public static boolean isAnagram(String str1, String str2) {

        //The number of characters in anagrams must be the same
        if(str1.length()!= str2.length()){
            return false;
        }

        // Array to count letters
        int[] charCount = new int[26];

        for (char ch : str1.toCharArray()) {
            charCount[ch - 'a']++;  //increment the cell value for the current letter
        }

        for (char ch : str2.toCharArray()) {
            charCount[ch - 'a']--; //// Decrement the number of occurrences of each letter in string str2
        }

        //// If all elements of the charCount array are zero, then the strings are anagrams
        for (int count : charCount) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void printResult(boolean result, String str1, String str2) {
        if (result) {
            System.out.println("Words " + str1 + " and " + str2 + " are anagrams");
        } else {
            System.out.println("Words " + str1 + " and " + str2 + " aren't anagrams");
        }
    }

    public static void main(String[] args) {
        String str1 = "anagram";
        String str2 = "nagaram";

        printResult(isAnagram(str1, str2), str1, str2);

        String str3 = "rat";
        String str4 = "cat";

        printResult(isAnagram(str3, str4), str3, str4);
    }
}