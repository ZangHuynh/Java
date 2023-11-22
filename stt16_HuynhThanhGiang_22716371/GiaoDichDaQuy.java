package stt16_HuynhThanhGiang_22716371;

import java.text.DecimalFormat;
import java.time.LocalDate;

public class GiaoDichDaQuy extends GiaoDich{
	private boolean loai;
	private String diaChi;
	private double soCara;
	
	@Override
	public double thanhTien() {
		return loai ? soCara * donGia : soCara * donGia * 0.9;
	}

	public GiaoDichDaQuy(String maGD, LocalDate ngayGD, double donGia, boolean loai, String diaChi, double soCara) {
		super(maGD, ngayGD, donGia);
		this.loai = loai;
		this.diaChi = diaChi;
		this.soCara = soCara;
	}

	public GiaoDichDaQuy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public GiaoDichDaQuy(String maGD, LocalDate ngayGD, double donGia) {
		super(maGD, ngayGD, donGia);
		// TODO Auto-generated constructor stub
	}

	public boolean getLoai() {
		return loai;
	}

	public void setLoai(boolean loai) {
		this.loai = loai;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public double getSoCara() {
		return soCara;
	}

	public void setSoCara(double soCara) {
		this.soCara = soCara;
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00 VND");
		return super.toString() + String.format(" %-20s %-20s %-20s %-20s", df.format(thanhTien()), loai ? "Cao Cấp":"Thường", diaChi, soCara) ;
	}
	
}
