package controll;

import context.DBContext;
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

//@WebServlet("/productImage")
public class ProductImageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try (Connection conn = DBContext.getConnection()) {
            String sql = "SELECT img FROM product WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                byte[] imgData = rs.getBytes("img");
                response.setContentType("image/jpeg");
                try (OutputStream os = response.getOutputStream()) {
                    os.write(imgData);
                    os.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
