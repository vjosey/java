package data;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
// in Artist Bean, we want JAVAX.PERSISTENCE
// in DAO, NO JAVAX.PERSISTENCE, ONLY ORG.HIBERNATE
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import beans.Artist;

public class ArtistDAO {
	
	// Hibernate 3.6
	// Hibernate 4.0+ ServiceRegistry & ServiceRegistryBuilder...
	private SessionFactory sessionFactory = 
			new Configuration().configure().buildSessionFactory();
	
	public void insert(Artist artist) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(artist);
		tx.commit();
		session.close();
	}
	
	public Artist findByName(String name) {
		// Query: HQL.. named parameters
		String hql = "from beans.Artist where name = :pickle";
		Session session = sessionFactory.openSession();
		Query query = session.createQuery(hql);
		query.setString("pickle", name);
		return (Artist) query.uniqueResult();
	}
	
	public List<Artist> searchByName(String name) {
		// Criteria: programmatically create a query
		// Restrictions: WHERE clause; Projections: aggregate function
		Criteria crit = sessionFactory.openSession().createCriteria(Artist.class);
		crit.add(Restrictions.like("name", "%"+name+"%"));
		return crit.list();
	}
	
	public Artist findById(int id) {
		Session session = sessionFactory.openSession();
		// load: throw an exception if the record isn't found by the proxy
		//return (Artist) session.load(Artist.class, id);
		
		// get: returns null (doesn't use a proxy.. query DB and returns object right away)
		return (Artist) session.get(Artist.class, id);
	}
	
	public List<Artist> findAll(){
		return sessionFactory.openSession().createQuery("from Artist").list();
	}
	
}






















