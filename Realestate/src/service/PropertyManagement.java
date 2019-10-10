package service;

import dataSourceLayer.mappers.addressMapper.AddressMapper;
import dataSourceLayer.mappers.favoriteList.FavoriteListMapper;
import dataSourceLayer.mappers.propertyMapper.PropertyMapper;
import dataSourceLayer.unitOfWork.UnitOfWork;
import models.Address;
import models.Property;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */

/**
 * contains core functionality of managing properties published by agents
 */
public class PropertyManagement {
    private static AddressMapper addressMapper = AddressMapper.getInstance();
    private static PropertyMapper propertyMapper = PropertyMapper.getInstance();
    private static FavoriteListMapper favoriteListMapper = FavoriteListMapper.getInstance();

    /**
     * agents publish new properties
     */
    public static void publishProperty(Property property, Address address) throws SQLException {
        UnitOfWork.newCurrent();
        // create an address object
//        Address address = new Address(street, city, state, postal_code, country);

        // store the address to db and get the unique id of the address
        int address_id = addressMapper.createAndGetID(address);

        // store the property into db containing the address id
        property.setAddress_id(address_id);
        //TODO: junhan
//        Property property = new Property(type, Integer.parseInt(num_bed), Integer.parseInt(num_bath),
//                Integer.parseInt(num_carpark), Date.valueOf(date_available), Date.valueOf(date_inspection), description,
//                address_id, rent_or_buy, Integer.parseInt(price), Integer.parseInt(agent_id));

        // use unit of work to insert a property to db
        UnitOfWork.getCurrent().registerNew(property);
        UnitOfWork.getCurrent().commit();
    }

    /**
     * to retrieve a list of properties published by a specific agent
     * @param agentID
     * @return a list of properties objects
     */
    public static List<Property> viewMyPropertyList(int agentID){
//        System.out.println(propertyMapper.searchByAgentID(agentID).size());
        return propertyMapper.searchByAgentID(agentID);
    }

    public static List<Property> searchPropertyByFilters(String rent_or_buy, String property_type, int minBed,
                                                         int maxBed, int minPrice, int maxPrice, int postCode) {
        return propertyMapper.searchByAllFilters(rent_or_buy, property_type, minBed, maxBed, minPrice, maxPrice,
                postCode);
    }

    /**
     * to retrieve a specific property
     * @param property_id
     * @return a property object
     */
    public static Property viewSpecificProperty(int property_id) {
        return propertyMapper.searchByPropertyID(property_id);
    }


    /**
     * to update a property's details
     * @return updated property object
     */
    public static void updateProperty(Property new_property) throws SQLException {
        // update the property in db
        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerDirty(new_property);
        UnitOfWork.getCurrent().commit();;
    }


    /**
     * to delete a published property
     * @param property_id
     * @throws SQLException
     */
    public static void deleteProperty(int property_id) throws SQLException {
        Property property = propertyMapper.searchByPropertyID(property_id);
        UnitOfWork.newCurrent();
        // 1. delete property from association table(favorite list) - AST stands for association
        // table
        favoriteListMapper.deleteRowsByPropertyID(property_id);

        // 2. delete property from property table - PT stands for property table
        UnitOfWork.getCurrent().registerDeleted(property);

        // 3. delete from address table
        UnitOfWork.getCurrent().registerDeleted(property.retrieveTheAddressObj());

        UnitOfWork.getCurrent().commit();
    }
}
