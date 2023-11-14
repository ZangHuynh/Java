package tuan8_PhongHocCoInterface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;

public class DanhSachPhong implements MethodOfDS {
	private ArrayList<PhongHoc> DSPhong;

	public DanhSachPhong() {
		DSPhong = new ArrayList<PhongHoc>();
	}

	public void them(PhongHoc phong) throws Exception {
		if (DSPhong.contains(phong) == false)
			DSPhong.add(phong);
		else {
			throw new Exception("Mã phòng đã trùng");
		}
	}

	public PhongHoc timKiemPhongHoc(String maPhong) {
		for (PhongHoc phong : DSPhong) {
			if (phong.getMaPhong().equalsIgnoreCase(maPhong))
				return phong;
		}
		return null;
	}

	public int timKiemViTri(String maPhong) {
		PhongHoc find = timKiemPhongHoc(maPhong);
		if (find != null)
			return DSPhong.indexOf(find);
		return -1;
	}

	public void xoa(PhongHoc phong) {
		DSPhong.remove(phong);
	}

	public void sua(PhongHoc phong) {
		int vt = DSPhong.indexOf(phong);
		if (vt > -1)
			DSPhong.set(vt, phong);
	}

	public ArrayList<PhongHoc> getDSPhongDatChuan() {
		ArrayList<PhongHoc> temp = new ArrayList<PhongHoc>();
		for (PhongHoc phong : DSPhong) {
			if (phong.datChuan())
				temp.add(phong);
		}
		return temp;
	}

	public void sortTheoDayNha() {
		Collections.sort(DSPhong, new Comparator<PhongHoc>() {

			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				return o1.getDayNha().compareToIgnoreCase(o2.getDayNha());
			}

		});
	}

	public void sortTheoDienTich() {
		Collections.sort(DSPhong, new Comparator<PhongHoc>() {

			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				Double s1 = o1.getDienTich();
				Double s2 = o2.getDienTich();
				return s2.compareTo(s1);
			}
		});
	}

	public void sortTheoBongDen() {
		Collections.sort(DSPhong, new Comparator<PhongHoc>() {

			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				Integer s1 = o1.getSoBongDen();
				Integer s2 = o2.getSoBongDen();
				return s1.compareTo(s2);
			}
		});
	}

	public ArrayList<PhongHoc> DSPhongCoSoMayCo60() {
		ArrayList<PhongHoc> temp = new ArrayList<PhongHoc>();
		for (PhongHoc phong : DSPhong) {
			if (phong instanceof PhongMayTinh && ((PhongMayTinh) phong).getSoLuongMayTinh() == 60)
				temp.add(phong);
		}
		return temp;
	}

	public void setDSPhong(ArrayList<PhongHoc> dSPhong) {
		DSPhong = dSPhong;
	}

	public int getSoLuongPhong() {
		return DSPhong.size();
	}

	public void sortTheo3ThuocTinh() { // từ số bóng đèn đến -> diện tích -> mã phòng
		Collections.sort(DSPhong, new Comparator<PhongHoc>() {

			@Override
			public int compare(PhongHoc o1, PhongHoc o2) {
				int comp1 = ((Integer) o1.getSoBongDen()).compareTo((Integer) o2.getSoBongDen());
				if (comp1 == 0) 
				{
					Double s1 = o1.getDienTich();
					Double s2 = o2.getDienTich();
					int comp2 = s2.compareTo(s1);
					if (comp2 == 0)
						return o1.getMaPhong().compareToIgnoreCase(o2.getMaPhong());
					else
						return comp2;

				} else
					return comp1;
			}

		});
	}

	public int demSoDayNha() {
		HashMap<String, PhongHoc> ht = new HashMap<String, PhongHoc>();
		for (PhongHoc phongHoc : DSPhong) {
			ht.put(phongHoc.getDayNha(), phongHoc);
		}
		System.out.println(ht);
		return ht.size();
	}

	public ArrayList<PhongHoc> getDSPhong() {
		return DSPhong;
	}

}
