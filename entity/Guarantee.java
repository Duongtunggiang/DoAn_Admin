package entity;

public class Guarantee {
	private int id;
	private String guarant;
	private int pid;
	public Guarantee(int id, String guarant, int pid) {
		super();
		this.id = id;
		this.guarant = guarant;
		this.pid = pid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGuarant() {
		return guarant;
	}
	public void setGuarant(String guarant) {
		this.guarant = guarant;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	@Override
	public String toString() {
		return "Guarantee [id=" + id + ", guarant=" + guarant + ", pid=" + pid + "]";
	}
	
	
}
