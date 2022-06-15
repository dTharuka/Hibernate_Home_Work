
package lk.ijse.hibernate.util;

import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.entity.Item;
import lk.ijse.hibernate.entity.Order;
import lk.ijse.hibernate.entity.OrderDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FactoryConfiguration {

    private static FactoryConfiguration factoryConfiguration;
    private final SessionFactory sessionFactory;

private FactoryConfiguration(){
    Configuration configuration = new Configuration().configure()
            .addAnnotatedClass(Customer.class)
            .addAnnotatedClass(Item.class)

            .addAnnotatedClass(Order.class)
            .addAnnotatedClass(OrderDetails.class);

    sessionFactory = configuration.buildSessionFactory();
}

    public static FactoryConfiguration getInstance() {
        return (factoryConfiguration == null) ? factoryConfiguration = new FactoryConfiguration()
                : factoryConfiguration;
    }
    public Session getSession() {
        return sessionFactory.openSession();
    }

}
