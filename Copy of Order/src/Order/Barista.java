package Order;

public class Barista {
	//바리스타의 특성을 저장하기 위한 클래스
	private String baristaId;	//바리스타 이름
	private int time1;//에스프레소		//제조 시간
	private int time2;//아메리카노
	private int time3;//과일주스
	private int time4;//카페라떼

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
