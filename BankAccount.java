/**
 * @author johnmichael.gerona
 * @created 1/4/24
 */

import java.math.BigDecimal;

public class BankAccount {
    private BigDecimal balance;

    public BankAccount(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public BigDecimal deposit(BigDecimal amount) throws AmountException {
        if(amount.compareTo(BigDecimal.ZERO) == 0 ||
                amount.compareTo(BigDecimal.ZERO) == -1) {
            throw new AmountException("invalid amount");
        }
        balance = balance.add(amount);
        return balance;
    }

    public BigDecimal withdraw(BigDecimal amount) throws AmountException {
        if(amount.compareTo(BigDecimal.ZERO) == 0 ||
                amount.compareTo(BigDecimal.ZERO) == -1) {
            throw new AmountException("invalid amount");
        }
        if(balance.compareTo(amount) == -1) {
            throw new AmountException("amount exceeds balance");
        }

        balance = balance.subtract(amount);
        return balance;
    }

}
