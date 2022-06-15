
package lk.ijse.hibernate;

import lk.ijse.hibernate.entity.Customer;
import lk.ijse.hibernate.entity.Item;
import lk.ijse.hibernate.entity.Order;
import lk.ijse.hibernate.entity.OrderDetails;
import lk.ijse.hibernate.util.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class AppInitializer {
    public static void main(String[] args) {




        Customer c2 = new Customer();
        c2.setCus_id("C002");
        c2.setCus_name("Kamal");
        c2.setCus_address("Galle");
        c2.setCus_contact("071-9043372");

        Item i1 = new Item();
        i1.setItem_code("I001");
        i1.setItem_description("chocolate");
        i1.setItem_price(1200.00);
        i1.setQtyOnHand(100);



        Order o3=new Order();
        o3.setOrderId("O0010");
        o3.setCustomer(c2);
        o3.setPrice(500.00);

        OrderDetails OD3 = new OrderDetails();
        OD3.setId("OD009");
        OD3.setItem(i1);
        OD3.setOrder(o3);
        OD3.setOrderQty(20);




        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        System.out.println(i1.getQtyOnHand());
        session.save(OD3);
//        session.delete(session.get(OrderDetails.class,"OD001"));

        transaction.commit();
        session.close();
    }
}
