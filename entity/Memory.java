package entity;

public class Memory {
	private int id;
	private int productId;
	private String memory;
	public Memory(int id, int productId, String memory) {
		super();
		this.id = id;
		this.productId = productId;
		this.memory = memory;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	@Override
	public String toString() {
		return "memories [id=" + id + ", productId=" + productId + ", memory=" + memory + "]";
	}
	
	
}
