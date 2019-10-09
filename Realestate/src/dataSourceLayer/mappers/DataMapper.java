package dataSourceLayer.mappers;

import dataSourceLayer.mappers.addressMapper.AddressMapper;
import dataSourceLayer.mappers.propertyMapper.PropertyMapper;
import dataSourceLayer.mappers.userMapper.UserMapper;
import models.Address;
import models.Property;
import models.User;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public abstract class DataMapper {
    public static DataMapper getMapper(Object o){
        if ( o instanceof User){
            return UserMapper.getInstance();
        } else if (o instanceof Property){
            return PropertyMapper.getInstance();
        } else if (o instanceof Address) {
            return AddressMapper.getInstance();
        }
        return null;
    }
    public abstract void create(Object o);

    public abstract void update(Object o);

    public abstract void delete(Object o);
}
