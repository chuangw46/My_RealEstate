package mappers.userMapper;

import models.User;

import java.util.List;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public interface UserMapperInterface {
    public void createUser(User user); // create

    public User getUserByEmail(String email); // read

    // TODO: caller needs to check if the returned result is null
    public List<User> getUserByName(String name);

    public void updateUser(User user); // update

    public void deleteUser(User user); // delete
}
