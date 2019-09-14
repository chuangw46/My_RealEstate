package dataSourceLayer.mappers.propertyMapper;

import models.Property;

import java.util.List;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public interface PropertyMapperInterface {
    /**
     * Feature A - only agents have the permission to create a property information
     * the permission check is done on the domain logic layer
     * @param property
     */
    public void createProperty(Property property); // create

    /**
     * Feature A - return a list of properties that the agent posted before
     * the permission check is done on the domain logic layer
     * @param agentID
     * @return a list of properties that the agent posted before
     */
    public List<Property> searchByAgentID(int agentID);

    /**
     * Feature A - only agents have the permission to update a property information
     * the permission check is done on the domain logic layer
     * @param property
     */
    public void updateProperty(Property property);

    /**
     * Feature A - only agents have the permission to delete a property
     * the permission check is done on the domain logic layer
     * @param property
     */
    public void deleteProperty(Property property);

    // TODO: Feature B
    public List<Property> searchByPostCode(int postCode);

    // TODO: Feature B
    public List<Property> searchByPropertyType(String type);

    // TODO: Feature B
    public List<Property> searchByRoomSize(int minBed, int maxBed);

    // TODO: Feature B
    public List<Property> searchByPrice(int minPrice, int maxPrice);

}
