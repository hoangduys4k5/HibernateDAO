package baitapnha.hoangduy.customerdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import baitapnha.hoangduy.customerdemo.model.Customer;
import baitapnha.hoangduy.customerdemo.services.CustomerService;

@Controller
public class CustomerController {
	@Autowired
    public CustomerService CustomerService;

    @GetMapping("/customers")
    public ModelAndView list(){
        List<Customer> Customers = this.CustomerService.findAll();
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customers", Customers);
        return modelAndView;
    }

    @GetMapping("/new")
    public ModelAndView showCreateForm(){
        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", new Customer());
        return modelAndView;
    }

    @PostMapping("/new")
    public ModelAndView createCustomer(@ModelAttribute("customer") Customer customer){
        int randomId = (int)(Math.random() * 10000);
        customer.setId(randomId);//For demo purpose only

        this.CustomerService.save(customer);

        ModelAndView modelAndView = new ModelAndView("customer/create");
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New Customer was created");
        return modelAndView;
    }

    @GetMapping(value = "/view")
    public ModelAndView view(@RequestParam("id") Integer CustomerId){
        Customer Customer = this.CustomerService.findById(CustomerId);
        ModelAndView modelAndView = new ModelAndView("customer/view");
        modelAndView.addObject("customer", Customer);
        return modelAndView;
    }
	  @GetMapping({"/","/login"}) 
	  public ModelAndView login(){
	  ModelAndView modelAndView = new ModelAndView("customer/login");
      modelAndView.addObject("customer", new Customer());
      return modelAndView;
	  }
	  @PostMapping(value = "/login") 
	  public ModelAndView check(@ModelAttribute("customer") Customer customer){
		boolean check = this.CustomerService.findCustomer(customer);
		  if(check == true) {
			  return list();
		  }else {
			  ModelAndView modelAndView = new ModelAndView("customer/login");
		        modelAndView.addObject("customer", new Customer());
		        modelAndView.addObject("message", "UserName or Password is not exists");
			  return modelAndView;
		  }
	  }
	  @GetMapping(value = "/register") 
	  public ModelAndView registerForm(){ 
		  ModelAndView modelAndView = new ModelAndView("customer/register");
	      modelAndView.addObject("customer", new Customer());
	      return modelAndView;
	  }
	  @PostMapping(value = "/register") 
	  public ModelAndView register(@ModelAttribute("customer") Customer customer){
		boolean check = this.CustomerService.checkCustomer(customer);
		  if(check == true) {
			  int randomId = (int)(Math.random() * 10000);
		        customer.setId(randomId);//For demo purpose only

		        this.CustomerService.save(customer);

		        ModelAndView modelAndView = new ModelAndView("customer/login");
		        modelAndView.addObject("customer", new Customer());
		        modelAndView.addObject("message", "New Customer was created");
		        return modelAndView;
		  }else {
			  ModelAndView modelAndView = new ModelAndView("customer/login");
		        modelAndView.addObject("customer", new Customer());
		        modelAndView.addObject("message", "UserName already exists");
			  return modelAndView;
		  }
		
	  }
	 
}
