package baitapnha.hoangduy.customerdemo.dao;

import java.util.List;

import baitapnha.hoangduy.customerdemo.entity.Customer;



public interface CustomerDAO {

	public List<Customer> findAll();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);

	public void deleteCustomer(int theId);
	public boolean findCustomer(Customer customer);
	public boolean checkCustomer(Customer customer);
	
}
