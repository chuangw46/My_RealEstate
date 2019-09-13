package mappers.addressMapper;

import models.Address;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class TestAddress {
    public static void main(String[] args) {
        AddressMapperInterface mapper = new AddressMapper();
        Address address = mapper.getAddressByID(1);
        System.out.println(address);

        address = mapper.getAddressByID(2);
        System.out.println(address);
        System.out.println("---------------------");
        for (Address temp : mapper.getAllAddressByPostCode(2323)){
            System.out.println(temp);
        }

    }
}
