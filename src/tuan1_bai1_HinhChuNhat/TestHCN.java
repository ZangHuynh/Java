package tuan1_bai1_HinhChuNhat;

import java.util.Scanner;


public class TestHCN {
	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) throws Exception {
		int n;
		try {
			System.out.println("Calculate program");
			do {
				n = menu();
				switch(n) {
					case 1:{
						printTitle();
						nhapCung();
						break;
					}
					case 2: {
						HinhChuNhat cn1 = setWidthLength();
						printTitle();
						System.out.println(cn1);
						break;
					}
					default: {
						System.out.println("Goodbye!");
						break;
					}
				}
			} while(n < 3);
		} catch (Exception err) {
			System.out.println(err.getMessage());
		}
	}
	
	public static int menu() {
		int chos;
		System.out.println("***Menu***\n" + "1.Nhập cứng\n" + "2.Nhập mềm\n" + "3.Thoát\n");
		chos = setNumber("Your choice: ");
		return chos;
	}
	
	static void printTitle() {
		String s=String.format("%10s %12s %10s %10s","Chiều dài", "Chiều Rộng", "Chu vi", "Diện tích");
		System.out.println(s);
	}
	
	public static int setNumber(String str) {
		System.out.println(str);
		return scn.nextInt();
	}
	
	public static void nhapCung() throws Exception {
		HinhChuNhat cn1 = new HinhChuNhat();
		cn1.setLength(5);
		cn1.setWidth(10);
		HinhChuNhat cn2 = new HinhChuNhat(10,8);
		System.out.println(cn1);
		System.out.println(cn2);
	}
	
	public static HinhChuNhat setWidthLength() {
		int l,w;
		l = setNumber("Input length: ");
		w = setNumber("Input width: ");
		HinhChuNhat cn = new HinhChuNhat(l,w);
		return cn;
	}
}
