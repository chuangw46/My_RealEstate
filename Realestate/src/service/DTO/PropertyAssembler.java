package service.DTO;

import dataSourceLayer.mappers.propertyMapper.PropertyMapper;
import models.Address;
import models.Agent;
import models.Property;
import service.remoteFacade.AgentFacade;

import java.sql.Date;
import java.sql.SQLException;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class PropertyAssembler {

    /**
     * encapsulate all property data into a property DTO including property data and its address
     * and agent DTO
     * @param property
     * @return PropertyDTO object
     */
    public PropertyDTO createPropertyDTO(Property property) {
        PropertyDTO result = new PropertyDTO();

        int property_id = property.getId();
        String type = property.getType();
        String rent_or_buy = property.getRent_or_buy();
        int price = property.getPrice();
        int num_bed = property.getNum_bed();
        int num_bath = property.getNum_bath();
        int num_carpark = property.getNum_carpark();
        Date date_available = property.getDate_available();
        Date date_inspection = property.getDate_inspection();
        String description = property.getDescription();

        Address address = property.retrieveTheAddressObj();
        int address_id = address.getId();
        String street = address.getStreet();
        String city = address.getCity();
        String state = address.getState();
        int postal_code = address.getPostal_code();
        String country = address.getCountry();

        Agent agent = (Agent)property.retrieveTheAgentObj();
        AgentDTO agentDTO = AgentFacade.getAgentAssembler().createAgentDTO(agent);

        result.setProperty_id(property_id);
        result.setType(type);
        result.setRent_or_buy(rent_or_buy);
        result.setPrice(price);
        result.setNum_bed(num_bed);
        result.setNum_bath(num_bath);
        result.setNum_carpark(num_carpark);
        result.setDate_available(date_available);
        result.setDate_inspection(date_inspection);
        result.setDescription(description);

        result.setAddress_id(address_id);
        result.setStreet(street);
        result.setCity(city);
        result.setState(state);
        result.setPostal_code(postal_code);
        result.setCountry(country);

        result.setAgentDTO(agentDTO);

        return result;
    }

    /**
     * update PROPERTY data based on given property DTO object and store it into db
     * @param propertyDTO
     * @throws SQLException
     */
    public void updateProperty(PropertyDTO propertyDTO) throws SQLException {
        Property property = new Property();
        property.setId(propertyDTO.getProperty_id());
        property.setType(propertyDTO.getType());
        property.setRent_or_buy(propertyDTO.getRent_or_buy());
        property.setPrice(propertyDTO.getPrice());
        property.setNum_bed(propertyDTO.getNum_bed());
        property.setNum_bath(propertyDTO.getNum_bath());
        property.setNum_carpark(propertyDTO.getNum_carpark());
        property.setDate_available(propertyDTO.getDate_available());
        property.setDate_inspection(propertyDTO.getDate_inspection());
        property.setDescription(propertyDTO.getDescription());

        Address address = new Address();
        address.setId(propertyDTO.getAddress_id());
        address.setStreet(propertyDTO.getStreet());
        address.setCity(propertyDTO.getCity());
        address.setState(propertyDTO.getState());
        address.setPostal_code(propertyDTO.getPostal_code());
        address.setCountry(propertyDTO.getCountry());

        property.setAddress_id(address.getId());
        property.setAgent_id(propertyDTO.getAgentDTO().getAgent_id());
        PropertyMapper.getLockingMapperInstance().update(property);
    }
}
