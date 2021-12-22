package baitapnha.hoangduy.customerdemo.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import baitapnha.hoangduy.customerdemo.model.Customer;
import baitapnha.hoangduy.customerdemo.repository.CustomerRepository;

public class CustomerRepositoryImpl implements CustomerRepository {

    private static final Map<Integer, Customer> Customers;

    static {
        Customers = new HashMap<>();
        Customers.put(1, new Customer(1,"hoangduy","123","Vo Duc Hoang Duy",20,"1 Nguyen Tri Phuong"));
        Customers.put(2, new Customer(2,"voduc","123","Vo Duc",21,"2 Ham Nghi"));
        Customers.put(3, new Customer(3,"duyhoang","123","Vo Duc Duy Hoang",22,"3 Tran Cao Van"));
        Customers.put(4, new Customer(4,"duyvo","123","Duy Vo",23,"4 Nguyen Van Linh"));
        Customers.put(5, new Customer(5,"voduy","123","Vo Duy",24,"5 Dien Bien Phu"));
        Customers.put(6, new Customer(6,"ducduy","123","Vo Hoang Duc Duy",25,"6 Bach Dang"));
    }

    @Override
    public List<Customer> findAll() {
        return new ArrayList<>(Customers.values());
    }

    @Override
    public Customer findById(int id) {
        Customer Customer = Customers.get(id);
        return Customer;
    }

    @Override
    public void save(Customer Customer) {
        Customers.put(Customer.getId(), Customer);
    }

	@Override
	public boolean findCustomer(Customer customer) {
		// TODO Auto-generated method stub
		boolean a = false;
		
		for(Map.Entry<Integer, Customer> item : Customers.entrySet()) {
			if(item.getValue().getUserName().toString().equals(customer.getUserName().toString())
			&& item.getValue().getPassWord().toString().equals(customer.getPassWord().toString())) {
			a = true;
			break;
			}
		}
		return a;
	}

	@Override
	public boolean checkCustomer(Customer customer) {
		// TODO Auto-generated method stub
			boolean a = true;
		
		for(Map.Entry<Integer, Customer> item : Customers.entrySet()) {
			if(item.getValue().getUserName().toString().equals(customer.getUserName().toString())) {
			a = false;
			break;
			}
		}
		return a;
	}

	@Override
	public void deleteById(int id) {
		 Customers.remove(id);
	}

	@Override
	public void edit(Customer customer) {	
		Customers.replace(customer.getId(), customer);
	}
}
