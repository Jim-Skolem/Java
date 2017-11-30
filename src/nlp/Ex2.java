/**
 *��Ȼ������� ʵ���
 *�δ��Զ�����
 *Ҫ��������ƣ������δʵĴʵ���δʵĴ��ƣ�����������߰�����
 *	      ��ģ�ͣ��Զ������δʡ������Ӧ��Ui����Web���档 
 */
package nlp;

import java.util.*;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;

public class Ex2 {
		
	//�����Ͽ������ش��������������ʽ
	static char[] searchcipai(String cipai) throws IOException{
		String str = null;
		InputStream is = new FileInputStream("Ci.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		while(true){
			str=reader.readLine();
			if(str.equals(cipai)){
				str = reader.readLine();//����һ��
				str = reader.readLine();//��ȡ�ڶ���
				//str = str.replaceAll("\\pP", " ");
				return str.toCharArray();				
			}			
		}		
	}
		
	static String getoneword()throws IOException{//���ֵ��ļ���ֱ�Ӷ�ȡ����
		//InputStream is = new FileInputStream("���ִʴʵ�.txt");
		//BufferedReader bf = new BufferedReader(new InputStreamReader(is));
		LineNumberReader reader = new LineNumberReader(new FileReader("���ִʴʵ�.txt"));
		String str = null;
		int rn = ThreadLocalRandom.current().nextInt(300);
		int i=0;
		while(i<rn){
			str=reader.readLine();
			i++;
		}
		
		char[] temp = str.toCharArray();
		return Character.toString(temp[0]);
				
	}
	
	static String gettwoword() throws IOException{
		LineNumberReader reader = new LineNumberReader(new FileReader("˫�ִʴʵ�.txt"));
		String str = null;
		int rn = ThreadLocalRandom.current().nextInt(300);
		int i=0;
		while(i<rn){
			str=reader.readLine();
			i++;
		}
		
		char[] temp = str.toCharArray();
		return ""+temp[0]+temp[1];
	}
	
	public static void main(String[] args){	
		
		
		MyFrame mf = new MyFrame();
		mf.setVisible(true);//���ڿ��ӻ�
		mf.setResizable(false);//�����ڴ�С�̶�
		mf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//�˳������Ĭ�ϴ��ڹر�
				
		
	}
	
}

class MyFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4422056525420762385L;
	JTextField input;
	JButton begin;
	JTextArea content;
	
	MyFrame(){
		this.setTitle("�Զ������δ�");//����
		this.frame();//�����ͻ��˽���
		begin.addActionListener(new beginListen());
		
	}
	
	void frame(){
		this.setSize(300, 450);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel p1=new JPanel();//�������p1
		p1.setLayout(new FlowLayout());//ˮƽ����		
		p1.add(new JLabel("�����������"));//��ӱ�ǩ
		input=new JTextField("��Ļ��",8);//��������ʼֵ���ı���
		p1.add(input);
		begin=new JButton("��ʼ");
		p1.add(begin);
		
		content=new JTextArea(18,30);//������Ϣ�ı���
		content.setEditable(false);//���ɱ༭
		content.setFont(new Font("����",Font.PLAIN,18));
		JScrollPane sc=new JScrollPane(content);//Խ��ɹ��������
		
		this.add(p1);
		this.add(sc);
	}
	
	class beginThread extends Thread{//�߳���
		
		public void run(){
			String str;
			content.setText("");//���
			try{
				str=input.getText();//��ȡ�����ı������Ϣ
				char[] ch = Ex2.searchcipai(str);//�������ƣ��������Ӧ�ĸ�ʽ
				//���
				for(int i=0;i<ch.length-1;i++){
					if(ch[i]=='��'||ch[i]=='��') continue;
					if(ch[i+1]=='��'||ch[i+1]=='��') ch[i]=Ex2.getoneword().charAt(0);
					else{
						ch[i]=Ex2.gettwoword().charAt(0);
						ch[i+1]=Ex2.gettwoword().charAt(1);
						i++;
					}
				}
				
				//���
				String s="";
				for(int i=0;i<ch.length;i++){
					s=s+ch[i];
					if(ch[i]=='��'||ch[i]=='��'){
						content.append(s+"\n");
						s="";
					}
				}
				//String out = String.valueOf(ch);
				//content.append(out);
				//System.out.print(ch);							
			}catch (Exception ex) { }
		}
	}
	
	class beginListen  implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			beginThread bt=new beginThread();
			bt.start();
			
		}
		
	}
}
