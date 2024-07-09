package controll;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import dao.DAO;
import entity.Category;
import entity.Product;


public class SearchControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SearchControll() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		seach(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	protected void seach(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UFT-8");
		String txtSearch = request.getParameter("txt");
		DAO dao = new DAO();
		
		List<Product> list = dao.searchByName(txtSearch);
		List<Category> listC = dao.getCategory();
		 
		request.setAttribute("ListC", listC);
		request.setAttribute("listP", list);
		request.getRequestDispatcher("Home.jsp").forward(request, response);
	    // or
//	    response.sendRedirect("Home.jsp?scroll=true");
	}

}
