package stt16_HuynhThanhGiang_22716371_GiaoDich;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DSGiaoDich implements MethodOfDS{
	ArrayList<GiaoDich> dsGD;

	public DSGiaoDich() {
		this.dsGD = new ArrayList<GiaoDich>();
	}
	
	public void themGD(GiaoDich gd) throws Exception {
		if(!dsGD.contains(gd))
			dsGD.add(gd);
		else 
			throw new Exception("Giao Dịch đã tồn tại!");
	}
	
	public GiaoDich timTheoMa(String maGD) {
		for(GiaoDich gd : dsGD) {
			if(maGD.equalsIgnoreCase(gd.getMaGD()))
				return gd;
		}
		return null;
	}
	
	public void xoaGD(GiaoDich gd) throws Exception {
		if(dsGD.contains(gd))
			dsGD.remove(gd);
		else 
			throw new Exception("Giao Dịch không tồn tại!");
	}
	
	public void sortTheoMa() {
		Collections.sort(dsGD, new Comparator<GiaoDich>() {

			@Override
			public int compare(GiaoDich o1, GiaoDich o2) {
				return o1.getMaGD().compareToIgnoreCase(o2.getMaGD());
			}

		});
	}
	
	public ArrayList<GiaoDich> ds2023() {
		ArrayList<GiaoDich> ds2023 = new ArrayList<GiaoDich>();
		for(GiaoDich gd : dsGD) {
			if(gd.getNgayGD().getYear() == 2023)
				ds2023.add(gd);
		}
		return ds2023;
	}
	
	public ArrayList<GiaoDich> getAll() {
		return dsGD;
	}
}
