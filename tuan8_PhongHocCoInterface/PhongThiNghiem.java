package tuan8_PhongHocCoInterface;

public class PhongThiNghiem extends PhongHoc {
	private boolean bonRuaTay;

	public PhongThiNghiem() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PhongThiNghiem(String dayNha, String maPhong, double dienTich, int soBongDen, boolean bonRuaTay) {
		super(dayNha, maPhong, dienTich, soBongDen);
		this.bonRuaTay = bonRuaTay;
		// TODO Auto-generated constructor stub
	}

	public boolean isBonRuaTay() {
		return bonRuaTay ? true : false;
	}

	public void setBonRuaTay(boolean bonRuaTay) {
		this.bonRuaTay = bonRuaTay;
	}

	@Override
	boolean datChuan() {
		return isBonRuaTay() && duSang() ? true : false;
	}

	@Override
	public String toString() {
		String brt = isBonRuaTay() ? "có bồn rửa tay(PTN)" : "không bồn rửa tay(PTN)";
		return super.toString() + String.format("%-20s", brt);
	}

}
