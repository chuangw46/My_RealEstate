package mappers.addressMapper;

import models.Address;

import java.util.List;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public interface AddressMapperInterface {

    public void createAddress(Address address); // create

    public Address getAddressByID(int id); // read

    // TODO: caller needs to check if the returned result is null
    public List<Address> getAllAddressByPostCode(int postcode); // read by postcode

    public void updateAddress(Address address); // update

    public void deleteAddress(Address address); // delete

}
