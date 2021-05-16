package kr.co.doctornow.calculater.domain;

import kr.co.doctornow.calculater.application.Money;

import java.util.ArrayList;
import java.util.List;

public class PolicySelector {

    private List<Policy> policies = new ArrayList<>();

    public PolicySelector() {
        Policy policy1 = new Policy();
        policy1.setId(1);
        policy1.setRule("absolute");
        policy1.setMinimumAmount(new Money(0));
        policy1.setMaximumAmount(new Money(10000));
        policy1.setAppliedAmount(1000);

        Policy policy2 = new Policy();
        policy2.setId(1);
        policy2.setRule("percent");
        policy2.setMinimumAmount(new Money(10000));
        policy2.setMaximumAmount(new Money(99999));
        policy2.setAppliedAmount(0.1);

        this.policies.add(policy1);
        this.policies.add(policy2);
    }

     public Policy selectPolicy(Money money) {
         for (Policy policy : this.policies) {
             if (policy.match(money)) {
                 return policy;
             }
         }
         return null;
     }
}
