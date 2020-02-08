package service;

import persistence.AuthenticationDAO;
import persistence.UserDAO;
import presentation.User;
import presentation.UserRole;
import util.Hash;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.List;

public class UserService implements Service<User> {

    private final UserDAO userDAO;
    private final AuthenticationDAO authenticationDAO;

    @Inject
    public UserService(UserDAO userDAO, AuthenticationDAO authenticationDAO) {
        this.userDAO = userDAO;
        this.authenticationDAO = authenticationDAO;
    }

    public List list() {
        return userDAO.list();
    }

    public User getByID(long id) {
        return userDAO.getByID(id);
    }

    public Response create(User user) throws NoSuchAlgorithmException {

        user.setClientID(userDAO.getHighestID() + 1);
        user.setPassword(Hash.hash(user.getPassword()));
        user.setUserRole(UserRole.UNVERIFIED);

        if(!userDAO.checkIfEmailExists(user.getEmail())) {

            if(userDAO.create(user)) {
                return Response.ok().build();
            } else {
                return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
            }

        } else {
            return Response.status(Response.Status.NOT_ACCEPTABLE).build();
        }

    }

    public Response update(User user) {
        if(userDAO.update(user)) {
            return Response.ok(user).build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    public Response deleteByID(long id) {
        if(userDAO.deleteByID(id)) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();

        }
    }

    public Response updateUserData(User user, String token) {
        long clientID = this.authenticationDAO.getUserIDByToken(token);
        if(clientID == user.getClientID()) {
            return this.update(user);
        } else {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }
    }
}
