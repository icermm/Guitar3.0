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

/**
 * Servlet implementation class delguitar
 */
@WebServlet("/delguitar")
public class delguitar extends HttpServlet {
	@SuppressWarnings("null")
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取系列号
		String serialNumber=request.getParameter("serialNumber");
		
		IGuitar i = dataAccess.createGuitarDao();
		i.delGuitar(serialNumber);		

 	 	request.getRequestDispatcher("index.html").forward(request, response);
	}
}
