package controll;

import java.io.IOException;

import dao.DAO;
import entity.ProductDetails;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/editProductDetails")
public class EditProductDetailsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public EditProductDetailsServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            int productId = Integer.parseInt(request.getParameter("productId"));
            String screenTechnology = request.getParameter("screenTechnology");
            String screenResolution = request.getParameter("screenResolution");
            String glassQuality = request.getParameter("glassQuality");
            String screenSize = request.getParameter("screenSize");
            String rearCameraResolution = request.getParameter("rearCameraResolution");
            String frontCameraResolution = request.getParameter("frontCameraResolution");
            String rearCameraDetails = request.getParameter("rearCameraDetails");
            String videoRecordingCapability = request.getParameter("videoRecordingCapability");
            String cameraFeatures = request.getParameter("cameraFeatures");
            String processor = request.getParameter("processor");
            String chip = request.getParameter("chip");
            String operatingSystem = request.getParameter("operatingSystem");
            String ram = request.getParameter("ram");
            String storage = request.getParameter("storage");
            String mobileNetworkSupport = request.getParameter("mobileNetworkSupport");
            String wifiSupport = request.getParameter("wifiSupport");
            String bluetoothSupport = request.getParameter("bluetoothSupport");
            String gpsSupport = request.getParameter("gpsSupport");
            String connectivityPorts = request.getParameter("connectivityPorts");
            String batteryCapacity = request.getParameter("batteryCapacity");

            ProductDetails details = new ProductDetails(productId, screenTechnology, screenResolution, glassQuality,
                    screenSize, rearCameraResolution, frontCameraResolution, rearCameraDetails, videoRecordingCapability,
                    cameraFeatures, processor, chip, operatingSystem, ram, storage, mobileNetworkSupport, wifiSupport,
                    bluetoothSupport, gpsSupport, connectivityPorts, batteryCapacity);

            DAO dao = new DAO();
            boolean success = dao.updateProductDetails(details);

            if (success) {
                response.sendRedirect(request.getContextPath() + "/admin-detail");
            } else {
                request.setAttribute("errorMessage", "Failed to update product details");
                request.getRequestDispatcher("/404.jsp").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("errorMessage", "Failed to update product details: " + e.getMessage());
            request.getRequestDispatcher("/404.jsp").forward(request, response);
        }
    }
}
