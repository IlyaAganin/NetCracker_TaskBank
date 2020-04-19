package bank;

import java.util.ArrayList;
import java.util.List;

public class Clerk extends Thread{
	
	 	private final List<Client> clients = new ArrayList<Client>();
	    private Bank bank;
	    private String clerkName;
	    private Integer numberOfClients = 0;
	    
	    public List<Client> getClients() {
	        return clients;
	    }
	    
	    public String getClerkName() {
	        return clerkName;
	    }

	    public Clerk(Bank bank, String clerkName) {
	        this.bank = bank;
	        this.clerkName = clerkName;
	    }
	    public void addClients(Client client) {
	        synchronized (clients) {
	            clients.add(client);
	            numberOfClients = numberOfClients + 1;
	            clients.notify();
	        }
	    }

	    public Integer getNumberOfClients() {
	        return numberOfClients;
	    }

	    @Override
	    public void run() {
	        while (true) {
	            if (clients.isEmpty()) {
	                synchronized (clients) {
	                    try {
	                        clients.wait();
	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                }
	            } else {
	                Client currentClient = clients.remove(0);
	                numberOfClients = numberOfClients - 1;
	                synchronized (bank) {
	                    if (currentClient.isGoingToWithdrawMoney) {
	                        if (currentClient.getAmountOfMoney() > bank.getTotalAmountOfMoney()) {
	                            this.clients.add(currentClient);
	                        } else {
	                            System.out.println("Client with name " + currentClient.getName() + " withdrew money from " + clerkName + " on sum " + currentClient.getAmountOfMoney());
	                            bank.withdrawMoney(currentClient.getAmountOfMoney());
	                            try {
	                                Thread.sleep(currentClient.getTime());

	                            } catch (InterruptedException e) {
	                                e.printStackTrace();
	                            }
	                        }
	                    }
	                }
	                if (!currentClient.isGoingToWithdrawMoney) {
	                    System.out.println("Client with name " + currentClient.getName() + " made deposit from " + clerkName + " on sum " + currentClient.getAmountOfMoney());
	                    bank.makeDeposit(currentClient.getAmountOfMoney());
	                    try {
	                        Thread.sleep(currentClient.getTime());

	                    } catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        }
	    }

}
