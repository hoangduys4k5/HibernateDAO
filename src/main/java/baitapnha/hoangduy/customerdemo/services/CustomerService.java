package baitapnha.hoangduy.customerdemo.services;

import java.util.List;

import baitapnha.hoangduy.customerdemo.model.Customer;



public interface CustomerService {
	List<Customer> findAll();

    Customer findById(int id);

    void save(Customer Customer);
    boolean findCustomer(Customer Customer);
    boolean checkCustomer(Customer customer);
}
