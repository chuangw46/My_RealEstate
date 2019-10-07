package dataSourceLayer.unitOfWork;

import dataSourceLayer.mappers.propertyMapper.PropertyMapperI;
import model.Property;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class PropertyUoW implements UnitOfWorkI<Property> {
    private Map<String, List<Property>> readyToCommit;
    private PropertyMapperI propertyMapper;

    public PropertyUoW(Map<String, List<Property>> readyToCommit, PropertyMapperI propertyMapper) {
        this.readyToCommit = readyToCommit;
        this.propertyMapper = propertyMapper;
    }

    /**
     * Any register new operation occurring on UnitOfWork is only going to be performed on commit.
     *
     * @param property
     */
    @Override
    public void registerInsert(Property property) {
        register(property, UnitOfWorkI.INSERT);
    }

    /**
     * Any register update operation occurring on UnitOfWork is only going to be performed on
     * commit.
     *
     * @param property
     */
    @Override
    public void registerUpdate(Property property) {
        register(property, UnitOfWorkI.UPDATE);
    }

    /**
     * Any register delete operation occurring on UnitOfWork is only going to be performed on commit.
     *
     * @param property
     */
    @Override
    public void registerDelete(Property property) {
        register(property, UnitOfWorkI.DELETE);
    }

    private void register(Property property, String operation) {
        //TODO
        List<Property> propertiesToOperate = readyToCommit.get(operation);
        if (propertiesToOperate == null){
            propertiesToOperate = new ArrayList<>();
        }
        propertiesToOperate.add(property);
        readyToCommit.put(operation, propertiesToOperate);
    }

    /***
     * All UnitOfWork operations batched together executed in commit only.
     */
    @Override
    public boolean commit() {
        boolean insertDone = true;
        boolean updateDone = true;
        boolean deleteDone = true;
        if (readyToCommit == null || readyToCommit.size() == 0) {
            return true;
        }
        // Commit started
        if (readyToCommit.containsKey(UnitOfWorkI.INSERT)) {
            insertDone = commitInsert();
        }
        if (readyToCommit.containsKey(UnitOfWorkI.UPDATE)) {
            updateDone = commitUpdate();
        }
        if (readyToCommit.containsKey(UnitOfWorkI.DELETE)) {
            deleteDone = commitDelete();
        }
        return insertDone && updateDone && deleteDone;

    }

    private boolean commitInsert() {
        List<Property> propertiesToBeInserted = readyToCommit.get(UnitOfWorkI.INSERT);
        for (Property p : propertiesToBeInserted) {
            if (!propertyMapper.createProperty(p))
                return false;
        }
        return true;
    }

    private boolean commitUpdate() {
        List<Property> propertiesToBeUpdated = readyToCommit.get(UnitOfWorkI.UPDATE);
        for (Property p : propertiesToBeUpdated) {
            if (!propertyMapper.updateProperty(p))
                return false;
        }
        return true;

    }

    private boolean commitDelete() {
        List<Property> propertiesToBeDeleted = readyToCommit.get(UnitOfWorkI.DELETE);
        for (Property p : propertiesToBeDeleted) {
            if (!propertyMapper.deleteProperty(p.getAgent_id(), p.getId()))
                return false;
        }
        return true;
    }
}
