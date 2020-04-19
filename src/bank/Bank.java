package bank;

public class Bank {
	
	Long totalAmountOfMoney;

	public Long getTotalAmountOfMoney() {
		return totalAmountOfMoney;
	}
	
    public synchronized void withdrawMoney(Long amountOfMoney) {
    	totalAmountOfMoney = totalAmountOfMoney - amountOfMoney;
    }
    
    public synchronized void makeDeposit(Long amountOfMoney) {
    	totalAmountOfMoney = totalAmountOfMoney + amountOfMoney;
    }
    
	public Bank(Long totalAmountOfMoney) {
		this.totalAmountOfMoney = totalAmountOfMoney;
	}

	@Override
	public String toString() {
		return "Bank [totalAmountOfMoney=" + totalAmountOfMoney + "]";
	}

}
