package service;

import javax.ws.rs.core.Response;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public interface Service<T> {

    List list();
    T getByID(long id);
    Response create(T object) throws NoSuchAlgorithmException;
    Response update(T object);
    Response deleteByID(long id);

}
