package tuan7_bai3_Vang;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TestTransaction {
	static TransactionArray transList = new TransactionArray();
	static Scanner scn = new Scanner(System.in);
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy"); 
	static DecimalFormat df = new DecimalFormat("#,##0.00 VND");

	public static void main(String[] args) {
		try {
			int opt;
			do{
				displayTrans(transList);
				opt=menu();
				switch(opt) {
					case 1: {
						createDefault();
						break;
					}
					case 2: {
						Transaction trans = inputTrans();
						transList.addTrans(trans);
						break;
					}
					case 3: {
						System.out.println("Total AVG Money Transction: " + df.format(transList.totalPriceAVG()));
						break;
					}
					case 4: {
						System.out.println("Sum Quantity Gold Transaction: " + transList.sumQuantityGT());
						System.out.println("Sum Quantity Money Transaction: " + transList.sumQuantityMT());
					}
					case 5: {
						displayUnitPrice1B();
						break;
					}
					default : {
						System.out.println("Goodbye!");
					}
				}
			}while(opt<6);

		}catch(Exception err) {
			System.out.println(err);
		}
	}

	public static int menu() {
		System.out.println("****MENU****\n" + "1.Create Default\n" + "2.Input A Transaction\n" + "3.Print AVG Total Price\n" + "4.Print Total Quantity.\n" + "5.Print Transacttion (Unit Price >1B)\n" + "6.Exit\n");
		int chos = inputInt("Your choice: ");
		scn.nextLine();
		return chos;
	}

	public static void createDefault() throws Exception {
		System.out.println("Input (1) to create GoldTransactiob, (another) to create MoneyTransactiob!");
		int chos = inputInt("Your choice: ");
		scn.nextLine();
		if(chos==1) {
			Transaction trans1 = new GoldTransaction("1111", LocalDate.parse("9/9/2023",dtf), 2000000000, 100, "9999");
			Transaction trans2 = new GoldTransaction("1112", LocalDate.parse("10/10/2023",dtf), 25000000, 200, "24K");
			Transaction trans3 = new GoldTransaction("1113", LocalDate.parse("11/11/2023",dtf), 10000000, 90, "white gold");
			Transaction trans4 = new GoldTransaction("1114", LocalDate.parse("21/12/2023",dtf), 23000000, 500, "rose gold");
			transList.addTrans(trans1);
			transList.addTrans(trans2);
			transList.addTrans(trans3);
			transList.addTrans(trans4);
		}else {
			Transaction trans1 = new MoneyTransaction("2221", LocalDate.parse("19/9/2023",dtf), 30000000, 200, 1, 1);
			Transaction trans2 = new MoneyTransaction("2222", LocalDate.parse("29/9/2023",dtf), 35000000, 150, 25.283, 2);
			Transaction trans3 = new MoneyTransaction("2223", LocalDate.parse("18/9/2023",dtf), 2000000000, 300, 25.282, 2);
			Transaction trans4 = new MoneyTransaction("2224", LocalDate.parse("7/9/2023",dtf), 1500000000, 100, 24.345, 3);
			transList.addTrans(trans1);
			transList.addTrans(trans2);
			transList.addTrans(trans3);
			transList.addTrans(trans4);
		}
	}
	
	public static String inputString(String s) {
		System.out.print(s);
		return scn.nextLine();
	}

	public static double inputDouble(String s) {
		System.out.print(s);
		return scn.nextDouble();
	}

	public static int inputInt(String s) {
		System.out.print(s);
		return scn.nextInt();
	}
	
	public static LocalDate inputDate(String day) {
		System.out.print(day);
		return LocalDate.parse(day, dtf);
	}

	public static Transaction inputTrans() {
		String transCode;
		LocalDate entryDate;
		double uPrice;
		int quantity;
		System.out.println("Input (1) to create GoldTransactiob, (another) to create MoneyTransactiob!");
		int chos = inputInt("Your choice: ");
		scn.nextLine();
		if(chos==1) {
			String goldType;
			
			transCode = inputString("Input transaction code: ");
			while(transList.findByCode(transCode)!=null) {
				System.out.println("This code already exist!");
				transCode = inputString("Input transaction code again: ");
			}
			entryDate = inputDate("Input transaction date: ");
			uPrice = inputDouble("Input unit price: ");
			quantity = inputInt("Input quantity: ");
			scn.nextLine();
			goldType = inputString("Input gold type: ");
			
			Transaction trans = new GoldTransaction(transCode, entryDate, uPrice, quantity, goldType);
			return trans;
		}else {
			int moneyType;
			double exRate;
			
			transCode = inputString("Input transaction code: ");
			while(transList.findByCode(transCode)!=null) {
				System.out.println("This code already exist!");
				transCode = inputString("Input transaction code again: ");
			}
			entryDate = inputDate("Input transaction date: ");
			uPrice = inputDouble("Input unit price: ");
			quantity = inputInt("Input quantity: ");
			scn.nextLine();
			moneyType = inputInt("Input money type (1 or 2 or 3): ");
			exRate = inputDouble("Input exchange rate: ");
			
			Transaction trans = new MoneyTransaction(transCode, entryDate, uPrice, quantity, exRate, moneyType);
			return trans;
		}
	}
	
	public static void displayTrans(TransactionArray transList) {
		displayTitle();
		for(Transaction trans : transList.getList()) {
			if(trans instanceof GoldTransaction) {
				System.out.print("Gold Transaction ");
				System.out.println(trans);
			}else {
				System.out.print("Money Transaction");
				System.out.println(trans);
			}
		}
	}
	
	public static void displayUnitPrice1B() {
		System.out.println("\n***List of transactions with a unit price over 1 billion***");
		displayTitle();
		for(Transaction trans : transList.getUnitPrice1B()) {
			if(trans instanceof GoldTransaction) {
				System.out.print("Gold Transaction ");
				System.out.println(trans);
			}else {
				System.out.print("Money Transaction");
				System.out.println(trans);
			}
		}
	}

	public static void displayTitle() {
		String s = String.format("%-15s  | %-15s | %-15s | %-25s | %-15s |  %-25s | %-20s | %-15s |\n","Transaction Type", "Transaction Code", "Transaction Date", "Unit Price", "Quantity", "Total Price",  "Gold Type/Exchange Rate", "Money Type");
		System.out.printf(s);
	}
}
