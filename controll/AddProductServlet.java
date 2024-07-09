package controll;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.List;

import dao.DAO;
import entity.Category;

@WebServlet("/addProduct")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10) // Giới hạn kích thước file 10MB
public class AddProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddProductServlet() {
        super();
    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
//            throws ServletException, IOException {
//        DAO dao = new DAO();
//        List<Category> categories = dao.getCategory();
//        request.setAttribute("categories", categories);
//        request.getRequestDispatcher("/admin-product.jsp").forward(request, response);
//    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String productName = request.getParameter("productName");
        Part filePart = request.getPart("img"); // Lấy file ảnh
        BigDecimal unitPrice = new BigDecimal(request.getParameter("unitPrice"));
        BigDecimal oldPrice = new BigDecimal(request.getParameter("oldPrice"));
        int cid = Integer.parseInt(request.getParameter("cid"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));

        byte[] img = null;
        if (filePart != null && filePart.getSize() > 0) {
            try (InputStream inputStream = filePart.getInputStream()) {
                img = inputStream.readAllBytes();
            }
        }

        DAO dao = new DAO();
        dao.addProduct(productName, img, unitPrice, oldPrice, cid, quantity);

        response.sendRedirect(request.getContextPath() + "/admin-product");
    }
}
