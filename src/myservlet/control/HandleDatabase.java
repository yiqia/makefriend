package myservlet.control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;

import com.sun.rowset.*;

import mybean.data.Login;
import mybean.data.MemberInform;
import mybean.data.ShowByPage;

public class HandleDatabase extends HttpServlet {
	CachedRowSetImpl rowSet = null;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (Exception e) {
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		Login login = (Login) session.getAttribute("login");
		boolean ok = true;
		if (login == null) {
			ok = false;
			response.sendRedirect("login.jsp");
		}
		if (ok == false) {
			return;
		}
		
		String showPages = "";
		showPages = request.getParameter("showPage");
		int showPage = Integer.parseInt(showPages);
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;
		List<MemberInform> list = new ArrayList<MemberInform>();
		String uri = "jdbc:mysql://192.168.88.77:3306/MakeFriend?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=false";
		try {
			con = DriverManager.getConnection(uri, "root", "1234");
			String sql1 = "SELECT * FROM member LIMIT ?,?";
			String sql2 = "SELECT count(*) FROM member";
			
			ps = con.prepareStatement(sql2);
			resultSet = ps.executeQuery(sql2);
			int countNumber,countPages;
			countNumber=countPages =0;
			if(resultSet.next()) {
				countNumber = resultSet.getInt(1);
			}
			if(countNumber % 5 == 0) {
				countPages = countNumber / 5 ;
			}else {
				countPages = countNumber / 5 + 1;
			}
			if(showPage <= 0) {
				showPage = countPages;
			}
			if(showPage > countPages) {
				showPage = 0;
			}
			
			// ==================================================
			ps = con.prepareStatement(sql1);
			ps.setInt(1, showPage-1);
			ps.setInt(2, showPage * 5);
			resultSet = ps.executeQuery();
			while(resultSet.next()) {
				MemberInform m = new MemberInform();
				m.setLogname(resultSet.getString("logname"));
				m.setEmail(resultSet.getString("email"));
				m.setPhone(resultSet.getString("phone"));
				m.setMessage(resultSet.getString("message"));
				m.setPic(resultSet.getString("pic"));
				m.setBackNews(resultSet.getString("backNews"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		request.setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("showAllMember.jsp");
		dispatcher.forward(request, response);
	}

	

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		Login login = (Login) session.getAttribute("login");
		boolean ok = true;
		if (login == null) {
			ok = false;
			response.sendRedirect("login.jsp");
		}
		if (ok == true) {
			continueDoGet(request, response);
		}
	}

	public void continueDoGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		MemberInform inform = new MemberInform();
		request.setAttribute("inform", inform);
		String logname = request.getParameter("logname");
		Connection con = null;
		String uri = "jdbc:mysql://192.168.88.77:3306/MakeFriend?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=false";
		try {
			con = DriverManager.getConnection(uri, "root", "1234");
			Statement sql = con.createStatement();
			ResultSet rs = sql.executeQuery("SELECT * FROM member where logname='" + logname + "'");
			if (rs.next()) {
				inform.setLogname(rs.getString(1));
				inform.setPhone(rs.getString(3));
				inform.setEmail(rs.getString(4));
				inform.setMessage(rs.getString(5));
				inform.setPic(rs.getString(6));
				inform.setBackNews("查询到的会员信息：");
			}
			con.close();
			RequestDispatcher dispatcher = request.getRequestDispatcher("showLookedMember.jsp");
			dispatcher.forward(request, response);
		} catch (SQLException exp) {
			inform.setBackNews("" + exp);
		}
	}

}
