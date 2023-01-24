package peaksoft.congiration;

import jakarta.persistence.EntityManagerFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import peaksoft.entity.Laptop;

import java.util.Properties;

/**
 * @author kurstan
 * @created at 24.01.2023 13:35
 */
public class DatabaseConnection {
    public static EntityManagerFactory createEntityManagerFactory(){
        Properties properties = new Properties();
        properties.setProperty(Environment.DRIVER, "org.postgresql.Driver");//"org.hibernate.driver_class"
        properties.setProperty(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
        properties.setProperty(Environment.USER, "postgres");
        properties.setProperty(Environment.PASS, "postgres");
        properties.setProperty(Environment.HBM2DDL_AUTO, "update");
        properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty(Environment.SHOW_SQL, "true");
        properties.setProperty(Environment.FORMAT_SQL, "true");

        Configuration configuration = new Configuration();
        configuration.addProperties(properties);
        configuration.addAnnotatedClass(Laptop.class);

        EntityManagerFactory entityManagerFactory =
                configuration.buildSessionFactory().unwrap(EntityManagerFactory.class);
        return entityManagerFactory;
    }
}
