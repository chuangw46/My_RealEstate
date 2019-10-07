package model;

import java.util.Objects;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */

/**
 * to construct object based on information retrieved from address table in database
 */

public class Address {
    private int id;
    private String street;
    private String city;
    private String state;
    private int postal_code;
    private String country;

//    public Address() {
//    }

    // the constructor without id -- for INSERT only
    public Address(String street, String city, String state, int postal_code, String country) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.postal_code = postal_code;
        this.country = country;
    }

    // the constructor with id -- for SELECT, UPDATE
    public Address(int id, String street, String city, String state, int postal_code, String country) {
        this.id = id;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postal_code = postal_code;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(int postal_code) {
        this.postal_code = postal_code;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postal_code=" + postal_code +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Address address = (Address) o;
        return id == address.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
