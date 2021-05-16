package kr.co.doctornow.calculater.domain;

import kr.co.doctornow.calculater.application.Money;
import kr.co.doctornow.calculater.infrastructure.PolicyMockRepository;

import java.util.ArrayList;
import java.util.List;

public class PolicySelector {

    private PolicyRepository policyRepository = new PolicyMockRepository();

     public Policy selectPolicy(Money money) {
         for (Policy policy : this.policyRepository.findAll()) {
             if (policy.match(money)) {
                 return policy;
             }
         }
         return null;
     }
}
