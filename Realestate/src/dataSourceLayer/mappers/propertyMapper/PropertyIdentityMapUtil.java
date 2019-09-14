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
    private static Map<Integer, Property> propertyIDMap = new HashMap<>();

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

    public static void deleteFromPropertyIDMap(int p_id) {
        propertyIDMap.remove(p_id);
    }

    public static Property getPropertyByPID(int propertyID){
        return propertyIDMap.get(propertyID);
    }

    public static void addToPropertyIDMap(Property p){
        propertyIDMap.put(p.getId(), p);
    }

    public static void deleteFromPropertyAgentMap(int agent_id, int p_id){
        List<Property> old = propertyAgentMap.get(agent_id);
        for (Property p : old){
            if (p.getId() == p_id) {
                old.remove(p);
                propertyAgentMap.put(agent_id, old);
                return;
            }
        }
    }
}
