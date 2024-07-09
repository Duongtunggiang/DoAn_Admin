package dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import context.DBContext;
import entity.Category;
import entity.Gift;
import entity.News;
import entity.Product;
import entity.ProductDetails;
import entity.User;

public class DAO {
	Connection connect = null; 			//ket noi SQL
	PreparedStatement prepare = null;   //Nem cau lenh sang SQL
	ResultSet resultSet = null; 		//Nhan ket qua tra ve
	
	//All product
	public List<Product> getAllProduct(){
		List<Product> list = new ArrayList<>();
		String query = "SELECT * FROM mobile.product;";
		try {
			new DBContext();
			connect = DBContext.getConnection(); //Mo ket noi SQL
			prepare = connect.prepareStatement(query);
			resultSet = prepare.executeQuery();
			while (resultSet.next()) {
				list.add(new Product(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getBytes(3),
						resultSet.getBigDecimal(4),
						resultSet.getBigDecimal(5),
						resultSet.getInt(6),
						resultSet.getInt(7)
						));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	//Top 1
	public List<Product> getTop1(){
		List<Product> top1 = new ArrayList<>();
		String top = "SELECT * FROM product ORDER BY id DESC LIMIT 1;";
		try {
			new DBContext();
			connect = DBContext.getConnection();
			prepare = connect.prepareStatement(top);
			resultSet = prepare.executeQuery();
			while (resultSet.next()) {
				top1.add(new Product(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getBytes(3),
						resultSet.getBigDecimal(4),
						resultSet.getBigDecimal(5),
						resultSet.getInt(6),
						resultSet.getInt(7)
						));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return top1;
	}
	//Category
	public List<Category> getCategory() {
        List<Category> productList = new ArrayList<>();

        try {
            String sql = "select * from categoryProduct";
            prepare = connect.prepareStatement(sql);
            resultSet = prepare.executeQuery();

            while(resultSet.next()) {
            	productList.add(new Category(
            			resultSet.getInt(1),
            			resultSet.getString(2)
            			));
            }
           
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productList;
    }
	public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        String sql = "SELECT id, categoryName FROM categoryProduct";
        
        try (Connection conn = DBContext.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String categoryName = rs.getString("categoryName");
                categories.add(new Category(id, categoryName));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return categories;
    }
	//Search by Name:
	public List<Product> searchByName(String txtSearch){
		List<Product> list = new ArrayList<>();
		String query = "select * from `product` where productName like ?";
		try {
			new DBContext();
			connect = DBContext.getConnection();
			prepare = connect.prepareStatement(query);
			prepare.setString(1, "%"+txtSearch+"%");
			resultSet = prepare.executeQuery();
			
			while(resultSet.next()) {
				list.add(new Product(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getBytes(3),
						resultSet.getBigDecimal(4),
						resultSet.getBigDecimal(5),
						resultSet.getInt(6),
						resultSet.getInt(7)
						));
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return list ;
	}
	public static void main(String[] args) {
		DAO dao = new DAO();
		List<Product> listX = dao.getAllProduct();
		List<Category> list = dao.getCategory();
		List<Product> listP = dao.searchByName("13");
		List<Gift> gift = dao.getAllGift("2");
		List<ProductDetails> d = dao.getAllDetails("2");
		
		for(Product o : listP) {
			System.out.println(o);
		}
	}
	//Category by id
	public List<Product> getProductByCateID(String id){
		List<Product> list = new ArrayList<>();
		String query = "Select * from `product` where cid = ?;";
		try {
			new DBContext();
			connect = DBContext.getConnection();
			prepare = connect.prepareStatement(query);
			prepare.setString(1, id);
			resultSet = prepare.executeQuery();
			
			while(resultSet.next()) {
				list.add(new Product(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getBytes(3),
						resultSet.getBigDecimal(4),
						resultSet.getBigDecimal(5),
						resultSet.getInt(6),
						resultSet.getInt(7))
						);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
	}
	//Gift
	public List<Gift> getAllGift(String id){
		List<Gift> list = new ArrayList<>();
		
		try {
			String gift = "SELECT * FROM gift where productId = ?";
			new DBContext();
			connect = DBContext.getConnection(); 
			prepare = connect.prepareStatement(gift);
			prepare.setString(1, id);
			resultSet = prepare.executeQuery();
			while (resultSet.next()) {
				list.add(new Gift(
						resultSet.getInt(1),
						resultSet.getString(2)
						));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public Product getProductByID(String id){
		
		String query = "Select * from `product` where id = ?;";
		try {
			new DBContext();
			connect = DBContext.getConnection();
			prepare = connect.prepareStatement(query);
			prepare.setString(1, id);
			resultSet = prepare.executeQuery();
			
			while(resultSet.next()) {
				return new Product(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getBytes(3),
						resultSet.getBigDecimal(4),
						resultSet.getBigDecimal(5),
						resultSet.getInt(6),
						resultSet.getInt(7)
						);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	public Category getCategoryByID(int i){
		
		String query = "SELECT cp.* FROM product p JOIN categoryProduct cp ON p.cid = cp.id WHERE p.id = ?;";
		try {
			new DBContext();
			connect = DBContext.getConnection();
			prepare = connect.prepareStatement(query);
			prepare.setInt(1, i);
			resultSet = prepare.executeQuery();
			
			while(resultSet.next()) {
				return new Category(
						resultSet.getInt(1),
						resultSet.getString(2)
						);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
		
	}
	//NEWS
	public List<News> getNews(){
		List<News> list = new ArrayList<>();
		String query = "SELECT * FROM news";
		try {
			new DBContext();
			connect = DBContext.getConnection(); 
			prepare = connect.prepareStatement(query);
			resultSet = prepare.executeQuery();
			while (resultSet.next()) {
				list.add(new News(
						resultSet.getInt(1),
						resultSet.getString(2)
						));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	//ProDetaillss
	public List<ProductDetails> getAllDetails(String id){
		List<ProductDetails> list = new ArrayList<>();
		
		try {
			String de = "SELECT * FROM productDetails where productId = ?";
			new DBContext();
			connect = DBContext.getConnection(); 
			prepare = connect.prepareStatement(de);
			prepare.setString(1, id);
			resultSet = prepare.executeQuery();
			while (resultSet.next()) {
				list.add(new ProductDetails(
//						resultSet.getInt(1),
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getString(5),
						resultSet.getString(6),
						resultSet.getString(7),
						resultSet.getString(8),
						resultSet.getString(9),
						resultSet.getString(10),
						resultSet.getString(11),
						resultSet.getString(12),
						resultSet.getString(13),
						resultSet.getString(14),
						resultSet.getString(15),
						resultSet.getString(16),
						resultSet.getString(17),
						resultSet.getString(18),
						resultSet.getString(19),
						resultSet.getString(20),
						resultSet.getString(21)
						));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	// Lấy chi tiết sản phẩm theo id
    public ProductDetails getProductDetailsById(int productId) {
        ProductDetails productDetails = null;
        String sql = "SELECT * FROM productDetails WHERE productId = ?";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, productId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    productDetails = new ProductDetails( rs.getInt("productId"),
                            rs.getString("screenTechnology"), rs.getString("screenResolution"),
                            rs.getString("glassQuality"), rs.getString("screenSize"), rs.getString("rearCameraResolution"),
                            rs.getString("frontCameraResolution"), rs.getString("rearCameraDetails"),
                            rs.getString("videoRecordingCapability"), rs.getString("cameraFeatures"),
                            rs.getString("processor"), rs.getString("chip"), rs.getString("operatingSystem"),
                            rs.getString("ram"), rs.getString("storage"), rs.getString("mobileNetworkSupport"),
                            rs.getString("wifiSupport"), rs.getString("bluetoothSupport"), rs.getString("gpsSupport"),
                            rs.getString("connectivityPorts"), rs.getString("batteryCapacity"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return productDetails;
    }
    //Add new detail product
    public boolean addProductDetails(ProductDetails details) {
        boolean success = false;
        String sql = "INSERT INTO productDetails (productId, screenTechnology, screenResolution, glassQuality, screenSize, "
                   + "rearCameraResolution, frontCameraResolution, rearCameraDetails, videoRecordingCapability, cameraFeatures, "
                   + "processor, chip, operatingSystem, ram, storage, mobileNetworkSupport, wifiSupport, bluetoothSupport, "
                   + "gpsSupport, connectivityPorts, batteryCapacity) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, details.getProductId());
            ps.setString(2, details.getScreenTechnology());
            ps.setString(3, details.getScreenResolution());
            ps.setString(4, details.getGlassQuality());
            ps.setString(5, details.getScreenSize());
            ps.setString(6, details.getRearCameraResolution());
            ps.setString(7, details.getFrontCameraResolution());
            ps.setString(8, details.getRearCameraDetails());
            ps.setString(9, details.getVideoRecordingCapability());
            ps.setString(10, details.getCameraFeatures());
            ps.setString(11, details.getProcessor());
            ps.setString(12, details.getChip());
            ps.setString(13, details.getOperatingSystem());
            ps.setString(14, details.getRam());
            ps.setString(15, details.getStorage());
            ps.setString(16, details.getMobileNetworkSupport());
            ps.setString(17, details.getWifiSupport());
            ps.setString(18, details.getBluetoothSupport());
            ps.setString(19, details.getGpsSupport());
            ps.setString(20, details.getConnectivityPorts());
            ps.setString(21, details.getBatteryCapacity());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }
    //Update detail
    public boolean updateProductDetails(ProductDetails details) {
        boolean success = false;
        String sql = "UPDATE productDetails SET screenTechnology=?, screenResolution=?, glassQuality=?, screenSize=?, "
                   + "rearCameraResolution=?, frontCameraResolution=?, rearCameraDetails=?, videoRecordingCapability=?, cameraFeatures=?, "
                   + "processor=?, chip=?, operatingSystem=?, ram=?, storage=?, mobileNetworkSupport=?, wifiSupport=?, bluetoothSupport=?, "
                   + "gpsSupport=?, connectivityPorts=?, batteryCapacity=? "
                   + "WHERE id=?";

        try (Connection conn = DBContext.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, details.getScreenTechnology());
            ps.setString(2, details.getScreenResolution());
            ps.setString(3, details.getGlassQuality());
            ps.setString(4, details.getScreenSize());
            ps.setString(5, details.getRearCameraResolution());
            ps.setString(6, details.getFrontCameraResolution());
            ps.setString(7, details.getRearCameraDetails());
            ps.setString(8, details.getVideoRecordingCapability());
            ps.setString(9, details.getCameraFeatures());
            ps.setString(10, details.getProcessor());
            ps.setString(11, details.getChip());
            ps.setString(12, details.getOperatingSystem());
            ps.setString(13, details.getRam());
            ps.setString(14, details.getStorage());
            ps.setString(15, details.getMobileNetworkSupport());
            ps.setString(16, details.getWifiSupport());
            ps.setString(17, details.getBluetoothSupport());
            ps.setString(18, details.getGpsSupport());
            ps.setString(19, details.getConnectivityPorts());
            ps.setString(20, details.getBatteryCapacity());
            ps.setInt(21, details.getId());

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                success = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return success;
    }
	public User getUser(String id){
		String user = "select * from users where username = ?";
		try {
			new DBContext();
			connect = DBContext.getConnection();
			prepare = connect.prepareStatement(user);
			prepare.setString(1, id);
			resultSet = prepare.executeQuery();
			while(resultSet.next()) {
				return new User(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3),
						resultSet.getString(4),
						resultSet.getString(5),
						resultSet.getInt(6),
						resultSet.getString(7),
						resultSet.getBytes(8),
						resultSet.getBytes(9)
						);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public User updateUser(String id, String fullName, String address, 
			String phoneNumber, String email) {
		String update = "update users set fullName = ?, address = ?, phoneNumber = ?, email = ? "
				+ "where id = ?";
		try {
			connect = DBContext.getConnection();
			PreparedStatement stm = connect.prepareStatement(update);
			stm.setString(1, fullName);
			stm.setString(2, address);
			stm.setString(3, phoneNumber);
			stm.setString(4, email);
			stm.setString(5, id);
			int rowUpdate = stm.executeUpdate();
			if(rowUpdate > 0) {
				return getUser(id);
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	//Admin
	public void addProduct(String productName,  byte[] img, BigDecimal unitPrice, BigDecimal oldPrice, int cid, int quantity) {
        String sql = "INSERT INTO `product` (productName, img, unitPrice, oldPrice, cid, quantity) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBContext.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, productName);
            stmt.setBytes(2, img);
            stmt.setBigDecimal(3, unitPrice);
            stmt.setBigDecimal(4, oldPrice);
            stmt.setInt(5, cid);
            stmt.setInt(6, quantity);
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
