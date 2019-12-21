import java.util.Scanner;

public class Classifier {

	private int number, userNumber;
	private Scanner sc;
	Classifier(){
		setNumber();	/* �������� ���� */
		sc = new Scanner(System.in);	
	}
	
	void setNumber() {
		this.number = ((int)(Math.random()*9)+1)*100
				+((int)(Math.random()*9)+1)*10
				+((int)(Math.random()*9)+1);
	}
	
	void setUserNumber(int userNumber) {
		this.userNumber = userNumber;		
	}
	
	boolean judge() { 
		int i=0,j=0,n,un; //i�� ��Ʈ����ũ, j�� ��
		String stringNumber = number+"";
		
		//ù��° �ڸ�
		n = number/100;
		un = userNumber/100;
		if(stringNumber.contains(un+""))
			j++;
		if(n==un) {
			j--;
			i++;
		}
		//�ι�°�ڸ�
		n = (number%100)/10;
		un = (userNumber%100)/10;
		if(stringNumber.contains(un+""))
			j++;
		if(n==un) {
			j--;
			i++;
		}
		//��°�ڸ�
		n = number%10;
		un = userNumber%10;
		if(stringNumber.contains(un+""))
			j++;
		if(n==un) {
			j--;
			i++;
		}
		
		if(i>0)
			System.out.print(i+"��Ʈ����ũ ");
		if(j>0)
			System.out.print(j+"��");
		if(number==userNumber) {
			System.out.println("\n3���� ���ڸ� ��� �����̽��ϴ�! ��������");
			return true;
		}
		return false;
	}
	void newGame() {
		System.out.println("������ ���� �����Ϸ��� 1, "
				+ "�����Ϸ��� 2�� �Է��ϼ���");
	}
	void game() {
		while(true) {
			System.out.print("\n���ڸ� �Է��� �ּ��� :");
			setUserNumber(sc.nextInt());	/* ����� �Է¹ޱ�  */
			if(judge()) {
				break;
			}
		}
	}
	
	void board() {
		while(true) {
			game();
			System.out.println("������ ���� �����Ϸ��� 1,"
					+ " �����Ϸ��� 2�� �Է��ϼ��� .");
			if(sc.nextInt()==2) {
				break;
			}
		}
	}
	
}
