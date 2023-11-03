package tuan2_bai4_Account;

public class AccountArray {
	private Account[] accounts;
	public int realElement=0;
	
	public AccountArray() {
		super();
		this.accounts = new Account[1];
	}
	
	public Account[] getAllAccount() {
		return accounts;
	}

	public Account searchAccount(long accountNumber) {
		for(int i=0;i < realElement;i++) {
			if(accounts[i].getNumOfAcc() == accountNumber)
				return accounts[i];
		}
		return null;
	}

	public void add(Account acc) throws Exception {
		if (!isExistingAccNumber(acc.getNumOfAcc())) {
			if (realElement == accounts.length) {
				Account[] newArr = new Account[accounts.length*2];
				for (int i = 0; i < realElement; i++) {
					newArr[i] = accounts[i];
				}
				accounts = newArr;
			}
			accounts[realElement++] = acc;
		} else {
			throw new Exception("This account already exists!");
		}
	}

	public boolean isExistingAccNumber(long accountNumber) {
		for(int i=0;i < realElement; i++)
			if(accountNumber == accounts[i].getNumOfAcc())
				return true;
		return false;
	}
}
