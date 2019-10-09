//package service;
//
//import dataSourceLayer.mappers.addressMapper.AddressMapper;
//import dataSourceLayer.mappers.addressMapper.AddressMapperI;
//import dataSourceLayer.mappers.favoriteList.FavoriteListMapper;
//import dataSourceLayer.mappers.favoriteList.FavoriteListMapperI;
//import dataSourceLayer.mappers.propertyMapper.PropertyMapper;
//import dataSourceLayer.mappers.propertyMapper.PropertyMapperI;
//import models.Address;
//import models.Property;
//
//import java.sql.Date;
//import java.util.List;
//
///**
// * @author Chuang Wang
// * @studentID 791793
// * @institution University of Melbourne
// */
//
///**
// * contains core functionality of managing properties published by agents
// */
//public class PropertyManagement {
//    private static AddressMapper addressMapper = new AddressMapper();
//    private static PropertyMapper propertyMapper = new PropertyMapper();
//    private static FavoriteListMapperI favoriteListMapper = new FavoriteListMapper();
//
//    /**
//     * agents publish new properties
//     */
//    public static boolean publishProperty(String type, String num_bed, String num_bath, String num_carpark, String date_available, String date_inspection, String description, String street, String city, String state, int postal_code, String country, String rent_or_buy, String price, String agent_id) {
//
//        // create an address object
//        Address address = new Address(street, city, state, postal_code, country);
//
//        // store the address to db and get the unique id of the address
//        int address_id = addressMapper.createAddress(address);
//
//        // store the property into db containing the address id
//        Property property = new Property(type, Integer.parseInt(num_bed), Integer.parseInt(num_bath),
//                Integer.parseInt(num_carpark),
//                Date.valueOf(date_available), Date.valueOf(date_inspection), description,
//                address_id, rent_or_buy, Integer.parseInt(price), Integer.parseInt(agent_id));
//        return propertyMapper.createProperty(property);
//    }
//
//    /**
//     * to retrieve a list of properties published by a specific agent
//     * @param agentID
//     * @return a list of properties objects
//     */
//    public static List<Property> viewMyPropertyList(int agentID){
////        System.out.println(propertyMapper.searchByAgentID(agentID).size());
//        return propertyMapper.searchByAgentID(agentID);
//    }
//
//    /**
//     * to retrieve a specific property
//     * @param property_id
//     * @return a property object
//     */
//    public static Property viewSpecificProperty(int property_id) {
//        return propertyMapper.searchByPropertyID(property_id);
//    }
//
//
//    /**
//     * to update a property's details
//     * @return updated property object
//     */
//    public static Property updateProperty(Property old_property, String type, String num_bed,
//                                   String num_bath, String num_carpark, String date_available,
//                                          String date_inspection, String description, String street,
//                                          String city, String state, int postal_code, String country,
//                                          String rent_or_buy, String price) {
//        old_property.setType(type);
//        old_property.setNum_bed(Integer.parseInt(num_bed));
//        old_property.setNum_bath(Integer.parseInt(num_bath));
//        old_property.setNum_carpark(Integer.parseInt(num_carpark));
//        old_property.setDate_available(Date.valueOf(date_available));
//        old_property.setDate_inspection(Date.valueOf(date_inspection));
//        old_property.setDescription(description);
//        old_property.retrieveTheAddressObj().setStreet(street);
//        old_property.retrieveTheAddressObj().setCity(city);
//        old_property.retrieveTheAddressObj().setState(state);
//        old_property.retrieveTheAddressObj().setPostal_code(postal_code);
//        old_property.retrieveTheAddressObj().setCountry(country);
//        old_property.setRent_or_buy(rent_or_buy);
//        old_property.setPrice(Integer.parseInt(price));
//        // update the property in db
//        if (propertyMapper.updateProperty(old_property)){
//            return propertyMapper.searchByPropertyID(old_property.getId());
//        }
//        return null;
//
//    }
//
//    /**
//     * to delete a published property
//     * @param agent_id
//     * @param property_id
//     * @param address_id
//     * @return boolean value: delete operation success or fail
//     */
//    public static boolean deleteProperty(int agent_id, int property_id, int address_id) {
//        boolean b1 = false;
//        boolean b2 = false;
//        boolean b3 = false;
//        // 1. delete property from association table(favorite list) - AST stands for association
//        // table
//        b1 = favoriteListMapper.deleteRowsByPropertyID(property_id);
//
//        // 2. delete property from property table - PT stands for property table
//        b2 = propertyMapper.deleteProperty(agent_id, property_id);
//
//        // 3. delete from address table
//        b3 = addressMapper.deleteAddressByID(address_id);
//
//
//        return b1 && b2 && b3;
//    }
//}
