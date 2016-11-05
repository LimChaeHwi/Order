package Order;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class OrderMain {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		//전체 주문데이터를 순차적으로 담기 위해서 Queue객체를 이용하였고 이때, Queue는 LinkedList로 생성하며 generic타입은 OrderData로 지정해주었다.
		//Stack은 class이며 Vector class를 상속, Queue는 interface이며 Collection interface를 상속
		Queue<OrderData> que = new LinkedList<OrderData>();
		//orderdata.txt에 전체 주문이 담겨 있는데 
		//file에 담긴 값을 문자형태로 읽기 위해서 FileReader클래스를 이용하였고
		//데이터를 한꺼번에 읽어서 버퍼에 저장해두는 클래스 BufferedReader를 이용하였다.
		//BufferdReader클래스는 read메소드가 데이터를 버퍼의 크기만큼 파일에서 데이터를 읽어서 버퍼에 저장해두도록 설정해주는 클래스.
		//default(8192byte)나 지정된 버퍼의 크기만큼 버퍼에 데이터를 저장하고 
		//버퍼를 다 비울 때까지 file(보조기억장치)에 접근하지 않고 버퍼에서 16byte씩 데이터를 가져가 사용한다.
		BufferedReader br = null; 
		try{
			br = new BufferedReader(new FileReader("src/Order/orderdata.txt"));
			//텍스트 파일에 있는 데이터를 구획문자를 기준으로 나눠서 사용하기 위해서 StringTokenizer를 이용한다.
			StringTokenizer stok = null; //구획문자':'
			StringTokenizer stok2 = null;//구획문자','
			String str = null;			//readLine메소드에서 리턴한 값을 저장하는 변수
			String beverageId = null;	//음료 이름
			int count = 0;				//주문량
			//Queue에 값 추가
			while(true){
				//readLine을 사용할 경우 텍스트파일의 내용을 한줄씩 읽어들인다.
				//BufferedReader의 readLine메소드이다. FileReader에는 InpuStreamReader에게 상속받은 read메소드만.
				str = br.readLine();
				if(str==null) break;
				//두 종류 이상의 음료를 주문한 경우
				stok2 = new StringTokenizer(str,",");
				while(stok2.hasMoreTokens()){
					stok = new StringTokenizer(stok2.nextToken(),":");
					while(stok.hasMoreTokens()){
						beverageId = stok.nextToken();
						count = Integer.parseInt(stok.nextToken());
						//Queue에 generic으로 지정한 OrderData객체 형식으로 값을 추가한다.
						que.add(new OrderData(beverageId, count));
					}
				}
			}
			//Queue에서 값 꺼내서 divisor메소드 전달.
			while(true){
				//peek메소드는 꺼내서 보고 다시 집어넣는 메소드이다.
				divisor(que.peek().getBeverageId(), que.peek().getCount());
				//remove메소드를 이용해서 사용한 데이터를 삭제한다.poll과 같다
				//poll메소드와의 차이점은 Queue객체가 비었을 때 exception을 던지는 것이다.
				que.remove();
				//Queue객체가 비었으면 루프를 빠져나온다. peek메소드는 Queue객체가 비었으면 null을 반환한다.
				if(que.peek()==null) break;
			}
		}
		catch(FileNotFoundException fnfe){
		      System.out.println("파일 없음");
		}
		catch(IOException ioe){
		      System.out.println("파일 내용없음");
		}
		finally{
			try{
				br.close();
			}catch(Exception e){
				
			}
		}
		//현재 실행중인 Java Virtual Machine을 종료한다.
		//System.exit(0);
	}
	//음료이름과 주문량을 입력 받아서
	//주문의 시작과 끝을 알리고 주문들어온 음료에 맞게 바리스타들에게 음료를 분배하는 기능을 담당한다.
	public static void divisor(String beverageId, int count) throws InterruptedException{
		//Barista들의 각각의 음료제조시간 특성에 맞게 Barista객체를 생성하였고
		//분배 할 때 바리스타들을 직접 생성해주면서 바리스타의 인원에 대한 유연성을 주었다.
		Barista baristaA = new Barista("baristaA",2,3,4,4);
		Barista baristaB = new Barista("baristaB",2,4,5,4);
		Barista baristaC = new Barista("baristaC",2,3,5,4);
		Barista baristaD = new Barista("baristaD",2,3,5,5);
		//divisor메소드를 생성하면서 주문이 들어왔음을 출력.
		System.out.println("["+beverageId+"] "+count+"잔 주문");
		//line배열에 Barista객체를 넣어서 주문받은 음료에 따라 Barista들의 순서를 정해서 커피를 제조하도록 하였다.
		Barista line[] = {baristaA, baristaB, baristaC, baristaD};
		Barista tmp;
		int complete = 0;	//완료된 음료 수
		//에스프레소는 모두 2222로 같다. 괜찮은 방법인가?
		if(beverageId.equals("espresso")){
			//에스프레소를 빠른 시간안에 제조 가능한 사람 순서대로 투입된다.
			for (int i = 0; i < line.length; i++) {
				for (int j = 0; j < line.length; j++) {
					if(line[i].getTime1()<line[j].getTime1()){
						tmp = line[i];
						line[i] = line[j];
						line[j] = tmp;
					}
				}
			}
		}
		else if(beverageId.equals("americano")){
			//아메리카노를 빠른 시간안에 제조 가능한 사람 순서대로 투입된다.
			for (int i = 0; i < line.length; i++) {
				for (int j = 0; j < line.length; j++) {
					if(line[i].getTime2()<line[j].getTime2()){
						tmp = line[i];
						line[i] = line[j];
						line[j] = tmp;
					}
				}
			}
		}
		else if(beverageId.equals("fruitbeverage")){
			//과일주스를 빠른 시간안에 제조 가능한 사람 순서대로 투입된다.
			for (int i = 0; i < line.length; i++) {
				for (int j = 0; j < line.length; j++) {
					if(line[i].getTime3()<line[j].getTime3()){
						tmp = line[i];
						line[i] = line[j];
						line[j] = tmp;
					}
				}
			}
		}
		else if(beverageId.equals("caffelatte")){
			//카페라떼를 빠른 시간안에 제조 가능한 사람 순서대로 투입된다.
			for (int i = 0; i < line.length; i++) {
				for (int j = 0; j < line.length; j++) {
					if(line[i].getTime4()<line[j].getTime4()){
						tmp = line[i];
						line[i] = line[j];
						line[j] = tmp;
					}
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < count; i++) {
			if(i==4) i=0;
			if(cnt==count)break;
			complete += making(line[i], beverageId);
			cnt++;
		}
		//음료 이름과 완료된 수량을 출력해줍니다.
		System.out.println("["+beverageId+"]"+"\t"+complete+"잔 나왔습니다.");
		System.out.println();
	}
	//divisor메소드에서 음료에 따라 순서를 정렬시킨 바리스타들을 순차적으로 커피를 제조하도록 한다.
	//Barista클래스를 이용해서 각 바리스타마다 제조시간에 맞게 커피를 제조한다. 시간단위는 1000millis. 1초.
	public static int making(Barista line , String beverageId) throws InterruptedException{
		Thread thread; 
		
		System.out.print(line.getBaristaId()+" 제조 ");
		if(beverageId.equals("espresso")){
			thread = new OrderThread(line.getTime1());
			thread.start();
			thread.join();
		}else if(beverageId.equals("americano")){
			thread = new OrderThread(line.getTime2());
			thread.start();
			thread.join();
		}else if(beverageId.equals("fruitbeverage")){
			thread = new OrderThread(line.getTime3());
			thread.start();
			thread.join();
		}else if(beverageId.equals("caffelatte")){
			thread = new OrderThread(line.getTime4());
			thread.start();
			thread.join();
		}
		System.out.println();
		return 1;
	}
}
