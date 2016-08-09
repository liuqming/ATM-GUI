package liuming.testatm;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;
import javax.swing.JOptionPane;
/**
 * ������
 * @author ��С�ӡ�����
 */
public class ATM {
	//������Դ�������
	Properties pro = new Properties();
	Properties prop = new Properties();
	//ATM�Ĺ��췽��
	public ATM(){
		try{
			//�����ļ�
			pro.load(new FileReader("bank.txt"));
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "�ļ�δ�ҵ���");
		}
	}
	
	/**
	 * ��ѯ
	 */
	public void find(){
		JOptionPane.showMessageDialog(null, "������Ϊ��" + pro.getProperty("money"));
	}
	
	/**
	 * ȡ��
	 */
	public void getMoney(){
		String tempTake = JOptionPane.showInputDialog("������ȡ���");
		int take = Integer.parseInt(tempTake);
		int money = Integer.parseInt(pro.getProperty("money"));
		if(take > money){
			JOptionPane.showMessageDialog(null, "ȡ����������н�");
		}
		else if(tempTake.matches("1[0-9]00|[1-9]00|2000")){
			//int take = Integer.parseInt(tempTake);
			//int money = Integer.parseInt(pro.getProperty("money"));
			money -= take;
			JOptionPane.showMessageDialog(null, "������Ϊ��"+money+"");
			new SetCalendar();
			String temp = String.valueOf(money);
			pro.setProperty("money", temp);
			try{
				pro.store(new FileWriter("bank.txt"), null);
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "�ļ������ڣ�");
			}
		}
		else if(tempTake.matches("[-][0-9]{0,}")){
			JOptionPane.showMessageDialog(null, "ȡ����������0��");
		}
		else if(tempTake.matches("[0-9]{0,}")){
			JOptionPane.showMessageDialog(null, "������100����������");
		}
		else{
			JOptionPane.showMessageDialog(null, "xxxxxxxx��");
		}
	}
	
	/**
	 * ���
	 */
	public void saveMoney(){
		String tempSave = JOptionPane.showInputDialog("������ȡ���");
		if(tempSave.matches("(1[0-9]{0,}00|[1-9]00)")){
			int save = Integer.parseInt(tempSave);
			int money = Integer.parseInt(pro.getProperty("money"));
			money += save;
			JOptionPane.showMessageDialog(null, "������Ϊ��"+money+"");
			new SetCalendar();
			String temp = String.valueOf(money);
			pro.setProperty("money", temp);
			try{
				pro.store(new FileWriter("bank.txt"), null);
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "�ļ������ڣ�");
			}
		}
		else if(tempSave.matches("[-][0-9]{0,}")){
			JOptionPane.showMessageDialog(null, "������������");
		}
		else if(tempSave.matches("[0-9]{0,}")){
			JOptionPane.showMessageDialog(null, "������100����������");
		}
		else{
			JOptionPane.showMessageDialog(null, "xxxxxxxx��");
		}
	}
	
	/**
	 * ������
	 */
	public void alterPwd(){
		try{
			prop.load(new FileReader("user.txt"));
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "�ļ�δ�ҵ���");
		}
		String tempPwd = JOptionPane.showInputDialog("�����������룺");
		if(tempPwd.matches("[0-9]{1,8}")){
			prop.setProperty("pwd", tempPwd);
			new SetCalendar();
			try{
				prop.store(new FileWriter("user.txt"), null);
			}catch(Exception e){
				JOptionPane.showMessageDialog(null, "�ļ������ڣ�");
			}
		}
	}
}
