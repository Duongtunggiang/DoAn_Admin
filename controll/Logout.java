package controll;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout")
public class Logout extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	public Logout() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	    // Lấy session hiện tại
	    HttpSession session = request.getSession(false);

	    if (session != null) {
	        // Xóa thông tin người dùng khỏi session
	        session.invalidate();

	        // Chuyển hướng người dùng về trang đăng nhập
	        response.sendRedirect("Home");
	    } else {
	        // Nếu không có session, chuyển hướng về trang đăng nhập
	        response.sendRedirect("Home");
	    }
	}
}
