package liuming.atm;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 * ������
 * @author ��С�ӡ�����
 */
public class ATM {
	//������Դ�ļ�����
	Properties pro = new Properties();
	
	public ATM(){
		try{
			//������Դ�ļ�
			pro.load(new FileReader("bank.txt"));
		}catch(Exception e){
			System.out.println("���ļ������ڣ�");
		}
	}
	
	/**��ѯ*/
	public void find(){
		//ͨ������money�������Ӧ��ֵ
		String money = pro.getProperty("money");
		JOptionPane.showMessageDialog(null, "������Ϊ��"+money);
	}
	
	/**ȡ��*/
	public void getMoney(){
		String tempTake = JOptionPane.showInputDialog("������ȡ����:");
		int take = Integer.parseInt(tempTake);
		
		int money = Integer.parseInt(pro.getProperty("money"));
		
		if(tempTake.matches("1[\\d]00|[1-9]00|2000")){
			money -= take;
			JOptionPane.showMessageDialog(null, "������Ϊ��"+money);
			String tempMoney = String.valueOf(money);
			//���ü���money����ֵ
			pro.setProperty("money", tempMoney);
			try{
				//д���ļ�
				pro.store(new FileWriter("bank.txt"), null);
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "�ļ������ڣ�");
			}
		}
		else if(tempTake.matches("[-][0-9]{0,}")){
			JOptionPane.showMessageDialog(null, "ȡ�����������0��");
		}
		else if(tempTake.matches("[0-9]{0,}")){
			JOptionPane.showMessageDialog(null, "������100����������");
		}
		else if(take > money){
			JOptionPane.showMessageDialog(null, "ȡ����������н�");
		}
		else {
			JOptionPane.showMessageDialog(null, "�����루0-9��֮�������");
		}
	}
	
	/**���*/
	public void saveMoney(){
		String tempSave = JOptionPane.showInputDialog("���������");
		int money = Integer.parseInt(pro.getProperty("money"));
		
		if(tempSave.matches("1[\\d]00|[1-9]00")){
			int save = Integer.parseInt(tempSave);
			money += save;
			JOptionPane.showMessageDialog(null, "������Ϊ��"+money);
			String tempMoney = String.valueOf(money);
			//���ü���money����ֵ
			pro.setProperty("money", tempMoney);
			try{
				//д���ļ�
				pro.store(new FileWriter("bank.txt"), null);
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "�ļ������ڣ�");
			}
		}
		else if(tempSave.matches("[-][0-9]{0,}")){
			JOptionPane.showMessageDialog(null, "ȡ�����������0��");
		}
		else if(tempSave.matches("[0-9]{0,}")){
			JOptionPane.showMessageDialog(null, "������100����������");
		}
		else {
			JOptionPane.showMessageDialog(null, "�����루0-9��֮�������");
		}
	}
}
