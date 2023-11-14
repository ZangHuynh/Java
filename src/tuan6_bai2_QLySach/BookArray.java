package tuan6_bai2_QLySach;

import java.util.ArrayList;

public class BookArray {
	ArrayList<Sach> bookList;

	public BookArray() {
		super();
		this.bookList = new ArrayList<Sach>();
	}

	public void addBook(Sach book) throws Exception { 
		if(bookList.contains(book)==false)
			bookList.add(book);
		else 
			throw new Exception("This book already exist!");
	}

	public Sach findBookByCode(String bookCode) {
		for(Sach book : bookList) {
			if(book.getBookCode().equalsIgnoreCase(bookCode))
				return book;
		}
		return null;
	}
	
	public ArrayList<Sach> findBookByPublisher(String publisher) {
		ArrayList<Sach> pubBook = new ArrayList<Sach>();
		for(Sach book : bookList) {
			if(book.getPublisher().equalsIgnoreCase(publisher))
				pubBook.add(book);
		}
		return pubBook;
	}
	
	public void removeBook(Sach book) throws Exception {
		if(bookList.contains(book)==true)
			bookList.remove(book);
		else 
			throw new Exception("This book cannot be found!");
	}

	public ArrayList<Sach> getThamKhao(){
		ArrayList<Sach> tkList = new ArrayList<Sach>();
		for(Sach book : bookList) {
			if(book instanceof SachThamKhao)
				tkList.add(book);
		}
		return tkList;
	}

	public ArrayList<Sach> getGiaoKhoa(){
		ArrayList<Sach> gkList = new ArrayList<Sach>();
		for(Sach book : bookList) {
			if(book instanceof SachGiaoKhoa)
				gkList.add(book);
		}
		return gkList;
	}

	public double unitPriceAVG() {
		ArrayList<Sach> tkList = getThamKhao();
		double avg=0;
		int cnt=0;
		for(Sach book : tkList) {
			avg+=book.getUnitPrice();
			cnt++;
		}
		return avg/cnt;
	}
	
	public double sumTotalPriceGK() {
		ArrayList<Sach> gkList = getGiaoKhoa();
		double sum=0;
		for(Sach book : gkList) {
			sum+=book.totalPrice();
		}
		return sum;
	}
	
	public double sumTotalPriceTK() {
		ArrayList<Sach> tkList = getThamKhao();
		double sum=0;
		for(Sach book : tkList) {
			sum+=book.totalPrice();
		}
		return sum;
	}
	
	public ArrayList<Sach> getList() {
		return bookList;
	}
}
