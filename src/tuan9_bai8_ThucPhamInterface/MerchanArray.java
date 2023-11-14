package tuan9_bai8_ThucPhamInterface;

import java.util.ArrayList;

public class MerchanArray implements MethodOfArray{
	private ArrayList<Merchandise> merchanList;
	
	public MerchanArray() {
		super();
		this.merchanList = new ArrayList<Merchandise>();
	}

	@Override
	public void addMerchan(Merchandise merchan) throws Exception {
		if(!merchanList.contains(merchan))
			merchanList.add(merchan);
		else 
			throw new Exception("This merchandise already exist!");
	}

	@Override
	public Merchandise findByCode(String merchanID) throws Exception {
		for(Merchandise merchan : merchanList)
			if(merchanID.equalsIgnoreCase(merchan.getMerchanID()))
				return merchan;
		return null;
	}

	@Override
	public void removeMerchan(Merchandise merchan) throws Exception {
		if(merchanList.contains(merchan))
			merchanList.remove(merchan);
		else
			throw new Exception("This merchandise not found!");
	}

	@Override
	public ArrayList<Merchandise> getAll() {
		return merchanList;
	}
}
