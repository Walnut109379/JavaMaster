package p01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SamplServlet01
 */
@WebServlet("/pageB")
public class PageB extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PageB() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//セッションオブジェクトを取得
		HttpSession session = request.getSession(false);

		Integer x = (Integer) session.getAttribute("XXX");

		Integer y = (Integer) session.getAttribute("YYY");

		//webブラウザへのお知らせ情報の設定
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>PageB</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>PageB</h1>");
		out.println("<hr>");
		int result = (int) x + (int) y;
		out.println(result + "<br>");
		out.println("</body>");
		out.println("</html>");
	}
}
