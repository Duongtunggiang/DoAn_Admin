package entity;

import java.math.BigDecimal;
import java.util.Arrays;

public class Product {
	private int id;
	private String productName;
	private byte[] img; 
	private BigDecimal unitPrice;
	private BigDecimal oldPrice;
	private int cid;
	private int quantity;
	public Product(int id, String productName, byte[] img, BigDecimal unitPrice, BigDecimal oldPrice, int cid,
			int quantity) {
		super();
		this.id = id;
		this.productName = productName;
		this.img = img;
		this.unitPrice = unitPrice;
		this.oldPrice = oldPrice;
		this.cid = cid;
		this.quantity = quantity;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public byte[] getImg() {
		return img;
	}
	public void setImg(byte[] img) {
		this.img = img;
	}
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}
	public BigDecimal getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(BigDecimal oldPrice) {
		this.oldPrice = oldPrice;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "Product [id=" + id + ", productName=" + productName + ", img=" + Arrays.toString(img) + ", unitPrice="
				+ unitPrice + ", oldPrice=" + oldPrice + ", cid=" + cid + ", quantity=" + quantity + "]";
	}

	
}