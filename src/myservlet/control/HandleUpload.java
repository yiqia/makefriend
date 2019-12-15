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
		
		// ��session���л�ȡlogin�����ڵ�¼ʱ��Ź���
		Login login=(Login)session.getAttribute("login");
		
		// ���ڱ���Ƿ�Ϊ��¼״̬
		boolean ok = true;
		
		// �ж�login�Ƿ�Ϊ��  �����ж��û���ʱ�Ƿ�Ϊ��¼״̬
		if(login==null) {
			ok=false;
			response.sendRedirect("login.jsp");
		}
		
		// ��¼״̬
		if(ok==true) {
			String logname = login.getLogname();
			// �����ϴ��ļ�����
			uploadFileMethod(request,response,logname);
		}
	}

	//�˷��������ļ��ϴ�
	public void uploadFileMethod(HttpServletRequest request, HttpServletResponse response, String logname) throws ServletException, IOException {
		
		// UploadFile �ϴ��ļ���JavaBean
		UploadFile upFile=new UploadFile();
		String backNews="";
		upFile.setBackNews(backNews);
		upFile.setSavedFileName("��ʱ������");
		
		try {
			HttpSession session=request.getSession(true);
			
			// ��UploadFile���浽session��
			session.setAttribute("upFile", upFile);
			
			// ��ȡJSessionID ÿ�λỰ�������һ��
			String tempFileName=(String)session.getId();
			
			// ����һ�� �ԡ�JSESSIONID��Ϊ�����޺�׺���ļ���Ϊ��ʱ�洢
			File f1=new File(tempFileName);
			
			// �����ļ�д����
			FileOutputStream o=new FileOutputStream(f1);
			
			// ��ȡ�������е��ֽ���
			InputStream in = request.getInputStream();
			
			// ������
			byte b[]=new byte[10000];
			int n;
			// ���������е��ֽ������ݣ�ͨ��д�������ļ�д�뵽��f1����
			while((n=in.read(b))!=-1)
				o.write(b,0,n);
			o.close();
			in.close();
			
			// ��������ļ��� �������ļ�������λ�ÿ�ʼ��д���������ڲ������ı����ļ�Ч�ʺܸ�
			RandomAccessFile randomRead=new RandomAccessFile(f1, "r");
			
			// ���û�����Ϊ�ļ�����
			String savedFileName=logname+".jpg";
			
			// ��ָ��ָ���ļ�ͷ
			randomRead.seek(0);
			
			long forthEndPosition=0;
			int forth=1;
			
			while((n=randomRead.readByte())!=-1&&(forth<=4)) {
				if(n=='\n') {
					forthEndPosition=randomRead.getFilePointer();
					forth++;
				}
			}
			
			// ��ȡ��ǰ��Ŀ����Ĵ���·��
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
					backNews="�ɹ��ϴ�";
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
