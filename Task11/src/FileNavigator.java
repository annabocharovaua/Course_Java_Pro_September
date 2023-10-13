package Task11.src;

import java.sql.Array;
import java.util.*;

public class FileNavigator {
    private Map<String, List<FileData>> fileMap;
    private String pathToFiles;

    public FileNavigator(String pathToFiles) {
        this.pathToFiles = pathToFiles;
        fileMap = new HashMap<>();
    }

    public void add(FileData file) {
        if (!file.getPath().startsWith(pathToFiles)) {
            System.out.println("Помилка: Шлях до файлу" + file.getName() + " не співпадає з базовим шляхом");
            return;
        }

        String path = file.getPath();
        fileMap.computeIfAbsent(path, k -> new ArrayList<>()).add(file);
    }

    public List<FileData> find(String path) {
        return fileMap.getOrDefault(path, new ArrayList<>());
    }

    public List<FileData> filterBySize(Integer maxSize) {
        List<FileData> result = new ArrayList<>();
        for (List<FileData> files : fileMap.values()) {
            for (FileData file : files) {
                if (file.getSize() <= maxSize) {
                    result.add(file);
                }
            }
        }
        return result;
    }

    public void remove(String path) {
        fileMap.remove(path);
    }

    public Map<String, List<FileData>> getFileMap() {
        return fileMap;
    }

    public List<FileData> sortBySize() {
        List<FileData> allFiles = new ArrayList<>();
        for (List<FileData> files : fileMap.values()) {
            for (FileData file : files) {
                allFiles.add(file);
            }
        }
        allFiles.sort(Comparator.comparing(FileData::getSize));
        return allFiles;
    }

}
