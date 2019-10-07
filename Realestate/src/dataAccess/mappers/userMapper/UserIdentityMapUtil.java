package dataAccess.mappers.userMapper;

import model.User;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chuang Wang
 * @studentID 791793
 * @institution University of Melbourne
 */

/**
 * user identity map
 */
public class UserIdentityMapUtil {
    private static Map<Integer, User> userIDMap = new HashMap<>();
    private static Map<String, User> userEmailMap = new HashMap<>();


    public static void addToUserIDMap(User user) {
        userIDMap.put(user.getId(), user);
    }

    public static User getUserByEmail(String email){
        return userEmailMap.get(email);
    }

    public static void addToUserEmailMap(User user){
        userEmailMap.put(user.getEmail(), user);
    }
}
