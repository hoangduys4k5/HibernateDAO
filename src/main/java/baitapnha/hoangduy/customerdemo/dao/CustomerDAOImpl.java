package baitapnha.hoangduy.customerdemo.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import baitapnha.hoangduy.customerdemo.entity.Customer;


@Transactional
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> findAll() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Customer> cq = cb.createQuery(Customer.class);
		Root<Customer> root = cq.from(Customer.class);
		cq.select(root);
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	@Override
	public void deleteCustomer(int id) {
		Session session = sessionFactory.getCurrentSession();
		Customer book = session.byId(Customer.class).load(id);
		session.delete(book);
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Customer theCustomer = currentSession.get(Customer.class, theId);
		return theCustomer;
	}

	@Override
	public boolean findCustomer(Customer customer) {
		Session currentSession = sessionFactory.getCurrentSession();
		List<Customer> query = findAll();
		for(Customer a : query) {
			if(a.getUserName().equals(customer.getUserName()) && a.getPassWord().equals(customer.getPassWord())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean checkCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return false;
	}
}
