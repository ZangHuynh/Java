package tuan1_bai2_QuanLySinhVien;

import java.util.Scanner;

public class QLySinhVien {
	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		SinhVien sv1 = new SinhVien("22716371", "Huynh Thanh Giang", 7, 10);
		SinhVien sv2 = new SinhVien("22717181", "Ho Vinh Thai", 1, 1);
		
		
		//sv3
		SinhVien sv3 = new SinhVien();
		System.out.println("Input your id: ");
		sv3.setMaSV(scn.nextLine());
		System.out.println("Input your name: ");
		sv3.setNameSV(scn.nextLine());
		System.out.println("Input LT point: ");
		sv3.setLTp(scn.nextFloat());
		System.out.println("Input TH point: ");
		sv3.setTHp(scn.nextFloat());
		
		System.out.println("Student Management ");
		printTitle();
		System.out.println(sv1);
		System.out.println(sv2);
		System.out.println(sv3);
	}
	
	static void printTitle() {
		String s = String.format("%15s %20s %12s %12s %15s", "Ma SV", "Name", "LT point", "TH point", "Average point");
		System.out.println(s);
	}
}
