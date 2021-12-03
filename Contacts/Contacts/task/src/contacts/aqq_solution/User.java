package contacts.aqq_solution;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<Contact> contactList = new ArrayList<>();

    public List<Contact> getContactList() {
        return new ArrayList<>(contactList);
    }

    protected void addContact(Contact newContact) {
        this.contactList.add(newContact);
    }

    protected void removeContactByIndex(int index) {
        this.contactList.remove(index);
    }

    protected Integer contactListSize() {
        return this.contactList.size();
    }

    protected Contact findContactByIndex(Integer index) {
        return this.contactList.get(index);
    }
}