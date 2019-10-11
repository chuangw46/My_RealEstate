package service;

import dataSourceLayer.mappers.userMapper.UserMapper;
import dataSourceLayer.unitOfWork.UnitOfWork;
import models.User;

import java.sql.SQLException;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */


/**
 * contains core functionality of managing user accounts including sign in, sign up and update
 * profile
 */
public class UserManagement {
    private static UserMapper userMapper = UserMapper.getSelfInstance();
//
//    /**
//     * log in
//     * @param email
//     * @param password
//     * @return a user object
//     */
//    public static User login(String email, String password) {
//        User user = userMapper.getUserByEmail(email);
//        if (user != null) {
//            if (password.equals(user.getPassword())){
//                return user;
//            }
//        }
//        return null;
//    }

    public static User getCurrentUser(String email){
        return userMapper.getUserByEmail(email);
    }

    /**
     * register an account
     * @param user
     * @return a user object
     */
    public static void signup(User user) throws SQLException {
        UnitOfWork.newCurrent();
        // use unit of work to insert a row to db
        UnitOfWork.getCurrent().registerNew(user);
        UnitOfWork.getCurrent().commit();
    }

    /**
     * update an agent profile
     * @param user
     */
    public static void updateProfile(User user) throws SQLException {
        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerDirty(user);
        UnitOfWork.getCurrent().commit();
    }

}
