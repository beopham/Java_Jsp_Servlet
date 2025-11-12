package Batloi;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Xuly
 */
@WebServlet("/Xuly")
public class Xuly extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Xuly() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		// Dùng cho dữ liệu NHẬN TỪ form (method POST)
		request.setCharacterEncoding("UTF-8"); 
		// Dùng cho dữ liệu TRẢ VỀ trình duyệt
		response.setContentType("text/html; charset=UTF-8");
		String email=request.getParameter("email");
		String mk=request.getParameter("mk");
		RequestDispatcher rd;
		if(email.equalsIgnoreCase("nam")&&mk.equalsIgnoreCase("123"))
		{
			rd=request.getRequestDispatcher("tc.jsp");
		}
		else {
			rd=request.getRequestDispatcher("tb.jsp");
		}
        rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
