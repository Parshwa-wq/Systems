package BankingSystem;

public class WithdrawHistory {

    private Long withdrawTime;
    private Long withdrawAmount;

    protected WithdrawHistory(Long amount){
        this.withdrawTime = System.currentTimeMillis();
        this.withdrawAmount = amount;
    }

    public Long getDepositTime(){
        return withdrawTime;
    }

    public Long getDepositAmount(){
        return withdrawAmount;
    }

    @Override
    public String toString() {
        return "Deposit of " + withdrawAmount + " at " + withdrawTime;
    }

    
}
