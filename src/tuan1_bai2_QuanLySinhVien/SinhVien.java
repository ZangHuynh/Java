package tuan1_bai2_QuanLySinhVien;

public class SinhVien {
	private String maSV;
	private String nameSV;
	private float LTp, THp;
	
	public SinhVien(String maSV, String nameSV, float lTp, float tHp) {
		super();
		this.maSV = maSV;
		this.nameSV = nameSV;
		LTp = lTp;
		THp = tHp;
	}

	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMaSV() {
		return maSV;
	}

	public void setMaSV(String maSV) {
		this.maSV = maSV;
	}

	public String getNameSV() {
		return nameSV;
	}

	public void setNameSV(String nameSV) {
		this.nameSV = nameSV;
	}

	public float getLTp() {
		return LTp;
	}

	public void setLTp(float lTp) {
		LTp = lTp;
	}

	public float getTHp() {
		return THp;
	}

	public void setTHp(float tHp) {
		THp = tHp;
	}

	public float pointAverage() {
		return (getLTp() + getTHp())/2;
	}
	
	
	@Override
	public String toString() {
		String str = String.format("%15s %20s %12.2f %12.2f %15.2f",getMaSV(), getNameSV(), getLTp(), getTHp(), pointAverage());
		return str;
	}
}
