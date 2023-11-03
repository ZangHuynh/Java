package tuan6_bai2_QLySach;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class TestBook {
	static Scanner scn = new Scanner(System.in);
	static BookArray bookList = new BookArray();
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
	static DecimalFormat df = new DecimalFormat("#,##0.00VND");
	public static void main(String[] args) throws Exception {
		int opt;
		do {
			displayBook(bookList);
			opt=menu();
			switch (opt) {
				case 1: {
					createDefault();
					break;
				}
				case 2: {
					Sach newBook = createABook();
					bookList.addBook(newBook);
					break;
				}
				case 3: {
					removeABook();
					break;
				}
				case 4: {
					updateBook();
					break;
				}
				case 5: {
					System.out.println("Average Tham Khao Unit Price: " + df.format(bookList.unitPriceAVG()));
					break;
				}
				case 6: {
					System.out.println("Sumary Giao Khao Total Price: " + df.format(bookList.sumTotalPriceGK()));
					System.out.println("Sumary Giao Khao Total Price: " + df.format(bookList.sumTotalPriceTK()));
					break;
				}
				case 7: {
					displayXPublisher();
					break;
				}
				default:
					System.out.println("Goodbye");;
			}
		}while(opt<8);
	}
	
	public static int menu() {
		System.out.println("****MENU****\n" + "1.Create Default\n" + "2.Input A Book\n" + "3.Remove A Book\n" + "4.Update\n" + "5.Print AVG Unit Price\n" + "6.Print Total Price\n" + "7.Print X publisher books\n" + "8.Exit\n");
		System.out.print("Your choice: ");
		int chos = scn.nextInt();
		scn.nextLine();
		return chos;
	}
	
	public static void createDefault() throws Exception {
		System.out.println("Input (1) to create SachGiaoKhoa, (another) to create SachThamKhao!");
		System.out.print("Your choice: ");
		int chos = scn.nextInt();
		scn.nextLine();
		if(chos==1) {
			Sach gk1 = new SachGiaoKhoa("1111", LocalDate.parse("9/9/2023",dtf), 20000, 100, "Kim Dong", true);
			Sach gk2 = new SachGiaoKhoa("1112", LocalDate.parse("10/10/2023",dtf), 25000, 150, "Lao Dong", true);
			Sach gk3 = new SachGiaoKhoa("1113", LocalDate.parse("11/11/2023",dtf), 14000, 80, "Tre", false);
			Sach gk4 = new SachGiaoKhoa("1114", LocalDate.parse("12/12/2023",dtf), 18000, 50, "Hoi Nha Van", false);
			bookList.addBook(gk1);
			bookList.addBook(gk2);
			bookList.addBook(gk3);
			bookList.addBook(gk4);
		}else {
			Sach tk1 = new SachThamKhao("2221", LocalDate.parse("9/9/2023",dtf), 30000, 100, "Kim Dong", 0.1);
			Sach tk2 = new SachThamKhao("2222", LocalDate.parse("10/10/2023",dtf), 20000, 150, "Lao Dong", 0.08);
			Sach tk3 = new SachThamKhao("2223", LocalDate.parse("11/11/2023",dtf), 18000, 70, "Tre", 0.15);
			Sach tk4 = new SachThamKhao("2224", LocalDate.parse("12/12/2023",dtf), 25000, 200, "Hoi Nha Van", 0.06);
			bookList.addBook(tk1);
			bookList.addBook(tk2);
			bookList.addBook(tk3);
			bookList.addBook(tk4);
		}
	}
	
	public static boolean inputBoolean(String s) {
		System.out.print(s);
		return scn.nextBoolean();
	}

	public static String inputString(String s) {
		System.out.print(s);
		return scn.nextLine();
	}

	public static double inputDouble(String s) {
		System.out.print(s);
		return scn.nextDouble();
	}

	public static long inputLong(String s) {
		System.out.print(s);
		return scn.nextLong();
	}
	
	public static LocalDate inputDate(String day) {
		System.out.print(day);
		return LocalDate.parse(day, dtf);
	}
	
	public static Sach createABook() {
		String bookCode, publisher;;
		double uPrice;
		long quantity;
		LocalDate entryDate;
		
		System.out.println("Input (1) to create SachGiaoKhoa, (another) to create SachThamKhao!");
		System.out.print("Your choice: ");
		int chos = scn.nextInt();
		scn.nextLine();
		if(chos==1) {
			boolean condition;
			
			bookCode = inputString("Input book code: ");
			while(bookList.findBookByCode(bookCode)!=null) {
				System.out.println("This book already exist!");
				bookCode = inputString("Input book code again: ");
			}
			entryDate = inputDate("Input entry date: ");
			uPrice = inputDouble("Input unit price: ");
			quantity = inputLong("Input quantity: ");
			scn.nextLine();
			publisher = inputString("Input publisher: ");
			condition = inputBoolean("Input condition(true/false): ");
			Sach gk = new SachGiaoKhoa(bookCode, entryDate, uPrice, quantity, publisher, condition);
			return gk;
		}else {
			double tax;
			
			bookCode = inputString("Input book code: ");
			while(bookList.findBookByCode(bookCode)!=null) {
				System.out.println("This book already exist!");
				bookCode = inputString("Input book code again: ");
			}
			entryDate = inputDate("Input entry date: ");
			uPrice = inputDouble("Input unit price: ");
			quantity = inputLong("Input quantity: ");
			scn.nextLine();
			publisher = inputString("Input publisher: ");
			tax = inputDouble("Input tax: ");
			Sach tk = new SachThamKhao(bookCode, entryDate, uPrice, quantity, publisher, tax);
			return tk;
		}
	}
	
	public static void displayXPublisher() {
		System.out.print("Input PUBLISHER NAME to display: ");
		String publisherName = scn.nextLine();
		ArrayList<Sach> pubBook = bookList.findBookByPublisher(publisherName);
		System.out.println("List " + publisherName + " books");
		displayTitle();
		for(Sach book : pubBook) {
			if(book instanceof SachGiaoKhoa) {
				System.out.print("\tSach Giao Khoa ");
				System.out.println(book);
			}else {
				System.out.print("\tSach Tham Khao ");
				System.out.println(book);
			}
		}
		System.out.println("\n");
	}
	
	public static void removeABook() throws Exception {
		System.out.print("Input BOOK CODE to update: ");
		String bookCode = scn.nextLine();
		Sach rmBook = bookList.findBookByCode(bookCode);
	    if (rmBook != null) {
	    	String ques = inputString("Do you want to remove a trip with " + bookCode + "(y or n): ");
	    	if(ques.equalsIgnoreCase("Y")) {
	    		bookList.removeBook(rmBook);
		        System.out.println("Trip with trip code (" + bookCode + ") has been removed.");
	    	} else {
	    		System.out.println("Trip with trip code (" + bookCode + ") removing failed.");
	    	}
	    } else {
	        throw new Exception("Trip with trip code (" + bookCode + ") not found.");
	    }
	}
	
	public static void updateBook() throws Exception {
		System.out.print("Input BOOK CODE to update: ");
		String bookCode = scn.nextLine();
		Sach udBook = bookList.findBookByCode(bookCode);
		if(udBook != null) {
			String publisher;
			double uPrice;
			long quantity;
			LocalDate entryDate;
			if(udBook instanceof SachGiaoKhoa) {
				int opt;
				do {
					opt=menuUpdateGK();
					switch (opt) {
						case 1:{
							entryDate = inputDate("Input entry date: ");
							udBook.setEntryDate(entryDate);
							break;
						}
						case 2: {
							uPrice = inputDouble("Input unit price: ");
							udBook.setUnitPrice(uPrice);
							scn.nextLine();
							break;
						}
						case 3: {
							quantity = inputLong("Input quantity: ");
							udBook.setQuantity(quantity);
							scn.nextLine();
							break;
						}
						case 4: {
							publisher = inputString("Input publisher: ");
							udBook.setPublisher(publisher);
							break;
						}
						case 5: {
							boolean condition = inputBoolean("Input condition(true/false): ");
							((SachGiaoKhoa)udBook).setCondition(condition);
							break;
						}
						default:{
							System.out.println("Updating Success!");
							break;
						}	
					}
					
				}while(opt<7);
			}else {
				int opt;
				do {
					opt = menuUpdateTK();
					switch (opt) {
						case 1:{
							entryDate = inputDate("Input entry date: ");
							udBook.setEntryDate(entryDate);
							break;
						}
						case 2: {
							uPrice = inputDouble("Input unit price: ");
							udBook.setUnitPrice(uPrice);
							scn.nextLine();
							break;
						}
						case 3: {
							quantity = inputLong("Input quantity: ");
							udBook.setQuantity(quantity);
							scn.nextLine();
							break;
						}
						case 4: {
							publisher = inputString("Input publisher: ");
							udBook.setPublisher(publisher);
							break;
						}
						case 5: {
							double tax = inputDouble("Input tax: ");
							((SachThamKhao)udBook).setTax(tax);
							break;
						}
						default:{
							System.out.println("Updating Success!");
							break;
						}
					}
				}while(opt<6);
			}
		}else {
			throw new Exception("Trip with trip code (" + bookCode + ") not found.");
		}
	}
	
	public static int menuUpdateGK() {
		System.out.println("****MENU****\n" + "1.Entry Date\n" + "2.Unit Price\n" + "3.Quantity\n" + "4.Publisher\n" + "5.Condition\n" + "6.Condition" + "7.Exit\n" );
		System.out.print("Your choice: ");
		int chos = scn.nextInt();
		scn.nextLine();
		return chos;
	}
	
	public static int menuUpdateTK() {
		System.out.println("****MENU****\n" + "1.Entry Date\n" + "2.Unit Price\n" + "3.Quantity\n" + "4.Publisher\n" + "5.Tax\n" + "6.Exit\n" );
		System.out.print("Your choice: ");
		int chos = scn.nextInt();
		scn.nextLine();
		return chos;
	}
	
	public static void displayBook(BookArray bookList) {
		displayTitle();
		for(Sach book : bookList.getList()) {
			if(book instanceof SachGiaoKhoa) {
				System.out.print("\tSach Giao Khoa ");
				System.out.println(book);
			}else {
				System.out.print("\tSach Tham Khao ");
				System.out.println(book);
			}
		}
	}
	
	public static void displayTitle() {
		String s = String.format("\t%s \t%15s \t%12s \t%17s \t%9s \t%14s \t%14s \t%19s\n","Book Type", "Book Code", "Entry Date", "Unit Price", "Quantity", "Publisher", "Condition/Tax", "Total Price");
		System.out.printf(s);
	}
}
