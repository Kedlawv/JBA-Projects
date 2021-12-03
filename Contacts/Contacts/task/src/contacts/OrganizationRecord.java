package contacts;

import java.util.Objects;

public class OrganizationRecord extends Record{

    private String orgName;
    private String address;

    public OrganizationRecord(){}

    public OrganizationRecord(String orgName, String address, String number) {
        super(number);
        this.orgName = orgName;
        this.address = address;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Organization name: " + orgName + "\n"
                + "Address: " + address + "\n"
                + "Number: " + super.getNumber() + "\n"
                + "Time created: " + super.getCreationDateTime() + "\n"
                + "Time last edit: " + super.getEditDateTime();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrganizationRecord that = (OrganizationRecord) o;
        return orgName.equals(that.orgName) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orgName, address);
    }
}
