package liuming.atm;

import java.io.FileReader;
import java.util.Properties;
import javax.swing.JOptionPane;
/**
 * ��½��
 * @author ��С�ӡ�����
 *
 */
public class Login {
	//������Դ�ļ�����
	Properties pro = new Properties();
	//Login��Ĺ��췽��
	public Login(){
		try{
			//�����ļ�
			pro.load(new FileReader("user.txt"));
		}catch(Exception e){
			System.out.println("���ļ������ڣ�");
		}
	}
	//��½
	public boolean load(){
		for(int i = 0; i < 3 ; i++){
			String name = JOptionPane.showInputDialog("�������û�����");
			String pwd = JOptionPane.showInputDialog("���������룺");
			try{
				if(name.matches("[a-zA-Z]{1,6}") && pwd.matches("[0-9]{1,8}")){
					if(name.equals(pro.getProperty("name")) && pwd.equals(pro.getProperty("pwd"))){
						JOptionPane.showMessageDialog(null, "��½�ɹ���");
						return true;
					}
					else{
						JOptionPane.showMessageDialog(null, "�û����������");
					}
				}
				else{
					System.out.println("�������");
				}
			}catch(NullPointerException Number){
				JOptionPane.showMessageDialog(null,"��ӭʹ�ã��ټ���");
				System.exit(0);
			}

		}
		return false;
	}
	
}
