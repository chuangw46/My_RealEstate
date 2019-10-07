package model;


import dataAccess.lazyLoad.FavoriteList;
import dataAccess.lazyLoad.FavoriteListImplement;


/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */

/**
 * to construct object based on information retrieved from client table in database
 */

public class Client extends User {
    private FavoriteList favorites;

    public Client(int id) {
        super(id);
    }

    public Client(int id, String name) {
        super(id, name);
    }

    public Client(String email, String password, String name) {
        super(email, password, name);
    }

    public Client(int id, String email, String password, String name) {
        super(id, email, password, name);
        this.favorites = new FavoriteListImplement(this);

    }


    public FavoriteList getFavorites() {
        return favorites;
    }

    public void addToFavorite(Property property) {
        favorites.add(property);
    }

    public void removeFromFavorite(Property property) {
        favorites.remove(property);
    }

}
