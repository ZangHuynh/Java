package stt16_HuynhThanhGiang_22716371_GiaoDich;

import java.util.ArrayList;

public interface MethodOfDS {
	
	public void themGD(GiaoDich gd) throws Exception;
	
	public GiaoDich timTheoMa(String maGD);
	
	public void xoaGD(GiaoDich gd) throws Exception;
	
	public void sortTheoMa();
	
	public ArrayList<GiaoDich> ds2023();
	
	public ArrayList<GiaoDich> getAll();
}
