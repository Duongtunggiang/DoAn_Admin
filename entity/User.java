package entity;

import java.util.Base64;

public class User {
	private int id;
	private String username;
	private String password;
	private String fullName ;
    private String address ;
    private int phoneNumber ;
    private String email ;
    private byte[] img;
    private byte[] coverImg;
    
    public boolean checkLogin(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }
    
//    public String getImgBase64() {
//        return Base64.getEncoder().encodeToString(this.img);
//    }


	public User(int id, String username, String password, String fullName, String address, int phoneNumber,
			String email, byte[] img, byte[] coverImg) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.fullName = fullName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.img = img;
		this.coverImg = coverImg;
	}

	

	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getFullName() {
		return fullName;
	}



	public void setFullName(String fullName) {
		this.fullName = fullName;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public int getPhoneNumber() {
		return phoneNumber;
	}



	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public byte[] getImg() {
		return img;
	}



	public void setImg(byte[] img) {
		this.img = img;
	}



	public byte[] getCoverImg() {
		return coverImg;
	}



	public void setCoverImg(byte[] coverImg) {
		this.coverImg = coverImg;
	}



	@Override
	public String toString() {
		return username;
	}

    
    
}
