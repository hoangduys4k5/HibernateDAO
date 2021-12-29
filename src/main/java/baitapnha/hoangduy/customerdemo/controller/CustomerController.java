package baitapnha.hoangduy.customerdemo.controller;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;

import javax.naming.Binding;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import baitapnha.hoangduy.customerdemo.entity.Customer;
import baitapnha.hoangduy.customerdemo.services.CustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public ModelAndView list() {
		List<Customer> Customers = this.customerService.findAll();
		ModelAndView modelAndView = new ModelAndView("customer/list");
		modelAndView.addObject("customers", Customers);
		return modelAndView;
	}

	@GetMapping("/new")
	public ModelAndView showCreateForm() {
		ModelAndView modelAndView = new ModelAndView("customer/create");
		modelAndView.addObject("customer", new Customer());
		return modelAndView;
	}

	@PostMapping("/new")
	public ModelAndView createCustomer(@ModelAttribute("customer") Customer customer) {
//		int randomId = (int) (Math.random() * 10000);
//		customer.setId(randomId);// For demo purpose only

		this.customerService.save(customer);

		ModelAndView modelAndView = new ModelAndView("customer/create");
		modelAndView.addObject("customer", new Customer());
		modelAndView.addObject("message", "New Customer was created");
		return modelAndView;
	}

	@GetMapping(value = "/view")
	public ModelAndView view(@RequestParam("id") Integer CustomerId) {
		Customer Customer = this.customerService.findById(CustomerId);
		ModelAndView modelAndView = new ModelAndView("customer/view");
		modelAndView.addObject("customer", Customer);
		return modelAndView;
	}

	@GetMapping({ "/", "/login" })
	public ModelAndView login() {
		ModelAndView modelAndView = new ModelAndView("customer/login");
		modelAndView.addObject("customer", new Customer());
		return modelAndView;
	}

	@PostMapping(value = "/login")
	public ModelAndView check(@Valid @ModelAttribute("customer") Customer customer, BindingResult theBindingResult) {
		boolean check = this.customerService.findCustomer(customer);

		ModelAndView modelAndView = new ModelAndView("redirect:/customers");
		if (theBindingResult.hasErrors()) {
			modelAndView.setViewName("customer/login");

			return modelAndView;
		} else if (check == false) {
			return modelAndView;
		} else {
			modelAndView.setViewName("customer/login");
			modelAndView.addObject("customer", new Customer());
			modelAndView.addObject("message", "UserName or Password is not exists");
			return modelAndView;
		}

	}

	@GetMapping(value = "/register")
	public ModelAndView registerForm() {
		ModelAndView modelAndView = new ModelAndView("customer/register");
		modelAndView.addObject("customer", new Customer());
		return modelAndView;
	}

	@PostMapping(value = "/register")
	public ModelAndView register(@Valid @ModelAttribute("customer") Customer customer, BindingResult theBindingResult) {
		boolean check = this.customerService.checkCustomer(customer);
		ModelAndView modelAndView = new ModelAndView("redirect:/customers");
		if (theBindingResult.hasErrors()) {
			modelAndView.setViewName("customer/edit");			
			return modelAndView;
		}
		else {
		if (check == true) {
			int randomId = (int) (Math.random() * 10000);
			customer.setId(randomId);// For demo purpose only

			this.customerService.save(customer);

			modelAndView.setViewName("customer/login");
			modelAndView.addObject("customer", new Customer());

			modelAndView.addObject("message", "New Customer was created");
			return modelAndView;
		} else {
			modelAndView.setViewName("customer/login");
			modelAndView.addObject("customer", new Customer());
			modelAndView.addObject("message", "UserName already exists");
			return modelAndView;
		}
		}
	}
	@GetMapping(value = "/delete")
	public ModelAndView delete(@RequestParam("id") Integer CustomerId) {
		Customer Customer = this.customerService.findById(CustomerId);
		ModelAndView modelAndView = new ModelAndView("customer/delete");
		modelAndView.addObject("customer", Customer);
		return modelAndView;
	}
	@PostMapping(value = "/deleteconfirm")
	public ModelAndView deleteconfirm(@RequestParam("id") Integer CustomerId) {
		this.customerService.deleteById(CustomerId);
		return list();
	}
	@GetMapping(value = "/edit")
	public ModelAndView edit(@RequestParam("id") Integer CustomerId) {
		Customer Customer = this.customerService.findById(CustomerId);
		ModelAndView modelAndView = new ModelAndView("customer/edit");
		modelAndView.addObject("customer", Customer);
		return modelAndView;
	}
	@PostMapping("/edit")
	public ModelAndView editconfirm(@Valid @ModelAttribute("customer") Customer customer, BindingResult theBindingResult) {
		ModelAndView modelAndView = new ModelAndView("redirect:/customers");
		if (theBindingResult.hasErrors()) {
			modelAndView.setViewName("customer/edit");			
			return modelAndView;
		}
		else {
		this.customerService.edit(customer);
		return list();
	}
	}
}


