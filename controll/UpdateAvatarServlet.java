package controll;

import context.DBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;

//@WebServlet("/UpdateAvatarServlet")
@MultipartConfig(maxFileSize = 1024 * 1024 * 10) // Giới hạn kích thước file 10MB
public class UpdateAvatarServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        Part filePart = request.getPart("profilePicture");

        if (filePart != null && filePart.getSize() > 0) {
            try (Connection conn = DBContext.getConnection()) {
                String sql = "UPDATE users SET img = ? WHERE username = ?";
                
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    try (InputStream inputStream = filePart.getInputStream()) {
                        stmt.setBlob(1, inputStream);
                    }
                    stmt.setString(2, username);
                    stmt.executeUpdate();
                } catch (Exception e) {
                    e.printStackTrace();
                    response.getWriter().println("Đã xảy ra lỗi khi cập nhật hình ảnh đại diện. Vui lòng thử lại sau.");
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                response.getWriter().println("Đã xảy ra lỗi khi kết nối đến cơ sở dữ liệu. Vui lòng thử lại sau.");
                return;
                
            } 
           
            finally {
                filePart.delete(); // Tùy chọn: Xóa file tạm sau khi tải lên
            }
        }

        response.sendRedirect("myacc?user=" + username);
    }
}
