package contacts.aqq_solution;

public class PersonalContactFactory implements ContactFactory {

    @Override
    public Contact createContact() {
        PersonalContactDetailsFactory detailsFactory = new PersonalContactDetailsFactory();
        return new PersonalContact(detailsFactory);
    }
}