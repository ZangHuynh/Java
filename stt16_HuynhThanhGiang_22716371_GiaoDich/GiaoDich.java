package stt16_HuynhThanhGiang_22716371_GiaoDich;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class GiaoDich {
	protected String maGD;
	protected LocalDate ngayGD;
	protected double donGia;
	protected double dienTich;
	
	protected GiaoDich(String maGD, LocalDate ngayGD, double donGia, double dienTich) {
		super();
		this.maGD = maGD;
		this.ngayGD = ngayGD;
		this.donGia = donGia;
		this.dienTich = dienTich;
	}

	protected GiaoDich() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected String getMaGD() {
		return maGD;
	}

	protected void setMaGD(String maGD) {
		this.maGD = maGD;
	}

	protected LocalDate getNgayGD() {
		return ngayGD;
	}

	protected void setNgayGD(LocalDate ngayGD) {
		this.ngayGD = ngayGD;
	}

	protected double getDonGia() {
		return donGia;
	}

	protected void setDonGia(double donGia) throws Exception {
		if(donGia > 0) {
			this.donGia = donGia;
		} else 
			throw new Exception("Đơn giá không được âm");
	}

	protected double getDienTich() {
		return dienTich;
	}

	protected void setDienTich(double dienTich) throws Exception {
		if(dienTich > 0) {
			this.dienTich = dienTich;
		} else 
			throw new Exception("Điện tích không được âm");
	}
	
	public abstract double thanhTien();
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,##0.00 VND");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
		return String.format("%-20s %-20s %-25s %-20s", maGD, dtf.format(ngayGD), df.format(donGia), dienTich);
	}
}
