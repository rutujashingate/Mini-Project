package HotelManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

public class UpdateCheck extends JFrame implements ActionListener {
	
	
	JTextField t1,t2,t3,t4,t5,t6;
	Choice c1;
	JButton b1,b2,b3;
	
	 UpdateCheck() {
		 
		 JLabel l1= new JLabel("Check In Details");
		 l1.setFont(new Font("Tahoma",Font.PLAIN,20));
		 l1.setBounds(90, 20, 200, 30);
		 add(l1);
		 
		 //customer id
		 JLabel l2= new JLabel("Customer Id");
		 l2.setBounds(30, 80, 100, 20);
		 add(l2);
		 
		 c1=new Choice();
		 try {
			 conn c=new conn();
			 ResultSet rs=c.s.executeQuery("select * from customer");
			 while(rs.next()) {
				 c1.add(rs.getString("numb"));
			 }
			 
			 
		 }catch(Exception e) {}
		 c1.setBounds(200, 80, 150, 25);
		 add(c1);
		 
		 //room no
		 JLabel l3= new JLabel("Room Number");
		 l3.setBounds(30, 120, 100, 20);
		 add(l3);
		 
		 t1=new JTextField();
		 t1.setBounds(200, 120, 150, 25);
		 add(t1);
		 
		 //name
		 JLabel l4= new JLabel("Name");
		 l4.setBounds(30, 160, 100, 20);
		 add(l4);
		 
		 t2=new JTextField();
		 t2.setBounds(200, 160, 150, 25);
		 add(t2);
		 
		 //checked in
		 JLabel l5= new JLabel("Checked In");
		 l5.setBounds(30, 200, 100, 20);
		 add(l5);
		 
		 t3=new JTextField();
		 t3.setBounds(200, 200, 150, 25);
		 add(t3);
		 
		 //amount paid
		 JLabel l6= new JLabel("Amount Paid");
		 l6.setBounds(30, 240, 100, 20);
		 add(l6);
		 
		 t4=new JTextField();
		 t4.setBounds(200, 240, 150, 25);
		 add(t4);
		 
		 //Pending amount
		 JLabel l7= new JLabel("Pending Amount");
		 l7.setBounds(30, 280, 100, 20);
		 add(l7);
		 
		 t5=new JTextField();
		 t5.setBounds(200, 280, 150, 25);
		 add(t5);
		 
		   b1=new JButton("Check");
			b1.setBackground(Color.BLACK);
			b1.setForeground(Color.WHITE);
			b1.setBounds(30, 340, 100, 30);
			b1.addActionListener(this);
			add(b1);
			
			b2=new JButton("Update");
			b2.setBackground(Color.BLACK);
			b2.setForeground(Color.WHITE);
			b2.setBounds(150, 340, 100, 30);
			b2.addActionListener(this);
			add(b2);
			
			b3=new JButton("Back");
			b3.setBackground(Color.BLACK);
			b3.setForeground(Color.WHITE);
			b3.setBounds(270, 340, 100, 30);
			b3.addActionListener(this);
			add(b3);
			
			ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/nine.jpg"));
	      
	      
	        JLabel l = new JLabel(i1);
	        l.setBounds(400,50,500,300);
	        add(l);
		 
		 getContentPane().setBackground(Color.WHITE);
		 setLayout(null);
		 setBounds(350,200,980,500);
		 setVisible(true);
		 
		
	}
	 
	 
	 
	 @Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			String r1=null;
			String depo=null;
			int amtpaid;
			String price=null;
			try {
				conn c=new conn();
				String id=c1.getSelectedItem();
				String str="select * from customer where numb='"+id+"'";
				ResultSet rs=c.s.executeQuery(str);
				while(rs.next()) {
					t1.setText(rs.getString("room"));
					t2.setText(rs.getString("name"));
					t3.setText(rs.getString("status"));
				    t4.setText(rs.getString("deposit"));
				    r1=rs.getString("room");
				    depo=rs.getString("deposit");
				    
					
				}
				
				ResultSet rst=c.s.executeQuery("select * from room where room_number='"+r1+"'");
				while(rst.next()) {
					price=rst.getString("price");
					amtpaid = Integer.parseInt(price)- Integer.parseInt(depo);
					t5.setText(Integer.toString(amtpaid));
				}
				
				
			}catch(Exception e1) {}
			
			
		}else if(e.getSource()==b2) {
			
		}else if(e.getSource()==b3) {
			
			new Reception().setVisible(true);
			this.setVisible(false);
			
		}
		
	}



	public static void main(String[] args) {
		new UpdateCheck().setVisible(true);
	}

}
