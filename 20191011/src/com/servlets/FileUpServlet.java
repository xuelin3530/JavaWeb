package com.servlets;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;
@WebServlet("/FileUpServlet")
public class FileUpServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//判断request中的类型是否"multipart/form-data"
		if(ServletFileUpload.isMultipartContent(req)) {
			//获得工厂
			DiskFileItemFactory fac = new DiskFileItemFactory();
			//创建文件上传对象
			ServletFileUpload  sfu = new ServletFileUpload(fac);
			try {
				//解析request，获取request中所有的文件项
				List<FileItem>  items = sfu.parseRequest(req);
				//遍历集合
				for(FileItem fi : items) {
					//判断是否是普通元素
					if(!fi.isFormField()) {
						//不是普通元素，才可以上传文件
						//上传后的文件名字
						String pagepath = fi.getName();
						String filename = FilenameUtils.getName(pagepath);
						//上传文件的物理路径
						String path = this.getServletContext().getRealPath("/file");
						//创建上传文件
						
						File file = new File(path, System.currentTimeMillis()+filename);
						//开始上传
						fi.write(file);
						System.out.println("上传成功");
					}else {

						System.out.println(fi.getFieldName()+"==="+fi.getString("utf-8"));
					}
				}
				
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
		
		
		
		
		
		
		
		
	}
}
