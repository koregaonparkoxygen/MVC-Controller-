package bank.info;

public class Register {

	private int accNo;
	private String userName;
	private String password;
	private float accBal;
	public Register(int accNo, String userName, String password, float accBal) {
		super();
		this.accNo = accNo;
		this.userName = userName;
		this.password = password;
		this.accBal = accBal;
	}
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public float getAccBal() {
		return accBal;
	}
	public void setAccBal(float accBal) {
		this.accBal = accBal;
	}
	
	
}
