package dataAccess.lazyLoad;

import model.Property;

import java.util.List;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */

/**
 * lazy load utility for client property favorite list
 */
public interface FavoriteList {
    public List<Property> getFavoriteList();

    public void add(Property property);

    public void remove(Property property);
}
