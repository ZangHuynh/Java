package tuan8_bai4_Dat;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class TestTransacion {
	static TransactionArray transList = new TransactionArray();
	static Scanner scn = new Scanner(System.in);
	static DecimalFormat df = new DecimalFormat("#,##0.00 VND");
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
	public static void main(String[] args) {
		try {
			int opt;
			do{
				displayList(transList);
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
						System.out.println("Total AVG Land Transction: " + df.format(transList.avgLandTrans()));
						break;
					}
					case 4: {
						System.out.println("Sum Quantity Land Transaction: " + transList.getQuantityLT());
						System.out.println("Sum Quantity House Transaction: " + transList.getQuantityHT());
						break;
					}
					case 5: {
						displayListDate(transList);
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
		System.out.println("****MENU****\n" + "1.Create Default\n" + "2.Input A Transaction\n" + "3.Print AVG Total Price\n" + "4.Print Total Quantity.\n" + "5.Print Transacttion (9/2013)\n" + "6.Exit\n");
		int chos = inputInt("Your choice: ");
		scn.nextLine();
		return chos;
	}
	
	public static void createDefault() throws Exception {
		System.out.println("Input (1) to create GoldTransactiob, (another) to create MoneyTransactiob!");
		int chos = inputInt("Your choice: ");
		scn.nextLine();
		if(chos == 1) {
			Transaction trans1 = new LandTransaction("1111", LocalDate.parse("29/9/2013",dtf), 600000000, 500, "A"); 
			Transaction trans2 = new LandTransaction("1112", LocalDate.parse("11/1/2013",dtf), 100000000, 200, "B");
			Transaction trans3 = new LandTransaction("1113", LocalDate.parse("1/11/2013",dtf), 300000000, 100, "B");
			Transaction trans4 = new LandTransaction("1114", LocalDate.parse("12/12/2013",dtf), 200000000, 700, "C");
			transList.addTrans(trans1);
			transList.addTrans(trans2);
			transList.addTrans(trans3);
			transList.addTrans(trans4);
		}else {
			Transaction trans1 = new HouseTransaction("2221", LocalDate.parse("10/1/2023",dtf), 200000000, 100, 1, "566 NTS");
			Transaction trans2 = new HouseTransaction("2222", LocalDate.parse("16/9/2013",dtf), 500000000, 200, 2, "566 NTS");
			Transaction trans3 = new HouseTransaction("2223", LocalDate.parse("11/9/2013",dtf), 400000000, 400, 2, "566 NTS");
			Transaction trans4 = new HouseTransaction("2224", LocalDate.parse("1/12/2023",dtf), 800000000, 1000, 1, "566 NTS");
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
	
	public static Transaction inputTrans() throws Exception {
		String transCode;
		LocalDate entryDate;
		double uPrice, area;

		System.out.println("Input (1) to create Land Transction, (another) to create House Transction!");
		int chos = inputInt("Your choice: ");
		scn.nextLine();
		if(chos == 1) {
			String landType;
			
			transCode = inputString("Input transaction code: ");
			while(transList.findByCode(transCode)!=null) {
				System.out.println("This code already exist!");
				transCode = inputString("Input transaction code again: ");
			}
			entryDate = inputDate("Input transaction date: ");
			uPrice = inputDouble("Input unit price: ");
			area = inputDouble("Input area: ");
			scn.nextLine();
			landType = inputString("Input land type: ");
			
			Transaction trans = new LandTransaction(transCode, entryDate, uPrice, area, landType);
			return trans;
		}else {
			int houseType; 
			String address;
			
			transCode = inputString("Input transaction code: ");
			while(transList.findByCode(transCode)!=null) {
				System.out.println("This code already exist!");
				transCode = inputString("Input transaction code again: ");
			}
			entryDate = inputDate("Input transaction date: ");
			uPrice = inputDouble("Input unit price: ");
			area = inputDouble("Input area: ");
			scn.nextLine();
			houseType = inputInt("Input 1(High-end) or 2(Regular): ");
			address = inputString("Input address: ");

			Transaction trans = new HouseTransaction(transCode, entryDate, uPrice, area, houseType, address);
			return trans;
		}
	}
	
	public static void displayTitle() {
		String s = String.format("%s %20s %20s %20s %20s  %23s %25s %20s","Transaction Type", "Transaction Code", "Transaction Date", "Unit Price", "Area", "Total Price",  "Land Type/House Type", "House Address");
		System.out.println(s);
	}
	
	public static void displayList(TransactionArray transList) {
		displayTitle();
		for(Transaction trans : transList.getAll()) {
			if(trans instanceof LandTransaction) {
				System.out.print("LandTransaction ");
				System.out.println(trans);
			}else {
				System.out.print("HouseTransaction");
				System.out.println(trans);
			}
		}
	}
	
	public static void displayListDate(TransactionArray transList) {
		System.out.println("***List Date 9/2013***");
		displayTitle();
		for(Transaction trans : transList.getTransByDate()) {
			if(trans instanceof LandTransaction) {
				System.out.print("LandTransaction ");
				System.out.println(trans);
			}else {
				System.out.print("HouseTransaction");
				System.out.println(trans);
			}
		}
		System.out.println("\n");
	};
}
