package p01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SamplServlet01
 */
@WebServlet("/pageA")
public class PageA extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PageA() {
		super();
		// TODO Auto-generated constructor stub
	}

	Scanner scan = new Scanner(System.in);

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//セッションオブジェクトを取得
		HttpSession session = request.getSession(true);

		int x = 0;
		int y = 0;

		session.setAttribute("XXX", x);

		session.setAttribute("YYY", y);

		//webブラウザへのお知らせ情報の設定
		response.setContentType("text/html; charset=UTF-8");

		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>PageA</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>PageA</h1>");
		out.println("<hr>");
		out.println("x?");
		x = scan.nextInt();
		out.println("y?");
		y = scan.nextInt();
		out.println("<a href='pageB'>Go to PageB</a><br>");
		out.println("</body>");
		out.println("</html>");
	}
}
