package dataSourceLayer.mappers;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */

// ExclusiveWriteLockManager is responsible for allocating locks
public class ExclusiveWriteLockManager {

    //---------------------------- singleton pattern setup ---------------------------------------
    private static ExclusiveWriteLockManager exclusiveWriteLockManager;

    /*
     a lockMap maintains which session holds what object
     the key is the object to be locked on
     the value is session id
     */
    private Map<Object, String> lockMap = new ConcurrentHashMap<>();

    private ExclusiveWriteLockManager(){ }

    public static ExclusiveWriteLockManager getInstance(){
        if (exclusiveWriteLockManager == null) {
            exclusiveWriteLockManager = new ExclusiveWriteLockManager();
        }
        return exclusiveWriteLockManager;
    }

    //---------------------------- Lock management ---------------------------------------
    public boolean acquireLock(Object lockable, String owner) {
        boolean result = true;
        if (hasLock(lockable)){
            result = false;
        } else {
            lockMap.put(lockable, owner);
        }
        return result;
    }

    public void releaseLock(Object lockable, String owner){
        if (hasLock(lockable))
            lockMap.remove(lockable, owner);
    }

    public void releaseAllLocks(String owner) {
        lockMap.entrySet().removeIf(entry -> (owner.equals(entry.getValue())));
    }

    private boolean hasLock(Object lockable){
        return lockMap.containsKey(lockable);
    }
}
