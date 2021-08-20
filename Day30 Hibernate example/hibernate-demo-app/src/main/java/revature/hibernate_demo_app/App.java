package revature.hibernate_demo_app;

import java.sql.Time;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println( "Project started..." );
        
        // create a configuration object
        Configuration cfg = new Configuration();
        
        // read the configuration and load in the object
        cfg.configure("hibernate.cfg.xml");
        
        // create factory object
        SessionFactory factory = cfg.buildSessionFactory();
        // open the session
        Session session = factory.openSession();
        // being the transaction
        Transaction transaction = session.beginTransaction();
        
        // create employee
        Employee employee = new Employee();
        employee.setId(1);
        employee.setName("Mark");
        employee.setEmail("mark@gmail.com");
                
        // create address
        Address address = new Address();
        address.setCity("city 1");
        address.setStreet("street 1");
        address.setOpen(true);
        address.setCreated(new Date());
        address.setX(123.456);
        
        // save the employee and address
        session.save(employee);
        session.save(address);
        // commit the transaction
        transaction.commit();
        // close the session
        session.close();
        
        
//        System.out.println(factory);
//        System.out.println(factory.isClosed());
    }
}
