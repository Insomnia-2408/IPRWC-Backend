package resource;

import javax.ws.rs.core.Response;
import java.util.List;

public interface Resource<T> {

    List index();
    T getByID(long id);
    Response post(T object);
    Response put(T object);
    Response delete(long id);

}
