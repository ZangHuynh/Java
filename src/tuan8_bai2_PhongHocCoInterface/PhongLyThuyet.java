package tuan8_bai2_PhongHocCoInterface;

public class PhongLyThuyet extends PhongHoc {
	private boolean mayChieu;
	
	public PhongLyThuyet() {
		super();
	}

	public PhongLyThuyet(String dayNha, String maPhong, double dienTich, int soBongDen, boolean mayChieu) {
		super(dayNha, maPhong, dienTich, soBongDen);
		this.mayChieu = mayChieu;
	}

	boolean datChuan() {
		return isMayChieu() && duSang() ? true : false;
	}

	public boolean isMayChieu() {
		return mayChieu;
	}

	public void setMayChieu(boolean mayChieu) {
		this.mayChieu = mayChieu;
	}

	@Override
	public String toString() {
		String mc = mayChieu ? "có máy chiếu(PLT)" : "không máy chiếu(PLT)";
		return super.toString() + String.format("%-20s", mc);
	}
	
}
