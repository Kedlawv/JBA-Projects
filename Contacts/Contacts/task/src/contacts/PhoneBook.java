package contacts;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PhoneBook {

    private List<Record> records;

    public PhoneBook() {
        records = new ArrayList<>();
//        records.add(new PersonRecord("Bilbo", "Baggings",
//                "123-456-789", LocalDate.now(), Gender.M));
//        records.add(new OrganizationRecord("Mordor", "Mount Doom Plaza",
//                "666"));
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
