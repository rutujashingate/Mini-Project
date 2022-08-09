package HotelManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;

public class UpdateRoom extends JFrame implements ActionListener {
	JTextField t1,t2,t3;
	Choice c1;
	JButton b1,b2,b3;
	
     UpdateRoom() {
    	 
    	 JLabel l1=new JLabel("Update Room Status");
    	 l1.setBounds(30, 20, 250, 30);
    	 l1.setFont(new Font("Tahoma",Font.PLAIN,20));
    	 add(l1);
    	 
    	 JLabel l2=new JLabel("Guest Id");
    	 l2.setBounds(30, 80, 120, 20);
    	 add(l2);
    	 
    	 c1=new Choice();
    	 try
    	 {
    		 conn c=new conn();
    		 ResultSet rs=c.s.executeQuery("select * from customer");
    		 while(rs.next()) {
    			 c1.add(rs.getString("numb"));
    		 }
    		 
    	 }catch(Exception e) {}
    	 c1.setBounds(200,80,150,25);
    	 add(c1);
    	 
    	 JLabel l3=new JLabel("Room No");
    	 l3.setBounds(30, 130, 120, 30);
		add(l3);
		
		t1=new JTextField();
		t1.setBounds(200, 130, 150, 25);
		add(t1);
		
		
		JLabel l4=new JLabel("Availability");
   	    l4.setBounds(30, 180, 120, 30);
		add(l4);
		
		t2=new JTextField();
		t2.setBounds(200, 180, 150, 25);
		add(t2);
		
		
		JLabel l5=new JLabel("Clean Status");
   	    l5.setBounds(30, 230, 120, 30);
		add(l5);
		
		t3=new JTextField();
		t3.setBounds(200, 230, 150, 25);
		add(t3);
		
		b1=new JButton("Check");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(120, 300, 120, 30);
		b1.addActionListener(this);
		add(b1);
		
		b2=new JButton("Update");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(40, 350, 120, 30);
		b2.addActionListener(this);
		add(b2);
		
		b3=new JButton("Back");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setBounds(210, 350, 120, 30);
		b3.addActionListener(this);
		add(b3);
		
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l = new JLabel(i3);
        l.setBounds(400,10,500,400);
        add(l);
		
		
		
		setLayout(null);
		setBounds(350, 200, 980, 450);
		setVisible(true);
		
		getContentPane().setBackground(Color.WHITE);
	}
     

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b1) {
			String r1=null;
			
			try {
				String s1=c1.getSelectedItem();
				conn c=new conn();
				ResultSet rst=c.s.executeQuery("select * from customer where numb='"+s1+"'");
				while(rst.next()) {
					t1.setText(rst.getString("room"));
					r1=rst.getString("room");
				}
				
				ResultSet rst1=c.s.executeQuery("select * from room where room_number='"+r1+"'");
				while(rst1.next()) {
					t2.setText(rst1.getString("available"));
					t3.setText(rst1.getString("status"));
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
					
		}
		else if(e.getSource()==b2) {
			try {
				conn c=new conn();
				String r1=t1.getText();
				String available = t2.getText();
				String status = t3.getText();
				
				String str="update room set available ='"+available+"', status='"+status+"' where room_number='"+r1+"'"  ;
				c.s.executeQuery(str);
				JOptionPane.showMessageDialog(null, "Room Updated Successfully");
				new Reception().setVisible(true);
				this.setVisible(false);
				
			}catch(Exception e2) {}
		}
		else if(e.getSource()==b3) {
			new Reception().setVisible(true);
			this.setVisible(false);
		}
		
	}


	public static void main(String[] args) {
          new UpdateRoom().setVisible(true);

	}

}
