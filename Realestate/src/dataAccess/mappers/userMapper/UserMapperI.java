package dataAccess.mappers.userMapper;

import model.User;

import java.util.List;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */

/**
 * user data mapper interface
 */
public interface UserMapperI {

    // TODO: sign up
    public boolean createUser(User user); // create

    // TODO: log in
    public User getUserByEmail(String email);

    // TODO: caller needs to check if the returned result is null
    public List<User> getUserByName(String name);

    // TODO: update user info
    public boolean updateUser(User user); // update

    // TODO: delete a user
    public void deleteUser(User user); // delete
}
