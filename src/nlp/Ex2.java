/**
 *自然语言理解 实验二
 *宋词自动生成
 *要求：输入词牌，基于宋词的词典和宋词的词牌，可以随机或者按照语
 *	      言模型，自动生成宋词。设计相应的Ui或者Web界面。 
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
		
	//在语料库中搜素词牌名，并输出格式
	static char[] searchcipai(String cipai) throws IOException{
		String str = null;
		InputStream is = new FileInputStream("Ci.txt");
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		while(true){
			str=reader.readLine();
			if(str.equals(cipai)){
				str = reader.readLine();//跳过一行
				str = reader.readLine();//读取第二行
				//str = str.replaceAll("\\pP", " ");
				return str.toCharArray();				
			}			
		}		
	}
		
	static String getoneword()throws IOException{//从字典文件中直接读取出词
		//InputStream is = new FileInputStream("单字词词典.txt");
		//BufferedReader bf = new BufferedReader(new InputStreamReader(is));
		LineNumberReader reader = new LineNumberReader(new FileReader("单字词词典.txt"));
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
		LineNumberReader reader = new LineNumberReader(new FileReader("双字词词典.txt"));
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
		mf.setVisible(true);//窗口可视化
		mf.setResizable(false);//将窗口大小固定
		mf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);//退出程序后默认窗口关闭
				
		
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
		this.setTitle("自动生成宋词");//标题
		this.frame();//构建客户端界面
		begin.addActionListener(new beginListen());
		
	}
	
	void frame(){
		this.setSize(300, 450);
		setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		JPanel p1=new JPanel();//创建面板p1
		p1.setLayout(new FlowLayout());//水平布局		
		p1.add(new JLabel("输入词牌名："));//添加标签
		input=new JTextField("苏幕遮",8);//创建带初始值的文本框
		p1.add(input);
		begin=new JButton("开始");
		p1.add(begin);
		
		content=new JTextArea(18,30);//创建信息文本区
		content.setEditable(false);//不可编辑
		content.setFont(new Font("楷体",Font.PLAIN,18));
		JScrollPane sc=new JScrollPane(content);//越界可滚动的面板
		
		this.add(p1);
		this.add(sc);
	}
	
	class beginThread extends Thread{//线程类
		
		public void run(){
			String str;
			content.setText("");//清空
			try{
				str=input.getText();//读取输入文本框的信息
				char[] ch = Ex2.searchcipai(str);//搜索词牌，并输出相应的格式
				//填词
				for(int i=0;i<ch.length-1;i++){
					if(ch[i]=='，'||ch[i]=='。') continue;
					if(ch[i+1]=='，'||ch[i+1]=='。') ch[i]=Ex2.getoneword().charAt(0);
					else{
						ch[i]=Ex2.gettwoword().charAt(0);
						ch[i+1]=Ex2.gettwoword().charAt(1);
						i++;
					}
				}
				
				//输出
				String s="";
				for(int i=0;i<ch.length;i++){
					s=s+ch[i];
					if(ch[i]=='，'||ch[i]=='。'){
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
