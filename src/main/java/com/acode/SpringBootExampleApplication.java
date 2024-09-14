package com.acode;

import lombok.Data;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("api/v1/customers")
public class SpringBootExampleApplication {

	//* 4
	private final CustomerRepository
					customerRepository;

	public SpringBootExampleApplication(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootExampleApplication.class, args);
	}

	//* 1
//	@GetMapping("/")
//	@GetMapping("/greet")
//	public String greet(String name) {
//		return "Hello " + name + "!";
//	}

	//* 2
	@GetMapping("/greet")
	public GreetResponse greet() {
		//return new GreetResponse("Hello World!");
		//* 3
		GreetResponse response = new GreetResponse(
						"Hello World!",
						List.of("JAVA", "GOLANG", "JAVASCRIPT"),
						new Person("Alex", 28, 30_000)
		);
		return response;
	}

	record Person(String name, int age, double savings) {}

	record GreetResponse(
					String greet,
					List<String> favProgLanguages,
					Person person
	) {}

//	@Data
//	class GreetResponse {
//		private final String greet;
//	}

	//* 3
	@GetMapping
	public List<Customer> getCustomers() {
//		return List.of();
		return customerRepository.findAll();
	}

	//* 4
	record NewCustomerRequest(
					String name,
					String email,
					Integer age
	) {}

	@PostMapping
	public void addCustomer(@RequestBody NewCustomerRequest request) {
		Customer customer = new Customer();
		customer.setName(request.name);
		customer.setEmail(request.email());
		customer.setAge(request.age());
		customerRepository.save(customer);
	}

	@DeleteMapping("{customerId}")
	public void deleteCustomer(@PathVariable("customerId") Integer id) {
		customerRepository.deleteById(id);
	}

	@PutMapping("{customerId}")
	public void updateCustomer(@PathVariable("customerId") Integer id,
	                           @RequestBody NewCustomerRequest request) {
		// Find the customer by ID or create a new one if not found
//	Customer customer = customerRepository.findById(id).orElse(new Customer());

		Customer customer = customerRepository.findById(id).orElse(null);
		if (customer == null) {
			customer = new Customer();
		} else {
			customer.setName(request.name);
		}

		customer.setEmail(request.email());
		customer.setAge(request.age());
		customerRepository.save(customer);
	}
}
