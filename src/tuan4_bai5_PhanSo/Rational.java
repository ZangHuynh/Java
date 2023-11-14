package tuan4_bai5_PhanSo;

public class Rational {
	private int numerator;
	private int denominator;
	
	
	public Rational(int numerator, int denominator) {
		super();
		this.numerator = numerator;
		this.denominator = denominator;
	}

	public Rational() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getNumerator() {
		return numerator;
	}

	public void setNumerator(int numerator) {
		this.numerator = numerator;
	}

	public int getDenominator() {
		return denominator;
	}

	public void setDenominator(int denominator) {
		this.denominator = denominator;
	}
	
	public int gcd(int a, int b) {
		if(b==0) return a;
		if(a%b==0) return b;
		return gcd(b,a%b);
	}
	
	public void reduce() {
		int a=gcd(getNumerator(), getDenominator());
		if(a>1) {
			setNumerator(getNumerator()/a);
			setDenominator(getDenominator()/a);
		}
	}

	public void reciprocal() {
		int temp;
		temp=getNumerator();
		setNumerator(getDenominator());
		setDenominator(temp);
	}
	
	@Override
	public String toString() {
		String str=String.format("%d/%d",getNumerator(),getDenominator());
		return str;
	}
}
