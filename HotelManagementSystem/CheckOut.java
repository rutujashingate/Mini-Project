package HotelManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

import javax.swing.*;

public class CheckOut extends JFrame implements ActionListener {
	
	Choice c1;
	JTextField t1;
	JButton b1,b2,b3;
	
	CheckOut(){
		
		JLabel l1=new JLabel("Check Out");
		l1.setBounds(100, 20, 150, 30);
		l1.setForeground(Color.DARK_GRAY);
		l1.setFont(new Font("Tahoma",Font.PLAIN,20));
		add(l1);
		
		
		JLabel l2=new JLabel("Customer Id");
		l2.setBounds(30, 80, 100, 30);
		add(l2);
		
		c1=new Choice();
		 try {
			 conn c=new conn();
			 ResultSet rs=c.s.executeQuery("select * from customer");
			 while(rs.next()) {
				 c1.add(rs.getString("numb"));
			 }
	     }catch(Exception e) {}
		 c1.setBounds(150, 80, 150, 25);
		 add(c1);
		
		JLabel l3=new JLabel("Room Number");
		l3.setBounds(30, 120, 100, 30);
		add(l3);
		
		 t1=new JTextField();
		 t1.setBounds(150, 120, 150, 25);
		 add(t1);
		
		 
		 b1=new JButton("CheckOut");
			b1.setBackground(Color.BLACK);
			b1.setForeground(Color.WHITE);
			b1.setBounds(30, 200, 120, 30);
			b1.addActionListener(this);
			add(b1);
			
			b2=new JButton("Back");
			b2.setBackground(Color.BLACK);
			b2.setForeground(Color.WHITE);
			b2.setBounds(170, 200, 100, 30);
			b2.addActionListener(this);
			add(b2);
			
			ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem/icons/tick.png"));
			Image i2=i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
			ImageIcon i3=new ImageIcon(i2);
			 b3=new JButton(i3);
			b3.setBounds(310, 80, 20, 20);
			b3.addActionListener(this);
			add(b3);
			
			ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem/icons/sixth.jpg"));
			Image i4=i.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
			ImageIcon i5=new ImageIcon(i4);
			JLabel l=new JLabel(i5);
			l.setBounds(350, 0, 400, 250);
			add(l);
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		setBounds(400, 250, 800, 300);
		setVisible(true);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		conn c=new conn();
		if(e.getSource()==b1) {
			
			String id=c1.getSelectedItem();
			String r1=t1.getText();
			String str="delete from customer where numb='"+id+"'";
			String str1="update room set available='Available' where room_number='"+r1+"'";
			
			try {
				c.s.executeUpdate(str);
				c.s.executeUpdate(str1);
				JOptionPane.showMessageDialog(null, "checkout Done");
				new Reception().setVisible(true);
				this.setVisible(false);
						
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else if(e.getSource()==b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}else if(e.getSource()==b3) {
			
			try {
				String id=c1.getSelectedItem();
				ResultSet rs= c.s.executeQuery("select * from customer where numb= '"+id+"'");
				while(rs.next()) {
					t1.setText(rs.getString("room"));
					
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		
	}



	public static void main(String[] args) {
		new CheckOut().setVisible(true);
	}

}
