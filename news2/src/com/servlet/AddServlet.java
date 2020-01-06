package com.servlet;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.dao.SqlHelper;
import com.pojo.User;


/**
 *  System.out.println(item.isFormField()); //�Ƿ���file����   ��file false  ����file  true
	System.out.println(item.getFieldName());//�����name���Ե�ֵ
	System.out.println(item.getString());//���ڷ�file���value���Ե�ֵ������file������ļ�����
	System.out.println(item.getName());//����file����ϴ��ļ������ƣ����ڷ�file�������null
	System.out.println(item.getContentType());//����file����ϴ��ļ�mime���� �����ڷ�file�������null
	System.out.println(item.getSize());//����file����ϴ��ļ��Ĵ�С �����ڷ�file���valueֵ�Ŀ��
 * 
 * 
 * @author Administrator
 *
 */
public class AddServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.����FileItemFactory����
		FileItemFactory factory = new DiskFileItemFactory();
		
		//2.����ServletFileUpload����
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setHeaderEncoding("utf-8");//���file������ļ���������������
		//����5�������ϴ��ĵ����������ļ��Ĵ�С������ʹ�ø÷�ʽ
		upload.setFileSizeMax(10000*1024);//�����ļ�������
		upload.setSizeMax(5*10000*1024);//һ���ϴ��������ļ����ܴ�С������
		
		//3.ͨ��ServletFileUpload����ʵ���ϴ����������ͻ���һ���������װ��һ����FileItem��
		List<FileItem>  itemList = null;
		try {
			itemList = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
			request.setAttribute("mess", "�ļ����ܳ���16kb....");
			request.getRequestDispatcher("/info2.jsp").forward(request, response);
			return;
		}
		//4.��������FileItem���൱�ڶԸ���������д���
		//System.out.println(itemList.size());
		String aid=null;
		String phone = null;
		String qq= null;
		String realName =null;
		String photoName = null;
		String photoType = null;
		for(int i=0;i<itemList.size();i++){
			//ȡ����i������
			FileItem item = itemList.get(i);
			String fieldName = item.getFieldName();
			//�Ը���������д�����ͨ������ļ�����Ҫ�ֿ�����
			if(item.isFormField()){//��ͨ����
				
				//name
				if("aid".equals(fieldName)){
					aid = item.getString();
				}
				//age
				if("phone".equals(fieldName)){
					phone = item.getString();
					System.out.println(phone);
				}
				
				//score
				if("qq".equals(fieldName)){
					qq = item.getString();
					System.out.println(qq);
				}
				
			}else{//�ļ�����
				//photo
				if("photo".equals(fieldName)){
					//����5�������ϴ��ļ���С  16kb���ڴ˴������ô��ַ��������ļ���С���ǲ����ʵģ�
//					long size = item.getSize();
//					if(size > 16*1024){
//						request.setAttribute("mess", "�ļ����ܳ���16kb");
//						request.getRequestDispatcher("/add.jsp").forward(request, response);
//						return;
//					}
					
					//����4��ֻ�ϴ�jpg��jpeg��gif�ļ�
					String contentType = item.getContentType();//images/jpg
					photoType = item.getContentType();
					if(!"image/png".equals(contentType) &&!"image/jpeg".equals(contentType) && !"image/gif".equals(contentType)){
						request.setAttribute("mess", "ֻ���ϴ�jpg��gif�ļ�");
						request.getRequestDispatcher("/info2.jsp").forward(request, response);
						return;
					}
					//ָ���ϴ����ļ��У�Tomcat��webAppsĿ¼�£�Tomcat��webAppsĿ¼֮�⣩
					//File dir = new File("d:/upload");//Servlet�Ƿ������������˴�ֻ�����·��
					//ֱ��ʹ������·���������
					//����3�����߼�·���õ�����·������������
					//File dir = new File("D:\\Java\\apache-tomcat-7.0.79\\webapps\\updownload1/upload");
					//String path = "upload";//�߼�·��
					///upload-----------C:\\Java\\apache-tomcat-7.0.79\\webapps\\updownload1/upload
					String realPath = this.getServletContext().getRealPath("/upload");
					File dir = new File(realPath);
					//����1������ļ��в����ڣ��ʹ���
					if(!dir.exists()){
						dir.mkdirs();
					}
					//ָ���ϴ����ļ���
					realName = item.getName(); //adfad.fadf.yi.jpg   
					//ָ���������ļ��к��ļ���
					//����2��Ϊ�˷�ֹ�ļ���ͬ�����ǣ��ϴ����������˵��ļ���������
					UUID uuid = UUID.randomUUID();
					String extName = realName.substring(realName.lastIndexOf("."));
					photoName = uuid.toString()+extName; //535bc231-935a-427b-a1d7-b3e6d8b8293e.jpg
					
					File file = new File(dir, photoName);
					//�ϴ�����Ƭ��ָ��λ��
					try {
						item.write(file);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				//other 
			}			
			
		}
		
		
		User user=new User(aid, phone, qq, realName, photoName, photoType);
		
		
		int n = SqlHelper.save(user);
		// ҳ����ת
		if (n != 0) {
			// �ض���:/����Ҫ��������·�� /stumgr /stumgr2
			//request.getRequestDispatcher("/main.jsp").forward(request, response);
		response.sendRedirect(request.getContextPath()+"/main.jsp");
		} else {
			request.setAttribute("mess", "���ʧ��!");
			request.getRequestDispatcher("/info2.jsp").forward(request, response);
		}

	}

}
