package stt16_HuynhThanhGiang_22716371;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TestGD {
	static ArrayGD gdList = new ArrayGD();
	static Scanner scn = new Scanner(System.in);
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
	static DecimalFormat df = new DecimalFormat("#,##0.00 VND");
	
	public static void main(String[] args) {
		try {
			int opt;
			do {
				opt = inputInt("Lựa chọn: ");
				switch(opt) {
				case 1:{
					createDefault();
					break;
				}
				case 2:{
					displayGD();
					break;
				}
				case 3:{
					GiaoDich newGD = createAGD();
					gdList.addGD(newGD);
					break;
				}
				case 4:{
					removeGiaoDich();
					break;
				}
				case 5:{
					updateGD();
					break;
				}
				case 6:{
					doanhThuTheoNam();
					break;
				}
				default:{
					System.out.println("Kết thúc chương trình!");
					break;
				}
				}
				
			}while(opt < 7);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static int inputInt(String s) {
		System.out.print(s);
		return scn.nextInt();
	}
	
	public static String inputString(String s) {
		System.out.print(s);
		return scn.next();
	}

	public static double inputDouble(String s) {
		System.out.print(s);
		return scn.nextDouble();
	}
	
	public static LocalDate inputDate(String s) {
		System.out.print(s);
		return LocalDate.parse(scn.next(),dtf);
	}
	
	public static boolean inputBoolean(String s) {
		System.out.print(s);
		return scn.nextBoolean();
	}
	
	public static void createDefault() throws Exception {
		System.out.println("Nhập (1) để tạo Giao Dịch Vàng, (số khác) để tạo Giao Dịch Đá Quý!");
		int choice = inputInt("Lựa chọn: ");
		if(choice == 1) {
			GiaoDich gd1 = new GiaoDichVang("V1111", LocalDate.parse("10/10/2023",dtf), 1000000, "999", 10);
			GiaoDich gd2 = new GiaoDichVang("V1112", LocalDate.parse("10/11/2023",dtf), 1000000, "98", 10);
			GiaoDich gd3 = new GiaoDichVang("V1113", LocalDate.parse("10/12/2023",dtf), 1000000, "SJC", 10);
			GiaoDich gd4 = new GiaoDichVang("V1114", LocalDate.parse("10/8/2023",dtf), 1000000, "999", 10);
			gdList.addGD(gd1);
			gdList.addGD(gd2);
			gdList.addGD(gd3);
			gdList.addGD(gd4);
			
		} else {
			GiaoDich gd1 = new GiaoDichDaQuy("DQ2221", LocalDate.parse("11/11/2023",dtf), 5000000, false, "XXX", 3);
			GiaoDich gd2 = new GiaoDichDaQuy("DQ2222", LocalDate.parse("11/10/2023",dtf), 5000000, false, "XXX", 3);
			GiaoDich gd3 = new GiaoDichDaQuy("DQ2223", LocalDate.parse("11/1/2023",dtf), 5000000, true, "XXX", 3);
			GiaoDich gd4 = new GiaoDichDaQuy("DQ2224", LocalDate.parse("11/8/2023",dtf), 5000000, true, "XXX", 3);
			gdList.addGD(gd1);
			gdList.addGD(gd2);
			gdList.addGD(gd3);
			gdList.addGD(gd4);
		}
	}
	
	public static GiaoDich createAGD() {
		System.out.println("Nhập (1) để tạo Giao Dịch Vàng, (số khác) để tạo Giao Dịch Đá Quý!");
		int choice = inputInt("Lựa chọn: ");

		String maGD = inputString("Nhập mã giao dịch: ");
		while(gdList.findByCode(maGD)!=null) {
			System.out.println("Giao Dịch đã tồn tại!");
			maGD = inputString("Nhập lại mã giao dịch: ");
		}
		LocalDate ngayGD = inputDate("Nhập ngày giao dịch: ");
		double donGia = inputDouble("Nhập đơn giá: ");
		
		if(choice == 1) {
			String loaiVang = inputString("Nhập loại vàng: ");
			double soLang = inputDouble("Nhập số lạng: ");
			GiaoDich newGD = new GiaoDichVang(maGD, ngayGD, donGia, loaiVang, soLang);
			return newGD;
		} else {
			boolean loai = inputBoolean("Nhập loại (true/false): ");
			String diaChi = inputString("Nhập địa chỉ: ");
			double soCara = inputDouble("Nhập số Cara: ");
			GiaoDich newGD = new GiaoDichDaQuy(maGD, ngayGD, donGia, loai, diaChi, soCara);
			return newGD;
		}
	}
	
	public static void removeGiaoDich() throws Exception {
		String maGD = inputString("Nhập mã Giao Dịch muốn xóa: ");
		GiaoDich newGD = gdList.findByCode(maGD);
		if(newGD != null) {
			String choice;
			do {
	            choice = inputString("Bạn chắc chắn muốn xóa? (Y/N): ");
	            if (choice.equalsIgnoreCase("Y")) {
	                gdList.removeGD(newGD);
	                System.out.println("Xóa thành công");
	            } else if (choice.equalsIgnoreCase("N")) {
	                System.out.println("Xóa không thành công");
	            } else {
	                System.out.println("Hãy nhập Y hoặc N");
	            }
	        } while (!choice.equalsIgnoreCase("Y") && !choice.equalsIgnoreCase("N"));
		} else 
			throw new Exception("Giao Dịch không tồn tại!");
	}
	
	public static void updateGD() throws Exception {
		String maGD = inputString("Nhập mã Giao Dịch muốn update: ");
		GiaoDich newGD = gdList.findByCode(maGD);
		if(newGD != null) {
			double donGia = inputDouble("Cập nhật đơn giá: ");
			newGD.setDonGia(donGia);
		} else 
			throw new Exception("Giao Dịch không tồn tại!");
	}
	
	public static void doanhThuTheoNam() {
		int nam = inputInt("Nhập năm muốn tính doanh thu: ");
		System.out.println("Doanh thu theo " + nam + ": " + df.format(gdList.doanhThu1Nam(nam)));
	}
	
	public static void displayGD() {
		System.out.println("*** GIAO DỊCH ***");
		for(GiaoDich gd : gdList.getAll())
			System.out.println(gd);
	}
}
