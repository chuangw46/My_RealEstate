package dataSourceLayer.mappers.addressMapper;

import models.Address;

import java.util.*;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class AddressIdentityMapUtil {
    private static Map<Integer, Address> addressPKMap = new HashMap<>();
    private static Map<Integer, List<Address>> addressPostCodeMap = new HashMap<>();


    public static Address getAddressByID(int id){
        return addressPKMap.get(id);
    }


    public static void addToPKMap(Address address){
        addressPKMap.put(address.getId(), address);
    }

    public static List<Address> getAddressByPostCode(int postcode){
        return addressPostCodeMap.get(postcode);
    }

    public static void addToPostCodeMap(Address address){
        List<Address> old = addressPostCodeMap.get(address.getPostal_code());
        if (old == null) {
            old = new ArrayList<>();
        }
        old.add(address);
        addressPostCodeMap.put(address.getPostal_code(), old);
    }
}
