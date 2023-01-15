package lt.seb.api.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import lt.seb.api.entities.Customer;
import lt.seb.api.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@AllArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @Operation(description = "Endpoint for getting all customers")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getCustomers(){
        return customerService.getCustomers();
    }

    @Operation(description = "Endpoint for getting the customer by his id")
    @GetMapping(value = "/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer getCustomer(@PathVariable("customerId") Long customerId){
        return customerService.getCustomerById(customerId);
    }
    @Operation(description = "Endpoint for customer creation")
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createCustomer(@RequestBody Customer customer) {
        customerService.createCustomer(customer);
    }

    @Operation(description = "Endpoint for uptating customer information")
    @PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateCustomer(@RequestBody Customer customer) {
        customerService.updateCustomer(customer);
    }

    @Operation(description = "Endpoint for customer deletion")
    @DeleteMapping(value = "/delete/{customerId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCustomer(@PathVariable("customerId") Long customerId) {
        customerService.deleteCustomer(customerId);
    }
}
