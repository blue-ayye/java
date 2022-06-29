package com.project.newspaper.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.project.dto.NewspaperDto;
import com.project.newspaper.entity.Newspaper;

@Component
public class NewspaperDAOImpl implements NewspaperDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public NewspaperDAOImpl() {
		System.out.println("NewspaperDAOImpl.NewspaperDAOImpl()");
	}

	@Override
	public boolean saveNewspaperEntity(Newspaper newspaper) {
		System.out.println("NewspaperDAOImpl.saveNewspaperEntity()");
		Session session = null;

		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(newspaper);
			session.getTransaction().commit();
			System.out.println("Newspaper entity saved!");
			return true;
		} catch (HibernateException e) {
			e.getMessage();
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Closed the session");
			} else {
				System.out.println("Session is not closed");
			}
		}
		return false;
	}

	@Override
	public Newspaper getNewspaperEntityByID(int id) {
		System.out.println("NewspaperDAOImpl.getNewspaperEntityByID()");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query query = session.getNamedQuery("Newspaper.getEntityByID");
			query.setParameter("_id", id);
			Newspaper newspaper = (Newspaper) query.uniqueResult();
			if (newspaper != null) {
				System.out.println("Newspapers Found: " + newspaper);
				return newspaper;
			} else {
				System.out.println("Newspapers Not Found");
				return null;
			}
		} catch (HibernateException e) {
			System.out.println("test1");
			e.getMessage();
			System.out.println("test2");
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Connection closed");
			} else {
				System.out.println("Connection not closed");
			}
		}
		return null;
	}

	@Override
	public List<Newspaper> getNewspaperEntitiesByName(String name) {
		System.out.println("NewspaperDAOImpl.getNewspaperEntities()");
		Session session = null;

		try {
			session = sessionFactory.openSession();
			Query query = null;
			query = session.getNamedQuery("Newspaper.getEntitiesByName");
			query.setParameter("_name", name);

			List<Newspaper> newspapers = query.list();
			if (newspapers != null) {
				System.out.println("Newspapers Found: " + newspapers);
				return newspapers;
			} else {
				System.out.println("Newspapers Not Found");
				return null;
			}
		} catch (HibernateException e) {
			e.getMessage();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Closed the session");
			} else {
				System.out.println("Session not closed");
			}
		}
		return null;
	}

	@Override
	public List<Newspaper> getNewspaperEntitiesByPrice(Double price) {
		System.out.println("NewspaperDAOImpl.getNewspaperEntitiesByPrice()");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query query = null;
			query = session.getNamedQuery("Newspaper.getEntitiesByPrice");
			query.setParameter("_price", price);
			List<Newspaper> newspapers = query.list();
			if (newspapers != null) {
				System.out.println("Newspapers Found: " + newspapers);
				return newspapers;
			} else {
				System.out.println("Newspapers Not Found");
				return null;
			}
		} catch (HibernateException e) {
			e.getMessage();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Closed the session");
			} else {
				System.out.println("Session not closed");
			}
		}
		return null;
	}

	@Override
	public List<Newspaper> getNewspaperEntitiesByLanguage(String language) {
		System.out.println("NewspaperDAOImpl.getNewspaperEntitiesByLanguage()");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query query = null;
			query = session.getNamedQuery("Newspaper.getEntitiesByLanguage");
			query.setParameter("_language", language);
			List<Newspaper> newspapers = query.list();
			if (newspapers != null) {
				System.out.println("Newspapers Found: " + newspapers);
				return newspapers;
			} else {
				System.out.println("Newspapers Not Found");
				return null;
			}
		} catch (HibernateException e) {
			e.getMessage();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Closed the session");
			} else {
				System.out.println("Session not closed");
			}
		}
		return null;
	}

	@Override
	public List<Newspaper> getNewspaperEntitiesByNoOfPages(int noOfPages) {
		System.out.println("NewspaperDAOImpl.getNewspaperEntitiesByNoOfPages()");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query query = null;
			query = session.getNamedQuery("Newspaper.getEntitiesByNoOfPages");
			query.setParameter("_noOfPages", noOfPages);
			List<Newspaper> newspapers = query.list();
			if (newspapers != null) {
				System.out.println("Newspapers Found: " + newspapers);
				return newspapers;
			} else {
				System.out.println("Newspapers Not Found");
				return null;
			}
		} catch (HibernateException e) {
			e.getMessage();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Closed the session");
			} else {
				System.out.println("Session not closed");
			}
		}
		return null;
	}

	@Override
	public boolean deleteNewspaperEntityByID(int id) {
		System.out.println("NewspaperDAOImpl.deleteNewspaperEntityByID()");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.getNamedQuery("Newspaper.deleteEntityByID");
			query.setParameter("_id", id);
			System.out.println("News paper with ID: " + id + "was successfully deleted" + query.executeUpdate());
			session.getTransaction().commit();
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.getMessage();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session closed!");
			} else {
				System.out.println("Session Not Closed");
			}
		}
		return false;
	}

	@Override
	public List<Newspaper> getAllNewspaperEntities() {
		System.out.println("NewspaperDAOImpl.getAllNewspaperEntities()");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			Query query = null;
			query = session.getNamedQuery("Newspaper.getAllEntities");
			List<Newspaper> newspapers = query.list();
			if (newspapers != null) {
				System.out.println("Newspapers Found: " + newspapers);
				return newspapers;
			} else {
				System.out.println("Newspapers not found");
				return null;
			}
		} catch (HibernateException e) {
			e.getMessage();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session is closed");
			} else {
				System.out.println("Session is not closed");
			}
		}
		return null;
	}

	@Override
	public boolean updateNewspaperEntityByID(NewspaperDto dto) {
		System.out.println("NewspaperDAOImpl.updateNewspaperEntityByID()");
		Session session = null;
		try {
			session = sessionFactory.openSession();
			session.beginTransaction();
			Query query = session.getNamedQuery("Newspaper.updateEntityByID");
			query.setParameter("_id", dto.getId());
			query.setParameter("_name", dto.getNewspaperName());
			query.setParameter("_price", dto.getPrice());
			query.setParameter("_language", dto.getLanguage());
			query.setParameter("_noOfPages", dto.getNoOfPages());
			query.executeUpdate();
			session.getTransaction().commit();
			return true;
		} catch (HibernateException e) {
			session.getTransaction().rollback();
			e.getMessage();
		} finally {
			if (session != null) {
				session.close();
				System.out.println("Session closed!");
			} else {
				System.out.println("Session Not Closed");
			}
		}
		return false;
	}

}