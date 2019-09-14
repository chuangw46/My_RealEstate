package test;

import dataSourceLayer.mappers.userMapper.UserMapper;
import dataSourceLayer.mappers.userMapper.UserMapperInterface;
import domainLogic.Authentication;
import models.Agent;
import models.Client;
import models.User;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class TestUser {
    public static void main(String[] args) {
        UserMapperInterface userMapper = new UserMapper();
//        System.out.println(login());
//        System.out.println(creatClientAccount(userMapper));
//        System.out.println(creatAgentAccount(userMapper));
//        updateClient(userMapper);
        updateAgent(userMapper);
    }

    public static User login(){
        return Authentication.login("chuangw@gmail.com", "chuangw");
    }

    public static boolean creatClientAccount(UserMapperInterface mapper){
        User client = new Client("testClient@gamil.com","test","test name");
        return mapper.createUser(client);
    }

    public static boolean creatAgentAccount(UserMapperInterface mapper){
        User agent = new Agent("testAgent@gamil.com","test","test name");
        return mapper.createUser(agent);
    }

    public static void updateClient(UserMapperInterface mapper) {
        User client = new Client(2,"testClient@gamil.com","test","test name Changed");
        mapper.updateUser(client);
    }

    public static void updateAgent(UserMapperInterface mapper) {
        User agent = new Agent(2,"testAgent@gamil.com","test","test name Changed");
        mapper.updateUser(agent);
    }


}
