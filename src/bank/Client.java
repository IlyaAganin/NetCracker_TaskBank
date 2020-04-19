package bank;

public class Client {
	
	final String name;
	final Long amountOfMoney;
	final Boolean isGoingToWithdrawMoney;
	Integer time;
	
	public final Integer getTime() {
		return time;
	}

	public final void setTime(Integer time) {
		this.time = time;
	}

	public Client(	String name,
			Long amountOfMoney,
			Boolean isGoingToWithdrawMoney,
			Integer time){
		this.name = name;
		this.amountOfMoney = amountOfMoney;
		this.isGoingToWithdrawMoney = isGoingToWithdrawMoney;
		this.time = time;
	}
	
	public String getName() {
		return name;
	}
	public Long getAmountOfMoney() {
		return amountOfMoney;
	}
	public Boolean getIsGoingToWithdrawMoney() {
		return isGoingToWithdrawMoney;
	}

	@Override
	public String toString() {
		return "Client [name=" + name + ", amountOfMoney=" + amountOfMoney + ", isGoingToWithdrawMoney="
				+ isGoingToWithdrawMoney + "]";
	}
	
	

}
