package models;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */

/**
 * to construct a company object, but it will be a small object. As such, we used the embedded
 * value pattern
 */

public class AgencyCompany {
    private String name;
    private String address;
    private String website;

    public AgencyCompany() {
    }

    public AgencyCompany(String name, String address, String website) {
        this.name = name;
        this.address = address;
        this.website = website;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
