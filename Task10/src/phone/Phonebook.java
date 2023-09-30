package Task10.src.phone;

import java.util.ArrayList;
import java.util.List;

public class Phonebook {
    private List<Record> records;

    public Phonebook() {
        records = new ArrayList<>();
    }

    public void add(Record record) {
        records.add(record);
    }

    public Record find(String name) {
        for (Record record : records) {
            if (record.getName().equalsIgnoreCase(name)) {
                return record;
            }
        }
        return null;
    }

    public List<Record> findAll(String name) {
        List<Record> foundRecords = new ArrayList<>();
        for (Record record : records) {
            if (record.getName().equalsIgnoreCase(name)) {
                foundRecords.add(record);
            }
        }

        if (foundRecords.isEmpty()) {
            return null;
        } else {
            return foundRecords;
        }
    }
}
