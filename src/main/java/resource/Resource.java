package resource;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.core.Response;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface Resource<T> {

    @GET
    List index(String token);

    @GET
    T getByID(String token, long id);

    @POST
    Response post(String token, T object) throws NoSuchAlgorithmException;

    @PUT
    Response put(String token, T object);

    @DELETE
    Response delete(String token, long id);

}
