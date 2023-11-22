package stt16_HuynhThanhGiang_22716371;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

abstract class GiaoDich {
	protected String maGD;
	protected LocalDate ngayGD;
	protected double donGia;
	
	protected GiaoDich(String maGD, LocalDate ngayGD, double donGia) {
		super();
		this.maGD = maGD;
		this.ngayGD = ngayGD;
		this.donGia = donGia;
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

	protected void setDonGia(double donGia) {
		this.donGia = donGia;
	}
	
	public abstract double thanhTien();
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((maGD == null) ? 0 : maGD.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GiaoDich other = (GiaoDich) obj;
		if (maGD == null) {
			if (other.maGD != null)
				return false;
		} else if (!maGD.equals(other.maGD))
			return false;
		return true;
	}

	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
		DecimalFormat df = new DecimalFormat("#,##0.00 VND");
		return String.format(" %-20s %-20s %-20s", maGD, dtf.format(ngayGD), df.format(donGia));
	}
	
}
