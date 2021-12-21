package baitapnha.hoangduy.customerdemo.repository;

import java.util.List;

import baitapnha.hoangduy.customerdemo.model.Customer;



public interface CustomerRepository {
	  List<Customer> findAll();

	    Customer findById(int id);

	    void save(Customer customer);
	    
	    boolean findCustomer(Customer customer);
	    boolean checkCustomer(Customer customer);
}
