package stt16_HuynhThanhGiang_22716371;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class GiaoDichVang extends GiaoDich{
	private String loaiVang;
	private double soLang;
	
	@Override
	public double thanhTien() {
		if(loaiVang.equalsIgnoreCase("SJC")) return soLang * donGia;
		else if(loaiVang.equalsIgnoreCase("999")) return soLang * donGia * 0.8;
		else return soLang * donGia * 0.7;
	}

	public GiaoDichVang(String maGD, LocalDate ngayGD, double donGia, String loaiVang, double soLang) {
		super(maGD, ngayGD, donGia);
		this.loaiVang = loaiVang;
		this.soLang = soLang;
	}

	public GiaoDichVang() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiaoDichVang(String maGD, LocalDate ngayGD, double donGia) {
		super(maGD, ngayGD, donGia);
		// TODO Auto-generated constructor stub
	}

	public String getLoaiVang() {
		return loaiVang.toUpperCase();
	}

	public void setLoaiVang(String loaiVang) throws Exception {
		if(loaiVang.matches("SJC|999|98"))	
			this.loaiVang = loaiVang;
		else throw new Exception("Loại chỉ có thể là SJC, 999, 98!");
	}

	public double getSoLang() {
		return soLang;
	}

	public void setSoLang(double soLang) {
		this.soLang = soLang;
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00 VND");
		return super.toString() + String.format(" %-20s %-20s %-20s", df.format(thanhTien()), loaiVang, soLang);
	}
	
}
