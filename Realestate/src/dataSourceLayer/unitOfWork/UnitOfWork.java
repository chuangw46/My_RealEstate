package dataSourceLayer.unitOfWork;

import dataSourceLayer.mappers.DataMapper;
import dataSourceLayer.mappers.addressMapper.AddressMapper;
import dataSourceLayer.mappers.propertyMapper.PropertyMapper;
import dataSourceLayer.mappers.userMapper.UserMapper;
import models.Address;
import models.Property;
import models.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class UnitOfWork {
    //------------------------------------- setup ----------------------------------------------
    private static ThreadLocal<UnitOfWork> current = new ThreadLocal<>();

    private List<Object> newObjects = new ArrayList<>();
    private List<Object> dirtyObjects = new ArrayList<>();
    private List<Object> deletedObjects = new ArrayList<>();

    public static void newCurrent() {
        setCurrent(new UnitOfWork());
    }

    private static void setCurrent(UnitOfWork uow) {
        current.set(uow);
    }

    public static UnitOfWork getCurrent() {
        return current.get();
    }

    //---------------------------------- registration -------------------------------------------

    /**
     * Any register new operation occurring on UnitOfWork is only going to be performed on commit.
     */
    public void registerNew(Object o){
        if (!newObjects.contains(o) && !dirtyObjects.contains(o) && !deletedObjects.contains(o)){
            newObjects.add(o);
        }
    }

    /**
     * Any register update operation occurring on UnitOfWork is only going to be performed on
     * commit.
     */
    public void registerDirty(Object o){
        if (!newObjects.contains(o) && !dirtyObjects.contains(o) && !deletedObjects.contains(o)){
            dirtyObjects.add(o);
        }
    }

    /**
     * Any register delete operation occurring on UnitOfWork is only going to be performed on commit.
     */
    public void registerDeleted(Object o){
        if (newObjects.remove(o))
            return;
        dirtyObjects.remove(o);
        if (!deletedObjects.contains(o)){
            deletedObjects.add(o);
        }

    }


    //--------------------------------------- commit ----------------------------------------------

    /***
     * All UnitOfWork operations batched together executed in commit only.
     */
    public void commit() throws SQLException {
        for (Object o : newObjects) {
            getMapper(o).create(o);
        }
        for (Object o : dirtyObjects) {
            getMapper(o).update(o);
        }
        for (Object o : deletedObjects) {
            getMapper(o).delete(o);
        }
    }

    private DataMapper getMapper(Object o){
        if (o instanceof User){
            return UserMapper.getInstance();
        } else if (o instanceof Property){
            return PropertyMapper.getInstance();
        } else if (o instanceof Address) {
            return AddressMapper.getInstance();
        }
        return null;
    }

}
