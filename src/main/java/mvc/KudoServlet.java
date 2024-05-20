package mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class KudoServlet
 */
@WebServlet("/kudo")
public class KudoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public KudoServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//文字化け対策
		request.setCharacterEncoding("UTF-8");

		//リクエスト・パラメータを取得
		int data1 = Integer.parseInt(request.getParameter("data1"));
		int data2 = Integer.parseInt(request.getParameter("data2"));

		//モデルのインスタンスを生成
		Tanaka t = new Tanaka();

		int result = t.tasu(data1, data2);

		//加算結果をJSPで表示できる準備
		request.setAttribute("result", result);

		//リクエスト転送
		RequestDispatcher rd = request.getRequestDispatcher("/mvc/honma.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
