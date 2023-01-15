package lt.seb.api.services;

import lombok.AllArgsConstructor;
import lt.seb.api.entities.Bundle;
import lt.seb.api.entities.Customer;
import lt.seb.api.entities.dto.BundleDTO;
import lt.seb.api.repositories.BundleRepository;
import lt.seb.api.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BundleService {
    private final BundleRepository bundleRepository;
    private final ProductRepository productRepository;
    private final RulesService rulesService;
    private final CustomerService customerService;

    public BundleDTO showBundle(Long customerId) {
       Bundle bundle = createBundle(customerId);
       return BundleDTO.builder()
               .bundleName(bundle.getBundleName())
               .accountName(productRepository.getById(bundle.getAccount()).getProductName())
               .creditCardName(checkIsNull(bundle).get(0))
               .debitCardName(checkIsNull(bundle).get(1))
               .build();
    }

    public Bundle createBundle(Long customerId) {
        Bundle bundle = new Bundle();
        var level = 0;

        Optional<Customer> customer = customerService.getCustomerByIdOptional(customerId);

        if (customer.isPresent()) {
            if (customer.get().getIsStudent()) {
               bundle = bundleRepository.getById(2L);
            }
            level = rulesService.getLevelForCustomer(customer.get());
            bundle = level == 0 ? bundleRepository.getById(1L) : bundleRepository.findBundleByValue(level);
        }
        return bundle;
    }

    private List<String> checkIsNull(Bundle bundle) {
        List<String> listOfValues = new ArrayList<>();

        var creditCardId = Objects.isNull(bundle.getCreditCard()) ? null : bundle.getCreditCard();
        var creditCard = Objects.isNull(creditCardId) ? null : productRepository.getById(creditCardId).getProductName();
        listOfValues.add(creditCard);

        var debitCardId = Objects.isNull(bundle.getDebitCard()) ? null : bundle.getDebitCard();
        var debitCard = Objects.isNull(debitCardId) ? null : productRepository.getById(debitCardId).getProductName();
        listOfValues.add(debitCard);

        return listOfValues;
    }

    public List<Bundle> getBundles() {
        return bundleRepository.findAll();
    }
}

