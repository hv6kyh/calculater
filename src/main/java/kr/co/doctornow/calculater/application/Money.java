package kr.co.doctornow.calculater.application;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Money implements Comparable<Money>{
    private double amount;

    public Money(double amount) {
        this.amount = amount;
    }

    public Money minus(Money money) {
         this.setAmount(this.getAmount() - money.getAmount());
         return this;
    }

    @Override
    public int compareTo(Money o) {
        return (int)(this.getAmount() - o.getAmount());
    }
}
