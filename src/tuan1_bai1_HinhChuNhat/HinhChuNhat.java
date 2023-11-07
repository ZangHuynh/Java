package tuan1_bai1_HinhChuNhat;

public class HinhChuNhat {
	private int length;
	private int width;
	
	public HinhChuNhat(int length, int width) {
		super();
		this.length = length;
		this.width = width;
	}

	public HinhChuNhat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getLength() {
			return length;
	}

	public void setLength(int length) throws Exception {
		if(length > 0)
			this.length = length;
		else throw new Exception ("Length cann't be negative number!");
	}

	public int getWidth() {
			return width;
	}

	public void setWidth(int width) throws Exception {
		if(width > 0)
			this.width = width;
		else throw new Exception ("Width cann't be negative number!");
	}
	
	public long area() {
		return getLength() * getWidth();
	}
	
	public int perimeter() {
		return (getLength() + getWidth()) * 2;
	}
	
	@Override
	public String toString() {
		return String.format("%10s %12s %10s %10s",getLength(), getWidth(), perimeter(), area());
	}
}
