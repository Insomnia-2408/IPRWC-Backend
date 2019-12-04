package App;

import io.dropwizard.Application;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.forms.MultiPartBundle;
import io.dropwizard.migrations.MigrationsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import ru.vyarus.dropwizard.guice.GuiceBundle;

import javax.sql.DataSource;

public class Main extends Application<ApiConfiguration> {

    public static void main(String[] args) throws Exception {
        new Main().run(args);
    }

    @Override
    public String getName() {
        return "Webshop";
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
        DataSource dataSource = factory.build(environment.metrics(), "webshop-datasource");

    }

}
