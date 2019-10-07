package test;

import dataSourceLayer.mappers.propertyMapper.PropertyMapper;
import dataSourceLayer.mappers.propertyMapper.PropertyMapperI;
import domainModels.Property;

import java.sql.Date;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class TestPropertyMapper {
    public static void main(String[] args) {
        PropertyMapperI mapper = new PropertyMapper();
//        testSearchByAgentID(mapper);
//        testInsertProperty(mapper);
//        testUpdateProperty(mapper);
        testDeleteProperty(mapper);
    }

    private static void testSearchByAgentID(PropertyMapperI mapper) {

        for (Property p : mapper.searchByAgentID(1)){
            System.out.println(p);
        }
    }

    private static void testInsertProperty(PropertyMapperI mapper){
        Property p = new Property(4,1);
        mapper.createProperty(p);

    }

    private static void testUpdateProperty(PropertyMapperI mapper) {
        Date available = Date.valueOf("2020-01-01");
        Date inspect = Date.valueOf("2020-02-02");

        Property p = new Property(40,"townhouse",2,1,1,
                available,inspect,"description",5,"rent",200,1);
        mapper.updateProperty(p);
    }

    private static void testDeleteProperty(PropertyMapperI mapper) {
//        mapper.deleteProperty(40);
    }
}
