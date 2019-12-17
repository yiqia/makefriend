package myservlet.control;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import mybean.data.*;

public class HandleUpload extends HttpServlet{

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}
		catch (Exception e) {}
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession(true);
		
		// 从session域中获取login对象（在登录时存放过）
		Login login=(Login)session.getAttribute("login");
		
		// 用于标记是否为登录状态
		boolean ok = true;
		
		// 判断login是否为空  用于判定用户此时是否为登录状态
		if(login==null) {
			ok=false;
			response.sendRedirect("login.jsp");
		}
		
		// 登录状态
		if(ok==true) {
			String logname = login.getLogname();
			// 调用上传文件方法
			uploadFileMethod(request,response,logname);
		}
	}

	//此方法用于文件上传
	public void uploadFileMethod(HttpServletRequest request, HttpServletResponse response, String logname) throws ServletException, IOException {
		
		// UploadFile 上传文件的JavaBean
		UploadFile upFile=new UploadFile();
		String backNews="";
		upFile.setBackNews(backNews);
		upFile.setSavedFileName("暂时无名字");
		
		try {
			HttpSession session=request.getSession(true);
			
			// 将UploadFile保存到session中
			session.setAttribute("upFile", upFile);
			
			// 获取JSessionID 每次会话都会存在一个
			String tempFileName=(String)session.getId();
			
			// 创建一个 以　JSESSIONID　为名，无后缀的文件作为临时存储
			File f1=new File(tempFileName);
			
			// 创建文件写入流
			FileOutputStream o=new FileOutputStream(f1);
			
			// 获取到请求中的字节流
			InputStream in = request.getInputStream();
			
			// 缓冲区
			byte b[]=new byte[10000];
			int n;
			// 读出请求中的字节流数据，通过写入流将文件写入到　f1　中
			while((n=in.read(b))!=-1)
				o.write(b,0,n);
			o.close();
			in.close();
			
			// 随机访问文件类 可以在文件的任意位置开始读写操作，对于操作非文本类文件效率很高
			RandomAccessFile randomRead=new RandomAccessFile(f1, "r");
			
			// 以用户名作为文件名字
			String savedFileName=logname+".jpg";
			
			// 让指针指向文件头
			randomRead.seek(0);
			
			long forthEndPosition=0;
			int forth=1;
			
			while((n=randomRead.readByte())!=-1&&(forth<=4)) {
				if(n=='\n') {
					forthEndPosition=randomRead.getFilePointer();
					forth++;
				}
			}
			
			// 获取当前项目部署的磁盘路径
			String path = request.getServletContext().getRealPath("/");
			
//			parentDir=parentDir.substring(0, parentDir.lastIndexOf("bin")-1);
//			String saveDir=parentDir+"/jsp/test11/image";
			
			File dir=new File(path+"image");
			dir.mkdir();
			File savingFile=new File(dir, savedFileName);
			if(savingFile.exists())
				savingFile.delete();
			RandomAccessFile randomSave=new RandomAccessFile(savingFile, "rw");
			randomRead.seek(randomRead.length());
			long endPosition=randomRead.getFilePointer();
			long mark=endPosition;
			int j=1;
			while((mark>=0)&&(j<=6)) {
				mark--;
				randomRead.seek(mark);
				n=randomRead.readByte();
				if(n=='\n') {
					endPosition=randomRead.getFilePointer();
					j++;
				}
			}
			randomRead.seek(forthEndPosition);
			long startPoint=randomRead.getFilePointer();
			while(startPoint<endPosition-1) {
				n=randomRead.readByte();
				randomSave.write(n);
				startPoint=randomRead.getFilePointer();
			}
			randomSave.close();
			randomRead.close();
			String uri="jdbc:mysql://47.100.179.136:3306/MakeFriend?"+"useUnicode=true&characterEncoding=utf8&serverTimezone=GMT&useSSL=false";
			Connection con=DriverManager.getConnection(uri,"MakeFriend","123456");
			Statement sql=con.createStatement();
			ResultSet rs=sql.executeQuery("SELECT * FROM member where logname='"+logname+"'");
			if(rs.next()) {
				int mm=sql.executeUpdate("UPDATE member SET pic='"+savedFileName+"' where logname='"+logname+"'");
				if(mm!=0) {
					backNews="成功上传";
					upFile.setSavedFileName(savedFileName);
					upFile.setBackNews(backNews+":"+path+"image");
				}
			}
			con.close();
			f1.delete();
		}
		catch (Exception exp) {
			backNews=""+exp;
			upFile.setBackNews(backNews);
		}
		RequestDispatcher dispatcher=request.getRequestDispatcher("showUploadMess.jsp");
		dispatcher.forward(request, response);
	}
	
}
