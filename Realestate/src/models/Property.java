package models;

import dataSourceLayer.mappers.addressMapper.AddressMapper;
import dataSourceLayer.mappers.addressMapper.AddressMapperI;

import java.sql.Date;
import java.util.Objects;
import java.util.Set;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */

/**
 * to construct object based on information retrieved from properties table in database
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
    private int address_id;
    private String rent_or_buy;
    private int price;
    private int agent_id;
    private Set<Client> favoriteBy;

    public Property() {
    }

    public Property(int id) {
        this.id = id;
    }

    public Property(int address_id, int agent_id) {
        this.address_id = address_id;
        this.agent_id = agent_id;
    }

    // the constructor without id -- for INSERT only
    public Property(String type, int num_bed, int num_bath, int num_carpark, Date date_available, Date date_inspection, String description, int address_id, String rent_or_buy, int price, int agent_id) {
        this.type = type;
        this.num_bed = num_bed;
        this.num_bath = num_bath;
        this.num_carpark = num_carpark;
        this.date_available = date_available;
        this.date_inspection = date_inspection;
        this.description = description;
        this.address_id = address_id;
        this.rent_or_buy = rent_or_buy;
        this.price = price;
        this.agent_id = agent_id;
    }

    // the constructor with id -- for SELECT only
    public Property(int id, String type, int num_bed, int num_bath, int num_carpark, Date date_available, Date date_inspection, String description, int address_id, String rent_or_buy, int price, int agent_id) {
        this.id = id;
        this.type = type;
        this.num_bed = num_bed;
        this.num_bath = num_bath;
        this.num_carpark = num_carpark;
        this.date_available = date_available;
        this.date_inspection = date_inspection;
        this.description = description;
        this.address_id = address_id;
        this.rent_or_buy = rent_or_buy;
        this.price = price;
        this.agent_id = agent_id;
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

    public String getRent_or_buy() {
        return rent_or_buy;
    }

    public void setRent_or_buy(String rent_or_buy) {
        this.rent_or_buy = rent_or_buy;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
    }

    public int getAgent_id() {
        return agent_id;
    }

    public void setAgent_id(int agent_id) {
        this.agent_id = agent_id;
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

    public String retrieveTheAddressString() {
        AddressMapperI am = new AddressMapper();
        Address a = am.getAddressByID(getAddress_id());
        return a.getStreet() + ", " + a.getCity() + " " + a.getState() + " " + a.getPostal_code() + " " + a.getCountry();
    }

    public Address retrieveTheAddressObj(){
        return new AddressMapper().getAddressByID(getAddress_id());
    }


    @Override
    public String toString() {
        return "Property{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", num_bed=" + num_bed +
                ", num_bath=" + num_bath +
                ", num_carpark=" + num_carpark +
                ", date_available=" + date_available +
                ", date_inspection=" + date_inspection +
                ", description='" + description + '\'' +
                ", address_id=" + address_id +
                ", rent_or_buy='" + rent_or_buy + '\'' +
                ", price=" + price +
                ", agent_id=" + agent_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Property property = (Property) o;
        return id == property.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
