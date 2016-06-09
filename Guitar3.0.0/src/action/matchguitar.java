package action;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.IGuitar;
import dao.dataAccess;
import beans.*;

/**
 * Servlet implementation class matchguitar
 */
@WebServlet("/matchguitar")
public class matchguitar extends HttpServlet {
	@SuppressWarnings("null")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接受页面查询条件，并封装成spec
		GuitarSpec spec = new GuitarSpec(null, null, null, null, null);
		spec.setBackWood(request.getParameter("backwood"));
		spec.setBuilder(request.getParameter("builder"));
		spec.setModel(request.getParameter("model"));
		spec.setTopWood(request.getParameter("topwood"));
		spec.setType(request.getParameter("type"));

		// 新建一个guitar List 用来存储匹配到的guitars				
		List matchingGuitars = new LinkedList();
		IGuitar i = dataAccess.createGuitarDao();
		matchingGuitars = i.Inventory().search(spec);		
		
		System.out.println(matchingGuitars);
		
		request.setAttribute("res", matchingGuitars);
		if (!matchingGuitars.isEmpty()) {
	        request.getRequestDispatcher("/result.jsp").forward(request,response);
	      } else {
	        System.out.println("对不起，暂无此商品。");
	      }	
	}
}
