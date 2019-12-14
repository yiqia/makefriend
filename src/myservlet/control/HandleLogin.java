package myservlet.control;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import mybean.data.Login;

public class HandleLogin extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
		}
	}

	public String handleString(String s) {
		try {
			byte bb[] = s.getBytes("iso-8859-1");
			s = new String(bb);
		} catch (Exception ee) {
		}
		return s;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection con = null;
		Statement sql = null;
		
		// Login类用于封装登录信息
		Login loginBean = null;
		// 用于保存登录状态
		String backNews = "";
		
		// 获取会话对象
		HttpSession session = request.getSession(true);
		try {
			// 从session会话中获取key为login的对象
			loginBean = (Login) session.getAttribute("login");
			
			// 如果没有 将loginBean存放到session会话中，key为login
			if (loginBean == null) {
				loginBean = new Login();
				session.setAttribute("login", loginBean);
			}
			
		} catch (Exception ee) {
			// 如果出现异常 继续究竟执行 loginBean为null的逻辑
			// 可能出现的异常为空指针异常
			loginBean = new Login();
			session.setAttribute("login", loginBean);
		}
		
		String logname = request.getParameter("logname").trim();
		String password = request.getParameter("password").trim();
		
		// 在loginBean中存放了登录状态，默认值为false
		boolean ok = loginBean.getSuccess();
		
		// 对字符从新编码
		logname = handleString(logname);
		password = handleString(password);
		
		// 判断登录状态
		if (ok == true && logname.equals(loginBean.getLogname())) {
			backNews = logname + "已经登录了";
			loginBean.setBackNews(backNews);
		} else {
			String uri = "jdbc:mysql://192.168.88.77:3306/MakeFriend?"
					+ "useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=false";
			
			// 验证登录用户名和密码
			boolean boo = (logname.length() > 0) && (password.length() > 0);
			
			try {
				con = DriverManager.getConnection(uri, "root", "1234");
				String condition = "select * from member where logname='" + logname + "' and password='" + password
						+ "'";
				sql = con.createStatement();
				if (boo) {
					ResultSet rs = sql.executeQuery(condition);
					// 判断是否存在下一条
					boolean m = rs.next();
					if (m == true) {
						backNews = "登录成功";
						loginBean.setBackNews(backNews);
						loginBean.setSuccess(true);
						loginBean.setLogname(logname);
					} else {
						backNews = "您输入的用户名不存在，或密码不匹配";
						loginBean.setBackNews(backNews);
						loginBean.setSuccess(false);
						loginBean.setLogname(logname);
						loginBean.setPassword(password);
					}
					rs.close();
				} else {
					backNews = "您输入的用户名不存在，或密码不匹配";
					loginBean.setBackNews(backNews);
					loginBean.setSuccess(false);
					loginBean.setLogname(logname);
					loginBean.setPassword(password);
				}
				sql.close();
				con.close();
			} catch (SQLException exp) {
				backNews = "登录异常:" + exp;
				loginBean.setBackNews(backNews);
				loginBean.setSuccess(false);
			}
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("showLoginMess.jsp");
		dispatcher.forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
