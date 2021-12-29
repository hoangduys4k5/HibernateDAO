package baitapnha.hoangduy.customerdemo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import baitapnha.hoangduy.customerdemo.dao.CustomerDAO;
import baitapnha.hoangduy.customerdemo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public List<Customer> findAll() {
        return this.customerDAO.findAll();
    }

    @Override
    public Customer findById(int id) {
        return this.customerDAO.getCustomer(id);
    }

    @Override
    public void save(Customer Customer) {
        this.customerDAO.saveCustomer(Customer);
    }
    @Override
    public boolean findCustomer(Customer Customer) {
    	
        return this.customerDAO.findCustomer(Customer);
    }

	@Override
	public boolean checkCustomer(Customer customer) {
		// TODO Auto-generated method stub
		 return this.customerDAO.checkCustomer(customer);
	}

	@Override
	public void deleteById(int id) {
		this.customerDAO.deleteCustomer(id);
		
	}

	@Override
	public void edit(Customer customer) {
		this.customerDAO.saveCustomer(customer);
		
	}
	
    
  
}