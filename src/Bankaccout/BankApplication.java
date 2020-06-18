package Bankaccout;

import java.util.Scanner;

public class BankApplication {

	private static Account[] accountArray = new Account[100];
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		boolean run = true;
		while (run) {
			System.out.println("1.���»��� | 2.���¸�� | 3.�Ա� | 4.��� | 5.����");
			System.out.print("����> ");
			
			int select = scanner.nextInt();
			
			if (select ==1) {
				createAccount();
			} else if (select ==2) {
				accountList();
			} else if (select ==3) {
				deposit();
			} else if (select ==4) {
				withdraw();
			} else if (select ==5) {
				run = false;
			}
		}
		System.out.println("���α׷� ����");
	}
	//���»��� 
	private static void createAccount() {
		System.out.println("���»���");
		System.out.print("���¹�ȣ : ");
		String ano = scanner.next();
		
		System.out.print("������ : ");
		String owner = scanner.next();
		
		System.out.print("�ʱ��Աݾ�: ");
		int money = scanner.nextInt();

		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				accountArray[i] = new Account(ano, owner, money);
				System.out.println("���: ���°� �����Ǿ����ϴ�.");
				break;
			}
		}
	}
	//���¸�Ϻ���    
	private static void accountList() {
		System.out.println("���¸��");
		for(int i=0; i<accountArray.length; i++) {
			if(accountArray[i] == null) {
				break;
			}
			System.out.println(
			accountArray[i].getAno() + "\t" + accountArray[i].getOwner() + "\t" + accountArray[i].getBalance());
		}
	}
	//find�̿��ؼ� �迭���� ano ã�� �ڵ�
	private static Account findAccount(String ano) {
		for (int i = 0; i < accountArray.length; i++) {
			if (accountArray[i] == null) {
				break;
			}
			if (accountArray[i].getAno().equals(ano)) {
				return accountArray[i];
			}
		}
		return null;
	}
		
	//�Ա��ϱ�, find�̿��ؼ� ���¹�ȣ ã��
	private static void deposit() {
		System.out.print("�Ա�");
		System.out.print("���¹�ȣ: ");
		String ano = scanner.next();
		System.out.print("�Աݾ�: ");
		int number = scanner.nextInt();

		if (findAccount(ano) == null) {
			System.out.println("�Է��� ���¹�ȣ�� ã�� ���߽��ϴ�.");
		} else {
			findAccount(ano).setBalance(findAccount(ano).getBalance() + number);
			System.out.println("���: �Ա��� �����Ǿ����ϴ�.");
		}
		
	}
	//����ϱ�, find�̿��ؼ� ���¹�ȣ ã��
	private static void withdraw() {
		System.out.println("���");
		System.out.print("���¹�ȣ: ");
		String ano = scanner.next();
		System.out.print("��ݾ�: ");
		int withd = scanner.nextInt();

		if (findAccount(ano) == null) {
			System.out.println("�Է��� ���¹�ȣ�� ã�� ���߽��ϴ�.");
		} else {
			if (withd > findAccount(ano).getBalance()) {
				System.out.println("�ܾ׺��� ū �׼��� �Է��ϼ̽��ϴ�.");
			} else {
				findAccount(ano).setBalance(findAccount(ano).getBalance() - withd);
				System.out.println("���: ����� �����Ǿ����ϴ�.");
			}
		}
	
	}

	
	
	}
	


	
	
	
		