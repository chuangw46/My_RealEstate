package dataSourceLayer.mappers;

import dataSourceLayer.ConcurrencyUtil.LockerManager;
import service.AppSession;

import java.sql.SQLException;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class LockingMapper implements DataMapper {
    private DataMapper impl;
    private String sessionID;

    public LockingMapper(DataMapper impl) {
        this.impl = impl;
        this.sessionID = AppSession.getSessionId();
    }

    // TODO: all retrieve - read lock  & favorite list all CRUD
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
        LockerManager.getInstance().acquireLock(o, sessionID);
        impl.delete(o);
        LockerManager.getInstance().releaseLock(o, sessionID);
    }
}
