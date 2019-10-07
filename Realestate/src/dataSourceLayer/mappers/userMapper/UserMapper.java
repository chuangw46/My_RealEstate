package dataSourceLayer.mappers.userMapper;

import dataSourceLayer.dbConfig.DBConnection;
import model.Agent;
import model.Client;
import model.User;
import utils.ConstructObjectFromDB;
import utils.ConstructUserSQLStmt;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */

/**
 * user data mapper implementation
 */
public class UserMapper implements UserMapperI {

    /**
     * create a new user in database either in client table or in agent table
     * @param user
     * @return true if success, false if failed
     */
    @Override
    public boolean createUser(User user) {
        try {
            String insertStatement = "";
            if (user instanceof Client){
                insertStatement = ConstructUserSQLStmt.getClientINSERTStmt(user);
            } else if (user instanceof Agent){
                insertStatement = ConstructUserSQLStmt.getAgentINSERTStmt(user);
            }
            PreparedStatement stmt = DBConnection.prepare(insertStatement);
            stmt.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    /**
     * retrieve a user information based on user email which is unique in table
     * @param email
     * @return a user object
     */
    @Override
    public User getUserByEmail(String email) {
        User user = UserIdentityMapUtil.getUserByEmail(email);
        try {
            if (user == null) {
                user = findUserByEmailFromAgent(email);
                if (user == null) {
                    user = findUserByEmailFromClient(email);
                }
            }
            if (user != null) {
                UserIdentityMapUtil.addToUserEmailMap(user);
                UserIdentityMapUtil.addToUserIDMap(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * TODO - Feature B: client can find an agent
     * @param name
     * @return
     */
    @Override
    public List<User> getUserByName(String name) {
        return null;
    }

    /**
     * update a user information and update the row in database
     * @param user
     * @return true if success, false if failed
     */
    @Override
    public boolean updateUser(User user) {
        if (user instanceof Client) {
            return updateClient((Client)user);
        } else if (user instanceof Agent) {
            return updateAgent((Agent)user);
        }
        return false;
    }

    /**
     * helper function for updateUser
     * @param client
     * @return true if success, false if failed
     */
    private boolean updateClient(Client client) {
        try {
            String updateStatement = ConstructUserSQLStmt.getClientUPDATEStmt(client);
            System.out.println(updateStatement);
            PreparedStatement stmt = DBConnection.prepare(updateStatement);
            int i = stmt.executeUpdate();
            System.out.println(i + " rows changed");
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    /**
     * helper function for updateUser
     * @param agent
     * @return true if success, false if failed
     */
    private boolean updateAgent(Agent agent) {
        try {
            String updateStatement = ConstructUserSQLStmt.getAgentUPDATEStmt(agent);
            PreparedStatement stmt = DBConnection.prepare(updateStatement);
            stmt.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }


    // TODO - Feature B
    @Override
    public void deleteUser(User user) {
    }

    /**
     * helper function for getUserByEmail function
     * @param email
     * @return a user object
     * @throws SQLException
     */
    private User findUserByEmailFromClient(String email) throws SQLException {
        String selectStatement = ConstructUserSQLStmt.getClientSELECTStmt(email);
        PreparedStatement stmt = DBConnection.prepare(selectStatement);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            return ConstructObjectFromDB.constructClientByRS(rs);
        }

        return null;
    }

    /**
     * helper function for getUserByEmail function
     * @param email
     * @return a user object
     * @throws SQLException
     */
    private User findUserByEmailFromAgent(String email) throws SQLException {
        String selectStatement = ConstructUserSQLStmt.getAgentSELECTStmt(email);
        PreparedStatement stmt = DBConnection.prepare(selectStatement);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            return ConstructObjectFromDB.constructAgentByRS(rs);
        }
        return null;
    }
}
