package entity;

import java.math.BigDecimal;

public class Color {
	private int colorId;
	private int memoryID;
	private String color;
	private BigDecimal oldPrice;
	private BigDecimal newPrice;
	public Color(int colorId, int memoryID, String color, BigDecimal oldPrice, BigDecimal newPrice) {
		super();
		this.colorId = colorId;
		this.memoryID = memoryID;
		this.color = color;
		this.oldPrice = oldPrice;
		this.newPrice = newPrice;
	}
	public int getColorId() {
		return colorId;
	}
	public void setColorId(int colorId) {
		this.colorId = colorId;
	}
	public int getMemoryID() {
		return memoryID;
	}
	public void setMemoryID(int memoryID) {
		this.memoryID = memoryID;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public BigDecimal getOldPrice() {
		return oldPrice;
	}
	public void setOldPrice(BigDecimal oldPrice) {
		this.oldPrice = oldPrice;
	}
	public BigDecimal getNewPrice() {
		return newPrice;
	}
	public void setNewPrice(BigDecimal newPrice) {
		this.newPrice = newPrice;
	}
	@Override
	public String toString() {
		return "Color [colorId=" + colorId + ", memoryID=" + memoryID + ", color=" + color + ", oldPrice=" + oldPrice
				+ ", newPrice=" + newPrice + "]";
	}
	
}
