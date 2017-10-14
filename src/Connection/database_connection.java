package Connection;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class database_connection {
	
	public static void main(String args[]) {
		
			/*Session session= new Configuration().configure().buildSessionFactory().getCurrentSession();
		
			Transaction tx = session.beginTransaction();
			Credenziali res= session.load(Credenziali.class, 0);
			tx.commit();
			System.out.println(res.getPassword());
			session.close();*/
	
			Configuration configuration = new Configuration().configure();
	        ServiceRegistry registry = new StandardServiceRegistryBuilder()
	                .applySettings(configuration.getProperties())
	                .build();
	        SessionFactory sessionFactory = configuration
	                .addAnnotatedClass(Credenziali.class)
	                .buildSessionFactory(registry);
	        Session session = sessionFactory.openSession();

	        session.beginTransaction();
	        //Credenziali res = (Credenziali) session.get(Credenziali.class, 0);
	        //System.out.println(res.getPassword());
	        @SuppressWarnings("unchecked")
			List<Credenziali> res = session.createQuery("FROM Credenziali WHERE email=:email and password=:password").setString("email", "admin@admin.com").setString("password", "12345678").list();
	        for(Credenziali credenziali : res) 
	        	System.out.println(credenziali);
	        session.close();
	}
}