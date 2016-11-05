package Order;

public class OrderThread extends Thread{
	private int time; //제조 시간
	
	public OrderThread() {
		// TODO Auto-generated constructor stub
	}
	
	public OrderThread(int time) {
		this.time = time;
	}

	public void run(){
		try {
			for (int i = 0; i < time; i++) {
				sleep(1000);
				System.out.print("·");
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
