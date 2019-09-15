package dataSourceLayer.mappers.propertyMapper;

import models.Property;

import java.util.*;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class PropertyIdentityMapUtil {
    private static Map<Integer, Set<Property>> propertyAgentMap= new HashMap<>();
    private static Map<Integer, Property> propertyIDMap = new HashMap<>();

    public static Set<Property> getPropertyByAgentID(int agentID){
        return propertyAgentMap.get(agentID);
    }

    public static void addToPropertyAgentMap(Property p){
        Set<Property> old = propertyAgentMap.get(p.getAgent_id());
        if (old == null) {
            old = new HashSet<>();
        }
        old.remove(p);
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
        Set<Property> old = propertyAgentMap.get(agent_id);
        for (Property p : old){
            if (p.getId() == p_id) {
                old.remove(p);
                propertyAgentMap.put(agent_id, old);
                return;
            }
        }
    }
}
