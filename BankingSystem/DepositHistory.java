package BankingSystem;

public class DepositHistory {
    private Long depositTime;
    private Long depositAmount;

    protected DepositHistory(Long amount){
        this.depositTime = System.currentTimeMillis();
        this.depositAmount = amount;
    }

    public Long getDepositTime(){
        return depositTime;
    }

    public Long getDepositAmount(){
        return depositAmount;
    }

    @Override
    public String toString() {
        return "Deposit of " + depositAmount + " at " + depositTime;
    }

}
