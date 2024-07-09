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

import context.DBContext;

public class ShowImgUserControll extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ShowImgUserControll() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String username = request.getParameter("user");
        try (Connection conn = DBContext.getConnection()) {
            String sql = "SELECT img FROM users WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
