package tuan4_bai7_SinhVienSort;

import java.util.Scanner;

public class TestSinhVien {
	static SinhVienArray svlist = new SinhVienArray();
	static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) {
		int opt,n;
		
		try {
			creatStuList();
			do {
				displayTitle();
				displayList();
				opt = menu();
				switch(opt) {
					case 1:{
						System.out.print("Input amount of student: ");
						n = scn.nextInt(); 
						for(int i=0;i<n;i++) {
							System.out.println("**The " + (i+1) + "student**");
							SinhVien newSV = inputSV();
							svlist.addStu(newSV);
						}
						break;
					}
					case 2:{
						svlist.sortIDStudent();
						break;
					}
					case 3:{
						System.out.println("Goodbye!");
					}
				}
			}while(opt!=3);
		}catch(Exception err){
			System.out.println(err.getMessage());
		}
	}
	
	public static int menu() {
		int chos;
		System.out.println("***Menu***\n" + "1.Create N Student\n" + "2.Sort (ID)\n" + "3.Exit\n");
		chos = inputInt("Your choice: ");
		return chos;
	}
	
	public static int inputInt(String s) {
		System.out.print(s);
		return scn.nextInt();
	}
	
	public static void creatStuList() throws Exception {
		SinhVien sv1 = new SinhVien(1114, "Huynh Thanh Giang", "TpHCM", "xxxxxxx");
		SinhVien sv2 = new SinhVien(1112, "Ho Quang Ziang", "TpHCM", "xxxxxxx");
		SinhVien sv3 = new SinhVien(1111, "Ho Vinh Jiang", "TpHCM", "xxxxxxx");
		SinhVien sv4 = new SinhVien(1113, "Le Tran Hoai Yang", "TpHCM", "xxxxxxx");
		
		svlist.addStu(sv1);
		svlist.addStu(sv2);
		svlist.addStu(sv3);
		svlist.addStu(sv4);
	}
	
	public static String inputString(String s) {
		System.out.println(s);
		return scn.nextLine();
	}
	
	public static long inputLong(String s) {
		System.out.println(s);
		return scn.nextLong();
	}
	
	public static SinhVien inputSV() {
		long stuID;
		String stuName, address, phone;
		
		stuID = inputLong("Input Student ID: ");
		while(svlist.isExisting(stuID)){
			System.out.println("This ID already exist!");
			stuID = inputLong("Input Student ID again: ");
		}
		scn.nextLine();
		stuName = inputString("Input Student Name: ");
		address = inputString("Input Address: ");
		phone = inputString("Input phonenumber: ");
		SinhVien sv = new SinhVien(stuID, stuName, address, phone);
		return sv;
	}
	
	public static void displayTitle() {
		String s = String.format("\t%-7s\t%20s\t%20s\t%15s\t%20s","STT", "Student ID", "Student Name", "Address", "Phonenumber");
		System.out.println(s);
	}
	
	public static void displayStu(SinhVien[] list) {
		for(int i=0;i<svlist.realElement;i++) {
			System.out.printf("\t%-7d\t",i+1);
			System.out.println(list[i]);
		}
	}
	
	public static void displayList() {
		SinhVien[] allSV = svlist.getAllStu();
		displayStu(allSV);
	}
}
