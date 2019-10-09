package service;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class LockManager {
    private static LockManager lockManager;

    private LockManager(){
        //
    }

    public static LockManager getInstance(){
        if (lockManager == null) {
            return new LockManager();
        }
        return lockManager;
    }

    public void acquireLock(int lockable, String owner) {
        //
    }

    public void releaseLock(int lockable, String owner){
        //
    }

    public boolean hasLock(int lockable, String owner){
        return false;
    }
}
