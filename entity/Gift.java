package entity;

public class Gift {
	private int id;
	private String giftName;
	public Gift(int id, String giftName) {
		super();
		this.id = id;
		this.giftName = giftName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGiftName() {
		return giftName;
	}
	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}
	@Override
	public String toString() {
		return "Gift [id=" + id + ", giftName=" + giftName + "]";
	}
	
}
