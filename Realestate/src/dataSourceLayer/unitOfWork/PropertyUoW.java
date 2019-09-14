package dataSourceLayer.unitOfWork;

import dataSourceLayer.mappers.propertyMapper.PropertyMapperInterface;
import models.Property;

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
    private PropertyMapperInterface propertyMapper;

    public PropertyUoW(Map<String, List<Property>> readyToCommit, PropertyMapperInterface propertyMapper) {
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
    public void commit() {
        if (readyToCommit == null || readyToCommit.size() == 0) {
            return;
        }
        // Commit started
        if (readyToCommit.containsKey(UnitOfWorkI.INSERT)) {
            commitInsert();
        }
        if (readyToCommit.containsKey(UnitOfWorkI.UPDATE)) {
            commitUpdate();
        }
        if (readyToCommit.containsKey(UnitOfWorkI.DELETE)) {
            commitDelete();
        }

    }

    private void commitInsert() {
        List<Property> propertiesToBeInserted = readyToCommit.get(UnitOfWorkI.INSERT);
        for (Property p : propertiesToBeInserted) {
            propertyMapper.createProperty(p);
        }
    }

    private void commitUpdate() {
        List<Property> propertiesToBeUpdated = readyToCommit.get(UnitOfWorkI.UPDATE);
        for (Property p : propertiesToBeUpdated) {
            propertyMapper.updateProperty(p);
        }

    }

    private void commitDelete() {
        List<Property> propertiesToBeDeleted = readyToCommit.get(UnitOfWorkI.DELETE);
        for (Property p : propertiesToBeDeleted) {
            propertyMapper.deleteProperty(p);
        }
    }
}
