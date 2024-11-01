package edu.icet.controller;

import edu.icet.dto.Customer;
import edu.icet.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@CrossOrigin
public class CustomerController {
    @Autowired
    CustomerService service;
    @GetMapping("/get-all")
    public List<Customer> getCustomer(){
        return service.getall();
    }
    @PostMapping("/add-customer")
    @ResponseStatus(HttpStatus.CREATED)
    public void addCustomer(@RequestBody Customer customer){
        service.addCustomer(customer);
    }
    @GetMapping("/search-by-id/{id}")
    public Customer searchCustomer(@PathVariable Integer id){
        return service.searchCustomerById(id);
    }
    @PutMapping("/update-customer")
    public void updateCustomer(@RequestBody Customer customer){
        service.updateCustomerById(customer);
    }
    @DeleteMapping("/delete-by-id/{id}")
    public void deleteCustomer(@PathVariable Integer id){
        service.deleteCustomerById(id);
    }
}
