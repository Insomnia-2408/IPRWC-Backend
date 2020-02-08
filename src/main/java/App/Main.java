package App;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.forms.MultiPartBundle;
import io.dropwizard.jersey.jackson.JsonProcessingExceptionMapper;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import persistence.AuthenticationDAO;
import persistence.CarDAO;
import persistence.ShoppingcartDAO;
import persistence.UserDAO;
import presentation.User;
import resource.AuthenticationResource;
import resource.CarResource;
import resource.ShoppingcartResource;
import resource.UserResource;
import ru.vyarus.dropwizard.guice.GuiceBundle;
import service.AuthenticationService;
import service.CarService;
import service.ShoppingcartService;
import service.UserService;
import util.DatabaseConnector;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.sql.DataSource;
import java.util.EnumSet;

public class Main extends Application<ApiConfiguration> {

    public static void main(String[] args) throws Exception {
        new Main().run(args);
    }

    @Override
    public String getName() {
        return "webshop";
    }

    @Override
    public void initialize(Bootstrap<ApiConfiguration> bootstrap) {
        System.out.println(
                getClass().getPackage()
        );
        bootstrap.addBundle(new MultiPartBundle());
        bootstrap.addBundle(GuiceBundle.builder()
                .enableAutoConfig(getClass().getPackage().getName())
                .build());

        bootstrap.addBundle(new MigrationsBundle<ApiConfiguration>() {
            @Override
            public DataSourceFactory getDataSourceFactory(ApiConfiguration configuration) {
                return configuration.getDataSourceFactory();
            }
        });

    }

    @Override
    public void run(ApiConfiguration config, Environment environment) {

        DataSourceFactory factory = config.getDataSourceFactory();
        DataSource dataSource = factory.build(environment.metrics(), "webshop");

        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);
        // Configure CORS parameters
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin,token");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        environment.jersey().packages("app.resource");

        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        new DatabaseConnector();
        DatabaseConnector.getInstance().setDataSource(dataSource);

        registerInjections(environment);

    }

    private void registerInjections(Environment environment) {

        UserDAO userDAO = new UserDAO();
        AuthenticationDAO authenticationDAO = new AuthenticationDAO();
        AuthenticationService authenticationService = new AuthenticationService(authenticationDAO, userDAO);

        environment.jersey().register(new JsonProcessingExceptionMapper(true));

        environment.jersey().register(
                new AuthenticationResource(authenticationService)
        );

        environment.jersey().register(
                new CarResource(
                        new CarService(
                                new CarDAO()
                        ),
                        authenticationService
                )
        );

        environment.jersey().register(
                new ShoppingcartResource(
                        new ShoppingcartService(
                                new ShoppingcartDAO()
                        ),
                        authenticationService
                )
        );

        environment.jersey().register(
                new UserResource(
                        new UserService(userDAO, authenticationDAO),
                        authenticationService
                )
        );

    }

}
