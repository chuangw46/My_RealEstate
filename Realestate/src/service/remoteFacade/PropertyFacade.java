package service.remoteFacade;

import dataSourceLayer.mappers.propertyMapper.PropertyMapper;
import models.Property;
import service.DTO.PropertyDTO;

import java.sql.SQLException;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class PropertyFacade {
    private static PropertyFacade instance;
    private PropertyFacade() {}
    public static PropertyFacade getInstance() {
        if (instance == null){
            instance = new PropertyFacade();
        }
        return instance;
    }
    public PropertyDTO getPropertyDTO(int propertyID){
        Property property = PropertyMapper.getSelfInstance().searchByPropertyID(propertyID);
        return PropertyAssembler.createPropertyDTO(property);
    }

    public void updateProperty(PropertyDTO propertyDTO) throws SQLException {
        PropertyAssembler.updateProperty(propertyDTO);
    }

    public String getPropertyJSON(int propertyID) {
        return PropertyDTO.serialize(getPropertyDTO(propertyID));
    }

    public void updatePropertyJSON(String json) throws SQLException {
        updateProperty(PropertyDTO.deserialize(json));
    }
}
