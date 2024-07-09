package controll;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import context.DBContext;
import dao.DAO;
import entity.Category;
import entity.Gift;
import entity.News;
import entity.Product;
import entity.ProductDetails;

@WebServlet("/detail")
public class DetailControll extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DetailControll() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		processRequest(request, response);
		

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	protected void processRequest(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		DAO dao = new DAO();
		
		String id = request.getParameter("pid");
	    Product p = dao.getProductByID(id);
	    request.setAttribute("detail", p);
	    
	    List<Gift> gifts = dao.getAllGift(id);
	    request.setAttribute("gift", gifts);
	    
	    List<News> news = dao.getNews();
	    request.setAttribute("newss", news);
	    
	    List<ProductDetails> detail = dao.getAllDetails(id);
	    request.setAttribute("de", detail);
	    
		List<Product> list = dao.getAllProduct();
		List<Category> listC = dao.getCategory();
		
		request.setAttribute("listP", list);
		request.setAttribute("ListC", listC);
	
		request.getRequestDispatcher("san-pham.jsp").forward(request, response);
	}


}
