package kadai10;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BbsServlet
 */
@WebServlet("/BbsServlet")
public class BbsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BbsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	List<String> message = new ArrayList<>();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("UTF-8");

		response.setContentType("text/html; charset=UTF-8");

		String name = request.getParameter("NAME");
		String msg = request.getParameter("MESSAGE");
		String action = request.getParameter("ACTION");
		int num = 0;

		if (action.equals("write")) {
			LocalDateTime ldt = LocalDateTime.now();
			DateTimeFormatter dtformat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
			String fdate = dtformat.format(ldt);
			message.add(fdate + "\t" + name + "：" + msg);
		} else if (action.equals("remove")) {
			int n = Integer.parseInt(request.getParameter("num"));
			message.remove(n);
		}

		PrintWriter out = response.getWriter();

		if (action.equals("write") || action.equals("remove")) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>掲示板</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<form action=\"/jmaster/BbsServlet\" method=\"post\">");
			out.println("<input type=\"hidden\" name=\"ACTION\" value=\"write\">");
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

			for (String m : message) {
				out.println(m + "\t");
				out.println("<a href=\"/jmaster/BbsServlet?ACTION=remove&num=" + num++ + "\">[削除]</a>");
				out.println("<hr>");
			}

		} else {
			out.println("操作エラー");
			out.println("<br>");
			out.println("<a href=\"/jmaster/kadai10/bbs.html\">[戻る]</a>");
		}

		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}