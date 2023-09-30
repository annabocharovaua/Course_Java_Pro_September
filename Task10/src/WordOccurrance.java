package Task10.src;

public class WordOccurrance {
    private String name;
    private int occurrence;

    public WordOccurrance(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void incrementOccurrance() {
        occurrence++;
    }

    @Override
    public String toString() {
        return "{name: \"" + name + "\", occurrence: " + occurrence + "}";
    }
}
