package dataSourceLayer.ConcurrencyUtil;

import dataSourceLayer.mappers.DataMapper;

import java.sql.SQLException;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class LockingMapper extends DataMapper{
    private DataMapper impl;

    public LockingMapper(DataMapper impl) {
        this.impl = impl;
    }

    // TODO: all retrieve - read lock  & favorite list all CRUD
    @Override
    public void create(Object o) throws SQLException {
        try {
            LockManager.getInstance().acquireWriteLock(o);
            impl.create(o);
            LockManager.getInstance().releaseWriteLock(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Object o) throws SQLException {
        try {
            LockManager.getInstance().acquireWriteLock(o);
            impl.update(o);
            LockManager.getInstance().releaseWriteLock(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Object o) throws SQLException {
        try {
            LockManager.getInstance().acquireWriteLock(o);
            impl.delete(o);
            LockManager.getInstance().releaseWriteLock(o);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
