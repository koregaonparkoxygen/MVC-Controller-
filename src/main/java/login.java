
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

import bank.dao.bankInterface;
import bank.dao.bankInterfaceImp;
import bank.info.Register;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public login() {
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
		String userName = request.getParameter("userName");
		String pass = request.getParameter("accPass");
		Register reg = new Register(0, userName, pass, 0);
		List<Register> list=new ArrayList<Register>();
		list.add(reg);

		PrintWriter pw=response.getWriter();
		bankInterface b=new bankInterfaceImp();
		int i=b.login(list);
		if(i>0) {
//			pw.print("Password Matched");
			response.sendRedirect("welcome.html");
		}
		else {
//			pw.print("Password not matched");
			response.sendRedirect("login.html");
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());

//		bankInterface b = new bankInterfaceImp();
//		String str = b.login(reg);// Str=valid
//		HttpSession session = request.getSession();
//		if (str.equals("valid")) {
//			session.setAttribute("Msg", str);
//			response.sendRedirect("welcome.html");
//		}
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
