package bank.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import DBconection.DBConnection;
import bank.info.Register;

public class bankInterfaceImp implements bankInterface {

	@Override
	public int create(List<Register> list) {
		Connection con = DBConnection.getDbConnection();
		int i = 0;
//		Register reg = list.get(0);
		try {
			for (Register reg : list) {

				PreparedStatement pstate = con.prepareStatement("insert into register values(?,?,?,?)");
				pstate.setInt(1, reg.getAccNo());
				pstate.setString(2, reg.getUserName());
				pstate.setString(3, reg.getPassword());
				pstate.setFloat(4, reg.getAccBal());
				i = pstate.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}

	@Override
	public int update(List<Register> list) {
		Connection con = DBConnection.getDbConnection();
//		List<Register> listreg=new ArrayList<Register>();
		int i = 0;
		try {
//			for (Register reg : list) {
			Register reg = list.get(0);
			PreparedStatement pstate = con.prepareStatement("update register set username=?,password=? where accno=? ");
			pstate.setString(1, reg.getUserName());
			pstate.setString(2, reg.getPassword());
			pstate.setInt(3, reg.getAccNo());
			i = pstate.executeUpdate();

//			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}

	@Override
	public int login(List<Register> list) {
		// TODO Auto-generated method stub
		int i = 0;
		Connection con = DBConnection.getDbConnection();
		try {
			for (Register reg : list) {
				PreparedStatement pstate = con.prepareStatement("SELECT password FROM register WHERE username = ?");
				pstate.setString(1, reg.getUserName());
				ResultSet rs = pstate.executeQuery();
				while (rs.next()) {
					String passStr = rs.getString("password");
					if (reg.getPassword().equals(passStr)) {
						i = 1;
						return i;
					}
				}
			}
		} catch (

		SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

//	@Override
//	public String login(Register rObj) {
//
//		List<Register> list = displayAll();
//		String str = null;
//		for (Register reg : list) {
//			if (reg.getUserName().equals(rObj.getUserName())) {
//				if (reg.getPassword().equals(rObj.getPassword())) {
//					str = "valid";
//					return str;
//				} else {
//					str = "Wrong Password";
//				}
//
//			} else {
//				str = "Incorect User Name";
//			}
//
//		}
//
//		return str;
//	}

	@Override
	public List<Register> retrive(int no) {
		Connection con = DBConnection.getDbConnection();
		List<Register> list = null;
		List<Register> listRsmd = new ArrayList<Register>();
		ResultSet rs = null;
		try {
			PreparedStatement pstate = con.prepareStatement("select * from register where accno=?");
			pstate.setInt(1, no);
			rs = pstate.executeQuery();

			if (rs.next()) {
				Register r = new Register(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4));
				list = new ArrayList<Register>();
				list.add(r);

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

	@Override
	public int delete(int accNo) {
		Connection con = DBConnection.getDbConnection();
		int i = 0;
		try {
			PreparedStatement pstate = con.prepareStatement("delete from register where accno=? ");
			pstate.setInt(1, accNo);
			i = pstate.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i;
	}

	@Override
	public List<Register> displayAll() {
		Connection con = DBConnection.getDbConnection();
		List<Register> list = null;
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("select * from register");
			list = new ArrayList<Register>();
			while (rs.next()) {
				Register r = new Register(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getFloat(4));
				list.add(r);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
