package Order;

public class OrderData {
	//�ֹ����� ���� ����� ���� �����ϱ� ���� Ŭ�����Դϴ�. 
	private String beverageId;	//���� �̸�
	private int count;			//�ֹ���
	
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
