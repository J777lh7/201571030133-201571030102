package yn;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import yn.calculate;
public class Start extends JFrame{
	private JButton start=new JButton("开始测试");
	int lun=0;
	/*public static void main(String[] args) {
		Start st=new Start();
		

	}*/
	
	public Start()
	{
		add(start);
		setSize(300, 300);
		setLocationByPlatform(true);//可以自行设置窗口位置 
		 start.addActionListener(new ActionListener()
			{
		    	public  void actionPerformed(ActionEvent  event)
				{     	
		    		calculate st=new calculate();
		    		
		    		st.setVisible(true);
		    		lun++;			}
			 });
		TimerThread time=new TimerThread();
		time.setVisible(true);
		Thread thread=new Thread(time);
		thread.start(); 
	}
	

}
