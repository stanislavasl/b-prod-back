package lt.seb.api.services;

import lombok.AllArgsConstructor;
import lt.seb.api.entities.Customer;
import lt.seb.api.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public void createCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> getCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerByIdOptional(Long customerId) {
        return customerRepository.findCustomerById(customerId);
    }

    public Customer getCustomerById(Long customerId) {
        return customerRepository.getById(customerId);
    }

    public Optional<Customer> getCustomerByPersonalCode (Long customerPersonalCode) {
        return customerRepository.findCustomerByPersonalCode(customerPersonalCode);
    }

    public void updateCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void deleteCustomer(Long customerId) {
        customerRepository.deleteById(customerId);
    }
}
