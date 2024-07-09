package controll;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import dao.DAO;
import entity.MySession;
import entity.User;

public class UpdateUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    
    
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
    		throws ServletException, IOException {
        // Lấy thông tin từ request
        String userId = request.getParameter("userId");
        String fullName = request.getParameter("fullName");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        DAO dao = new DAO();
        // Gọi phương thức updateUser() để cập nhật thông tin người dùng
        User updatedUser = dao.updateUser(userId, fullName, address, phoneNumber, email);

        // Lưu thông tin người dùng đã cập nhật vào session
        HttpSession session = request.getSession();
        session.setAttribute("User", updatedUser);
     // Lưu trữ các thông tin cần thiết vào instance của MySession
        MySession mySession = MySession.getInstance(session);

        // Chuyển hướng về trang Home
        response.sendRedirect(request.getContextPath() + "/myacc?user=" + mySession.getUser().getUsername());
    }
}






