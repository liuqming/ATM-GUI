package liuming.testatm;

import java.io.FileReader;
import java.util.Properties;
import javax.swing.JOptionPane;
/**
 * ��½
 * @author ��С�ӡ�����
 */
public class Login {
	//������Դ�������
	static Properties pro = new Properties();
	String str = "user.txt";
	//Login��Ĺ��췽��
	public Login(){
		try{
			//�����ļ�
			pro.load(new FileReader(str));
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, "�ļ������ڣ�");
		}
	}
	//��½����
	public static boolean load(){
		int i = 0;
		do{
			String name = JOptionPane.showInputDialog("�������û�����");
			String pwd = JOptionPane.showInputDialog("���������룺");
			try{
				if(name.matches("[a-zA-Z]{1,6}") && pwd.matches("[0-9]{1,8}")){
					if(name.equals(pro.getProperty("name")) && pwd.equals(pro.getProperty("pwd"))){
						JOptionPane.showMessageDialog(null, "��½�ɹ���");
						return true;
					}
					else{
						JOptionPane.showMessageDialog(null, "�û������������");
						i++;
					}
				}
				else{
					JOptionPane.showMessageDialog(null, "����Ƿ���");
					i++;
				}
			}catch(NullPointerException nullPoint){
				JOptionPane.showMessageDialog(null, "ллʹ�á�\n    �ټ���");
				System.exit(0);
			}
		}while(i<3);
		return false;
	}
}
