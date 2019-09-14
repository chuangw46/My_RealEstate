package domainLogic;

import dataSourceLayer.mappers.userMapper.UserMapper;
import dataSourceLayer.mappers.userMapper.UserMapperInterface;
import models.User;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class Authentication {

    private static UserMapperInterface userMapper = new UserMapper();

    public static User login(String email, String password) {
        User user = userMapper.getUserByEmail(email);
        if (user != null) {
            if (password.equals(user.getPassword())){
                return user;
            }
        }
        return null;
    }

}
