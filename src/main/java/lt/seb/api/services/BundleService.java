package lt.seb.api.services;

import lombok.AllArgsConstructor;
import lt.seb.api.entities.Bundle;
import lt.seb.api.entities.Customer;
import lt.seb.api.entities.dto.BundleDTO;
import lt.seb.api.repositories.BundleRepository;
import lt.seb.api.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BundleService {
    private static final Long ID = 2L;
    private final BundleRepository bundleRepository;
    private final ProductRepository productRepository;
    private final RulesService rulesService;
    private final CustomerService customerService;

    public BundleDTO createBundle(Long customerId){
        BundleDTO bundleDTO = new BundleDTO();
        Optional<Customer> customer = customerService.getCustomerByIdOptional(customerId);

        if(customer.isPresent() && customer.get().getIsStudent()){
            bundleDTO = BundleDTO.builder()
                    .bundleName(bundleRepository.getById(ID).getBundleName())
                    .accountName(productRepository.getById(bundleRepository.getById(ID).getAccount()).getProductName())
                    .creditCardName(productRepository.getById(bundleRepository.getById(ID).getCreditCard()).getProductName())
                    .debitCardName(productRepository.getById(bundleRepository.getById(ID).getDebitCard()).getProductName())
                    .build();
        }

        var level = 0;
        if(customer.isPresent()){
            level = rulesService.getLevelForCustomer(customer.get());
        }
        Bundle bundle = bundleRepository.findBundleByValue(level, ID);
        if(customer.isPresent() && !customer.get().getIsStudent()){
           bundleDTO = BundleDTO.builder()
                    .bundleName(bundle.getBundleName())
                    .accountName(productRepository.getById(bundle.getAccount()).getProductName())
                    .creditCardName(productRepository.getById(bundle.getCreditCard()).getProductName())
                    .debitCardName(productRepository.getById(bundle.getDebitCard()).getProductName())
                    .build();
        }
        return bundleDTO;
    }
}
