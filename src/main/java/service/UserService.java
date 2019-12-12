package service;

import persistence.UserDAO;
import presentation.User;
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

    @Inject
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
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

        if(userDAO.create(user)) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    public Response update(User user) {
        if(userDAO.update(user)) {
            return Response.ok().build();
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
}
