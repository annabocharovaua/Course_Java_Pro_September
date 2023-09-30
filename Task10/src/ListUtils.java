package Task10.src;

import java.util.*;

public class ListUtils {
    public static int countOccurrance(List<String> stringList, String target) {
        int count = 0;
        for (String str : stringList) {
            if (str.equals(target)) count++;
        }
        return count;
    }

    public static List<Integer> toList1(Integer[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }

    public static List<Integer> toList2(Integer[] array) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, array);
        return list;
    }

    public static List<Integer> findUnique(List<Integer> inputList) {
        List<Integer> uniqueList = new ArrayList<>();
        for (Integer number : inputList) {
            if (!uniqueList.contains(number)) {
                uniqueList.add(number);
            }
        }
        return uniqueList;
    }

    public static void calcOccurrance(List<String> words) {
        List<String> uniqueWords = new ArrayList<>();
        List<Integer> wordCounts = new ArrayList<>();

        for (String word : words) {
            if (uniqueWords.contains(word)) {
                int index = uniqueWords.indexOf(word);
                int count = wordCounts.get(index);
                wordCounts.set(index, count+1);
            } else {
                uniqueWords.add(word);
                wordCounts.add(1);
            }
        }

        for (int i = 0; i < uniqueWords.size(); i++) {
            System.out.println("Word " + uniqueWords.get(i) + " count = " + wordCounts.get(i));
        }
    }

    public static void calcOccurrance2(List<String> words) {
        Map<String, Integer> wordCount = new HashMap<>();

        for (String word : words) {
            if (wordCount.containsKey(word)) {
                int count = wordCount.get(word);
                wordCount.put(word, count+1);
            } else {
                wordCount.put(word, 1);
            }
        }

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            System.out.println("Word " + entry.getKey() + " count =  " + entry.getValue());
        }

    }

    public static List<WordOccurrance> findOccurrence(List<String> words){
        List<WordOccurrance> ocurrances  = new ArrayList<>();
        for(String word : words){
            boolean flag = false;
            for(WordOccurrance occurrance : ocurrances){
                if(occurrance.getName().equals(word)){
                    occurrance.incrementOccurrance();
                    flag = true;
                    break;
                }
            }
            if(!flag){
                ocurrances.add(new WordOccurrance(word));
            }
        }
        return ocurrances;
    }


}
