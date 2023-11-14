package quanLySach;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachCacSach 
{
	private    ArrayList<Sach> lstSach;
	public  ArrayList<Sach> getAllSach() 
	{
		return lstSach;
	}
	
	public void sua(Sach objSach) throws Exception 
	{
		int viTri= lstSach.indexOf(objSach);
		if (viTri>=0)
		lstSach.set(viTri, objSach);
		else
			throw new Exception("Không sửa dc vì không thấy sách để sửa");
	}
	public DanhSachCacSach() 
	{
		lstSach= new ArrayList<Sach>();
		// TODO Auto-generated constructor stub
	}
	
	//sort 2 thuộc tính

	public void sortTheoNhaXBanSoLuong() {
		Collections.sort(lstSach, new Comparator<Sach>() {
			@Override
			public int compare(Sach o1, Sach o2) {
				// TODO Auto-generated method stub
				// nếu tên nhà xuất bản giống nhau
				if( o1.getNhaXB().compareToIgnoreCase(o2.getNhaXB()) == 0 ) 
				{
					Integer sl1=(Integer) o1.getSoLuong();
					Integer sl2=(Integer) o2.getSoLuong();
					return	sl1.compareTo(sl2); // thì sắp xếp theo số lượng
				}
				return o1.getNhaXB().compareToIgnoreCase(o2.getNhaXB());

			}

		});

	}
	public void sortTheoNgayNhap() {
		Collections.sort(lstSach, new Comparator<Sach>() {
			@Override
			public int compare(Sach o1, Sach o2) {
				LocalDate d1=o1.getNgayNhap();
				LocalDate d2=o2.getNgayNhap();
				return d1.compareTo(d2);
			}

		});
	}

	public void sortTheoGiaTien() {
		
		Collections.sort(lstSach, new Comparator<Sach>() {
			@Override
			public int compare(Sach o1, Sach o2) {
				Double gia1 = o1.getDonGia();
				Double gia2 = o2.getDonGia();
				return gia1.compareTo(gia2);
			}

		});
	}
	public void xoa(Sach objXoa) {
		lstSach.remove(objXoa);
	}
	public Sach timKiemDoiTuongSach(String maSach)
	{
		for (Sach objSach : lstSach)
			if (objSach.getMaSach().equalsIgnoreCase(maSach))
				return objSach;
		return null;
	}
	public void them(Sach objSach) throws Exception {
		if (lstSach.contains(objSach)) // đã tồn tại
			throw new Exception("Mã sách đã trùng");
		else
			lstSach.add(objSach);
	}

	public ArrayList<Sach> getListSachGiaoKhoa()
	{
		ArrayList<Sach> sachGK= new ArrayList<Sach>();
		for (Sach objS : lstSach) 
		{
			if(objS instanceof SachGiaoKhoa )
				sachGK.add(objS);
		}
		return sachGK;
	}
	public ArrayList<Sach> getListSachThamKhao()
	{
		ArrayList<Sach> sachTK= new ArrayList<Sach>();
		for (Sach objS : lstSach) 
		{
			if(objS instanceof SachThamKhao )
				sachTK.add(objS);
		}
		return sachTK;
	}

	public double sumTotalPriceGK() {
		ArrayList<Sach> gkList = getListSachGiaoKhoa();
		double sum=0;
		for(Sach book : gkList) {
			sum+=book.thanhTien();
		}
		return sum;
	}
	
	public double sumTotalPriceTK() {
		ArrayList<Sach> tkList = getListSachThamKhao();
		double sum=0;
		for(Sach book : tkList) {
			sum+=book.thanhTien();
		}
		return sum;
	}
}
