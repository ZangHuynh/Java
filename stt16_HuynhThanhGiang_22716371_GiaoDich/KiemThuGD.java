package stt16_HuynhThanhGiang_22716371_GiaoDich;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class KiemThuGD {
	static DSGiaoDich dsGiaoDich = new DSGiaoDich();
	static Scanner scn = new Scanner(System.in);
	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
	public static void main(String[] args) {
		try {
			int opt;
			do {
				opt = menuMain();
				scn.nextLine();
				switch (opt) {
					case 1: {
						nhapCung();
						break;
					}
					case 2: {
						GiaoDich newGD = nhapMem();
						dsGiaoDich.themGD(newGD);
						break;
					}
					case 3: {
						xoaTheoMa();
						break;
					}
					case 4: {
						capNhat();
						break;
					}
					case 5: {
						displayDS2023();
						break;
					}
					case 6: {
						displayList();
						break;
					}
					case 7: {
						dsGiaoDich.sortTheoMa();
						break;
					}
					case 8: {
						
						break;
					}
				default:
					System.out.println("Kết thúc chương trình!");;
				}
			}while(opt < 9);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static int menuMain() {
		System.out.println("\t******************************************");
		System.out.println("\t**   CHƯƠNG TRÌNH QUẢN LÝ GIAO DỊCH     **");
		System.out.println("\t* 1. Nhập cứng                           *");
		System.out.println("\t* 2. Thêm một phòng                      *");
		System.out.println("\t* 3. Xóa                                 *");
		System.out.println("\t* 4. Sửa                                 *");
		System.out.println("\t* 5. Xuất danh sách giao dịch 2023       *");
		System.out.println("\t* 6. Xuất danh sách tất cả giao dịch     *");
		System.out.println("\t* 7. Sắp xếp theo mã giao dịch           *");
		System.out.println("\t* 8. Tổng doanh thu theo mỗi tháng       *");
		System.out.println("\t* 9. Lưu và Thoát                        *");
		System.out.println("\t******************************************");
		System.out.print("Nhập lựa chọn: ");
		return scn.nextInt();
	}
	
	public static int menuGDD() {
		System.out.println("**** MENU GIAO DỊCH ĐẤT ****\n1.Ngày Giao Dịch\n2.Đơn Giá\n3.Diện Tích\n4.Loại Đất\n5.Exit");
		return scn.nextInt();
	}

	public static int menuGDN() {
		System.out.println("**** MENU GIAO DỊCH NHÀ ****\\n1.Ngày Giao Dịch\\n2.Đơn Giá\\n3.Diện Tích\n4.Loại Nhà\n5.Địa Chỉ\n6.Exit");
		return scn.nextInt();
	}
	
	public static void nhapCung() throws Exception {
		System.out.println("Nhập (1) để tạo Giao Dịch Đất, (số khác) để tạo Giao Dịch Nhà!");
		System.out.print("Nhập: ");
		int chos = scn.nextInt();
		if(chos == 1) {
			GiaoDich gd1 = new GiaoDichDat("1111", LocalDate.parse("18/8/2023",dtf), 200000000, 500, 1);
			GiaoDich gd2 = new GiaoDichDat("1112", LocalDate.parse("24/12/2023",dtf), 150000000, 300, 2);
			GiaoDich gd3 = new GiaoDichDat("1113", LocalDate.parse("23/4/2022",dtf), 300000000, 1000, 2);
			GiaoDich gd4 = new GiaoDichDat("1114", LocalDate.parse("10/11/2020",dtf), 320000000, 200, 1);
			dsGiaoDich.themGD(gd1);
			dsGiaoDich.themGD(gd2);
			dsGiaoDich.themGD(gd3);
			dsGiaoDich.themGD(gd4);
		} else {
			GiaoDich gd1 = new GiaoDichNha("2221", LocalDate.parse("30/10/2023",dtf), 230000000, 100, 2, "Tp.HCM");
			GiaoDich gd2 = new GiaoDichNha("2222", LocalDate.parse("5/12/2022",dtf), 250000000, 500, 1, "Tp.HCM");
			GiaoDich gd3 = new GiaoDichNha("2223", LocalDate.parse("8/9/2021",dtf), 330000000, 200, 2, "Tp.HCM");
			GiaoDich gd4 = new GiaoDichNha("2224", LocalDate.parse("25/5/2023",dtf), 100000000, 600, 1, "Tp.HCM");
			dsGiaoDich.themGD(gd1);
			dsGiaoDich.themGD(gd2);
			dsGiaoDich.themGD(gd3);
			dsGiaoDich.themGD(gd4);
		}
	}
	
	public static GiaoDich nhapMem() {
		String maGD;
		LocalDate ngayGD;
		double donGia, dienTich;
		System.out.println("Nhập (1) để tạo Giao Dịch Đất, (số khác) để tạo Giao Dịch Nhà!");
		System.out.println("Nhập: ");
		int chos = scn.nextInt();
		scn.nextLine();
		if(chos == 1) {
			System.out.print("Nhập mã giao dịch: ");
			maGD = scn.nextLine();
			System.out.print("Nhập ngày giao dịch: ");
			ngayGD = LocalDate.parse(scn.nextLine(),dtf);
			System.out.print("Nhập đơn giá giao dịch: ");
			donGia = scn.nextDouble();
			System.out.print("Nhập diện tích giao dịch: ");
			dienTich = scn.nextDouble();
			System.out.print("\n(1) Loại đất ruộng lúa.\n(số khác) Loại đất trồng cây.");
			System.out.print("Nhập loại đất: ");
			int loaiDat = scn.nextInt();
			GiaoDich newGD = new GiaoDichDat(maGD, ngayGD, donGia, dienTich, loaiDat);
			return newGD;
		} else {
			System.out.print("Nhập mã giao dịch: ");
			maGD = scn.nextLine();
			System.out.print("Nhập ngày giao dịch: ");
			ngayGD = LocalDate.parse(scn.nextLine(),dtf);
			System.out.print("Nhập đơn giá giao dịch: ");
			donGia = scn.nextDouble();
			System.out.print("Nhập diện tích giao dịch: ");
			dienTich = scn.nextDouble();
			System.out.print("\n(1) Loại nhà cao cấp.\n(số khác) Loại nhà thường.");
			System.out.print("Nhập loại nhà: ");
			int loaiNha = scn.nextInt();
			scn.nextLine();
			System.out.print("Nhập địa chỉ nhà: ");
			String diaChi = scn.nextLine();
			GiaoDich newGD = new GiaoDichNha(maGD, ngayGD, donGia, dienTich, loaiNha, diaChi);
			return newGD;
		}
	}
	
	public static void xoaTheoMa() throws Exception {
		System.out.print("Nhập mã Giao Dịch muốn xóa: ");
		String maGD = scn.nextLine();
		GiaoDich newGD = dsGiaoDich.timTheoMa(maGD);
		if(newGD!=null) {
			String choice;
			do {
				System.out.print("Bạn có chắc muốn xóa? (Y/N): ");
	            choice = scn.nextLine();
	            if (choice.equalsIgnoreCase("Y")) {
	                dsGiaoDich.xoaGD(newGD);
	                System.out.println("Xóa thành công!");
	            } else if (choice.equalsIgnoreCase("N")) {
	                System.out.println("Xóa không thành công!");
	            } else {
	                System.out.println("Nhập Y hoặc N!");
	            }
	        } while (!choice.equalsIgnoreCase("Y") && !choice.equalsIgnoreCase("N"));
		} else 
			throw new Exception("Giao Dịch không tồn tại!");
	}
	
	public static void capNhat() throws Exception {
		System.out.print("Nhập mã Giao Dịch muốn cập nhật: ");
		String maGD = scn.nextLine();
		GiaoDich newGD = dsGiaoDich.timTheoMa(maGD);
		if(newGD!=null) {
			if(newGD instanceof GiaoDichDat) {
				int choice;
				do {
					choice= menuGDD();
					switch(choice) {
					case 1:{
						System.out.print("Nhập ngày giao dịch: ");
						LocalDate ngayGD = LocalDate.parse(scn.nextLine(),dtf);
						newGD.setNgayGD(ngayGD);
						break;
					}
					case 2:{
						System.out.print("Nhập đơn giá giao dịch: ");
						double donGia = scn.nextDouble();
						newGD.setDonGia(donGia);
						break;
					}
					case 3:{
						System.out.print("Nhập diện tích giao dịch: ");
						double dienTich = scn.nextDouble();;
						newGD.setDienTich(dienTich);
						break;
					}
					case 4:{
						System.out.print("\n(1) Loại đất ruộng lúa.\n(số khác) Loại đất trồng cây.");
						System.out.print("Nhập loại đất: ");
						int loaiDat = scn.nextInt();
						((GiaoDichDat) newGD).setLoaiDat(loaiDat);
						break;
					}
					}
				}while(choice < 5);
			} else {
				int choice;
				do {
					choice = menuGDN();
					switch(choice) {
					case 1:{
						System.out.print("Nhập ngày giao dịch: ");
						LocalDate ngayGD = LocalDate.parse(scn.nextLine(),dtf);
						newGD.setNgayGD(ngayGD);
						break;
					}
					case 2:{
						System.out.print("Nhập đơn giá giao dịch: ");
						double donGia = scn.nextDouble();
						newGD.setDonGia(donGia);
						break;
					}
					case 3:{
						System.out.print("Nhập diện tích giao dịch: ");
						double dienTich = scn.nextDouble();;
						newGD.setDienTich(dienTich);
						break;
					}
					case 4:{
						System.out.print("\n(1) Loại nhà cao cấp.\n(số khác) Loại nhà thường.");
						System.out.print("Nhập loại nhà: ");
						int loaiNha = scn.nextInt();
						((GiaoDichNha) newGD).setLoaiNha(loaiNha);
						break;
					}
					case 5:{
						System.out.print("Nhập địa chỉ nhà: ");
						String diaChi = scn.nextLine();
						((GiaoDichNha) newGD).setDiaChi(diaChi);
						break;
					}
					default:{
						System.out.println("End of the program!");
					}
					}
				}while(choice < 6);
			}
		} else 
			throw new Exception("This room hasn't found!");
	}
	
	public static void displayTitle() {
		String s = String.format("%-15s %-20s %-20s %-20s %-20s %-25s %-20s", "Loại Giao Dịch", "Mã Giao Dịch", "Ngày Giao Dịch", "Đơn Giá", "Diện Tích", "Thành Tiền", "Loại Đất/Nhà", "Địa Chỉ Nhà");
		System.out.println(s);
	}
	
	public static void displayList() {
		System.out.println("*** DANH SÁCH GIAO DỊCH ***");
		displayTitle();
		for(GiaoDich gd : dsGiaoDich.getAll()) {
			if(gd instanceof GiaoDichDat) {
				System.out.printf("%-16s", "Giao Dịch Đất");
				System.out.println(gd);
			}else {
				System.out.printf("%-16s", "Giao Dịch Nhà");
				System.out.println(gd);
			}
		}
	}
	
	public static void displayDS2023() {
		System.out.println("*** DANH SÁCH GIAO DỊCH 2023 ***");
		displayTitle();
		for(GiaoDich gd : dsGiaoDich.ds2023()) {
			if(gd instanceof GiaoDichDat) {
				System.out.printf("%-16s", "Giao Dịch Đất");
				System.out.println(gd);
			}else {
				System.out.printf("%-16s", "Giao Dịch Nhà");
				System.out.println(gd);
			}
		}
	}
}
