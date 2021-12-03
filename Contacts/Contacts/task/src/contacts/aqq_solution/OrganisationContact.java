package contacts.aqq_solution;

import java.time.LocalDateTime;
import java.util.Scanner;

public class OrganisationContact extends Contact {
    private String organisationName;
    private String address;

    public OrganisationContact(OrganisationContactDetailsFactory detailsFactory) {
        this.organisationName = detailsFactory.createOrganisationName();
        this.address = detailsFactory.createAddress();
        super.number = detailsFactory.createNumber();
        super.createdAt = detailsFactory.setCreatedAt();
        super.lastEdit = super.createdAt;
    }

    private String addressToString() {
        return (this.address.equals("") ? "[no data]" : this.address);
    }

    @Override
    public String printContactInfo() {
        return "Organization name: " + this.organisationName +
                "\nAddress: " + addressToString() +
                super.toString();
    }

    @Override
    public void editContact() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a field (name, address, number)");

        switch (scanner.nextLine().toLowerCase()) {
            case "name":
                this.editName(scanner);
                break;
            case "address":
                this.editAddress(scanner);
                break;
            case "number":
                super.editNumber();
                break;
            default:
                System.out.println("invalid input");
        }
        super.lastEdit = LocalDateTime.now();
        scanner.close();
    }

    private void editName(Scanner sc) {
        System.out.println("Enter the organization name:");
        this.organisationName = sc.nextLine();
        System.out.println("The record updated!");
    }

    private void editAddress(Scanner sc) {
        System.out.println("Enter the address:");
        this.address = sc.nextLine();
        System.out.println("The record updated!");
    }


}