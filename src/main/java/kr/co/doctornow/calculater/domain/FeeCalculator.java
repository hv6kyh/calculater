package kr.co.doctornow.calculater.domain;

import kr.co.doctornow.calculater.application.Money;

public class FeeCalculator {

    private PolicySelector policySelector = new PolicySelector();

    public Money calculateFee(Money money) throws Exception {
        Policy policy = this.policySelector.selectPolicy(money);
        System.out.println("수수료 정책: " + policy.getRule());
        if (policy == null) {
            throw new Exception("적용 가능한 수수료 정책이 없습니다.");
        }
        Money fee = policy.calculate(money);
        return money.minus(fee);
    }
}
