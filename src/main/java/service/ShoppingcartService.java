package service;

import persistence.ShoppingcartDAO;
import presentation.Product;
import presentation.ProductType;

import javax.inject.Inject;
import javax.ws.rs.core.Response;

public class ShoppingcartService {

    private final ShoppingcartDAO shoppingcartDAO;

    @Inject
    public ShoppingcartService(ShoppingcartDAO shoppingcartDAO) {
        this.shoppingcartDAO = shoppingcartDAO;
    }

    public Object getCart(long id) {
        return shoppingcartDAO.getCart(id);
    }

    public Response add(long clientID, Product product) {

        if(shoppingcartDAO.add(clientID, product)) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    public Response delete(long clientID, Product product) {

        if(shoppingcartDAO.delete(clientID, product)) {
            return Response.ok().build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

}
