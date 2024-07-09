package controll;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import context.DBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/sortProduct")
public class SortProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try (Connection conn = DBContext.getConnection()) {
            // Step 1: Set the row number variable to 0
            String setRowNumberSql = "SET @row_number = 0";
            PreparedStatement setRowNumberStmt = conn.prepareStatement(setRowNumberSql);
            setRowNumberStmt.executeUpdate();
            
            // Step 2: Update the IDs of the products in sequence
            String updateIdSql = "UPDATE product SET id = (@row_number:=@row_number + 1)";
            PreparedStatement updateIdStmt = conn.prepareStatement(updateIdSql);
            updateIdStmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Redirect back to the product list after sorting
        response.sendRedirect(request.getContextPath() + "/admin-product");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doGet(request, response);
    }
}

