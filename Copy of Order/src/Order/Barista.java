package Order;

public class Barista {
	//�ٸ���Ÿ�� Ư���� �����ϱ� ���� Ŭ����
	private String baristaId;	//�ٸ���Ÿ �̸�
	private int time1;//����������		//���� �ð�
	private int time2;//�Ƹ޸�ī��
	private int time3;//�����ֽ�
	private int time4;//ī���

	public Barista() {
		// TODO Auto-generated constructor stub
	}

	public Barista(String baristaId, int time1, int time2, int time3, int time4) {
		this.baristaId = baristaId;
		this.time1 = time1;
		this.time2 = time2;
		this.time3 = time3;
		this.time4 = time4;
	}

	public String getBaristaId() {
		return baristaId;
	}

	public void setBaristaId(String baristaId) {
		this.baristaId = baristaId;
	}

	public int getTime1() {
		return time1;
	}

	public void setTime1(int time1) {
		this.time1 = time1;
	}

	public int getTime2() {
		return time2;
	}

	public void setTime2(int time2) {
		this.time2 = time2;
	}

	public int getTime3() {
		return time3;
	}

	public void setTime3(int time3) {
		this.time3 = time3;
	}

	public int getTime4() {
		return time4;
	}

	public void setTime4(int time4) {
		this.time4 = time4;
	}

}
