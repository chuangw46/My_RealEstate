package dataSourceLayer.mappers;

import java.sql.SQLException;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public interface DataMapper {
    public void create(Object o) throws SQLException;

    public void update(Object o) throws SQLException;

    public void delete(Object o) throws SQLException;
}
