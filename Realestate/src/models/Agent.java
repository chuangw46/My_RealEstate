package models;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class Agent extends User{
    private AgencyCompany company;
    private String phone;
    private String bio;

    public Agent(int id, String name, String email, String password) {
        super(id, name, email, password);
    }

    public AgencyCompany getCompany() {
        return company;
    }

    public void setCompany(AgencyCompany company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
