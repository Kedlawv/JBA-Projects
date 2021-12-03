package contacts.aqq_solution;

public class OrganisationContactFactory implements ContactFactory {
    @Override
    public Contact createContact() {
        OrganisationContactDetailsFactory detailsFactory = new OrganisationContactDetailsFactory();
        return new OrganisationContact(detailsFactory);
    }
}