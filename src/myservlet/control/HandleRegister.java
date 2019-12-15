package myservlet.control;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

import mybean.data.*;

public class HandleRegister extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (Exception e) {}
	}
	
	public String handleString(String s) {
		try {
			byte bb[]=s.getBytes("iso-8859-1");
		}
		catch (Exception ee) {}
		return s;
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection con;
		Statement sql;
		
		Register reg=new Register();
		// 将reg放入请求域中
		request.setAttribute("register", reg);
		
		// 获取注册必要参数
		String logname=request.getParameter("logname").trim();
		String password=request.getParameter("password").trim();
		String email=request.getParameter("email").trim();
		String phone=request.getParameter("phone").trim();
		String message=request.getParameter("message").trim();
		
		if(logname==null)
			logname="";
		if(password==null)
			password="";
		boolean isLD=true;
		
		// 判断logname中是否由数字或字母组成
		for(int i=0;i<logname.length();i++) {
			char c=logname.charAt(i);
			if(!((c<='z'&&c>='a')||(c<='Z'&&c>='A')||(c<='9'&&c>='0')))
				isLD=false;
		}
		
		// 判断判断账号或密码是否为空，且用户名合法
		boolean boo=logname.length()>0&&password.length()>0&&isLD;
		
		// 用于记录注册状态
		String backNews="";
		
		try {
			// 对获取到的参数值进行从新编码
			logname=handleString(logname);
			password=handleString(password);
			phone=handleString(phone);
			email=handleString(email);
			message=handleString(message);
			
			// 对要执行的sql进行拼串
			String pic="public.jpg";
			String insertRecord="('"+logname+"','"+password+"','"+phone+"','"+email+"','"+message+"','"+pic+"')";
			String insertCondition="INSERT INTO member VALUES "+insertRecord;
			
			String uri="jdbc:mysql://47.100.179.136:3306/MakeFriend?user=MakeFriend&password=123456&useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=false";
			// 获取jdbc连接
			con=DriverManager.getConnection(uri);
			// 创建执行SQL语句的Statement对象
			sql=con.createStatement();
			
			// 用户名与密码合法，执行
			if(boo) {
				// 执行更新SQL，如果成功插入，返回更新成功的记录条数，此处为 1
				int m=sql.executeUpdate(insertCondition);
				
				// 更新成功执行语句
				if(m!=0) {
					backNews="注册成功";
					reg.setBackNews(backNews);
					reg.setLogname(logname);
					reg.setPassword(password);
					reg.setPhone(phone);
					reg.setEmail(email);
					reg.setMessage(message);
				}
			}
			else {
				// 信息填写不完整或名字中有非法字符
				backNews="信息填写不完整或名字中有非法字符";
				reg.setBackNews(backNews);
			}
			// 释放资源
			sql.close();
			con.close();
		}
		catch (SQLException exp) {
			// 数据库中主键值重复，会抛出异常到此处
			backNews="该会员名已被使用，请您更换名字"+exp;
			reg.setBackNews(backNews);
		}
		// 获得请求转发器对象，并将页面指定为 showRegisterMess.jsp
		RequestDispatcher dispatcher=request.getRequestDispatcher("showRegisterMess.jsp");
		// 携带请求和相应进行转发
		dispatcher.forward(request, response);
	}

}
