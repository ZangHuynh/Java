package tuan4_bai5_PhanSo;

import java.util.Scanner;

public class TestRational {
	static Scanner scn = new Scanner(System.in);
	public static void main(String[] args) {
		try {
			int opt;
			Rational ra1 = new Rational(2, 6);
			Rational ra2 = new Rational(1, 3);
			Rational newRat = new Rational();
			
			do {
				System.out.println("\nThe first rational: " + ra1);
				System.out.println("The second rational: " + ra2);
				System.out.println("The new rational: " + newRat);
				opt = menu();
				switch(opt) {
					case 1:{
						newRat = creatRational();
						break;
					}
					case 2:{
						ra1.reduce();
						ra2.reduce();
						newRat.reduce();
						break;
					}
					case 3:{
						ra1.reciprocal();
						ra2.reciprocal();
						newRat.reciprocal();
						break;
					}
					case 4:{
						System.out.println("The sum of ra1 and ra2: " + add(ra1, ra2)); 
						System.out.println("The sum of two new rationals: " + add(creatRational(), creatRational()));
						break;
					}
					case 5:{
						System.out.println("The substract of ra1 and ra2: " + subtract(ra1, ra2));
						System.out.println("The substract of ra1 and ra2: " + subtract(creatRational(), creatRational()));
						break;
					}
					case 6:{
						System.out.println("The multiphy of ra1 and ra2: " + multiply(ra1, ra2));
						System.out.println("multiphy of ra1 and ra2: " + multiply(creatRational(), creatRational()));
						break;
					}
					case 7:{
						System.out.println("The multiphy of ra1 and ra2: " + divide(ra1, ra2));
						System.out.println("The multiphy of ra1 and ra2: " + divide(creatRational(), creatRational()));
						break;
					}
					case 8:{
						compareTo(ra1, ra2);
						compareTo(creatRational(), creatRational());
						break;
					}
					case 9:{
						System.out.println("Goodbye!");
						break;
					}
				}
			}while(opt!=9);
		}catch(Exception err) {
			System.out.println(err.getMessage());
		}
	}
	
	public static int menu() {
		System.out.println("\n****MENU****\n" + "1.Input rational\n" + "2.Reduce\n"  + "3.Reciprocal\n" + "4.Add\n" + "5.Substract\n" + "6.Multiphy\n" + "7.Divide\n" + "8.Compare\n" + "9.Exit\n");
		return inputInt("Your choice: ");
	}
	
	public static int inputInt(String s) {
		System.out.print(s);
		return scn.nextInt();
	}
	
	public static Rational creatRational() {
		int numer, deno;
		numer = inputInt("Input numerator: ");
		deno = inputInt("Input denominator: ");
		Rational ra = new Rational(numer, deno);
		return ra;
	}
	
	public static void commonDenominator(Rational rat1, Rational rat2) {
		int n = rat1.getDenominator();
		rat1.setDenominator(rat1.getDenominator()*rat2.getDenominator());
		rat1.setNumerator(rat1.getNumerator()*rat2.getDenominator());
		rat2.setDenominator(rat1.getDenominator());
		rat2.setNumerator(rat2.getNumerator()*n);
	}
	
	public static Rational add(Rational rat1, Rational rat2) {
		Rational sum = new Rational();
		rat1.reduce();
		rat2.reduce();
		
		if(rat1.getDenominator()==rat2.getDenominator()) {
			sum.setNumerator(rat1.getNumerator()+rat2.getNumerator());
			sum.setDenominator(rat1.getDenominator());
		}else {
			commonDenominator(rat1, rat2);
			sum.setNumerator(rat1.getNumerator()+rat2.getNumerator());
			sum.setDenominator(rat1.getDenominator());
		}
		sum.reduce();
		return sum;
	}
	
	public static Rational subtract(Rational rat1, Rational rat2) {
		Rational sub = new Rational();
		rat1.reduce();
		rat2.reduce();
		
		if(rat1.getDenominator()==rat2.getDenominator()) {
			sub.setNumerator(rat1.getNumerator()-rat2.getNumerator());
			sub.setDenominator(rat1.getDenominator());
		}else {
			commonDenominator(rat1, rat2);
			sub.setNumerator(rat1.getNumerator()-rat2.getNumerator());
			sub.setDenominator(rat1.getDenominator());
		}
		sub.reduce();
		return sub;
	}
	
	public static Rational multiply(Rational rat1, Rational rat2) {
		Rational mul = new Rational();
		rat1.reduce();
		rat2.reduce();
		
		mul.setNumerator(rat1.getNumerator()*rat2.getNumerator());
		mul.setDenominator(rat1.getDenominator()*rat2.getDenominator());
		mul.reduce();
		return mul;
	}
	
	public static Rational divide(Rational rat1, Rational rat2) {
		Rational div = new Rational();
		rat1.reduce();
		rat2.reduce();
		rat2.reciprocal();
		
		div = multiply(rat1, rat2);
		div.reduce();
		return div;
	}
	
	public static void compareTo(Rational rat1, Rational rat2) {
		Rational s1 = new Rational(rat1.getNumerator(),rat1.getDenominator());
		Rational s2 = new Rational(rat2.getNumerator(),rat2.getDenominator());
		s1.reduce();
		s2.reduce();
		
		if(s1.getDenominator()==s2.getDenominator()) {
			if(s1.getNumerator()==s2.getNumerator())
				System.out.println(rat1+"="+rat2);
			else if(s1.getNumerator()>s2.getNumerator())
				System.out.println(rat1 + ">" + rat2);
				else System.out.println(rat1 + "<" + rat2);
		}else {
			commonDenominator(s1, s2);
			if(s1.getNumerator()==s2.getNumerator()) {
				System.out.println(rat1+"="+rat2);
			}else if(s1.getNumerator()>s2.getNumerator()) {
				System.out.println(rat1 + ">" + rat2);	
				}else System.out.println(rat1 + "<" + rat2);
		}
	}
}
