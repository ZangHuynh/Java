package tuan8_PhongHocCoInterface;

import java.util.ArrayList;

interface MethodOfDS {
	public void them(PhongHoc phong) throws Exception;

	public PhongHoc timKiemPhongHoc(String maPhong);

	public int timKiemViTri(String maPhong);

	public void xoa(PhongHoc phong);

	public void sua(PhongHoc phong);

	public ArrayList<PhongHoc> getDSPhongDatChuan();

	public void sortTheoDayNha();

	public void sortTheoDienTich();

	public void sortTheoBongDen();

	public ArrayList<PhongHoc> DSPhongCoSoMayCo60();

	public void setDSPhong(ArrayList<PhongHoc> dSPhong);

	public int getSoLuongPhong();

	public void sortTheo3ThuocTinh();

	public int demSoDayNha();

	public ArrayList<PhongHoc> getDSPhong();

}