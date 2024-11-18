package kursachserver;

import kursachserver.models.Account;
import kursachserver.models.PersonInfo;
import kursachserver.models.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class HibSessionFactory {
	private static SessionFactory sessionFactory=null;
	private HibSessionFactory(){}
	public static SessionFactory getSessionFactory(){
		if(sessionFactory==null){
			try{
				Configuration configuration = new Configuration().configure();
				configuration.addAnnotatedClass(Account.class);
				configuration.addAnnotatedClass(PersonInfo.class);
				configuration.addAnnotatedClass(User.class);
				StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
				sessionFactory=configuration.buildSessionFactory(builder.build());

			}catch (Exception ex){
				ex.printStackTrace();
			}

		}
		return sessionFactory;
	}
}
