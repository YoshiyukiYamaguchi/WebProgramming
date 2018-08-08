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
 * Servlet implementation class LoginListServlet
 */
@WebServlet("/LoginListServlet")
public class LoginListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UserDao loginDao = new UserDao();
		List<UserBeans> userList =loginDao.findAll();
		request.setAttribute("userList",userList );
		;


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Users.jsp");
		dispatcher.forward(request,response );


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String loginId = request.getParameter("loginId");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");
		String date = request.getParameter("date");

		UserDao loginDao = new UserDao();
		List<UserBeans> userList = loginDao.UserSeach(loginId, name, birthDate,date);
		request.setAttribute("userList", userList);


		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Users.jsp");
		dispatcher.forward(request, response);


	}

}

