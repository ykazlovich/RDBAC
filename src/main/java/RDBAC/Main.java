package RDBAC;


import RDBAC.model.Order;
import org.apache.cayenne.ObjectContext;
import org.apache.cayenne.configuration.server.ServerRuntime;
import org.apache.cayenne.query.ObjectSelect;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring.xml", "/spring-db.xml");
//        ServerRuntime serverRuntime2 = (ServerRuntime) context.getBean("ServerRuntime");
//
//        //ServerRuntime serverRuntime = (ServerRuntime) context.getBean("serverRuntime");
//
//        ObjectContext objectContext = serverRuntime2.newContext();
//        Order order1 = objectContext.newObject(Order.class);
//
//        objectContext.commitChanges();
//
//        System.out.println(ObjectSelect.query(Order.class).select(objectContext));
        Order order = new Order();

        System.out.println(order.getOrderId());


    }
}
