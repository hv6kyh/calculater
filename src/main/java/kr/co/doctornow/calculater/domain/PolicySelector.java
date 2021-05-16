package kr.co.doctornow.calculater.domain;

import kr.co.doctornow.calculater.application.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicySelector {

    private PolicyRepository policyRepository;

    @Autowired
    public PolicySelector(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

     public Policy selectPolicy(Money money) {
         for (Policy policy : this.policyRepository.findAll()) {
             if (policy.match(money)) {
                 return policy;
             }
         }
         return null;
     }
}
