package test;

import dataSourceLayer.mappers.addressMapper.AddressMapper;
import dataSourceLayer.mappers.addressMapper.AddressMapperI;
import models.Address;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class TestAddress {
    public static void main(String[] args) {
        AddressMapperI mapper = new AddressMapper();
//        testGetByPostcode(mapper);
        testCreateAddress(mapper);

    }

    private static void testGetByPostcode(AddressMapperI mapper) {
        Address address = mapper.getAddressByID(1);
        System.out.println(address);

        address = mapper.getAddressByID(2);
        System.out.println(address);
        System.out.println("---------------------");
        for (Address temp : mapper.getAllAddressByPostCode(2323)){
            System.out.println(temp);
        }
    }

    private static void testCreateAddress(AddressMapperI mapper){
        Address address = new Address("123 eli", "melb", "vic",3000,"au");
        mapper.createAddress(address);
    }
}
