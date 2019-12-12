package resource;

import presentation.User;
import service.UserService;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class UserResource implements Resource<User> {

    private final UserService service;

    @Inject
    public UserResource(UserService userService) {
        this.service = userService;
    }


    public List index() {
        return service.list();
    }

    public User getByID(long id) {
        return service.getByID(id);
    }

    public Response post(User user) throws NoSuchAlgorithmException {
        return service.create(user);
    }

    public Response put(User user) {
        return service.update(user);
    }

    public Response delete(long id) {
        return service.deleteByID(id);
    }
}
