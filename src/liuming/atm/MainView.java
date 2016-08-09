package liuming.atm;

import javax.swing.JOptionPane;

public class MainView {
	/**
	 * ������
	 * @author ��С�ӡ�����
	 * @param args
	 */
	public MainView(){
		//����һ��ATM�Ķ���,���ڵ���ATM���еķ���
		ATM atm = new ATM();
		//����һ��Login�Ķ������ڵ���Login���еķ���
		Login login = new Login();
		boolean log = login.load();
		
		if(log == false){
			JOptionPane.showMessageDialog(null, "�Ƿ��û���");
			System.exit(0);
		}
		
		do{
			try{
				String str = JOptionPane.showInputDialog(
						"1��ȡ��\n2�����\n3����ѯ\n4��ȡ��\n��ѡ��");
				if(str.matches("[1-4]")){
					int choose = Integer.parseInt(str);
					switch(choose){
					case 1:
						atm.getMoney();//����ATM���е�getMoney����
						break;
					case 2:
						atm.saveMoney();//����ATM���е�saveMoney����
						break;
					case 3:
						atm.find();//����ATM���е�find����
						break;
					case 4:
						JOptionPane.showMessageDialog(null, "��ӭʹ�ã��ټ���");
						System.exit(0);
						break;
//						default:
//							JOptionPane.showMessageDialog(null, "�������");
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "�������");
				}
				
			}catch(NumberFormatException Number){
				JOptionPane.showMessageDialog(null, "ϵͳ��æ�����Ժ�����...");
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
		}while(true);
	}
	
	public static void main(String[] args) {
		MainView atm = new MainView();
	}

}
