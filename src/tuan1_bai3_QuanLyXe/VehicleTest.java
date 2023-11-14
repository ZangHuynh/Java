package tuan1_bai3_QuanLyXe;

import java.util.Scanner;

public class VehicleTest {
	public static void main(String[] args) throws Exception {
		Vehicle v[] = null;
		int opt,n;
		System.out.println("Amount of people: ");
		n = scn.nextInt();
		try {
			do {
				opt = menu();
				switch(opt) {
				case 1:{
					v = new Vehicle [n];
					for(int i=0; i<n; i++) {
						System.out.println("The " + (i+1) + " person");
						v[i] = new Vehicle();
						inputVehicle(v[i]);
					}	
					break;
				}
				case 2:{
					System.out.println("Vehicle Management Program!");
					printTitle();
					for(int i=0; i < n; i++) {
						v[i].printTax();
					}
					break;
				}
				case 3:{
					System.out.println("Goodbye!");
					break;
				}
				}
			}while(opt!=3);
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}

	static Scanner scn = new Scanner(System.in);
	static void inputVehicle(Vehicle xe) throws Exception {
		scn.nextLine();
		System.out.println("\tInput owner name: ");
		xe.setOwnerName(scn.nextLine());
		System.out.println("\tInput vehicle name: ");
		xe.setVehicleName(scn.nextLine());
		System.out.println("\tInput capacity: ");
		xe.setCapacity(scn.nextInt());
		System.out.println("\tInput price: ");
		xe.setPrice(scn.nextFloat());
	}

	public static int menu() {
		int chos;
		System.out.println("***Menu***\n" + "1.Input and creat\n" + "2.Print \n" + "3.Exit\n");
		chos = setNumber("Your choose: ");
		return chos;
	}

	public static int setNumber(String str) {
		int n=0;
		System.out.println(str);
		n = scn.nextInt();
		return n;
	}

	static void printTitle() {
		String s = String.format("%20s %15s %12s %20s %15s", "Owner Name", "Vehicle Name", "Capacity", "Price", "Tax");
		System.out.println(s);
	}
}
