package resource;

import java.util.List;

public interface Resource {

    List index();
    Object post();
    Object getByID(long id);
    Object put();
    Object delete();

}
