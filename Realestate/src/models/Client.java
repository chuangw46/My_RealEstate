package models;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class Client extends User{
    private Set<Property> favorites;
    public Client(int id, String name, String email, String password) {
        super(id, name, email, password);
        favorites = new HashSet<>();
    }

    public Set<Property> getFavorites() {
        return favorites;
    }

    public void addToFavorite(Property property){
        favorites.add(property);
    }

    public void removeFromFavorite(Property property){
        favorites.remove(property);
    }

}
