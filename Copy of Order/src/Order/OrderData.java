package Order;

public class OrderData {
	//주문으로 들어온 음료와 양을 저장하기 위한 클래스입니다. 
	private String beverageId;	//음료 이름
	private int count;			//주문량
	
	public OrderData() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderData(String beverageId, int count) {
		this.beverageId = beverageId;
		this.count = count;
	}
	public String getBeverageId() {
		return beverageId;
	}
	public void setBeverageId(String beverageId) {
		this.beverageId = beverageId;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

}
