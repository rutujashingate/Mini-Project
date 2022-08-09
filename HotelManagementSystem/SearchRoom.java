package HotelManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

import javax.swing.*;

import net.proteanit.sql.DbUtils;



public class SearchRoom extends JFrame implements ActionListener {
	
	JComboBox c1;
	JCheckBox c2;
	JButton b1,b2;
	JTable t1;
	
	 SearchRoom() {
		
		 JLabel l1=new JLabel("Search For Room");
			l1.setBounds(400, 30, 200, 30);
			//l1.setForeground(Color.DARK_GRAY);
			l1.setFont(new Font("Tahoma",Font.PLAIN,20));
			add(l1);
			
			JLabel l2=new JLabel("Room Bed Type");
			l2.setBounds(50, 100, 100, 20);
			add(l2);
			
			c1= new JComboBox(new String[] {"Single Bed","Double Bed"});
			c1.setBounds(150, 100, 150, 25);
			
			add(c1);
		 
			
		   c2=new JCheckBox("Only Display Available");
		   c2.setBounds(650,100,150,25);
		   add(c2);
		 
		 
		 t1=new JTable();
		 t1.setBounds(0, 200, 1000, 300);
		 add(t1);
		 
		 b1=new JButton("Submit");
			b1.setBackground(Color.BLACK);
			b1.setForeground(Color.WHITE);
			b1.setBounds(300, 520, 120, 30);
			b1.addActionListener(this);
			add(b1);
			
			b2=new JButton("Back");
			b2.setBackground(Color.BLACK);
			b2.setForeground(Color.WHITE);
			b2.setBounds(500, 520, 100, 30);
			b2.addActionListener(this);
			add(b2);
			
			
			JLabel l3=new JLabel("Room Number");
			l3.setBounds(50, 160, 100, 20);
			add(l3);
			
			JLabel l4=new JLabel("Availability");
			l4.setBounds(270, 160, 100, 20);
			add(l4);
			
			JLabel l5=new JLabel("Cleaning Status");
			l5.setBounds(450, 160, 100, 20);
			add(l5);
			
			JLabel l6=new JLabel("Price");
			l6.setBounds(670, 160, 100, 20);
			add(l6);
			
			JLabel l7=new JLabel("Bed Type");
			l7.setBounds(870, 160, 100, 20);
			add(l7);
		 
		 setLayout(null);
		 setBounds(350,200,1000,600);
		 setVisible(true);
		 
		 getContentPane().setBackground(Color.WHITE);
		 
		 
	}
	 
	 
	 
	 @Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			try {
				conn c= new conn();
				
				String str="select * from room where bed_type='"+c1.getSelectedItem()+"'";
				String str1="select * from room where available='available' and bed_type='"+c1.getSelectedItem()+"'";
				ResultSet rs=c.s.executeQuery(str);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
				
				if(c2.isSelected()) {
					ResultSet rst=c.s.executeQuery(str1);
					t1.setModel(DbUtils.resultSetToTableModel(rst));
					
				}
			}
			
		catch(Exception e1) {}
	 }
		else if(e.getSource()==b2) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
		
	}



	public static void main(String[] args) {
		new SearchRoom().setVisible(true);
	}

}
