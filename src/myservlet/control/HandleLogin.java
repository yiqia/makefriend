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
		
		// Login�����ڷ�װ��¼��Ϣ
		Login loginBean = null;
		// ���ڱ����¼״̬
		String backNews = "";
		
		// ��ȡ�Ự����
		HttpSession session = request.getSession(true);
		try {
			// ��session�Ự�л�ȡkeyΪlogin�Ķ���
			loginBean = (Login) session.getAttribute("login");
			
			// ���û�� ��loginBean��ŵ�session�Ự�У�keyΪlogin
			if (loginBean == null) {
				loginBean = new Login();
				session.setAttribute("login", loginBean);
			}
			
		} catch (Exception ee) {
			// ��������쳣 ��������ִ�� loginBeanΪnull���߼�
			// ���ܳ��ֵ��쳣Ϊ��ָ���쳣
			loginBean = new Login();
			session.setAttribute("login", loginBean);
		}
		
		String logname = request.getParameter("logname").trim();
		String password = request.getParameter("password").trim();
		
		// ��loginBean�д���˵�¼״̬��Ĭ��ֵΪfalse
		boolean ok = loginBean.getSuccess();
		
		// ���ַ����±���
		logname = handleString(logname);
		password = handleString(password);
		
		// �жϵ�¼״̬
		if (ok == true && logname.equals(loginBean.getLogname())) {
			backNews = logname + "�Ѿ���¼��";
			loginBean.setBackNews(backNews);
		} else {
			String uri = "jdbc:mysql://47.100.179.136:3306/MakeFriend?"
					+ "useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=false";
			
			// ��֤��¼�û���������
			boolean boo = (logname.length() > 0) && (password.length() > 0);
			
			try {
				con = DriverManager.getConnection(uri, "MakeFriend", "123456");
				String condition = "select * from member where logname='" + logname + "' and password='" + password
						+ "'";
				sql = con.createStatement();
				if (boo) {
					ResultSet rs = sql.executeQuery(condition);
					// �ж��Ƿ������һ��
					boolean m = rs.next();
					if (m == true) {
						backNews = "��¼�ɹ�";
						loginBean.setBackNews(backNews);
						loginBean.setSuccess(true);
						loginBean.setLogname(logname);
					} else {
						backNews = "��������û��������ڣ������벻ƥ��";
						loginBean.setBackNews(backNews);
						loginBean.setSuccess(false);
						loginBean.setLogname(logname);
						loginBean.setPassword(password);
					}
					rs.close();
				} else {
					backNews = "��������û��������ڣ������벻ƥ��";
					loginBean.setBackNews(backNews);
					loginBean.setSuccess(false);
					loginBean.setLogname(logname);
					loginBean.setPassword(password);
				}
				sql.close();
				con.close();
			} catch (SQLException exp) {
				backNews = "��¼�쳣:" + exp;
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
