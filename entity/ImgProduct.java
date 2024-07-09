package entity;

import java.util.Arrays;

public class ImgProduct {
	private int id;
	private int coID;
	private byte [] imageUrl;
	public ImgProduct(int id, int coID, byte[] imageUrl) {
		super();
		this.id = id;
		this.coID = coID;
		this.imageUrl = imageUrl;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCoID() {
		return coID;
	}
	public void setCoID(int coID) {
		this.coID = coID;
	}
	public byte[] getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(byte[] imageUrl) {
		this.imageUrl = imageUrl;
	}
	@Override
	public String toString() {
		return "ImgProduct [id=" + id + ", coID=" + coID + ", imageUrl=" + Arrays.toString(imageUrl) + "]";
	}
	
	
}