package dataSourceLayer.unitOfWork;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public interface UnitOfWorkI<T> {
    String INSERT = "INSERT";
    String DELETE = "DELETE";
    String UPDATE = "UPDATE";

    /**
     * Any register new operation occurring on UnitOfWork is only going to be performed on commit.
     */
    void registerInsert(T entity);

    /**
     * Any register update operation occurring on UnitOfWork is only going to be performed on
     * commit.
     */
    void registerUpdate(T entity);

    /**
     * Any register delete operation occurring on UnitOfWork is only going to be performed on commit.
     */
    void registerDelete(T entity);

    /***
     * All UnitOfWork operations batched together executed in commit only.
     */
    void commit();
}
