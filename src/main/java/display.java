
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class display
 */
@WebServlet("/display")
public class display extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public display() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		bankInterface b = new bankInterfaceImp();
		List<Register> lst = b.displayAll();

		request.setAttribute("empList", lst);
		RequestDispatcher view = request.getRequestDispatcher("list.jsp");
		view.forward(request, response);

//		request.setAttribute("empList", lst);
//		RequestDispatcher view = request.getRequestDispatcher("list.jsp");
//		view.forward(request, response);
		/*
		 * type1-using servlet... pw.print("<table>"); for(Register r:lst) {
		 * pw.print("<tr><td>"+r.getFname()+"</td><td>"+r.getRno()+"</td><tr>"); }
		 * pw.println("</table>")
		 */

		/*
		 * type2--- HttpSession session=request.getSession(true);
		 * session.setAttribute("data",lst); response.sendRedirect("DisplayAll.jsp");
		 */
		// type3-request dispacher

//		request.getRequestDispatcher("Display.jsp").forward(request, response);

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
