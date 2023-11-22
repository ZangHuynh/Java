package stt16_HuynhThanhGiang_22716371;

import java.util.ArrayList;

public class ArrayGD implements MethodOfArray{
	private ArrayList<GiaoDich> gdList;
	
	public ArrayGD() {
		super();
		this.gdList = new ArrayList<GiaoDich>();
	}

	@Override
	public void addGD(GiaoDich gd) throws Exception {
		if(!gdList.contains(gd))
			gdList.add(gd);
		else throw new Exception("Giao Dịch đã tồn tại!");
	}

	@Override
	public GiaoDich findByCode(String roomCode) {
		for(GiaoDich gd : gdList)
			if(gd.getMaGD().equals(roomCode))
				return gd;
		return null;
	}

	@Override
	public void removeGD(GiaoDich gd) throws Exception {
		if(gdList.contains(gd))
			gdList.remove(gd);
		else throw new Exception("Giao dịch không tồn tại!");
	}
	
	@Override
	public double doanhThu1Nam(int nam) {
		double sum = 0;
		for(GiaoDich gd : gdList)
			if(gd.getNgayGD().getYear() == nam)
				sum += gd.thanhTien();
		return sum;
	}

	@Override
	public ArrayList<GiaoDich> getAll() {
		return gdList;
	}

}
