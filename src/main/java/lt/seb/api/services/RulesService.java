package lt.seb.api.services;

import lt.seb.api.entities.Customer;
import org.springframework.stereotype.Service;

@Service
public class RulesService {

    public Integer getLevelForCustomer(Customer customer){
        return Math.min(Math.min(ageRules((customer.getAge())), incomeRules(customer.getAnnualIncome())), studentRules(customer.getIsStudent()));
    }

    public Integer ageRules(Integer customerAge){
        return customerAge < 18 ? 0 : 3;
    }

    public Integer incomeRules(Long customerIncome) {
        return customerIncome > 40000 ? 3 : customerIncome > 12000 ? 2 : customerIncome > 0 ? 1 : 0;
    }

    public Integer studentRules(Boolean isStudent){
        return isStudent ? 0 : 3;
    }

}
