package Task11.src;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileNavigator navigator = new FileNavigator("/path/to/file");

        FileData file1 = new FileData("file1.txt", 100, "/path/to/file");
        FileData file2 = new FileData("file2.txt", 200, "/path/to/file/directory1");
        FileData file3 = new FileData("file3.txt", 600, "/path/to/another");
        FileData file4 = new FileData("file4.txt", 150, "/path/to/file/directory");
        FileData file5 = new FileData("file5.txt", 700, "/path/to/file/directory");

        navigator.add(file1);
        navigator.add(file2);
        navigator.add(file3);
        navigator.add(file4);
        navigator.add(file5);

        System.out.println("Find files at /path/to/file:");
        List<FileData> filesAtPath = navigator.find("/path/to/file");
        for (FileData file : filesAtPath) {
            System.out.println("File: " + file.getName() + ", size: " + file.getSize());
        }

        System.out.println("Find files at /path/to/file/directory :");
        List<FileData> filesAtPath2 = navigator.find("/path/to/file/directory");
        for (FileData file : filesAtPath2) {
            System.out.println("File: " + file.getName() + ", size: " + file.getSize());
        }

        System.out.println("Filtered files by max size 400:");
        List<FileData> filteredFiles = navigator.filterBySize(400);
        for (FileData file : filteredFiles) {
            System.out.println("File: " + file.getName() + ", size: " + file.getSize());
        }

        System.out.println("Sorted files by size:");
        List<FileData> sortedFiles = navigator.sortBySize();
        for (FileData file : sortedFiles) {
            System.out.println("File: " + file.getName() + ", size: " + file.getSize());
        }

        navigator.remove("/path/to/file");
        System.out.println("Files after removal:");
        Map<String, List<FileData>> filesMap = navigator.getFileMap();
        for (List<FileData> files : filesMap.values()) {
            for (FileData file : files) {
                System.out.println("File: " + file.getName() + ", Size: " + file.getSize());
            }
        }

    }
}


