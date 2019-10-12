//package dataSourceLayer.ConcurrencyUtil;
//
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * @author Chuang Wang
// * @studentID 791793
// * @institution University of Melbourne
// */
//public class ReadWriteLock {
//    // key: read thread   value: access count
//    private Map<Thread, Integer> readingThreads = new HashMap<>();
//
//    private int writeAccesses = 0;
//    private int writeRequests = 0;
//
//    private Thread writingThread = null;
//
//    // --------------------------- acquire & release lock for read process ------------------------
//    public synchronized void acquireReadLock() throws InterruptedException {
//        Thread callingThread = Thread.currentThread();
//        while (!canGrantReadAccess(callingThread)){
//            wait();
//        }
//        readingThreads.put(callingThread, (getReadAccessCount(callingThread) + 1));
//    }
//
//    public synchronized void releaseReadLock(){
//        Thread callingThread = Thread.currentThread();
//        if (!isReader(callingThread)) {
//            throw new IllegalMonitorStateException("Thread does not hold a read lock");
//        }
//        int accessCount = getReadAccessCount(callingThread);
//        if (accessCount == 1) {
//            readingThreads.remove(callingThread);
//        } else {
//            readingThreads.put(callingThread, accessCount - 1);
//        }
//        notifyAll();
//    }
//
//    public synchronized void release(){
//        Thread callingThread = Thread.currentThread();
//        if (!isReader(callingThread) || isWriter(callingThread)) {
//            throw new IllegalMonitorStateException("Thread does not hold a any lock");
//        }
//        readingThreads.remove(callingThread);
//        writingThread = null;
//        notifyAll();
//    }
//
//    // --------------------------- acquire lock for write process ---------------------------------
//    public synchronized void acquireWriteLock() throws InterruptedException {
//        writeRequests++;
//        Thread callingThread = Thread.currentThread();
//        while (!canGrantWriteAccess(callingThread)) {
//            wait();
//        }
//        writeRequests--;
//        writeAccesses++;
//        writingThread = callingThread;
//    }
//
//    public synchronized void releaseWriteLock(){
//        if (!isWriter(Thread.currentThread()))
//            throw new IllegalMonitorStateException("Thread does not hold a write lock");
//        writeAccesses--;
//        if (writeAccesses == 0)
//            writingThread = null;
//        notifyAll();
//
//    }
//    // ----------------------------- helpers for acquireWriteLock() --------------------------------
//    private boolean canGrantWriteAccess(Thread callingThread) {
//        if (isOnlyReader(callingThread))
//            return true;
//        if (hasReader())
//            return false;
//        if (writingThread == null)
//            return true;
//        return isWriter(callingThread);
//    }
//
//    private boolean isOnlyReader(Thread callingThread) {
//        return readingThreads.size() == 1 && readingThreads.get(callingThread) != null;
//    }
//
//    private boolean hasReader() {
//        return readingThreads.size() > 0;
//    }
//
//    // ----------------------------- helpers for acquireReadLock() --------------------------------
//    private boolean canGrantReadAccess(Thread callingThread) {
//        if (isWriter(callingThread)) // TODO: ?
//            return true;
//        if (hasWriter())
//            return false;
//        if (isReader(callingThread))
//            return true;
//        return !hasWriteRequests();
//
//    }
//
//    private Integer getReadAccessCount(Thread callingThread) {
//        Integer count = readingThreads.get(callingThread);
//        if (count == null)
//            return 0;
//        return count;
//    }
//
//    private boolean isWriter(Thread callingThread) {
//        return writingThread == callingThread;
//    }
//
//    private boolean hasWriter() {
//        return writingThread != null;
//    }
//
//    private boolean isReader(Thread callingThread) {
//        return readingThreads.get(callingThread) != null;
//    }
//
//    private boolean hasWriteRequests() {
//        return this.writeRequests > 0;
//    }
//
//}
