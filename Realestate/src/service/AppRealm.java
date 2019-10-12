package service;

import dataSourceLayer.mappers.userMapper.UserMapper;
import models.Agent;
import models.Client;
import models.User;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;

public class AppRealm extends JdbcRealm {
    private UserMapper userMapper = UserMapper.getSelfInstance();

    /**
     * get email from token and find the corresponding user, then create a SimpleAuthenticationInfo storing the user
     * object
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        UsernamePasswordToken userPassToken = (UsernamePasswordToken) token;
        final String email = userPassToken.getUsername();

        final User user = userMapper.getUserByEmail(email);
        if (user == null) {
            System.out.println("No account found for user with email " + email);
            return null;
        }
        return new SimpleAuthenticationInfo(user, user.getPassword(), user.getName());
    }

    /**
     * retrieve user object from the principals, give user corresponding role based on their user type
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo getAuthorizationInfo(PrincipalCollection principals) {
        Set<String> roles = new HashSet<>();
        if(principals.isEmpty()) {
            System.out.println("Given principals to authorize are empty.");
            return null;
        }
        String email = ((User)(principals.getPrimaryPrincipal())).getEmail();
        final User user = userMapper.getUserByEmail(email);

        if (user == null) {
            System.out.println("No account found for user with email " + email);
            return null;
        }

        // add role of the user according to its type
        if(user instanceof Client) {
            roles.add(AppSession.CLIENT_ROLE);
        } else if (user instanceof Agent) {
            roles.add(AppSession.AGENT_ROLE);
        }
        return new SimpleAuthorizationInfo(roles);
    }
}
