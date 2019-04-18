package thread;

public class Supplier extends Thread {
	public int Ham = 10;
	static int i = 1;
	int j = 1;

	public void run() { // Thread�� ����Ǹ� 3���ִٰ� make() ����
		while (true) {
			try {
				Thread.sleep(3000);
				make();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public synchronized void make() {
		Ham = Ham + 1;
		System.out.println(j + " ��° �ܹ��� ����");
		this.notify(); // ���� 0���̸� buy()�� ���ϹǷ�, consumer�� wait�� ���� �ٽ� ��������
		// ���� ���� �ְ� �ȵ��ð�� notifyall();
		j++;
	}

	public synchronized void buy() {
		Thread t = Thread.currentThread();
		//�������� thread�� ������� �˾ƺ��� ����
		while (Ham == 0) {
			System.out.println("�ܹ��� ���ȸ�");
			System.out.println("wait�� ������" + t.getName());
			try {
				wait();
				System.out.println("wait���� ��� ������ " + t.getName()); //�켱���� ������
				System.out.println("������ ���� " + t.getState());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Ham = Ham - 1;
		System.out.println(t.getName() + " " + i + " ��°�ܹ��� �ȸ�, " + " �����ܹ���" + Ham);
		i++;
	}
}
