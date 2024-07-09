package controll;

import jakarta.servlet.RequestDispatcher;
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

@WebServlet("/Home")
public class HomeControll extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HomeControll() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Home(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}
	protected void Home(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UFT-8");
		
		DAO dao = new DAO();
		List<Product> list = dao.getAllProduct();
		request.setAttribute("listP", list);
		
		List<Category> listC = dao.getCategory();
		request.setAttribute("ListC", listC);
		
		List<Product> top = dao.getTop1();
		request.setAttribute("Top1", top);
		
		request.getRequestDispatcher("Home.jsp").forward(request, response);
	   
	}


}
