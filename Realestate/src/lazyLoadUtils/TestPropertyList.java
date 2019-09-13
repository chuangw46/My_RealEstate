package lazyLoadUtils;

import models.Client;
import models.Property;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class TestPropertyList {
    public static void main(String[] args) {
        Client testClient = new Client(1, "frank@gamil.com","123","frank");
        for (Property p : testClient.getFavorites().getFavoriteList()){
            System.out.println(p);
        }
    }
}
