package servletPackage;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import servletPackage.Shows;
import servletPackage.ShowWeek;
/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Shows allData;       
	private String data;
	private String week;
	private String category;
	private String rank;
	private String showTitle;
	private String seasonTitle;
	private String hoursViewed;
	private String WeeksTop10;
	private String user;
	private String pass;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet() {
		super();
		allData = new Shows("allData","./servletPackage/netflixAllWeeksGlobalProcessed.txt");


		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		user = request.getParameter("userName");
		pass = request.getParameter("passWord");
		request.setAttribute("userName",user); 
		request.setAttribute("passWord",pass); 

		if(request.getParameter("index")!=null) {
			user = request.getParameter("userName");
			pass = request.getParameter("passWord");
			if(user.equals("md") && pass.equals("pw")) {
				data = "<select name=\"Shows\">";
				data += allData.toStringTitle();
				if (showTitle != null)
				{
					data += "<option value=\""+showTitle+"\">"+showTitle+"</option>";
				}
				data += "</select>";
				request.setAttribute("dropDownOptions",data); 	
				RequestDispatcher rd=request.getRequestDispatcher("/Main.jsp");
				rd.forward(request,response);
			} else {
				RequestDispatcher rd =request.getRequestDispatcher("/index.html");
				rd.forward(request,response);


			}
		}
		if(request.getParameter("addingMovie")!=null) {
			RequestDispatcher rd =request.getRequestDispatcher("/AddMovie.jsp");
			rd.forward(request,response);
		}
		if(request.getParameter("addMovie")!=null) {
			week = request.getParameter("Week");
			category = request.getParameter("Category");
			rank = request.getParameter("Rank");
			showTitle = request.getParameter("ShowTitle");
			seasonTitle = request.getParameter("SeasonTitle");
			hoursViewed = request.getParameter("HrsViewed");
			WeeksTop10 = request.getParameter("WeeksTop10");

			request.setAttribute("Week",week); 
			request.setAttribute("Category",category); 
			request.setAttribute("Rank",rank); 
			request.setAttribute("ShowTitle",showTitle); 
			request.setAttribute("SeasonTitle",seasonTitle); 
			request.setAttribute("HrsViewed",hoursViewed); 
			request.setAttribute("WeeksTop10",WeeksTop10); 

			String Add = week+category+rank+showTitle+seasonTitle+hoursViewed+WeeksTop10;
			data += Add;
			RequestDispatcher rd=request.getRequestDispatcher("/index.html");
			rd.forward(request,response);
		}
		if(request.getParameter("newMain")!=null) {
			showTitle = request.getParameter("ShowTitle");
			user = request.getParameter("userName");
			pass = request.getParameter("passWord");
			
			data = "<select name=\"Shows\">";
			data += allData.toStringTitle();
			data += "<option value=\""+showTitle+"\">"+showTitle+"</option>";
			data += "</select>";
			
			request.setAttribute("dropDownOptions",data); 	
			RequestDispatcher rd=request.getRequestDispatcher("/Main.jsp");
			rd.forward(request,response);
		}
		if(request.getParameter("logout")!=null) {
			RequestDispatcher rd =request.getRequestDispatcher("/index.html");
			rd.forward(request,response);
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
