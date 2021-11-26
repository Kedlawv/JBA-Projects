package contacts;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    List<Record> records;

    public PhoneBook() {
        records = new ArrayList<>();
    }

    public void addRecord(Record record) {
        records.add(record);
    }

    public List<Record> getAllRecords() {
        return records;
    }
}
