package quanLySach;

import java.time.LocalDate;

public class SachThamKhao extends Sach
{
	private double thue;

	@Override
	 double thanhTien() {
		// TODO Auto-generated method stub
		double tien=0;
		tien = getDonGia()* getSoLuong()+getThue();
		return tien;
	}

	public double getThue() {
		return thue;
	}

	public void setThue(double thue) {
		this.thue = thue;
	}

	public SachThamKhao(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXB, double thue) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXB);
		this.thue = thue;
	}

	public SachThamKhao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SachThamKhao(String maSach, LocalDate ngayNhap, double donGia, int soLuong, String nhaXB) {
		super(maSach, ngayNhap, donGia, soLuong, nhaXB);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() +  String.format("%-30.2f|",getThue());
	}
}
