package servlet;


import java.io.IOException;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import service.gachasyori;

@WebServlet("/GachaServ")
public class GachaServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/GachaJ.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		// 文字コードエンコーディング
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		// 行動取得
		String action = request.getParameter("Action");
		gachasyori g =new gachasyori();
		List<entity.Character> Resultlist = g.gachastructure(action);
		request.setAttribute("Result", Resultlist);

		// 画面遷移
		RequestDispatcher rd = request.getRequestDispatcher("/GachaJ.jsp");
		rd.forward(request, response);
	}
}