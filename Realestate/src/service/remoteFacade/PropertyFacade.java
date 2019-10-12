package service.remoteFacade;

import dataSourceLayer.mappers.propertyMapper.PropertyMapper;
import models.Property;
import service.DTO.PropertyAssembler;
import service.DTO.PropertyDTO;

import java.sql.SQLException;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class PropertyFacade {
    //---------------------------- singleton pattern setup ---------------------------------------
    private static PropertyFacade instance;
    private static PropertyAssembler propertyAssembler = new PropertyAssembler();

    private PropertyFacade() {}
    public static PropertyFacade getInstance() {
        if (instance == null){
            instance = new PropertyFacade();
        }
        return instance;
    }

    /**
     * generate a property DTO based on given property ID
     * @param propertyID
     * @return PropertyDTO object
     */
    public PropertyDTO getPropertyDTO(int propertyID){
        Property property = PropertyMapper.getSelfInstance().searchByPropertyID(propertyID);
        return propertyAssembler.createPropertyDTO(property);
    }

    /**
     * update a property data based on the property DTO dto object and store it into database
     * @param propertyDTO
     * @throws SQLException
     */
    public void updateProperty(PropertyDTO propertyDTO) throws SQLException {
        propertyAssembler.updateProperty(propertyDTO);
    }

    // serialize
    public String getPropertyJSON(int propertyID) {
        return PropertyDTO.serialize(getPropertyDTO(propertyID));
    }

    // deserialize
    public void updatePropertyJSON(String json) throws SQLException {
        updateProperty(PropertyDTO.deserialize(json));
    }

    /**
     * get a property assembler object
     * @return PropertyAssembler object
     */
    public static PropertyAssembler getPropertyAssembler() {
        return propertyAssembler;
    }
}
