package service;

import dataSourceLayer.mappers.userMapper.UserMapper;
import dataSourceLayer.mappers.userMapper.UserMapperI;
import model.Agent;
import model.Client;
import model.User;

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
    private static UserMapperI userMapper = new UserMapper();


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

    /**
     * register an account
     * @param email
     * @param password
     * @param name
     * @param type
     * @return a user object
     */
    public static User signup(String email, String password, String name, String type){
        User user;
        if (type.equals("Client")) {
            user = new Client(email, password, name);
        } else{
            user = new Agent(email, password, name);
        }
        if (userMapper.createUser(user)) {
            return userMapper.getUserByEmail(email);
        }
        return null;
    }

    /**
     * update client profile
     * @param user
     * @param name
     * @return a client object
     */
    public static User updateClientProfile(User user, String name){
        Client client =(Client)user;
        client.setName(name);
        if(userMapper.updateUser(client)) {
            return userMapper.getUserByEmail(client.getEmail());
        }
        return null;
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
    public static User updateAgentProfile(User user, String name, String phone, String company_name,
                                       String company_address, String company_website, String bio){
        Agent agent = (Agent)user;
        agent.setName(name);
        agent.setPhone(phone);
        agent.getCompany().setName(company_name);
        agent.getCompany().setAddress(company_address);
        agent.getCompany().setWebsite(company_website);
        agent.setBio(bio);
        if(userMapper.updateUser(agent)) {
            return userMapper.getUserByEmail(agent.getEmail());
        }
        return null;
    }

}
