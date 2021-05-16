package kr.co.doctornow.calculater.application;

import kr.co.doctornow.calculater.domain.FeeCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculateFeeService {

    private FeeCalculator feeCalculator;

    @Autowired
    public CalculateFeeService(FeeCalculator feeCalculator) {
        this.feeCalculator = feeCalculator;
    }

    public Money calculateFee(Money money) throws Exception {
        return this.feeCalculator.calculateFee(money);
    }
}
