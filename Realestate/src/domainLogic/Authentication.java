package domainLogic;

import mappers.userMapper.UserMapper;
import mappers.userMapper.UserMapperInterface;
import models.User;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class Authentication {

    private static UserMapperInterface userMapper = new UserMapper();
    public static boolean login(String email, String password) {
        User user = userMapper.getUserByEmail(email);
        return user != null && password.equals(user.getPassword());
    }

}
