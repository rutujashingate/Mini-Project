package HotelManagementSystem;


import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class HotelManagementSystem extends JFrame implements ActionListener {
	
        HotelManagementSystem(){
		
		setBounds(100,150,1366,565); //First two args location and another 2 args size
		//setSize(400,400);
	
		//setLocation(300,300);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem/icons/first.jpg"));
		JLabel l1=new JLabel(i1);
		l1.setBounds(0, 0,1366, 565);
		add(l1);
		
		JLabel l2=new JLabel("Hotel Management System");
		l2.setBounds(20,420, 1000, 90);
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("serif",Font.PLAIN,65));
		l1.add(l2);
		
		JButton b1=new JButton("Next");
		b1.setBackground(Color.WHITE);
		b1.setForeground(Color.BLACK);
		b1.setBounds(1150, 450,150,30);
		b1.addActionListener(this);
		l1.add(b1);
		
		setLayout(null);
		setVisible(true);
		
		while(true) {
			l2.setVisible(false);
			try {
				Thread.sleep(500);
			}
			catch(Exception e) {
				
				
			}
			l2.setVisible(true);
			
			try
			{
				Thread.sleep(500);
			}catch(Exception e) {}
		
	
	}
        }
        
        public void actionPerformed(ActionEvent ae) {
        	new Login().setVisible(true);
        	//this.setVisible(false);
        }
	

	public static void main(String[] args) {
		new HotelManagementSystem();
	

	}

}
