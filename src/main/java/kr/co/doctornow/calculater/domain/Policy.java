package kr.co.doctornow.calculater.domain;

import kr.co.doctornow.calculater.application.Money;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Policy {

    private int id;
    private String rule;
    private Money minimumAmount;
    private Money maximumAmount;
    private double aaa;

    public boolean match(Money money) {
        System.out.println("최소 금액: " + this.minimumAmount.compareTo(money));
        System.out.println("최대 금액: " + this.maximumAmount.compareTo(money));
        return this.minimumAmount.compareTo(money) <= 0 && this.maximumAmount.compareTo(money) > 0;
    }

    public Money calculate(Money money) {
        if (this.rule.equals("absolute")) {
            return new Money(this.aaa);
        }

        return new Money(money.getAmount() * this.aaa);
    }
}
