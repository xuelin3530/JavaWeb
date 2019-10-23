package com.art.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import com.art.pojo.Art;
import com.art.service.IArtService;
import com.art.service.impl.ArtServiceImpl;

/**
 * Servlet implementation class AddArt
 */
@WebServlet("/AddArt")
public class AddArtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private IArtService ias = new ArtServiceImpl();
	
	public AddArtServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		Art art = new Art();
		
		DiskFileItemFactory fac = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(fac);
		
		try {
			List<FileItem> items = sfu.parseRequest(request);
			for(FileItem fi : items) {
				if (fi.isFormField()) {
					String fieldname = fi.getFieldName();
					String value = fi.getString("utf-8");
					switch (fieldname) {
					case "art_name":
						art.setArt_name(value);
						break;
					case "art_price":
						art.setArt_price(value);
						break;
					case "art_introduction":
						art.setArt_introduction(value);
						break;
					case "art_detail":
						art.setArt_detail(value);
					}
				}else {
					String pagepath=fi.getName();
					String filename = FilenameUtils.getName(pagepath);
					art.setArt_cover("/image/"+filename);
					String path = this.getServletContext().getRealPath("/image");
					File pathFile = new File(path);
					if(!pathFile.exists()) {
						pathFile.mkdirs();
					}
					File file = new File(path, filename);
					fi.write(file);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		//保存图示信息
		
		ias.addArt(art);
		
		
		response.sendRedirect("/art-mall/ShowArtsServlet");
		System.out.println("添加成功");
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
