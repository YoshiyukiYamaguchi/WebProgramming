package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.UserBeans;

/**
 * Servlet implementation class UsersDeleteServlet
 */
@WebServlet("/UsersDeleteServlet")
public class UsersDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		UserDao infoDao = new UserDao();
		UserBeans user = infoDao.UserInfo(id);
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UsersDelete.jsp");
		dispatcher.forward(request, response );

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");

		if(id == null){
			request.setAttribute("errMsg","入力された内容は正しくありません。" );

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UsersDelete.jsp");
			dispatcher.forward(request,response );
			return;
		}

		UserDao deleteDao = new UserDao();
		deleteDao.UsersDelete(id);

		

		response.sendRedirect("LoginListServlet");


	 }
}


