package dataSourceLayer.mappers;

import service.AppSession;

import java.sql.SQLException;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class LockingMapper implements DataMapper {
    // the concrete mapper
    private DataMapper impl;
    private String sessionID;

    /*
     a locking mapper object is created when concrete mapper's instance is created(both are
     singleton)
     */
    public LockingMapper(DataMapper impl) {
        this.impl = impl;
        this.sessionID = AppSession.getSessionId();
    }

    @Override
    public void create(Object o) throws SQLException {
        impl.create(o);
    }

    @Override
    public void update(Object o) throws SQLException {
        impl.update(o);
    }

    @Override
    public void delete(Object o) throws SQLException {
        // Implicit lock implementation
        ExclusiveWriteLockManager.getInstance().acquireLock(o, sessionID);
        impl.delete(o);
        ExclusiveWriteLockManager.getInstance().releaseLock(o, sessionID);
    }
}
