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

    public Response onLogin(@NotNull Credentials credentials) {

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
            return Response.ok().build();
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

}
