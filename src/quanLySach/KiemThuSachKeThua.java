package quanLySach;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class KiemThuSachKeThua {
	static DanhSachCacSach DS = new DanhSachCacSach();
	static Scanner scn = new Scanner(System.in);
	static DecimalFormat df = new DecimalFormat("#,##0.00 VND");
	static void suaSach() throws Exception {
		LocalDate ngayNhap;
		System.out.println("Nhập mã sách cần sửa ");
		String maSach = scn.nextLine();
		Sach sachS = DS.timKiemDoiTuongSach(maSach);
		if (sachS != null) {
			System.out.println("Thông tin sách trước khi sửa \n" + sachS);
			if (sachS instanceof SachGiaoKhoa) {
				//thầy sửa tình trang và ngày nhập
				System.out.println("nhập ngày-tháng-năm sửa (dd/MM/yyyy)!!");
				String ngayChuoi = scn.nextLine();
				ngayNhap = convertToDate(ngayChuoi);
				System.out.println("Nhập tình trang 1 nếu là sách mới hoặc O nếu là sách cũ: ");
				int tinhTrang  = scn.nextInt();
				while (tinhTrang!=1 && tinhTrang!=0) {
					System.out.println("Vui lòng nhập đúng yêu cầu");
					tinhTrang = new Scanner(System.in).nextInt();
				}
				Boolean	kieu = tinhTrang == 1 ? true : false;
				sachS.setNgayNhap(ngayNhap)	;
				((SachGiaoKhoa) sachS).setTinhTrang(kieu);//vì sách giáo khoa mới có tình trạng
			} 
			else {
				//Thầy sửa nhà xuất bản
				System.out.println("Nhập nhà xuất bản");
				String nhaXBan=scn.nextLine();
				sachS.setNhaXB(nhaXBan);
			}
			DS.sua(sachS);
		} 
		else 
			System.out.println("Không tồn tại mã sách này");
	}
	public static LocalDate convertToDate(String dateString) {
		// dateString=06/10/2023
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate date = LocalDate.parse(dateString, dateFormatter);
		return date;
	}
	static void xoaSach() {
		System.out.println("Nhập mã sách cần xóa");
		String maSach = scn.nextLine();
		Sach sachTim = DS.timKiemDoiTuongSach(maSach);
		if (sachTim != null) {
			System.out.println("Bạn có xác nhận xóa sách này không [y/Y]: ");
			String acp = scn.nextLine();
			if (acp.equalsIgnoreCase("y")) {
				DS.xoa(sachTim);
			} else {
				System.out.println("Bạn đã giữ lại sách này");
			}
		} else
			System.out.println("Không tồn tại mã sách này");

	}
	public static void nhapDefaul() throws Exception {

		LocalDate ngay1= convertToDate("03/01/2023");
		LocalDate ngay2= convertToDate("07/11/2023");
		LocalDate ngay3= convertToDate("08/12/2023");
		LocalDate ngay4= convertToDate("05/06/2023");
		LocalDate ngay5= convertToDate("05/03/2023");

		Sach sach1 = new SachGiaoKhoa("TV1", ngay1, 25000, 20, "Kim Đồng", true);
		Sach sach2 = new SachGiaoKhoa("EL1", ngay2, 10000, 32, "Phương Nam", false);
		Sach sach3 = new SachThamKhao("MT1", ngay3, 23000, 14, "Phương Lan", 1500);
		Sach sach4 = new SachThamKhao("LS12", ngay4, 43000, 14, "Hoa Mộc Lan", 2500);
		Sach sach5 = new SachThamKhao("LS13", ngay5, 43000, 14, "Tổng hợp TP.HCM", 2500);
		DS.them(sach1);
		DS.them(sach2);
		DS.them(sach3);
		DS.them(sach4);
		DS.them(sach5);
	}
	static Sach themMotSachMoi() {
		Sach sachMoi=null;
		try {
			String maSach, nhaXB, ngayChuoi;
			LocalDate ngayNhap;
			int soLuong;
			double donGia;

			System.out.println("Nhập mã sách: ");
			maSach = scn.nextLine();
			Sach objSach = DS.timKiemDoiTuongSach(maSach);
			if (objSach != null) {
				System.out.println("Mã sách đã trùng");
				return null;
			} else { 
				// không trùng
				// ngayChuoi=09/10/2023
				System.out.println("nhập ngày-tháng-năm (dd/MM/yyyy)!!");
				ngayChuoi = scn.nextLine();
				ngayNhap = convertToDate(ngayChuoi);
				System.out.println("Nhập đơn giá: ");
				donGia = scn.nextDouble();
				System.out.println("Nhập số lượng: ");
				soLuong = scn.nextInt();
				System.out.println("Nhập nhà xuất bản: ");
				nhaXB = scn.nextLine();
				System.out.println("Nhập sách giáo khoa nhấn 1 hoặc khác để nhập sách tham khảo: ");
				int chon = scn.nextInt(); // để nhập 1 hay khác

				if (chon == 1) {
					int  tinhTrang;
					System.out.println("Nhập 1 nếu là sách mới hoặc O nếu là sách cũ: ");
					tinhTrang  = scn.nextInt();
					while (tinhTrang!=1 && tinhTrang!=0) {
						System.out.println("Vui lòng nhập đúng yêu cầu");
						tinhTrang = new Scanner(System.in).nextInt();
					}
					Boolean	kieu = tinhTrang == 1 ? true : false;
					sachMoi = new SachGiaoKhoa(maSach, ngayNhap, donGia, soLuong, nhaXB, kieu);
				} else {
					// sách tham khảo
					double thue;
					System.out.println("Nhập thuế");
					thue = scn.nextDouble();
					sachMoi = new SachThamKhao(maSach, ngayNhap, donGia, soLuong, nhaXB, thue);
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return sachMoi;
	}
	static void xuatDSSachThamKhao() {
		System.out.println("\t\t\t\t\t\tDANH SÁCH CÁC LOẠI SÁCH THAM KHAO \n");
		System.out.println(
				"\t-----------------------------------------------------------------------------------------------------------");
		System.out.println("\t" + tieuDeThamKhao());
		System.out.println(
				"\t-----------------------------------------------------------------------------------------------------------");
		for (Sach sGiaoKhoa : DS.getListSachThamKhao()) {
			System.out.println("\t" + sGiaoKhoa);
			System.out.println(
				"\t-----------------------------------------------------------------------------------------------------------");
		}
		System.out.println("\n\n\n");
	}
	static void xuatDSSachGK() {
		System.out.println("\t\t\t\t\t\tDANH SÁCH CÁC LOẠI SÁCH GIÁO KHOA \n");
		System.out.println(
				"\t-----------------------------------------------------------------------------------------------------------");
		System.out.println("\t" + tieuDeGiaoKhoa());
		System.out.println(
				"\t-----------------------------------------------------------------------------------------------------------");
		for (Sach sGiaoKhoa : DS.getListSachGiaoKhoa()) {
			System.out.println("\t" + sGiaoKhoa);
			System.out.println(
				"\t-----------------------------------------------------------------------------------------------------------");
		}
		System.out.println("\n\n\n");
	}
	static String tieuDeGiaoKhoa() {
		return String.format("|%-10s|%-15s|%-15s|%-10s|%-20s|%-30s|%-30s|", "Mã sách", "Ngày nhập", "Đơn giá", "Số lượng",
				"Nhà XB", "Thành Tiên", "Tình Trang");
	}
	static String tieuDeThamKhao() {
		return String.format("|%-10s|%-15s|%-15s|%-10s|%-20s|%-30s|%-30s|", "Mã sách", "Ngày nhập", "Đơn giá", "Số lượng",
				"Nhà XB", "Thành Tiên", "Thuế");
	}
	static String tieuDeChung() {
		return String.format("|%-10s|%-15s|%-15s|%-10s|%-20s|%-30s|%-30s|", "Mã sách", "Ngày nhập", "Đơn giá", "Số lượng",
				"Nhà XB", "Thành Tiên", "Thuế(STK) hoặc TTrang(SGK)");
	}
	static void xuatAll() {
		System.out.println("\t\t\t\t\t\tDANH SÁCH CÁC LOẠI SÁCH \n");
		System.out.println(
				"\t------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("\t" + tieuDeChung());
		System.out.println(
				"\t------------------------------------------------------------------------------------------------------------------------------------------");
		for (Sach objsach : DS.getAllSach()) {
			System.out.println("\t" + objsach);
			System.out.println(
				"\t------------------------------------------------------------------------------------------------------------------------------------------");
		}
		System.out.println("\n\n");
	}
	public static void main(String[] args) throws Exception
	{
		Sach objSach=null;
		int chon = -1;
		try {
			do {
				Menu();
				System.out.println("Nhập lựa chọn: ");

				chon = scn.nextInt();
				switch (chon) 
				{
				case 1:
					nhapDefaul();
					break;
				case 2:
					objSach= themMotSachMoi();
					DS.them(objSach);
					break;
				case 3:
					xoaSach();
					break;
				case 4:
					suaSach();
					break;
				case 5:
					DS.sortTheoNhaXBanSoLuong();
					break;
				case 6:
					// DSsortTheoDonGia();break;}
				case 7:
					xuatDSSachGK();
					break;
				case 8:
					xuatDSSachThamKhao();
					break;
				case 9:
					DS.sortTheoNgayNhap();
					xuatAll();
					break;
				case 10:
					System.out.println("Tổng tiền Sách Giáo Khoa: " + df.format(DS.sumTotalPriceGK()));
					System.out.println("Tổng tiền Sách Giáo Khoa: " + df.format(DS.sumTotalPriceTK()));
					break;
				case 11:
					xuatAll();
					break;
				default:
					System.out.println("Cảm ơn bạn đã sử dụng chương trình");
				}
			} while (chon < 12);

		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Lỗi " + e.getMessage());
		}
	}
	static void Menu() {
		System.out.println("\t********************************************");
		System.out.println("\t**     Chương trình quản lí thư viện      **");
		System.out.println("\t* 1. Nhập cứng mặc định                    *");
		System.out.println("\t* 2. Nhập 1 sách mới                       *");
		System.out.println("\t* 3. Xóa                                   *");
		System.out.println("\t* 4. Sửa                                   *");
		System.out.println("\t* 5. Sắp xếp theo nhà xuất bản và số lượng *");                            
		System.out.println("\t* 6. Sắp xếp theo đơn giá                  *");
		System.out.println("\t* 7. Xuất danh sách SGK và tổng tiền SGK   *");
		System.out.println("\t* 8. Xuất danh sách STK và tổng tiền STK   *");
		System.out.println("\t* 9. Sắp xếp theo ngày nhập                *");
		System.out.println("\t* 10. Xuất tổng số tiền của các loại sách  *");
		System.out.println("\t* 11. Xuất toàn bộ danh sách               *");
		System.out.println("\t* 12. Thoát                                *");
		System.out.println("\t********************************************");
	}
}
