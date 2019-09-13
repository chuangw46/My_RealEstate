package mappers.userMapper;

import dbConfig.DBConnection;
import models.Agent;
import models.Client;
import models.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */
public class UserMapper implements UserMapperInterface{

    @Override
    public void createUser(User user) {

    }

//    @Override
//    public boolean verifyUser(String email, String password) {
//        User user = UserIdentityMapUtil.getUserByEmail(email);
//        try {
//            if (user == null) {
//                // get the object from databas
//                user = findUserByEmailFromAgent(email);
//                if (user == null) {
//                    user = findUserByEmailFromClient(email);
//                }
//            }
//            if (user == null) {
//                return false;
//            } else {
//                UserIdentityMapUtil.addToUserEmailMap(user);
//                UserIdentityMapUtil.addToUserIDMap(user);
//                return password.equals(user.getPassword());
//            }
//        } catch (SQLException e) {
//            System.out.println("SQLException");
//        }
//        return false;
//    }

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

    private User findUserByEmailFromClient(String email) throws SQLException {
        String selectStatement = "SELECT * FROM client WHERE email = '" + email + "'";
        PreparedStatement stmt = DBConnection.prepare(selectStatement);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            return getClientHelper(rs);
        }

        return null;
    }

    private User getClientHelper(ResultSet rs) throws SQLException {
        int u_id = rs.getInt(1);
        String u_email = rs.getString(2);
        String u_pw = rs.getString(3);
        String u_name = rs.getString(4);
        return new Client(u_id, u_email, u_pw, u_name);
    }


    private User findUserByEmailFromAgent(String email) throws SQLException {
        String selectStatement = "SELECT * FROM agent WHERE email = '" + email + "'";
        PreparedStatement stmt = DBConnection.prepare(selectStatement);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            return getAgentHelper(rs);
        }

        return null;
    }

    private User getAgentHelper(ResultSet rs) throws SQLException {
        int u_id = rs.getInt(1);
        String u_email = rs.getString(2);
        String u_pw = rs.getString(3);
        String u_phone = rs.getString(4);
        String u_company_name = rs.getString(5);
        String u_company_address = rs.getString(6);
        String u_company_website = rs.getString(7);
        String u_bio = rs.getString(8);
        String u_name = rs.getString(9);

        return new Agent(u_id,u_email,u_pw,u_name,u_phone,u_bio, u_company_name,
                u_company_address, u_company_website);
    }


    @Override
    public List<User> getUserByName(String name) {
        return null;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }
}
