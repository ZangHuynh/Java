package tuan8_PhongHocCoInterface;

public class PhongMayTinh extends PhongHoc {
	private int soLuongMayTinh;
	private final double CHUANPM = 1.5;

	public PhongMayTinh() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhongMayTinh(String dayNha, String maPhong, double dienTich, int soBongDen, int soLuongMayTinh) {
		super(dayNha, maPhong, dienTich, soBongDen);
		this.soLuongMayTinh = soLuongMayTinh;
	}

	public int getSoLuongMayTinh() {
		return soLuongMayTinh;
	}

	public void setSoLuongMayTinh(int soLuongMayTinh) {
		this.soLuongMayTinh = soLuongMayTinh;
	}

	public boolean phongMayDatChuan() {
		return (getDienTich() / getSoLuongMayTinh() <= CHUANPM) ? true : false;
	}

	@Override
	boolean datChuan() {
		return phongMayDatChuan() && duSang() ? true : false;
	}

	@Override
	public String toString() {
		return super.toString() + String.format("%-2d " , getSoLuongMayTinh()) + "máy tính";
	}
	
}
