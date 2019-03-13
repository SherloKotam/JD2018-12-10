package by.it.zagurskaya.project.java.beans;

public class UserEntry implements Entity {
    private long id;
    private long UserOperationId;
    private long sprEntryId;
    private long currencyId;
    private String accountDebit;
    private String accountCredit;
    private double sum;
    private boolean isSpending;
    private double rate;

    public UserEntry() {
    }

    public UserEntry(long id, long userOperationId, long sprEntryId, long currencyId, String accountDebit, String accountCredit, double sum, boolean isSpending, double rate) {
        this.id = id;
        UserOperationId = userOperationId;
        this.sprEntryId = sprEntryId;
        this.currencyId = currencyId;
        this.accountDebit = accountDebit;
        this.accountCredit = accountCredit;
        this.sum = sum;
        this.isSpending = isSpending;
        this.rate = rate;
    }

    public UserEntry(long id) {
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserOperationId() {
        return UserOperationId;
    }

    public void setUserOperationId(long userOperationId) {
        UserOperationId = userOperationId;
    }

    public long getSprEntryId() {
        return sprEntryId;
    }

    public void setSprEntryId(long sprEntryId) {
        this.sprEntryId = sprEntryId;
    }

    public long getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(long currencyId) {
        this.currencyId = currencyId;
    }

    public String getAccountDebit() {
        return accountDebit;
    }

    public void setAccountDebit(String accountDebit) {
        this.accountDebit = accountDebit;
    }

    public String getAccountCredit() {
        return accountCredit;
    }

    public void setAccountCredit(String accountCredit) {
        this.accountCredit = accountCredit;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public boolean getIsSpending() {
        return isSpending;
    }

    public void setIsSpending(boolean isSpending) {
        this.isSpending = isSpending;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

       @Override
    public String toString() {
        return "UserEntry{" +
                "id=" + id +
                ", UserOperationId=" + UserOperationId +
                ", sprEntryId=" + sprEntryId +
                ", currencyId=" + currencyId +
                ", accountDebit='" + accountDebit + '\'' +
                ", accountCredit='" + accountCredit + '\'' +
                ", sum=" + sum +
                ", isSpending=" + isSpending +
                ", rate=" + rate +
                '}';
    }
}
