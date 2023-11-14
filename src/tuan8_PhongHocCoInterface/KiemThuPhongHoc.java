package tuan8_PhongHocCoInterface;

import java.util.ArrayList;
import java.util.Scanner;

public class KiemThuPhongHoc {
	static DanhSachPhong DSPhong = new DanhSachPhong();
	static PhongHoc phongHoc;
	// ----------------------------------------end-------------------------------------------------------------------------
	static String tieuDe() {
		return String.format("%-10s%-15s%-15s%-15s%-20s", "Dãy nhà", "Mã phòng", "SLBĐ", "Diện tích", "Ghi Chú");
	}

	static void Menu() {
		System.out.println("\t******************************************");
		System.out.println("\t**   Chương trình quản lí phòng học     **");
		System.out.println("\t* 1. Đọc dữ liệu                         *");
		System.out.println("\t* 2. Thêm một phòng                      *");
		System.out.println("\t* 3. Xóa                                 *");
		System.out.println("\t* 4. Sửa                                 *");
		System.out.println("\t* 5. Xuất danh sách phòng đạt chuẩn      *");
		System.out.println("\t* 6. Xuất danh sách các phòng            *");
		System.out.println("\t* 7. Sắp xếp theo dãy nhà                *");
		System.out.println("\t* 8. Sắp xếp theo diện tích              *");
		System.out.println("\t* 9. Sắp xếp theo số bóng đèn tăng dần   *");
		System.out.println("\t* 10.Danh sách các phòng có 60 máy       *");
		System.out.println("\t* 11.Tổng số phòng học                   *");
		System.out.println("\t* 12.Tổng số phòng học                   *");
		System.out.println("\t* 13.Sắp xếp theo 3 thuộc tính           *");
		System.out.println("\t* 14. Lưu và Thoát                       *");
		System.out.println("\t******************************************");
		System.out.println("---Nhập lựa chọn---");
	}

	static void menuChung() {
		System.out.println("\t*****************************************");
		System.out.println("\t**       Mời nhập thông tin cần sửa    **");
		System.out.println("\t* 1. Dãy nhà                            *");
		System.out.println("\t* 2. Số bóng đèn                        *");
		System.out.println("\t* 3. Diện tích                          *");

	}

	static void menuSuaPLT() {
		menuChung();
		System.out.println("\t* 4. Máy chiếu                          *");
		System.out.println("\t* 5. Về menu chính                      *");
		System.out.println("\t*****************************************");
		System.out.println("---Nhập lựa chọn---");
	}

	static void menuSuaPMT() {
		menuChung();
		System.out.println("\t* 4. Số lượng máy tính                  *");
		System.out.println("\t* 5. Về menu chính                      *");
		System.out.println("\t*****************************************");
		System.out.println("---Nhập lựa chọn---");
		;
	}

	static void menuSuaPTN() {
		menuChung();
		System.out.println("\t* 4. Bồn rữa tay                        *");
		System.out.println("\t* 5. Về menu chính                      *");
		System.out.println("\t*****************************************");
		System.out.println("---Nhập lựa chọn---");
	}

	static void nhapCung() throws Exception {

		PhongHoc p1 = new PhongLyThuyet("V", "V14.01", 100, 100, true);
		PhongHoc p2 = new PhongLyThuyet("V", "V14.02", 80, 80, false);
		PhongHoc p3 = new PhongMayTinh("H", "H51", 61, 65, 70);
		PhongHoc p4 = new PhongMayTinh("H", "H52", 70, 40, 60);
		PhongHoc p5 = new PhongThiNghiem("X", "X10", 20, 10, false);
		PhongHoc p6 = new PhongThiNghiem("X", "X12", 30, 15, true);
		DSPhong.them(p1);
		DSPhong.them(p2);
		DSPhong.them(p3);
		DSPhong.them(p4);
		DSPhong.them(p5);
		DSPhong.them(p6);

		
		  System.out.println("Đã đọc dữ liệu cũ thành công");
		 

	}

	static PhongHoc themPhongHoc() {
		String dayNha;
		String maPhong;
		double dienTich;
		int soBongDen;
		System.out.println("Nhập mã phòng: ");
		maPhong = new Scanner(System.in).nextLine();
		if (DSPhong.timKiemViTri(maPhong) != -1) { // tìm thấy
			System.out.println("Mã phòng đã trùng");
			return null;
		} else { // không tìm thấy
			System.out.println("Nhập dãy nhà:");
			dayNha = new Scanner(System.in).nextLine();
			System.out.println("Nhập diện tích: ");
			dienTich = new Scanner(System.in).nextDouble();
			System.out.println("Nhập số bóng đèn: ");
			soBongDen = new Scanner(System.in).nextInt();
			System.out.println("Nhập [1] nếu là phòng lý thuyết " + "[2] nếu là phòng máy tính "
					+ "hoặc khác để nhập phòng thí nghiệm");
			int luaChon = new Scanner(System.in).nextInt();
			if (luaChon == 1) // phòng lý thuyết
			{
				boolean mayChieu;
				System.out.println("Phòng này có máy chiếu hay không [Y/N]: ");
				String coMC = new Scanner(System.in).next();
				while (!coMC.equalsIgnoreCase("y") && !coMC.equalsIgnoreCase("n")) {
					System.out.println("Vui lòng nhập đúng yêu cầu");
					System.out.println("Phòng này có máy chiếu hay không [Y/N]: ");
					coMC = new Scanner(System.in).next();
				}
				mayChieu = (coMC.equalsIgnoreCase("y")) ? true : false;
				phongHoc = new PhongLyThuyet(dayNha, maPhong, dienTich, soBongDen, mayChieu);
			} else if (luaChon == 2) { // phòng máy tính
				int soLuong;
				System.out.println("Nhập số lượng máy tính: ");
				soLuong = new Scanner(System.in).nextInt();
				phongHoc = new PhongMayTinh(dayNha, maPhong, dienTich, soBongDen, soLuong);
			} else {
				boolean bonRuaTay;
				System.out.println("Phòng này có bồn rữa tay hay không [Y/N]: ");
				String coBRT = new Scanner(System.in).next();
				while (!coBRT.equalsIgnoreCase("y") && !coBRT.equalsIgnoreCase("n")) {
					System.out.println("Vui lòng nhập đúng yêu cầu");
					System.out.println("Phòng này có bồn rữa tay hay không [Y/N]: ");
					coBRT = new Scanner(System.in).next();
				}
				bonRuaTay = (coBRT.equalsIgnoreCase("y")) ? true : false;
				phongHoc = new PhongThiNghiem(dayNha, maPhong, dienTich, soBongDen, bonRuaTay);
			}
		}
		return phongHoc;
	}

	static void xuat() {
		System.out.println("\n\t\t\t DANH SÁCH CÁC PHÒNG\n\n");
		System.out.println(tieuDe());
		System.out.println("===============================================================================");
		for (PhongHoc phong : DSPhong.getDSPhong()) {
			System.out.println(phong);
		}
		System.out.println("\n\n\n");
	}

	static void xoaPhong() {
		System.out.println("Nhập mã phòng cần xóa: ");
		String maPhong = new Scanner(System.in).nextLine();
		PhongHoc px = DSPhong.timKiemPhongHoc(maPhong);
		if (px == null) {
			System.out.println("Không tìm thấy mã phòng");
		} else {
			System.out.println("Bạn có xác nhận xóa phòng này không [y/n]: ");
			String acp = new Scanner(System.in).nextLine();
			if (acp.equalsIgnoreCase("y")) {
				DSPhong.xoa(px);
			} else {
				System.out.println("Bạn đã giữ lại phòng này");
			}
		}
	}

	static void suaChung(int chon, PhongHoc phs) {
		switch (chon) {
		case 1:
			System.out.println("Nhập dãy nhà:");
			phs.setDayNha(new Scanner(System.in).nextLine());
			break;
		case 2:
			System.out.println("Nhập diện tích: ");
			phs.setDienTich(new Scanner(System.in).nextDouble());
			break;
		case 3:
			System.out.println("Nhập số bóng đèn: ");
			phs.setSoBongDen(new Scanner(System.in).nextInt());
			break;
		}

	}

	static void suaPhong() {
		int chon = -1, cnt = 0;
		System.out.println("Nhập mã phòng cần sửa: ");
		String maPhong = new Scanner(System.in).nextLine();
		PhongHoc ps = DSPhong.timKiemPhongHoc(maPhong);
		if (ps == null) {
			System.out.println("Không tìm thấy mã phòng");
		} else {
			System.out.println(tieuDe());
			System.out.println("===============================================================================");
			System.out.println("Thông tin phòng trước khi sửa: \n" + ps);
			if (ps instanceof PhongLyThuyet) { // nếu là phòng lý thuyết
				PhongLyThuyet phs = (PhongLyThuyet) ps;
				do {
					menuSuaPLT();
					chon = new Scanner(System.in).nextInt();
					cnt++;
					suaChung(chon, phs);
					if (chon == 4) {
						System.out.println("Phòng này có máy chiếu hay không [Y/N]: ");
						String coMC = new Scanner(System.in).next();
						while (!coMC.equalsIgnoreCase("y") && !coMC.equalsIgnoreCase("n")) {
							System.out.println("Vui lòng nhập đúng yêu cầu");
							System.out.println("Phòng này có máy chiếu hay không [Y/N]: ");
							coMC = new Scanner(System.in).next();
						}
						phs.setMayChieu((coMC.equalsIgnoreCase("y")) ? true : false);
					}
					if (chon == 5) {
						if (cnt > 1)
							DSPhong.sua(phs);
						System.out.println("Về menu chính");
						break;
					}
				} while (chon < 5);

			} else if (ps instanceof PhongMayTinh) { // nếu là phòng máy tính
				PhongMayTinh phs = (PhongMayTinh) ps;
				do {
					menuSuaPMT();
					chon = new Scanner(System.in).nextInt();
					cnt++;
					suaChung(chon, phs);
					if (chon == 4) {
						System.out.println("Nhập số lượng máy tính: ");
						phs.setSoLuongMayTinh(new Scanner(System.in).nextInt());
					}
					if (chon == 5) {
						if (cnt > 1)
							DSPhong.sua(phs);
						System.out.println("Về menu chính");
						break;
					}
				} while (chon < 6);

			} else { // là phòng thí nghiệm
				PhongThiNghiem phs = (PhongThiNghiem) ps;
				do {
					menuSuaPTN();
					chon = new Scanner(System.in).nextInt();
					cnt++;
					suaChung(chon, phs);
					if (chon == 4) {
						System.out.println("Phòng này có bồn rữa tay hay không [Y/N]: ");
						String coBRT = new Scanner(System.in).next();
						while (!coBRT.equalsIgnoreCase("y") && !coBRT.equalsIgnoreCase("n")) {
							System.out.println("Vui lòng nhập đúng yêu cầu");
							System.out.println("Phòng này có bồn rữa tay hay không [Y/N]: ");
							coBRT = new Scanner(System.in).next();
						}
						phs.setBonRuaTay((coBRT.equalsIgnoreCase("y")) ? true : false);
					}
					if (chon == 5) {
						if (cnt > 1)
							DSPhong.sua(phs);
						System.out.println("Về menu chính");
						break;
					}
				} while (chon < 5);

			}
		}
	}

	static void xuatPhongDatChuan() {
		System.out.println("\t\t\tDANH SÁCH PHÒNG ĐẠT CHUẨN\n\n");
		System.out.println(tieuDe());
		System.out.println("===============================================================================");
		for (PhongHoc phong : DSPhong.getDSPhongDatChuan()) {
			System.out.println(phong);
		}
		System.out.println("\n\n\n");
	}

	static void sortTheoTenDayNha() {
		DSPhong.sortTheoDayNha();
		System.out.println("Đã sắp xếp thành công");
	}

	static void sortTheoDienTichGiamDan() {
		DSPhong.sortTheoDienTich();
		System.out.println("Đã sắp xếp thành công");
	}

	static void sortTheoSoBongDenTangDan() {
		DSPhong.sortTheoBongDen();
		System.out.println("Đã sắp xếp thành công");
	}

	static void xuatPhongMayTinh60() {
		if (DSPhong.DSPhongCoSoMayCo60().size() == 0)
			System.out.println("Không có phòng nào");
		else {
			System.out.println("\t\t\tDANH SÁCH PHÒNG CÓ 60 MÁY\n\n");
			System.out.println(tieuDe());
			System.out.println("===============================================================================");
			for (PhongHoc phong : DSPhong.DSPhongCoSoMayCo60()) {
				System.out.println(phong);
			}
			System.out.println("\n\n\n");
		}

	}

	static void themMem() throws Exception {
		PhongHoc p = themPhongHoc();
		if (p != null) {
			DSPhong.them(p);
			System.out.println("Thêm thành công");
		}
	}

	static void xuatTongSoPhongHoc() {
		System.out.println("Có tổng cộng: " + DSPhong.getSoLuongPhong() + " phòng học");
	}

	static void demSoDayNhaHienCo() {
		System.out.println("Có tất cả: " + DSPhong.demSoDayNha() + " dãy nhà");
	}

	static void sortTheo3Truong() {
		DSPhong.sortTheo3ThuocTinh();
		System.out.println("Đã sắp xếp thành công");
	}

	public static void main(String[] args) throws Exception {
		try {
			int chon = -1;
			do {
				Menu();
				chon = new Scanner(System.in).nextInt();
				switch (chon) {
				case 1: {nhapCung();break;}
				case 2: {themMem();break;}
				case 3: {xoaPhong();break;}
				case 4: {suaPhong();break;}
				case 5: {xuatPhongDatChuan();break;}
				case 6: {xuat();break;}
				case 7: {sortTheoTenDayNha();break;}
				case 8: {sortTheoDienTichGiamDan();break;}
				case 9: {sortTheoSoBongDenTangDan();break;}
				case 10: {xuatPhongMayTinh60();break;}
				case 11: {xuatTongSoPhongHoc();break;}
				case 12: {demSoDayNhaHienCo();break;}
				case 13: {sortTheo3Truong();break;}
				default:
					System.out.println("Cảm ơn đã sử dụng chương trình");
				}
			} while (chon < 14);

		} catch (ArithmeticException e1) {
			System.out.println("Không được chia cho không" + e1.getMessage());
		} catch (ArrayIndexOutOfBoundsException e2) {
			System.out.println("Lỗi mảng" + e2.getMessage());
		} catch (Exception e) {
			System.out.println("Lỗi không xác định" + e.getMessage());
		}
	}
}
