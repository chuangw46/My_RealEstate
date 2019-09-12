package models;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class Property {
    private int id;
    private String type;
    private int num_bed;
    private int num_bath;
    private int num_carpark;
    private Date date_available;
    private Date date_inspection;
    private String description;
    private boolean rent;
    private int price;
    private Address address;
    private Agent postedBy;
    private Set<Client> favoriteBy;
//    private

//    public static void main(String[] args) {
//        String str="2015-03-31";
//        Date date=Date.valueOf(str);//converting string into sql date
//        System.out.println(date);
//    }
    public Property(int id, Address address) {
        this.id = id;
        this.address = address;
        favoriteBy = new HashSet<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNum_bed() {
        return num_bed;
    }

    public void setNum_bed(int num_bed) {
        this.num_bed = num_bed;
    }

    public int getNum_bath() {
        return num_bath;
    }

    public void setNum_bath(int num_bath) {
        this.num_bath = num_bath;
    }

    public int getNum_carpark() {
        return num_carpark;
    }

    public void setNum_carpark(int num_carpark) {
        this.num_carpark = num_carpark;
    }

    public Date getDate_available() {
        return date_available;
    }

    public void setDate_available(Date date_available) {
        this.date_available = date_available;
    }

    public Date getDate_inspection() {
        return date_inspection;
    }

    public void setDate_inspection(Date date_inspection) {
        this.date_inspection = date_inspection;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isRent() {
        return rent;
    }

    public void setRent(boolean rent) {
        this.rent = rent;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Agent getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(Agent postedBy) {
        this.postedBy = postedBy;
    }

    public Set<Client> getFavoriteBy() {
        return favoriteBy;
    }

    public void addClient(Client client) {
        favoriteBy.add(client);
    }

    public void removeClient(Client client){
        favoriteBy.remove(client);
    }
}
