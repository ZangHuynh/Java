package tuan5_bai1_ChuyenXe;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TripTest {
	static Scanner scn = new Scanner(System.in);
	static TripList tripList = new TripList();
	
	public static void main(String[] args) throws Exception {
		try {
			int opt;
			do {
				displayTrip(tripList);
				opt=menu();
				switch (opt) {
					case 1: {
						createDefault();
					break;
					}
					case 2: {
						ChuyenXe newTrip = createATrip();
						tripList.addTrip(newTrip);
					break;
					}
					case 3: {
						removeATrip();
						break;
					}
					case 4: {
						updateTrip();
						break;
					}
					case 5: {
						DecimalFormat df = new DecimalFormat("#,##0.00VND");
						System.out.println("Sumary NoiThanh Renenue: " + df.format(tripList.sumRevenueNT()));
						System.out.println("Sumary NgoaiThanh Renenue: " + df.format(tripList.sumRevenueNgT()));
						break;
					}
					default:
						System.out.println("Goodbye");;
				}
			}while(opt<6);
		} catch (Exception err) {
			System.out.println(err);
		}
	}
	
	public static int menu() {
		System.out.println("****MENU****\n" + "1.Create Default\n" + "2.Input A Trip\n" + "3.Remove A Trip\n" + "4.Update\n" + "5.Print Revenue\n" + "6.Exit\n" );
		System.out.print("Your choice: ");
		int chos = scn.nextInt();
		scn.nextLine();
		return chos;
	}
	
	public static void createDefault() throws Exception {
		System.out.println("Input (1) to create NoiThanh, (another) to create NgoaiThanh!");
		System.out.print("Your choice: ");
		int chos = scn.nextInt();
		if(chos==1) {
			ChuyenXe nt1 = new NoiThanh("1111","Huynh Thanh Giang", "67-XXXX", 25000000, 300, 2);
			ChuyenXe nt2 = new NoiThanh("1112","Ho Vinh Zang", "84-XXXX", 15000000, 250, 1);
			ChuyenXe nt3 = new NoiThanh("1113","Ho Quang Jang", "93-XXXX", 5000000, 100, 5);
			ChuyenXe nt4 = new NoiThanh("1114","Le Tran Hoai Yang", "63-XXXX", 10000000, 200, 2);
			tripList.addTrip(nt1);
			tripList.addTrip(nt2);
			tripList.addTrip(nt3);
			tripList.addTrip(nt4);
		}else {
			ChuyenXe ngt1 = new NgoaiThanh("2221", "Huynh Thanh Giang", "8X-XXX", 30000000, "An Giang", 2);
			ChuyenXe ngt2 = new NgoaiThanh("2222", "Ho Vinh Zang", "5X-XXX", 20000000, "An Giang", 2);
			ChuyenXe ngt3 = new NgoaiThanh("2223", "Ho Quang Jang", "6X-XXX", 32000000, "An Giang", 2);
			ChuyenXe ngt4 = new NgoaiThanh("2224", "Le Tran Hoai Yang", "7X-XXX", 25000000, "An Giang", 2);
			tripList.addTrip(ngt1);
			tripList.addTrip(ngt2);
			tripList.addTrip(ngt3);
			tripList.addTrip(ngt4);
		}
	}
	
	public static int inputInt(String s) {
		System.out.print(s);
		return scn.nextInt();
	}
	
	public static String inputString(String s) {
		System.out.print(s);
		return scn.nextLine();
	}

	public static double inputDouble(String s) {
		System.out.print(s);
		return scn.nextDouble();
	}
	
	public static ChuyenXe createATrip() {
		String tripCode, driverName, numPlate;
		double revenue;
		System.out.println("Input (1) to create NoiThanh, (another) to create NgoaiThanh!");
		int chos = inputInt("Your choice: ");
		scn.nextLine();
		if(chos==1) {
			double km;
			int route;
			tripCode = inputString("Input trip code: ");
			while (tripList.findTripCode(tripCode) != null) {
				System.out.println("This trip already exits!");
				tripCode = inputString("Input trip code again: ");
			}
			driverName = inputString("Input driver name: ");
			numPlate = inputString("Input number plate: ");
			revenue = inputDouble("Input renevue: ");
			km = inputDouble("Input km traveled: ");
			route = inputInt("Input route number: ");
			ChuyenXe nt = new NoiThanh(tripCode, driverName, numPlate, revenue, km, route); 
			return nt;
		}else {
			String desti;
			int travel;
			
			tripCode = inputString("Input trip code: ");
			driverName = inputString("Input driver name: ");
			numPlate = inputString("Input number plate: ");
			revenue = inputDouble("Input renevue: ");
			scn.nextLine();
			desti = inputString("Input destination: ");
			travel = inputInt("Input travel days: ");
			ChuyenXe ngt = new NgoaiThanh(tripCode, driverName, numPlate, revenue, desti, travel);
			return ngt;
		}
	}
	
	public static void removeATrip() throws Exception {
	    System.out.println("Input TRIP CODE to remove: ");
	    String tripCode = scn.nextLine();
	    ChuyenXe rmTrip = tripList.findTripCode(tripCode);
	    if (rmTrip != null) {
	        tripList.removeTrip(rmTrip);
	        System.out.println("Trip with trip code (" + tripCode + ") has been removed.");
	    } else {
	        throw new Exception("Trip with trip code (" + tripCode + ") not found.");
	    }
	}
	
	public static void updateTrip() throws Exception {
		System.out.print("Input TRIP CODE to update: ");
		String tripCode = scn.nextLine();
		ChuyenXe udTrip = tripList.findTripCode(tripCode);
		if(udTrip != null) {
			if(udTrip instanceof NoiThanh) {
				int opt;
				do {
					opt=menuUpdateNT();
					switch (opt) {
						case 1: {
							System.out.print("Input driver name: ");
							udTrip.setDriverName(scn.nextLine());
							break;
						}
						case 2:{
							System.out.print("Input number plate: ");
							udTrip.setNumberPlate(scn.nextLine());
							break;
						}
						case 3: {
							System.out.print("Input renevue: ");
							udTrip.setRevenue(scn.nextDouble());
							scn.nextLine();
							break;
						}
						case 4: {
							System.out.print("Input km traveled: ");
							((NoiThanh)udTrip).setKmTraveled(scn.nextDouble());
							scn.nextLine();
							break;
						}
						case 5: {
							System.out.print("Input route number: ");
							((NoiThanh)udTrip).setRouteNumber(scn.nextInt());
							scn.nextLine();
							break;
						}
						default:{
							System.out.println("Updating Success!");
							break;
						}	
					}
				}while(opt<6);
			}else {
				int opt;
				do {
					opt = menuUpdateNgT();
					switch (opt) {
						case 1: {
							System.out.print("Input driver name: ");
							udTrip.setDriverName(scn.nextLine());
						}
						case 2: {
							System.out.print("Input number plate: ");
							udTrip.setNumberPlate(scn.nextLine());
							break;
						}
						case 3: {
							System.out.print("Input renevue: ");
							udTrip.setRevenue(scn.nextDouble());
							scn.nextLine();
							break;
						}
						case 4: {
							System.out.print("Input km traveled: ");
							((NgoaiThanh)udTrip).setDestination(scn.nextLine());
							break;
						}	
						case 5: {
							System.out.print("Input route number: ");
							((NgoaiThanh)udTrip).setTravelDay(scn.nextInt());
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
			throw new Exception("Trip with trip code (" + tripCode + ") not found.");
		}
	}
	
	public static int menuUpdateNT() {
		System.out.println("****MENU****\n" + "1.Driver Name\n" + "2.Plate Number\n" + "3.Revenue\n" + "4.Km Traveled\n" + "5.Route Number\n" + "6.Exit\n" );
		System.out.print("Your choice: ");
		int chos = scn.nextInt();
		scn.nextLine();
		return chos;
	}
	
	public static int menuUpdateNgT() {
		System.out.println("****MENU****\n" + "1.Driver Name\n" + "2.Plate Number\n" + "3.Revenue\n" + "4.Destination\n" + "5.Travel Days\n" + "6.Exit\n" );
		System.out.print("Your choice: ");
		int chos = scn.nextInt();
		scn.nextLine();
		return chos;
	}
	
	public static void displayTrip(TripList tripList) {
		displayTitle();
		for(ChuyenXe trip : tripList.getList()) {
			if(trip instanceof NoiThanh) {
				System.out.print("\tNoiThanh");
				System.out.println(trip);
			}else {
				System.out.print("\tNgoaiThanh");
				System.out.println(trip);
			}
		}
	}
	
	public static void displayTitle() {
		String s = String.format("\t%s \t%s \t%16s \t%15s \t%16s \t%s \t%s\n","Trip Type", "Trip Code", "Driver Name", "Plate Number", "Revenue", "Km Traveled/Destination", "Route Number/Travel Day");
		System.out.printf(s);
	}
}
