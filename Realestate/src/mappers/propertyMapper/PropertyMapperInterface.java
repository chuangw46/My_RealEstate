package mappers.propertyMapper;

import models.Agent;
import models.Property;

import java.util.List;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public interface PropertyMapperInterface {
    public void createProperty(Property property); // create

    public List<Property> searchByPropertyType(String type);

    public List<Property> searchByRoomSize(int minBed, int maxBed);

    public List<Property> searchByPrice(int minPrice, int maxPrice);

    public List<Property> searchByAgent(Agent agent);

    public void updateProperty(Property property);

    public void deleteProperty(Property property);

}
