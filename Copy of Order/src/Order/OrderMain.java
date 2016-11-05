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
		//��ü �ֹ������͸� ���������� ��� ���ؼ� Queue��ü�� �̿��Ͽ��� �̶�, Queue�� LinkedList�� �����ϸ� genericŸ���� OrderData�� �������־���.
		//Stack�� class�̸� Vector class�� ���, Queue�� interface�̸� Collection interface�� ���
		Queue<OrderData> que = new LinkedList<OrderData>();
		//orderdata.txt�� ��ü �ֹ��� ��� �ִµ� 
		//file�� ��� ���� �������·� �б� ���ؼ� FileReaderŬ������ �̿��Ͽ���
		//�����͸� �Ѳ����� �о ���ۿ� �����صδ� Ŭ���� BufferedReader�� �̿��Ͽ���.
		//BufferdReaderŬ������ read�޼ҵ尡 �����͸� ������ ũ�⸸ŭ ���Ͽ��� �����͸� �о ���ۿ� �����صε��� �������ִ� Ŭ����.
		//default(8192byte)�� ������ ������ ũ�⸸ŭ ���ۿ� �����͸� �����ϰ� 
		//���۸� �� ��� ������ file(���������ġ)�� �������� �ʰ� ���ۿ��� 16byte�� �����͸� ������ ����Ѵ�.
		BufferedReader br = null; 
		try{
			br = new BufferedReader(new FileReader("src/Order/orderdata.txt"));
			//�ؽ�Ʈ ���Ͽ� �ִ� �����͸� ��ȹ���ڸ� �������� ������ ����ϱ� ���ؼ� StringTokenizer�� �̿��Ѵ�.
			StringTokenizer stok = null; //��ȹ����':'
			StringTokenizer stok2 = null;//��ȹ����','
			String str = null;			//readLine�޼ҵ忡�� ������ ���� �����ϴ� ����
			String beverageId = null;	//���� �̸�
			int count = 0;				//�ֹ���
			//Queue�� �� �߰�
			while(true){
				//readLine�� ����� ��� �ؽ�Ʈ������ ������ ���پ� �о���δ�.
				//BufferedReader�� readLine�޼ҵ��̴�. FileReader���� InpuStreamReader���� ��ӹ��� read�޼ҵ常.
				str = br.readLine();
				if(str==null) break;
				//�� ���� �̻��� ���Ḧ �ֹ��� ���
				stok2 = new StringTokenizer(str,",");
				while(stok2.hasMoreTokens()){
					stok = new StringTokenizer(stok2.nextToken(),":");
					while(stok.hasMoreTokens()){
						beverageId = stok.nextToken();
						count = Integer.parseInt(stok.nextToken());
						//Queue�� generic���� ������ OrderData��ü �������� ���� �߰��Ѵ�.
						que.add(new OrderData(beverageId, count));
					}
				}
			}
			//Queue���� �� ������ divisor�޼ҵ� ����.
			while(true){
				//peek�޼ҵ�� ������ ���� �ٽ� ����ִ� �޼ҵ��̴�.
				divisor(que.peek().getBeverageId(), que.peek().getCount());
				//remove�޼ҵ带 �̿��ؼ� ����� �����͸� �����Ѵ�.poll�� ����
				//poll�޼ҵ���� �������� Queue��ü�� ����� �� exception�� ������ ���̴�.
				que.remove();
				//Queue��ü�� ������� ������ �������´�. peek�޼ҵ�� Queue��ü�� ������� null�� ��ȯ�Ѵ�.
				if(que.peek()==null) break;
			}
		}
		catch(FileNotFoundException fnfe){
		      System.out.println("���� ����");
		}
		catch(IOException ioe){
		      System.out.println("���� �������");
		}
		finally{
			try{
				br.close();
			}catch(Exception e){
				
			}
		}
		//���� �������� Java Virtual Machine�� �����Ѵ�.
		//System.exit(0);
	}
	//�����̸��� �ֹ����� �Է� �޾Ƽ�
	//�ֹ��� ���۰� ���� �˸��� �ֹ����� ���ῡ �°� �ٸ���Ÿ�鿡�� ���Ḧ �й��ϴ� ����� ����Ѵ�.
	public static void divisor(String beverageId, int count) throws InterruptedException{
		//Barista���� ������ ���������ð� Ư���� �°� Barista��ü�� �����Ͽ���
		//�й� �� �� �ٸ���Ÿ���� ���� �������ָ鼭 �ٸ���Ÿ�� �ο��� ���� �������� �־���.
		Barista baristaA = new Barista("baristaA",2,3,4,4);
		Barista baristaB = new Barista("baristaB",2,4,5,4);
		Barista baristaC = new Barista("baristaC",2,3,5,4);
		Barista baristaD = new Barista("baristaD",2,3,5,5);
		//divisor�޼ҵ带 �����ϸ鼭 �ֹ��� �������� ���.
		System.out.println("["+beverageId+"] "+count+"�� �ֹ�");
		//line�迭�� Barista��ü�� �־ �ֹ����� ���ῡ ���� Barista���� ������ ���ؼ� Ŀ�Ǹ� �����ϵ��� �Ͽ���.
		Barista line[] = {baristaA, baristaB, baristaC, baristaD};
		Barista tmp;
		int complete = 0;	//�Ϸ�� ���� ��
		//���������Ҵ� ��� 2222�� ����. ������ ����ΰ�?
		if(beverageId.equals("espresso")){
			//���������Ҹ� ���� �ð��ȿ� ���� ������ ��� ������� ���Եȴ�.
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
			//�Ƹ޸�ī�븦 ���� �ð��ȿ� ���� ������ ��� ������� ���Եȴ�.
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
			//�����ֽ��� ���� �ð��ȿ� ���� ������ ��� ������� ���Եȴ�.
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
			//ī��󶼸� ���� �ð��ȿ� ���� ������ ��� ������� ���Եȴ�.
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
		//���� �̸��� �Ϸ�� ������ ������ݴϴ�.
		System.out.println("["+beverageId+"]"+"\t"+complete+"�� ���Խ��ϴ�.");
		System.out.println();
	}
	//divisor�޼ҵ忡�� ���ῡ ���� ������ ���Ľ�Ų �ٸ���Ÿ���� ���������� Ŀ�Ǹ� �����ϵ��� �Ѵ�.
	//BaristaŬ������ �̿��ؼ� �� �ٸ���Ÿ���� �����ð��� �°� Ŀ�Ǹ� �����Ѵ�. �ð������� 1000millis. 1��.
	public static int making(Barista line , String beverageId) throws InterruptedException{
		Thread thread; 
		
		System.out.print(line.getBaristaId()+" ���� ");
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
