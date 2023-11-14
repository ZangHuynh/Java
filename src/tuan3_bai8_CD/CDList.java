package tuan3_bai8_CD;

import java.util.Arrays;
import java.util.Comparator;

public class CDList {
	private CD[] cds;
	public int realElement=0;
	
	public CDList() {
		super();
		this.cds = new CD[1];
	}
	
	public boolean isExistingCD(int cdNumber) {
		for(int i=0;i<realElement;i++)
			if(cds[i].getCdID() == cdNumber)
				return true;
		return false;
	}
	
	public void addCD(CD cd) throws Exception {
		if(!isExistingCD(cd.getCdID())) {
			if(realElement == cds.length) {
				CD[] newCD = new CD[cds.length+1];
				for(int i=0;i<realElement;i++)
					newCD[i]=cds[i];
				cds=newCD;
			}
			cds[realElement++]=cd;
		}else {
			throw new Exception("This CD already exist!");
		}
	}
	
	public double sumPriceCD() {
		double sum = 0;
		for(int i=0;i<realElement;i++) {
			sum += cds[i].getPrice();
		}
		return sum;
	}
	
	public void sortPriceCD() {
		Comparator<CD>sortPrice = new Comparator<CD>() {
			
			@Override
			public int compare(CD thiscd, CD thatcd) {
				return thiscd.getPrice()<thatcd.getPrice()?1:-1;
			}
		};
		Arrays.sort(cds,sortPrice);
	}
	
	public void sortNameCD() {
		Comparator<CD>sortName = (thiscd,thatcd) ->{
			return thiscd.getNameCD().compareToIgnoreCase(thatcd.getNameCD());
		};
		Arrays.sort(cds,sortName);
	}
	
	public CD[] getAllCD() {
		return cds;
	}
}
