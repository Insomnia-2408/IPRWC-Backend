package service;

import persistence.ShoppingcartDAO;

import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.List;

public class ShoppingcartService {

    private final ShoppingcartDAO shoppingcartDAO;

    @Inject
    public ShoppingcartService(ShoppingcartDAO shoppingcartDAO) {
        this.shoppingcartDAO = shoppingcartDAO;
    }

    public Object getCart(long id) {
        return shoppingcartDAO.getCart(id);
    }

    public Response add(Object object) {
        if(shoppingcartDAO.add(object)) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    public Response delete(Object object) {
        if(shoppingcartDAO.delete(object)) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
