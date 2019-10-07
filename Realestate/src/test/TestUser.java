package test;

import dataSourceLayer.mappers.userMapper.UserMapper;
import dataSourceLayer.mappers.userMapper.UserMapperI;
import domainLogic.UserManagement;
import domainModels.Agent;
import domainModels.Client;
import domainModels.User;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class TestUser {
    public static void main(String[] args) {
        UserMapperI userMapper = new UserMapper();
//        System.out.println(login());
//        System.out.println(creatClientAccount(userMapper));
        System.out.println(creatAgentAccount(userMapper));
//        updateClient(userMapper);
//        updateAgent(userMapper);
    }

    public static User login(){
        return UserManagement.login("chuangw@gmail.com", "chuangw");
    }

    public static boolean creatClientAccount(UserMapperI mapper){
        User client = new Client("testClient@gamil.com","test","test name");
        return mapper.createUser(client);
    }

    public static boolean creatAgentAccount(UserMapperI mapper){
        User agent = new Agent("a@gmail.com","chuangw","test name");
        return mapper.createUser(agent);
    }

    public static void updateClient(UserMapperI mapper) {
        User client = new Client(2,"testClient@gamil.com","test","test name Changed");
        mapper.updateUser(client);
    }

    public static void updateAgent(UserMapperI mapper) {
        User agent = new Agent(2,"testAgent@gamil.com","test","test name Changed");
        mapper.updateUser(agent);
    }


}
