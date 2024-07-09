package entity;

public class Ads {
	private int id;
	private String img;
	private String recoment;
	private String textAd;
	public Ads(int id, String img, String recoment, String textAd) {
		super();
		this.id = id;
		this.img = img;
		this.recoment = recoment;
		this.textAd = textAd;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getRecoment() {
		return recoment;
	}
	public void setRecoment(String recoment) {
		this.recoment = recoment;
	}
	public String getTextAd() {
		return textAd;
	}
	public void setTextAd(String textAd) {
		this.textAd = textAd;
	}
	@Override
	public String toString() {
		return "Ads [id=" + id + ", img=" + img + ", recoment=" + recoment + ", textAd=" + textAd + "]";
	}
	
	
}
