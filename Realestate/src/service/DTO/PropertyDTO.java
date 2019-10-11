package service.DTO;

import com.google.gson.Gson;

import java.sql.Date;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class PropertyDTO {
    private int property_id;
    private String type;
    private int num_bed;
    private int num_bath;
    private int num_carpark;
    private Date date_available;
    private Date date_inspection;
    private String description;
    private String rent_or_buy;
    private int price;

    private int address_id;
    private String street;
    private String city;
    private String state;
    private int postal_code;
    private String country;

    private AgentDTO agentDTO;

//    public PropertyDTO(int property_id, String type, int num_bed, int num_bath, int num_carpark, Date date_available, Date date_inspection, String description, int address_id, String street, String city, String state, int postal_code, String country, String rent_or_buy, int price, AgentDTO agentDTO) {
//        this.property_id = property_id;
//        this.type = type;
//        this.num_bed = num_bed;
//        this.num_bath = num_bath;
//        this.num_carpark = num_carpark;
//        this.date_available = date_available;
//        this.date_inspection = date_inspection;
//        this.description = description;
//        this.address_id = address_id;
//        this.street = street;
//        this.city = city;
//        this.state = state;
//        this.postal_code = postal_code;
//        this.country = country;
//        this.rent_or_buy = rent_or_buy;
//        this.price = price;
//        this.agentDTO = agentDTO;
//    }

    public int getProperty_id() {
        return property_id;
    }

    public void setProperty_id(int property_id) {
        this.property_id = property_id;
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

    public int getAddress_id() {
        return address_id;
    }

    public void setAddress_id(int address_id) {
        this.address_id = address_id;
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

    public AgentDTO getAgentDTO() {
        return agentDTO;
    }

    public void setAgentDTO(AgentDTO agentDTO) {
        this.agentDTO = agentDTO;
    }

    public static String serialize(PropertyDTO propertyDTO) {
        Gson gson = new Gson();
        return gson.toJson(propertyDTO);
    }

    public static PropertyDTO deserialize(String propertyDTOStr){
        Gson gson = new Gson();
        return gson.fromJson(propertyDTOStr, PropertyDTO.class);
    }


}
