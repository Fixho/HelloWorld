package com.gd.hw.category.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gd.hw.category.model.service.CategoryService;
import com.gd.hw.category.model.vo.Region;

/**
 * Servlet implementation class CityAddListController
 */
@WebServlet("/addCity.cg")
public class CityAddListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CityAddListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String title = request.getParameter("new-city-title");
		String engTitle = request.getParameter("new-city-eng-title");
		
		Region r = new Region(title,engTitle);
		
		int result = new CategoryService().addRegion(r);
		
		if(result>0) {
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
