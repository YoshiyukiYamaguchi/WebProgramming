package controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
 * Servlet implementation class UsersUpdateServlet
 */
@WebServlet("/UsersUpdateServlet")
public class UsersUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		UserDao infoDao = new UserDao();
		UserBeans user = infoDao.UserInfo(id);
		request.setAttribute("user", user);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UsersUpdate.jsp");
		dispatcher.forward(request, response );
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String password = request.getParameter("password");
		String re_password = request.getParameter("re_password");
		String name = request.getParameter("name");
		String birthDate = request.getParameter("birthDate");
		String id = request.getParameter("id");
		String loginId = request.getParameter("loginId");

		Charset charset = StandardCharsets.UTF_8;

		String algorithm = "MD5";


		byte[] bytes = null;
		try {
			bytes = MessageDigest.getInstance(algorithm).digest(password.getBytes(charset));
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
		String result = DatatypeConverter.printHexBinary(bytes);


		if(!password.equals(re_password)|| name == "" || birthDate == ""){
			request.setAttribute("errMsg","入力された内容は正しくありません。" );

			UserBeans ub = new UserBeans(loginId,name,birthDate,password);

			request.setAttribute("user", ub);


			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/UsersUpdate.jsp");
			dispatcher.forward(request,response );

			return;

		}

		UserDao userUpdateDao = new UserDao();
		userUpdateDao.UsersUpdate(name, result, birthDate, id);

		response.sendRedirect("LoginListServlet");




	}

}
