package dataSourceLayer.mappers.propertyMapper;

import models.Property;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class PropertyIdentityMapUtil {
    private static Map<Integer, List<Property>> propertyAgentMap= new HashMap<>();

    public static List<Property> getPropertyByAgentID(int agentID){
        return propertyAgentMap.get(agentID);
    }

    public static void addToPropertyAgentMap(Property p){
        List<Property> old = propertyAgentMap.get(p.getAgent_id());
        if (old == null) {
            old = new ArrayList<>();
        }
        old.add(p);
        propertyAgentMap.put(p.getAgent_id(), old);
    }
}
