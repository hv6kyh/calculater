package kr.co.doctornow.calculater.application;

import kr.co.doctornow.calculater.domain.FeeCalculator;

public class CalculateFeeService {

    private FeeCalculator feeCalculator = new FeeCalculator();

    public Money calculateFee(Money money) throws Exception {
        Money finalMoney = this.feeCalculator.calculateFee(money);
        return finalMoney;
    }
}
