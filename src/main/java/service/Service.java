package service;

import java.util.List;

public interface Service {

    List list();
    Object getByID(long id);
    Object deleteByID();
    Object update();

}
