package dataSourceLayer.mappers.userMapper;

import dataSourceLayer.dbConfig.DBConnection;
import dataSourceLayer.mappers.DataMapper;
import models.Agent;
import models.Client;
import models.User;
import utils.ConstructObjectFromDB;
import utils.ConstructUserSQLStmt;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */

/**
 * user data mapper implementation
 */
public class UserMapper extends DataMapper {
    //---------------------------- singleton pattern setup ---------------------------------------
    private static UserMapper userMapper;

    private UserMapper() {
        //
    }

    public static UserMapper getInstance() {
        if (userMapper == null) {
            return new UserMapper();
        }
        return userMapper;
    }

    //------------------------- create, update, delete(Call by UoW) ------------------------------

    /**
     * create a new user in database either in client table or in agent table
     *
     * @param o
     */
    @Override
    public void create(Object o) throws SQLException {
        User user = (User) o;

        String insertStatement = "";
        if (user instanceof Client) {
            insertStatement = ConstructUserSQLStmt.getClientINSERTStmt(user);
        } else if (user instanceof Agent) {
            insertStatement = ConstructUserSQLStmt.getAgentINSERTStmt(user);
        }
        PreparedStatement stmt = DBConnection.prepare(insertStatement);
        stmt.executeUpdate();
    }

    /**
     * update a user information and update the row in database
     *
     * @param o
     */
    @Override
    public void update(Object o) throws SQLException {
        User user = (User) o;
        if (user instanceof Client) {
            updateClient((Client) user);
        } else if (user instanceof Agent) {
            updateAgent((Agent) user);
        }
    }

    /**
     * There is no account delete operation available for users. As such this method is not
     * implemented.
     *
     * @param o
     */
    @Override
    public void delete(Object o) throws SQLException{
        //
    }

    /**
     * helper function for updateUser
     *
     * @param client
     */
    private void updateClient(Client client) throws SQLException {
        String updateStatement = ConstructUserSQLStmt.getClientUPDATEStmt(client);
        PreparedStatement stmt = DBConnection.prepare(updateStatement);
        stmt.executeUpdate();
    }

    /**
     * helper function for updateUser
     *
     * @param agent
     */
    private void updateAgent(Agent agent) throws SQLException {
        String updateStatement = ConstructUserSQLStmt.getAgentUPDATEStmt(agent);
        PreparedStatement stmt = DBConnection.prepare(updateStatement);
        stmt.executeUpdate();
    }

    //------------------- read operations (Called by service layer directly) -------------------

    /**
     * retrieve a user information based on user email which is unique in table
     *
     * @param email
     * @return a user object
     */
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
     * TODO - Feature B: client can find an agent by name
     *
     * @param name
     * @return
     */
    public List<User> getAgentByName(String name) {
        List<User> result = new ArrayList<>();
        try {
            String selectStatement = ConstructUserSQLStmt.getAgentSELECTStmtByName(name);
            PreparedStatement stmt = DBConnection.prepare(selectStatement);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                result.add(ConstructObjectFromDB.constructAgentByRS(rs));
            }
        } catch (SQLException e) {
            return null;
        }
        return result;
    }


    /**
     * helper function for getUserByEmail function
     *
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
     *
     * @param email
     * @return a user object
     * @throws SQLException
     */
    private User findUserByEmailFromAgent(String email) throws SQLException {
        String selectStatement = ConstructUserSQLStmt.getAgentSELECTStmtByEmail(email);
        PreparedStatement stmt = DBConnection.prepare(selectStatement);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            return ConstructObjectFromDB.constructAgentByRS(rs);
        }
        return null;
    }
}
