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
		String user = request.getParameter("userName");
		String pass = request.getParameter("passWord");
		request.setAttribute("userName",user); 
		request.setAttribute("passWord",pass); 
		
		if(request.getParameter("Login")!=null) {
            if(user.equals("md") && pass.equals("pw")) {
            	
            	ArrayList<ShowWeek> moviesInWeek = allData.getOneWeek("2021-07-04");
    			String hello = allData.toString();
//				String [] data = new String[moviesInWeek.size()];
//				int index = 0;
//				for (ShowWeek sw : moviesInWeek){
//					data[index] = sw.getShowTitle();
//					index++;
//				}
				request.setAttribute("dropDownOptions",hello); 	
				RequestDispatcher rd=request.getRequestDispatcher("/Main.jsp");
				rd.forward(request,response);
            } else {
                RequestDispatcher rd =request.getRequestDispatcher("/index.html");
                rd.forward(request,response);
		
				
			}
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
