package resource;

import java.util.List;

public interface Resource {

    List index();
    Object post();
    Object get();
    Object put();
    Object delete();

}
