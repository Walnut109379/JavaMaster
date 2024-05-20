package kadai21;

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

/**
 * Servlet implementation class BbsServlet2
 * @param <UserInfoBeans>
 */
@WebServlet("/BbsServlet2")
public class BbsServlet2<UserInfoBeans> extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BbsServlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	List<String> msg = new ArrayList<>();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		HttpSession session = request.getSession(true);

		request.setCharacterEncoding("UTF-8");

		List<String> msg = (ArrayList<String>) session.getAttribute("TL");
		if (msg == null) {
			msg = new ArrayList<String>();
			session.setAttribute("TL", msg);
		} else {
			String name = request.getParameter("NAME");
			String message = request.getParameter("MESSAGE");
			msg.add(name + "：" + message);
		}

		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>掲示板</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<form action=\"/jmaster/BbsServlet2\" method=\"post\">");
		out.println("名前：");
		out.println("<br>");
		out.println("<input type=\"text\" name=\"NAME\">");
		out.println("<br>");
		out.println("メッセージ：");
		out.println("<br>");
		out.println("<textarea name=\"MESSAGE\"></textarea>");
		out.println("<br>");
		out.println("<input type=\"submit\" value=\"書き込み\">");
		out.println("<br>");
		out.println("<hr>");

		for (String m : msg) {
			out.println(m);
			out.println("<hr>");
		}
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
