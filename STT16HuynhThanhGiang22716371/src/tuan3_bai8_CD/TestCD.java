package tuan3_bai8_CD;

import java.util.Scanner;

public class TestCD {
	static CDList cdList;
	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		int opt;
		cdList = new CDList();
		try {
			do {
				opt = menu();
				switch (opt) {
					case 1: {
						CD newCD = createACD();
						cdList.addCD(newCD);
						break;
					}
					case 2: {
						createCDDefault();
						break;
					}
					case 3: {
						displayTitle();
						displayAllCD();
						break;
					}
					case 4: {
						System.out.println("Number of CDs: " + cdList.realElement);
						break;
					}
					case 5: {
						System.out.println("Total cost of CDs: " + cdList.sumPriceCD());
						break;
					}
					case 6: {
						cdList.sortPriceCD();
						break;
					}
					case 7: {
						cdList.sortNameCD();;
						break;
					}
					case 8: {
						System.out.println("Goodbye!");
						break;
					}
					
				}
			}while(opt!=8);
		}catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}
	
	public static int menu() {
		int chos;
		System.out.println("***Menu***\n" + "1.Create A CD\n" + "2.Create CD List\n" + "3.Print CD List \n" + "4.Amount of CDs\n"  + "5.Total cost of CDs\n" + "6.Sort (Price)\n" + "7.Sort (Name)\n" + "8.Exit\n");
		chos = inputInt("Your choice: ");
		return chos;
	}
	
	public static int inputInt(String s) {
		System.out.println(s);
		return scn.nextInt();
	}
	
	public static void createCDDefault() throws Exception {
		CD cd1 = new CD(1111, "DQ", "AQS", 5, 200);
		CD cd2 = new CD(1112, "CQ", "BQS", 10, 150);
		CD cd3 = new CD(1113, "BQ", "CQS", 15, 700);
		CD cd4 = new CD(1114, "AQ", "DQS", 25, 500);
		cdList.addCD(cd1);
		cdList.addCD(cd2);
		cdList.addCD(cd3);
		cdList.addCD(cd4);
	}
	
	public static String inputString(String s) {
		System.out.println(s);
		return scn.nextLine();
	}

	public static double inputDouble(String s) {
		System.out.println(s);
		return scn.nextDouble();
	}

	public static long inputLong(String s) {
		System.out.println(s);
		return scn.nextLong();
	}
	
	public static CD createACD() throws Exception {
		int cdCode, numSongs;
		String cdName, singName;
		double cdPrice;
		
		cdCode = inputInt("Input id CD: ");
		while(cdList.isExistingCD(cdCode)) {
			System.out.println("This cd adready exist!");
			cdCode = inputInt("Input id CD agian: ");
		}
		scn.nextLine();
		cdName = inputString("Input CD name: ");
		singName = inputString("Input singer name: ");
		numSongs = inputInt("Input number of songs: ");
		cdPrice = inputDouble("Input cd price: ");
		CD cd = new CD(cdCode, cdName, singName, numSongs, cdPrice);
		return cd;
	}
	
	public static void displayCD(CD[] list) {
		for(int i=0;i<cdList.realElement;i++) {
			System.out.printf("%d",i+1);
			System.out.println(list[i]);
		}
	}
	
	public static void displayAllCD() {
		CD[] allCD = cdList.getAllCD();
		displayCD(allCD);
	}
	
	public static void displayTitle() {
		String s = String.format("%s %17s %19s %15s %20s %15s","STT", "CD ID", "CD Name", "Singer Name", "Number of Songs", "CD Price" );
		System.out.println(s);
	}
}
