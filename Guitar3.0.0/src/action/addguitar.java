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
 * Servlet implementation class addguitar
 */
@WebServlet("/addguitar")
public class addguitar extends HttpServlet {
	@SuppressWarnings("null")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接受页面添加条件，并封装成spec
		GuitarSpec spec = new GuitarSpec(null, null, null, null, null);
		spec.setBackWood(request.getParameter("backwood"));
		spec.setBuilder(request.getParameter("builder"));
		spec.setModel(request.getParameter("model"));
		spec.setTopWood(request.getParameter("topwood"));
		spec.setType(request.getParameter("type"));
		
		//获取系列号和价格
		String serialNumber=request.getParameter("serialnumber");
		double price= Double.valueOf(request.getParameter("price").toString());
		
		IGuitar i = dataAccess.createGuitarDao();
		i.addGuitar(serialNumber, price, spec);		

 	 	request.getRequestDispatcher("index.html").forward(request, response);
	}
}
