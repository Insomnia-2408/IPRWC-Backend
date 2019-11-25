package service;

import java.util.List;

public interface Service {

    List list();
    Object getByID();
    Object deleteByID();
    Object update();

}
