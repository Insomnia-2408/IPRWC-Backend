package persistence;

import javax.ws.rs.core.Response;
import java.util.List;

public interface DAO<T> {

    List list();
    T getByID(long id);
    boolean deleteByID(long id);
    boolean update(T object);
    boolean post(T object);

}
