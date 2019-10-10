package dataSourceLayer.ConcurrencyUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chuang Wang
 * @institution University of Melbourne
 */
public class LockManager {
    private static LockManager lockManager;
    private final Map<Object, ReadWriteLock> lockMap;

    private LockManager(){
        lockMap = new HashMap<>();
    }

    public static LockManager getInstance(){
        if (lockManager == null) {
            return new LockManager();
        }
        return lockManager;
    }

    // ----------------------- acquire & release lock for read transaction ------------------------
    public synchronized void acquireReadLock(Object toLock) throws InterruptedException {
        getReadWriteLock(toLock).acquireReadLock();
    }

    public synchronized void releaseReadLock(Object toRelease) {
        getReadWriteLock(toRelease).releaseReadLock();
    }

    // ----------------------- acquire & release lock for write transaction ------------------------
    public synchronized void acquireWriteLock(Object toLock) throws InterruptedException {
        getReadWriteLock(toLock).acquireWriteLock();
    }

    public synchronized void releaseWriteLock(Object toRelease) {
        getReadWriteLock(toRelease).releaseWriteLock();
    }

    private ReadWriteLock getReadWriteLock(Object toLock) {
        ReadWriteLock lock = lockMap.get(toLock);
        if (lock == null){
            lockMap.putIfAbsent(toLock, new ReadWriteLock());
            lock = lockMap.get(toLock);
        }
        return lock;
    }
}
