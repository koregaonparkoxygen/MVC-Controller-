
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bank.dao.bankInterface;
import bank.dao.bankInterfaceImp;
import bank.info.Register;

/**
 * Servlet implementation class update
 */
@WebServlet("/update")
public class update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public update() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		int regNo = Integer.parseInt(request.getParameter("regNo"));
		String regName = request.getParameter("userName");
		String pass = request.getParameter("accPass");
		float accBal = Float.parseFloat(request.getParameter("accBal"));
		Register reg = new Register(regNo, regName, pass, accBal);
		List<Register> list = new ArrayList<Register>();
		list.add(reg);
		
		PrintWriter pw= response.getWriter();
		bankInterface b=new bankInterfaceImp();
		int i=b.update(list);
		if(i>0) {
			pw.print("Record Updated");
		}

		// response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
