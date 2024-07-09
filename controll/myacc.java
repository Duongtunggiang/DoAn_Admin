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
import entity.User;

@WebServlet("/myacc")
public class myacc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public myacc() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		myAcc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		myAcc(request, response);
	}
	private void myAcc(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		response.setContentType("text/html");
		String id = request.getParameter("user");
		
		DAO dao = new DAO();
		List<Product> list = dao.getAllProduct();
		List<Category> listC = dao.getCategory();
		User user = dao.getUser(id);
		
		request.setAttribute("listP", list);
		request.setAttribute("ListC", listC);
		request.setAttribute("User", user);

	    RequestDispatcher rd = request.getRequestDispatcher("/myacc.jsp");
	    rd.include(request, response);

	}
}
