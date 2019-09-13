package lazyLoadUtils;

import models.Property;

import java.util.List;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public interface FavoriteList {
    public List<Property> getFavoriteList();

    public void add(Property property);

    public void remove(Property property);
}
