package yn;
import java.awt.event.*;
import java.awt.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
public class calculate extends JFrame
{
	public BinaryTree bTree; 
	public static final int DEFAULT_WIDTH = 1000;
	public static final int DEFAULT_HEIGHT = 1000;
	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	
	private JTextArea textArea1;
	private JTextField field;
	int cnt=0;
	int score=0;
	ArrayList<Integer> scores=new ArrayList<Integer>();
	public  calculate()
	{
		setTitle("得分情况");
		setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
		setLocationByPlatform(true);//可以自行设置窗口位置 
		label1 = new JLabel("显示如下:",JLabel.LEFT);
		label1.setFont(new Font("SansSerif", Font.BOLD + Font.ITALIC, 18));
		label1.setBounds(200, 50, 300,45);
		this.add(label1);
		
		label2 = new JLabel("输入你的答案：",JLabel.LEFT);
		label2.setFont(new Font("SansSerif", Font.BOLD + Font.ITALIC, 18));
		label2.setBounds(200, 600, 300,45);
		this.add(label2);
		
		label3 = new JLabel("",JLabel.LEFT);
		label3.setFont(new Font("SansSerif", Font.BOLD + Font.ITALIC, 18));
		label3.setBounds(200, 800, 300,45);
		this.add(label3);
		
		button1 = new JButton("出题");
		button1.setBounds(800, 200, 100,25);
		this.add(button1);
		button2 = new JButton("结果");
		button2.setBounds(800, 400, 100,25);
		this.add(button2);
		button3 = new JButton("总结");
		button3.setBounds(800, 600, 100,25);
		this.add(button3);
		
		textArea1 = new JTextArea();
	    textArea1.setColumns(21);
	    textArea1.setRows(21);
	    textArea1.setBounds(200, 100, 400,400);
	    this.add(textArea1);
	    
	    field = new JTextField();
        field.setColumns(20);
        field.setBounds(400, 600, 300, 45);
        this.add(field);
        
	    JPanel pan = new JPanel();
	    add(pan);
	    
	    button1.addActionListener(new ActionListener()
		{
	    	public  void actionPerformed(ActionEvent  event)
			{     	
	    		if(cnt<20)
	    		{
	    			question();
		    		cnt++;
	    		}
	    		else{
	    			button1.setText("再来一次");
	    			Start st=new Start();
	    			st.setVisible(true);
	    		}
	    		
	    		  		
			}
		 });
	    
	    button2.addActionListener(new ActionListener()
	    {
	    	public  void actionPerformed(ActionEvent  event)
	    	{
	    		int c=0;
	    		String n1 = field.getText();
	    		 field.setText(null);
	    		 String result = bTree.CalAndVal();
	    		 textArea1.append(n1);
	    		 
	    		if(n1.equals(result))
	 	            {
	 	            	textArea1.append("  答案正确\n");      	
	 	            	score=score+5;	 
	 	            }
	 	            else{
	 	            	textArea1.append("  答案错误,正确答案为："+result+"\n");
	 	            }
			}
	    });	

	    button3.addActionListener(new ActionListener()
	    {
	    	public  void actionPerformed(ActionEvent  event)
	    	{
	    		scores.add(score);
	    		//for(int i=0;i<scores.size();i++)	    		
 	    		label3.setText("你的成绩为："+scores + "分");
	    		Chart window=new Chart(scores);
	    		window.setVisible(true);
	    		
	    	}
	    });	
	    
	   
	}
	
	public void question()
	{
		
		bTree = new BinaryTree(2);  
		bTree.createBTree();  
	    textArea1.append(bTree.toString() + "=" );
	}
	
}