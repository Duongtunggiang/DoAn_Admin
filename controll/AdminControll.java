package controll;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.DAO;
import entity.Category;
import entity.Product;


public class AdminControll extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AdminControll() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		admin(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void admin(HttpServletRequest request, HttpServletResponse response) 
	        throws ServletException, IOException {
	    response.setContentType("text/html; charset=UFT-8");
	    
	    DAO dao = new DAO();
	    
	    // Lấy tất cả sản phẩm
	    List<Product> lists = dao.getAllProduct();
	    request.setAttribute("listP", lists);
	    
	    // Lấy tất cả danh mục
	    List<Category> listC = dao.getCategory();
	    request.setAttribute("ListC", listC);
	  
	 // Tạo Map chứa danh mục
	    Map<Integer, Category> categoryMap = new HashMap<>();
	    for (Category category : listC) {
	        categoryMap.put(category.getId(), category);
	    }

	    // Tạo Map chứa danh mục tương ứng với từng sản phẩm
	    Map<Integer, Category> productCategoryMap = new HashMap<>();
	    for (Product product : lists) {
	        int categoryId = product.getCid();
	        Category category = categoryMap.get(categoryId);
	        productCategoryMap.put(product.getId(), category);
	    }
	    request.setAttribute("productCategoryMap", productCategoryMap);
	    
	    request.getRequestDispatcher("admin-product.jsp").forward(request, response);
	}

}
