package contacts;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    private List<Record> records;

    public PhoneBook() {
        records = new ArrayList<>();
    }

    public boolean addRecord(Record record) {
        return records.add(record);
    }

    public boolean removeRecord(Record record){
        return records.remove(record);
    }

    public Record removeRecord(int index){
        return records.remove(index);
    }

    public int getNumberOfRecords(){
        return records.size();
    }

    public List<Record> getAllRecords() {
        return records;
    }

    public Record getRecordByIndex(int index){
        return records.get(index);
    }
}
