package bank.dao;
import java.util.List;

import bank.info.Register;

public interface bankInterface {

	public int create(List<Register> list) ;
	public int update(List<Register> list);
	public int login(List<Register> list);
//	public String login(Register rObj);
	public int delete(int accNo);
	public List<Register> retrive(int no);
	public List<Register> displayAll();
}
