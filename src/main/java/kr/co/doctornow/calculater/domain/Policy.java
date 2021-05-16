package kr.co.doctornow.calculater.domain;

import kr.co.doctornow.calculater.application.Money;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor
public class Policy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String rule;

    @Column(nullable = false)
    private double minimumAmount;

    @Column(nullable = false)
    private double maximumAmount;

    @Column(nullable = false)
    private double appliedAmount;

    public boolean match(Money money) {
        return this.minimumAmount <= money.getAmount() && this.maximumAmount > money.getAmount();
    }

    public Money calculate(Money money) {
        if (this.rule.equals("absolute")) {
            return new Money(this.appliedAmount);
        }
        return new Money(money.getAmount() * this.appliedAmount);
    }
}
