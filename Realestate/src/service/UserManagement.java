package service;

import dataSourceLayer.mappers.userMapper.UserMapper;
import dataSourceLayer.unitOfWork.UnitOfWork;
import models.Agent;
import models.Client;
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
    private static UserMapper userMapper = UserMapper.getInstance();

    /**
     * log in
     * @param email
     * @param password
     * @return a user object
     */
    public static User login(String email, String password) {
        User user = userMapper.getUserByEmail(email);
        if (user != null) {
            if (password.equals(user.getPassword())){
                return user;
            }
        }
        return null;
    }

    public static User getCurrentUser(String email){
        return userMapper.getUserByEmail(email);
    }

    /**
     * register an account
     * @param email
     * @param password
     * @param name
     * @param type
     * @return a user object
     */
    public static void signup(String email, String password, String name, String type) throws SQLException {
        UnitOfWork.newCurrent();
        User user;
        if (type.equals("Client")) {
            user = new Client(email, password, name);
        } else {
            user = new Agent(email, password, name);
        }

        // use unit of work to insert a row to db
        UnitOfWork.getCurrent().registerNew(user);
        UnitOfWork.getCurrent().commit();
    }

    /**
     * update client profile
     * @param user
     * @param name
     * @return a client object
     */
    public static void updateClientProfile(User user, String name) throws SQLException {
        UnitOfWork.newCurrent();
        Client client =(Client)user;
        client.setName(name);

        // use unit of work to update a data record to db
        UnitOfWork.getCurrent().registerDirty(client);
        UnitOfWork.getCurrent().commit();

    }

    /**
     * update an agent profile
     * @param user
     * @param name
     * @param phone
     * @param company_name
     * @param company_address
     * @param company_website
     * @param bio
     * @return an agent object
     */
    public static void updateAgentProfile(User user, String name, String phone, String company_name,
                                       String company_address, String company_website, String bio) throws SQLException {
        Agent agent = (Agent)user;
        agent.setName(name);
        agent.setPhone(phone);
        agent.getCompany().setName(company_name);
        agent.getCompany().setAddress(company_address);
        agent.getCompany().setWebsite(company_website);
        agent.setBio(bio);

        UnitOfWork.newCurrent();
        UnitOfWork.getCurrent().registerDirty(agent);
        UnitOfWork.getCurrent().commit();
    }

}
