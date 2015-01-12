package edu.fjnu.haolaimai.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import edu.fjnu.haolaimai.domain.Category;
import edu.fjnu.haolaimai.domain.Good;
import edu.fjnu.haolaimai.exception.ApplicationException;
import edu.fjnu.haolaimai.service.GoodService;
import edu.fjnu.haolaimai.service.impl.GoodServiceImpl;
import edu.fjnu.hotelsys.service.HotelService;
import edu.fjnu.hotelsys.service.HotelServiceImpl;

public class GoodServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public GoodServlet() {
		super();
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GoodService goodService = new GoodServiceImpl();
		/**
		 * 还未实现输出商品类名
		 */
		//找到本机JAVA默认的临时存储空间，用来作为数据获取过程中的缓存区
		File tempFile=new File(System.getProperty("java.io.tmpdir")); //目录也是文件，目录是一个特殊的文件，其实目录本质上是一个文本文件，包含了这个目录下文件的列表信息。
		DiskFileItemFactory factory=new DiskFileItemFactory();
		factory.setSizeThreshold(4096);
		factory.setRepository(tempFile);	
		ServletFileUpload sfu=new ServletFileUpload(factory);
		sfu.setSizeMax(5000000);

		List<FileItem> fileItems=null; 
		String method=null;

		if(sfu.isMultipartContent(request)) //判断request是否是多段提交
		{
			try {
				fileItems=sfu.parseRequest(request);
				for(FileItem item:fileItems)
				{
					if(item.isFormField() && item.getFieldName().equals("method"))
					{
						method=item.getString("utf-8");
						break;
					} 					
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else		
			method=request.getParameter("method");

		/**
		 * 调用方法选择
		 */
		if("addGood".equals(method)){
			Good good = new Good();
			for (FileItem item : fileItems) {
				if (item.isFormField()
						&& item.getFieldName().equals("goodName"))
					good.setGoodName(item.getString("utf-8"));
				else if (item.isFormField()
						&& item.getFieldName().equals("goodPrice"))
					good.setGoodPrice(Double.parseDouble(item
							.getString("utf-8")));
				else if (item.isFormField()&& item.getFieldName().equals("categoryIdS")){
					Category category = new Category();
					int ID = Integer.parseInt(item.getString("utf-8"));
					category.setCateId(ID);
					good.setCategory(category);}
				else if (item.isFormField()
						&& item.getFieldName().equals("description"))
					good.setDescription(item.getString("utf-8"));
				else if (!item.isFormField()
						&& item.getFieldName().equals("goodImage")) {
					byte[] goodImage = new byte[(int) item.getSize()];
					item.getInputStream().read(goodImage, 0,
							(int) item.getSize());
					good.setGoodImage(goodImage);
				}
			}
			try{
				goodService.add(good);
			}catch(ApplicationException e){
				request.setAttribute("msg", e.getMessage());
			}
			response.sendRedirect("jsps/admin/goods/list_goods.jsp");

		}
		else if("loadHotel".equals(method)){
			request.setAttribute("hotelList", hotelService.loadall());
			
			request.getRequestDispatcher("jsps/hotel/list_hotel.jsp").forward(request, response);
		}
	}


	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
