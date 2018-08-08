package controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

import dao.UserDao;
import model.UserBeans;

/**
 * Servlet implementation class NewUsersServlet
 */
@WebServlet("/NewUsersServlet")
public class NewUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewUsersServlet() {
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

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewUser.jsp");
		dispatcher.forward(request, response );

		}






	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		UserDao loginDao = new UserDao();
			List<UserBeans> userList =loginDao.findAll();



		String loginId = request.getParameter("loginId");
		String password = request.getParameter("password");
		String re_password = request.getParameter("re_password");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birth_date");
		UserDao infoDao = new UserDao();
		UserBeans user = infoDao.LoginInfo(loginId, password);

		Charset charset = StandardCharsets.UTF_8;

		String algorithm = "MD5";


		byte[] bytes = null;
		try {
			bytes = MessageDigest.getInstance(algorithm).digest(password.getBytes(charset));
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
		String result = DatatypeConverter.printHexBinary(bytes);


        if (!password.equals(re_password )|| loginId == "" || name == "" || birthDate == "" || password == ""
        		) {
			request.setAttribute("errMsg","入力された内容は正しくありません。");

			UserBeans ub = new UserBeans(loginId,name,birthDate,password);
			request.setAttribute("ub", ub);

			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewUser.jsp");
			dispatcher.forward(request, response);
			return ;
		}
        UserDao NewUserDao = new UserDao();
        try {
        	NewUserDao.NewUser(loginId, name, birthDate, result);
        } catch (SQLException e) {
        	request.setAttribute("errmSg", "そのログインIDは既に使用されています。");
        	RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/NewUser.jsp");
    		dispatcher.forward(request, response);
    		return;
        }

		String passwordP = password;
		String id = request.getParameter("id");
		response.sendRedirect("LoginListServlet");





	}

}
