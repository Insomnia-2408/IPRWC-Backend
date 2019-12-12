package service;

import persistence.AuthenticationDAO;
import persistence.UserDAO;
import presentation.Credentials;
import presentation.User;
import presentation.UserRole;
import util.Verification;

import javax.inject.Inject;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.core.Response;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.UUID;

public class AuthenticationService {

    private final AuthenticationDAO authenticationDAO;
    private final UserDAO userDAO;

    @Inject
    public AuthenticationService(AuthenticationDAO authenticationDAO, UserDAO userDAO) {
        this.authenticationDAO = authenticationDAO;
        this.userDAO = userDAO;
    }

    public long checkToken(String token) {

        long clientID = authenticationDAO.getTokenUser(token);

        if(clientID != 0) {
            return clientID;
        } else {
            return 0;
        }
    }

    public Response onLogin(@NotNull Credentials credentials) throws NoSuchAlgorithmException {

        User user = null;

        if(Verification.verifyEmail(credentials.getEmail())) {
            user = userDAO.getAuthorization(credentials);
            return verifyFoundUser(user);
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

    }

    private Response verifyFoundUser(User user) {

        if(user != null && user.getUserRole() != UserRole.UNVERIFIED) {
            String token = createToken();
            authenticationDAO.setToken(user.getClientID(), token);
            return Response.ok(token).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    public String createToken() {

        String token = UUID.randomUUID().toString().toUpperCase()
                + "|" + "clientID" + "|"
                + new Date();

        return token;
    }

    public boolean isAuthorized(String token, UserRole userRole) {

        long clientID = checkToken(token);
        User user = userDAO.getByID(clientID);
        return user.getUserRole().equals(userRole);

    }

}
