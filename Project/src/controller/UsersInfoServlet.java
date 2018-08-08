package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import model.UserBeans;

/**
 * Servlet implementation class UsersInfoServlet
 */
@WebServlet("/UsersInfoServlet")
public class UsersInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDao loginDao = new UserDao();
		List<UserBeans> userList =loginDao.findAll();
		String id = request.getParameter("id");
		String loginId = request.getParameter("loginId");
		String name = request.getParameter("name");
		UserDao infoDao = new UserDao();
		UserBeans user = infoDao.UserInfo(id);
		request.setAttribute("user", user);




		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UsersInfo.jsp");
		dispatcher.forward(request,response );
	}


}
