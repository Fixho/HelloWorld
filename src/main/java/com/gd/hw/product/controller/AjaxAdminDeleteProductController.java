package com.gd.hw.product.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gd.hw.product.model.service.AdminProductService;

/**
 * Servlet implementation class AjaxAdminDeleteProductController
 */
@WebServlet("/deleteProduct.pro")
public class AjaxAdminDeleteProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxAdminDeleteProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String checkedValues[] = request.getParameterValues("checkedValues");
		System.out.println("delete");
		int result = new AdminProductService().deleteProduct(checkedValues);
		System.out.println(result);
		if(result>0) {
			response.setContentType("text/html; charset=UTF-8");
			response.getWriter().print(result);
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
