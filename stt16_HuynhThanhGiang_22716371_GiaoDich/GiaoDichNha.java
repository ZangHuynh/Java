package stt16_HuynhThanhGiang_22716371_GiaoDich;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class GiaoDichNha extends GiaoDich{
	private int loaiNha;
	private String diaChi;
	private final double thue = 0.1;
	
	public GiaoDichNha(String maGD, LocalDate ngayGD, double donGia, double dienTich, int loaiNha, String diaChi) {
		super(maGD, ngayGD, donGia, dienTich);
		this.loaiNha = loaiNha;
		this.diaChi = diaChi;
	}
	
	public GiaoDichNha() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public GiaoDichNha(String maGD, LocalDate ngayGD, double donGia, double dienTich) {
		super(maGD, ngayGD, donGia, dienTich);
		// TODO Auto-generated constructor stub
	}

	public int getLoaiNha() {
		return loaiNha;
	}

	public void setLoaiNha(int loaiNha) {
		this.loaiNha = loaiNha;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	@Override
	public double thanhTien() {
		if(loaiNha == 1) return dienTich * donGia + (thue * donGia * dienTich);
		else return dienTich * donGia * 0.9;
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00 VND");
		String loaiNha;
		if(this.loaiNha == 1) loaiNha = "Ruộng lúa";
		else loaiNha = "Trồng cây";
		return super.toString() + String.format(" %-25s %-20s", df.format(thanhTien()), loaiNha, diaChi);
	}
}
