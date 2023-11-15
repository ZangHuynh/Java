package stt16_HuynhThanhGiang_22716371_GiaoDich;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class GiaoDichDat extends GiaoDich {
	private int loaiDat;
	private final double tax = 0.05;
	
	public GiaoDichDat(String maGD, LocalDate ngayGD, double donGia, double dienTich, int loaiDat) {
		super(maGD, ngayGD, donGia, dienTich);
		this.loaiDat = loaiDat;
	}

	public GiaoDichDat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiaoDichDat(String maGD, LocalDate ngayGD, double donGia, double dienTich) {
		super(maGD, ngayGD, donGia, dienTich);
		// TODO Auto-generated constructor stub
	}

	public int getLoaiDat() {
		return loaiDat;
	}

	public void setLoaiDat(int loaiDat) {
		this.loaiDat = loaiDat;
	}

	@Override
	public double thanhTien() {
		if(loaiDat == 1) return dienTich * donGia;
		else return dienTich * donGia + dienTich * donGia * tax;
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00 VND");
		String loaiDat;
		if(this.loaiDat == 1) loaiDat = "Ruộng lúa";
		else loaiDat = "Trồng cây";
		return super.toString() + String.format(" %-25s %-20s", df.format(thanhTien()), loaiDat);
	}
}
