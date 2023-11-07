package tuan2_bai4_Account;

import java.util.Scanner;

public class TestAccount {
	static AccountArray accountList;
	static Scanner sn = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		int opt;
		accountList = new AccountArray();
		try {
			do {
				opt = menu();
				switch(opt) {
				case 1:{
					Account newAcc = createAccount();
					accountList.add(newAcc);
					break;
				}
				case 2:{
					createDefaultAccountList();
					break;
				}
				case 3:{
					displayTitle();
					displayAccountList();
					break;
				}
				case 4:{
					accountList.searchAccount(inputLong("Input your id account to deposit: ")).deposit(inputDouble("Input amount of money: "));
					break;
				}
				case 5:{
					accountList.searchAccount(inputLong("Input your id account to withdraw: ")).withdraw(inputDouble("Input amount of money: "), 10);
					break;
				}
				case 6:{
					accountList.searchAccount(inputLong("Input your id account to transfer: ")).transfer(accountList.searchAccount(inputLong("Input id account you need to transfer: ")), inputDouble("Input amount of money: "));
					break;
				}
				case 7:{
					System.out.println("Goodbye!");
					break;
				}
				}

			}while(opt!=7);

		}catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}

	public static int menu() {
		int chos;
		System.out.println("***Menu***\n" + "1.Create A Account\n" + "2.Create Account List\n" + "3.Print Account List \n" + "4.Deposit \n"  + "5.Withdraw\n" + "6.Transfer\n" + "7.Exit\n");
		chos = inputInt("Your choose: ");
		return chos;
	}

	public static int inputInt(String s) {
		int numInt;
		System.out.println(s);
		numInt = sn.nextInt();
		return numInt;
	}

	public static String inputString(String s) {
		String str;
		System.out.println(s);
		str = sn.nextLine();
		return str;
	}

	public static double inputDouble(String s) {
		double numDouble;
		System.out.println(s);
		numDouble = sn.nextFloat();
		return numDouble;
	}

	public static long inputLong(String s) {
		long numDouble;
		System.out.println(s);
		numDouble = sn.nextLong();
		return numDouble;
	}

	public static Account createAccount() throws Exception {
		Account acc;
		long accountNumber;
		String name;
		double balance;
		accountNumber = inputLong("Input your id account: ");
		while(accountList.isExistingAccNumber(accountNumber)) {
			System.out.println("Id account already exist!");
			accountNumber = inputLong("Input again: ");
		}
		name = inputString("Input account name: ");
		balance = inputDouble("Input the initial deposit amount: ");
		acc = new Account(accountNumber,name,balance);
		return acc;
	}

	public static void createDefaultAccountList() throws Exception {
		Account Acc1 = new Account(1111,"Huynh Thanh Giang", 0);
		Account Acc2 = new Account(1112,"Ho Quang Nhan ", 50);
		Account Acc3 = new Account(1113,"Le Tran Hoai Loc", 100);
		Account Acc4 = new Account(1114,"Tran Quoc Sang", 500);
		accountList.add(Acc1);
		accountList.add(Acc2);
		accountList.add(Acc3);
		accountList.add(Acc4);
	}

	public static void displayAccount(Account[] list) {
		for(int i=0; i < accountList.realElement;i++) {
			System.out.printf("\t%-7d",i+1);
			System.out.println(list[i]);
		}	
	}
	
	public static void displayAccountList() {
		Account [] allAccount = accountList.getAllAccount();
		displayAccount(allAccount);
	}
	
	static void displayTitle() {
		String s = String.format("\t%-7s %20s %20s %15s", "STT" ,"ID account", "Name" , "Balance");
		System.out.println(s);
	}
}
