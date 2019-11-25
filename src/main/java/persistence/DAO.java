package persistence;

import java.util.List;

public interface DAO {

    List list();
    Object getByID();
    Object deleteByID();
    Object update();

}
