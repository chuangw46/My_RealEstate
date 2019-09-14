package domainLogic;

import dataSourceLayer.mappers.addressMapper.AddressMapper;
import dataSourceLayer.mappers.addressMapper.AddressMapperInterface;
import dataSourceLayer.mappers.propertyMapper.PropertyMapper;
import dataSourceLayer.mappers.propertyMapper.PropertyMapperInterface;
import models.Address;
import models.Property;

import java.sql.Date;
import java.util.List;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class PropertyManagement {
    private static AddressMapperInterface addressMapper = new AddressMapper();
    private static PropertyMapperInterface propertyMapper = new PropertyMapper();

    public static boolean publishProperty(String type, String num_bed, String num_bath, String num_carpark, String date_available, String date_inspection, String description, String street, String city, String state, int postal_code, String country, String rent_or_buy, String price, String agent_id) {
        // create an address object
        Address address = new Address(street, city, state, postal_code, country);

        // store the address to db and get the unique id of the address
        int address_id = addressMapper.createAddress(address);

        // store the property into db containing the address id
        Property property = new Property(type, Integer.parseInt(num_bed), Integer.parseInt(num_bath),
                Integer.parseInt(num_carpark),
                Date.valueOf(date_available), Date.valueOf(date_inspection), description,
                address_id, rent_or_buy, Integer.parseInt(price), Integer.parseInt(agent_id));
        return propertyMapper.createProperty(property);
    }

    public static List<Property> viewMyPropertyList(int agentID){
        return propertyMapper.searchByAgentID(agentID);
    }

    public static Property viewSpecificProperty(int property_id) {
        return propertyMapper.searchByPropertyID(property_id);
    }


    public static Property updateProperty(Property old_property, String type, String num_bed,
                                   String num_bath, String num_carpark, String date_available,
                                          String date_inspection, String description, String street,
                                          String city, String state, int postal_code, String country,
                                          String rent_or_buy, String price) {
        old_property.setType(type);
        old_property.setNum_bed(Integer.parseInt(num_bed));
        old_property.setNum_bath(Integer.parseInt(num_bath));
        old_property.setNum_carpark(Integer.parseInt(num_carpark));
        old_property.setDate_available(Date.valueOf(date_available));
        old_property.setDate_inspection(Date.valueOf(date_inspection));
        old_property.setDescription(description);
        old_property.retrieveTheAddressObj().setStreet(street);
        old_property.retrieveTheAddressObj().setCity(city);
        old_property.retrieveTheAddressObj().setState(state);
        old_property.retrieveTheAddressObj().setPostal_code(postal_code);
        old_property.retrieveTheAddressObj().setCountry(country);
        old_property.setRent_or_buy(rent_or_buy);
        old_property.setPrice(Integer.parseInt(price));
        // update the property in db
        if (propertyMapper.updateProperty(old_property)){
            return old_property;
        }
        return null;

    }
    public static boolean deleteProperty(int agent_id, int property_id) {
        return propertyMapper.deleteProperty(agent_id, property_id);
    }
}
