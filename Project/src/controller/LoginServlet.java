
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
import javax.servlet.http.HttpSession;
import javax.xml.bind.DatatypeConverter;

import dao.UserDao;
import model.UserBeans;

/**
 * Servlet implementation class LoginSevlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");
		dispatcher.forward(request, response); //←入力フォームを使うページなのでいらないと思いきや
		//doGetにもフォワード文には記述が必要。
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");//←文字化け防止のためのリクエスト　基本的にこれは記述しておく

		String loginId = request.getParameter("loginId");//← getParameterメソッドにjspの＜form＞タグ内の("loginId")
		String password = request.getParameter ("password");


		Charset charset = StandardCharsets.UTF_8;

		String algorithm = "MD5";


		byte[] bytes = null;
		try {
			bytes = MessageDigest.getInstance(algorithm).digest(password.getBytes(charset));
		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}
		String result = DatatypeConverter.printHexBinary(bytes);






		UserDao loginDao= new UserDao();
		UserBeans user = loginDao.LoginInfo(loginId, result);//←取得した引数をDAOのLoginInfoメソッドの引数に入れ、LoginBeans型の変数userにセット

		if (user == null ) {
			request.setAttribute("errMsg", "ログインに失敗しました。");//←setAttributeメソッドは、指定された"属性名"と"属性値"をセットできるメソッド
																		//ここでは、"errMsg"という属性名に"ログインに..."という属性値を設定した


			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/Login.jsp");//ここでJSPにフォワード、returnを記述してここで一度おわらせないとログイン失敗したのにログインできてしまう。
			dispatcher.forward(request, response);
			return;
		}

		HttpSession session = request.getSession();
		session.setAttribute("userInfo",user);//←ログインできた時、セッションでログインのページに留めておくための記述（？）

		response.sendRedirect("LoginListServlet");//←レスポンスで他のサーブレットにリダイレクト（ほかのサーブレットに処理丸投げ）

	}

}

