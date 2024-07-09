package controll;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import dao.DAO;
import entity.Product;
import entity.ProductDetails;

//@WebServlet("/admin-detail")
public class AdminDetailControll extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AdminDetailControll() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        adminDetail(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void adminDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        DAO dao = new DAO();

        List<Product> lists = dao.getAllProduct();
        request.setAttribute("listP", lists);

        // Lấy id sản phẩm từ request nếu có
        String idParam = request.getParameter("id");
        if (idParam != null) {
            int productId = Integer.parseInt(idParam);
            ProductDetails productDetails = dao.getProductDetailsById(productId);
            request.setAttribute("productDetails", productDetails);
        }

        request.getRequestDispatcher("admin-detail.jsp").forward(request, response);
    }
}
