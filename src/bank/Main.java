package bank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long totalAmountOfMoney = 1000000000;
		Bank mainBank = new Bank(totalAmountOfMoney);
		
        List<Clerk> clerkList = new ArrayList<Clerk>();
        Clerk c1 = new Clerk(mainBank, "Clerk1");
        Clerk c2 = new Clerk(mainBank, "Clerk2");
        Clerk c3 = new Clerk(mainBank, "Clerk3");
        Clerk c4 = new Clerk(mainBank, "Clerk4");
        clerkList.add(c1);
        clerkList.add(c2);
        clerkList.add(c3);
        clerkList.add(c4);

        for (Clerk clerk : clerkList) {
        	clerk.start();
        }
        
        Boolean isGoingToWithdrawMoney;
        for (int i = 0; i < 10; i++) {
            isGoingToWithdrawMoney = i % 2 != 0;
            Clerk clerk =  clerkList.get(0);
            clerk.addClients(new Client( ("Client" + (i+1)), ((long) (Math.random() * 50000) ), isGoingToWithdrawMoney,   ((int) (Math.random() * 250) )  ) );

            Collections.sort(clerkList, new Comparator<Clerk>() {
                public int compare(Clerk c1, Clerk c2) {
                    return c1.getNumberOfClients().compareTo(c2.getNumberOfClients());
                }

            });
        }
	}

}
