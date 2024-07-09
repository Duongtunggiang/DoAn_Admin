package controll;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import context.DBContext;
import entity.MySession;
import entity.User;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegisterServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Kiểm tra xem các trường có được cung cấp hay không
        if (username != null && password != null) {
            // Kiểm tra tên tài khoản có ký tự và dấu tiếng Việt không
            if (!isValidUsername(username)) {
                response.getWriter().println("<div class=\"alert alert-danger error-message\">Tên đăng nhập không được chứa ký tự và dấu của tiếng Việt.</div>");
                return;
            }

            // Kiểm tra độ mạnh của mật khẩu
            if (!isValidPassword(password)) {
                response.getWriter().println("<div class=\"alert alert-danger error-message\">Mật khẩu phải có độ dài tối thiểu 8 ký tự, bao gồm chữ hoa, chữ thường và số.</div>");
                return;
            }

            // Kết nối tới cơ sở dữ liệu
            try (Connection conn = DBContext.getConnection();
                 PreparedStatement stmt = conn.prepareStatement("SELECT COUNT(*) FROM users WHERE username = ?")) {
                stmt.setString(1, username);
                ResultSet resultSet = stmt.executeQuery();
                resultSet.next();
                int count = resultSet.getInt(1);
                if (count > 0) {
                    response.getWriter().println("<div class=\"alert alert-danger error-message\">Tên đăng nhập đã được sử dụng. Vui lòng chọn tên đăng nhập khác.</div>");
                } else {
                    try (PreparedStatement insertStmt = conn.prepareStatement("INSERT INTO users (`username`, `password`) VALUES (?, ?)")) {
                        insertStmt.setString(1, username);
                        insertStmt.setString(2, password);
                        int rowsAffected = insertStmt.executeUpdate();
                        if (rowsAffected > 0) {
                        	// Lấy thông tin người dùng từ cơ sở dữ liệu
                            int id = 0; // Chưa có thông tin chi tiết khi đăng ký, có thể cập nhật sau
                            String fullName = ""; // Chưa có thông tin chi tiết khi đăng ký, có thể cập nhật sau
                            String address = ""; // Chưa có thông tin chi tiết khi đăng ký, có thể cập nhật sau
                            int phoneNumber = 0; // Chưa có thông tin chi tiết khi đăng ký, có thể cập nhật sau
                            String email = ""; // Chưa có thông tin chi tiết khi đăng ký, có thể cập nhật sau
                            byte[] img = null; // Chưa có ảnh đại diện khi đăng ký
                            byte[] coverImg = null; // Chưa có ảnh bìa khi đăng ký

                            // Tạo đối tượng User với dữ liệu từ cơ sở dữ liệu
                            User user = new User(id, username, password, fullName, address, phoneNumber, email, img, coverImg);

                        	HttpSession session = request.getSession();
                        	session.setAttribute("username", user);
                        	session.setAttribute("isLoggedIn", true);
                        	MySession.getInstance(session);
                        	response.sendRedirect("Home");
                        	
                        } else {
                            response.getWriter().println("<div class=\"alert alert-danger error-message\">Đăng ký không thành công. Vui lòng thử lại sau.</div>");
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
                response.getWriter().println("<div class=\"alert alert-danger error-message\">Đăng ký không thành công. Vui lòng thử lại sau.</div>");
            }
        }
    }

    private static boolean isValidUsername(String username) {
        // Định nghĩa một biểu thức chính quy để kiểm tra ký tự và dấu tiếng Việt
        String regex = "^[a-zA-Z0-9]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(username);
        return matcher.matches();
    }

    private static boolean isValidPassword(String password) {
        // Kiểm tra độ dài
        if (password.length() < 8) {
            return false;
        }

        // Kiểm tra chữ hoa, chữ thường và số
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            }
        }
        if (!hasUppercase || !hasLowercase || !hasDigit) {
            return false;
        }

        // Kiểm tra các mật khẩu phổ biến
        String[] commonPasswords = {"password", "123456", "qwerty", "abcd1234", "letmein", "monkey"};
        for (String commonPassword : commonPasswords) {
            if (password.equalsIgnoreCase(commonPassword)) {
                return false;
            }
        }

        // Nếu vượt qua tất cả các kiểm tra, mật khẩu hợp lệ
        return true;
    }
}