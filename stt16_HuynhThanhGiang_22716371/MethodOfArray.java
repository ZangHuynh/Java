package stt16_HuynhThanhGiang_22716371;

import java.util.ArrayList;

interface MethodOfArray {
	public void addGD(GiaoDich gd) throws Exception;
	
	public GiaoDich findByCode(String roomCode);
	
	public void removeGD(GiaoDich room) throws Exception;
	
	public double doanhThu1Nam(int nam);
	
	public ArrayList<GiaoDich> getAll();
	
}
