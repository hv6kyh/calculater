package kr.co.doctornow.calculater.domain;

import kr.co.doctornow.calculater.application.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeeCalculator {

    private PolicySelector policySelector;

    @Autowired
    public FeeCalculator(PolicySelector policySelector) {
        this.policySelector = policySelector;
    }

    public Money calculateFee(Money money) throws Exception {
        Policy policy = this.policySelector.selectPolicy(money);
        if (policy == null) {
            throw new Exception("적용 가능한 수수료 정책이 없습니다.");
        }
        Money fee = policy.calculate(money);
        return money.minus(fee);
    }
}
