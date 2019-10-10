package dataSourceLayer.mappers;

import java.sql.SQLException;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public interface DataMapper {
//    public static DataMapper getMapper(Object o){
//        if ( o instanceof User){
//            return UserMapper.getInstance();
//        } else if (o instanceof Property){
//            return PropertyMapper.getInstance();
//        } else if (o instanceof Address) {
//            return AddressMapper.getInstance();
//        }
//        return null;
//    }
    public void create(Object o) throws SQLException;

    public void update(Object o) throws SQLException;

    public void delete(Object o) throws SQLException;
}
