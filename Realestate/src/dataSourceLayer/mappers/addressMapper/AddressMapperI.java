package dataSourceLayer.mappers.addressMapper;

import domainModels.Address;

import java.util.List;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */

/**
 * address data mapper interface
 */
public interface AddressMapperI {

    public int createAddress(Address address); // create

    public Address getAddressByID(int id); // read

    // TODO: caller needs to check if the returned result is null
    public List<Address> getAllAddressByPostCode(int postcode); // read by postcode

    public boolean updateAddress(Address address); // update

    public boolean deleteAddressByID(int a_id); // delete

}
