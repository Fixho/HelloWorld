package com.gd.hw.category.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gd.hw.category.model.service.CategoryService;
import com.gd.hw.category.model.vo.ProCategory;

/**
 * Servlet implementation class CategoryAddListController
 */
@WebServlet("/addList.cg")
public class CategoryAddListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryAddListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String categoryName = request.getParameter("categories-add-title");
		String categoryEngName =request.getParameter("categories-add-eng-title");
		
		ProCategory pc = new ProCategory(categoryName,categoryEngName);
		
		
//		추 후 로그인 한 유저 추가 
		
		int result =  new CategoryService().addCategory(pc);
		
			
		if(result > 0) {
			response.sendRedirect(request.getContextPath()+"/list.cg");
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
