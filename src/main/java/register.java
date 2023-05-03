import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Out;

import bank.dao.bankInterface;
import bank.dao.bankInterfaceImp;
import bank.info.Register;

/**
 * Servlet implementation class register
 */
@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public register() {
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
		String regName = request.getParameter("regName");
		String pass = request.getParameter("pass");
		float accBal = Float.parseFloat(request.getParameter("accBal"));
		Register reg = new Register(regNo, regName, pass, accBal);
		List<Register> list = new ArrayList<Register>();
		list.add(reg);

		PrintWriter pw = response.getWriter();
		bankInterface bObj = new bankInterfaceImp();
		int i = bObj.create(list);
		if (i > 0) {
		pw.print("Record saved ");
		response.sendRedirect("login.html");
		}
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
