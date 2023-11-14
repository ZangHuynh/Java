package tuan5_bai1_ChuyenXe;

import java.util.ArrayList;

public class TripList {
	ArrayList<ChuyenXe> tripList;

	public TripList() {
		super();
		this.tripList = new ArrayList<ChuyenXe>();
	}

	public void addTrip(ChuyenXe trip) throws Exception {
		if(tripList.contains(trip)==false) {
			tripList.add(trip);
		}else
			throw new Exception("This trip already exist!");
	}
	
	public void removeTrip(ChuyenXe trip) throws Exception {
		if(tripList.contains(trip)==true) {
			tripList.remove(trip);
		}else
			throw new Exception("This trip does not exist!");
	}
	
	public ArrayList<ChuyenXe> getNgoaiThanhList() {
		ArrayList<ChuyenXe> ngtList = new ArrayList<ChuyenXe>(); 
		for(ChuyenXe trip : tripList) {
			if(trip instanceof NgoaiThanh) {
				ngtList.add(trip);
			}
		}
		return ngtList;
	}
	
	public double sumRevenueNgT() {
		double sum=0;
		ArrayList<ChuyenXe> ngtList = getNgoaiThanhList();
		for(ChuyenXe trip : ngtList)
			sum+=trip.getRevenue();
		return sum;
	}
	
	public ArrayList<ChuyenXe> getNoiThanhList() {
		ArrayList<ChuyenXe> ntList = new ArrayList<ChuyenXe>(); 
		for(ChuyenXe trip : tripList) {
			if(trip instanceof NoiThanh) {
				ntList.add(trip);
			}
		}
		return ntList;
	}
	
	public double sumRevenueNT() {
		double sum=0;
		ArrayList<ChuyenXe> ntList = getNoiThanhList();
		for(ChuyenXe trip : ntList)
			sum+=trip.getRevenue();
		return sum;
	}

	public ArrayList<ChuyenXe> getList() {
		return tripList;
	}
	
	public ChuyenXe findTripCode(String tripCode) {
	    for (ChuyenXe trip : tripList) {
	        if (trip.getTripCode().equals(tripCode)) {
	            return trip;
	        }
	    }
	    return null;
	}
}
