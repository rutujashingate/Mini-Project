package HotelManagementSystem;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class AddDriver extends JFrame implements ActionListener {
	
	TextField t1,t2,t3,t4,t5;
	JComboBox c1 , c2;
	JButton b1,b2;
	
	public AddDriver() {
		
		JLabel title=new JLabel("ADD DRIVERS");
		title.setBounds(150,10,150,30);
		title.setFont(new Font("Tahoma",Font.BOLD,10));
		add(title);
		
		JLabel name = new JLabel("Name");
		name.setForeground(new Color(25, 25, 112));
		name.setFont(new Font("Tahoma", Font.PLAIN, 14));
		name.setBounds(60, 70, 100, 30);
		add(name);
		
		t1=new TextField();
		t1.setBounds(200,70,150,30);
		add(t1);
		

		JLabel age = new JLabel("Age");
		//name.setForeground(new Color(25, 25, 112));
		age.setFont(new Font("Tahoma", Font.PLAIN, 14));
		age.setBounds(60, 110, 100, 30);
		add(age);
		
		t2=new TextField();
		t2.setBounds(200, 110, 150, 30);
		add(t2);
		

		JLabel gender= new JLabel("Gender");
		//name.setForeground(new Color(25, 25, 112));
		gender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gender.setBounds(60, 150, 100, 30);
		add(gender);
		
		c1=new JComboBox(new String[] {"Male","Female"});
		c1.setBounds(200, 150, 150, 30);
		c1.setBackground(Color.WHITE);
		add(c1);
		
		

		JLabel car = new JLabel("Car Company");
		//car.setForeground(new Color(25, 25, 112));
		car.setFont(new Font("Tahoma", Font.PLAIN, 14));
		car.setBounds(60, 190, 100, 30);
		add(car);
		
		t3=new TextField();
		t3.setBounds(200, 190, 150, 30);
		add(t3);
		
		

		JLabel model = new JLabel("Car Model");
		//name.setForeground(new Color(25, 25, 112));
		model.setFont(new Font("Tahoma", Font.PLAIN, 14));
		model.setBounds(60, 230, 100, 30);
		add(model);
		
		t4=new TextField();
		t4.setBounds(200, 230, 150, 30);
		add(t4);
		
		

		JLabel available= new JLabel("Available");
		//name.setForeground(new Color(25, 25, 112));
		available.setFont(new Font("Tahoma", Font.PLAIN, 14));
		available.setBounds(60, 270, 100, 30);
		add(available);
		
		c2=new JComboBox(new String[] {"Available","Busy"});
		c2.setBounds(200,270,150,30);
		c2.setBackground(Color.WHITE);
		add(c2);
		
		

		JLabel location = new JLabel("Location");
		//name.setForeground(new Color(25, 25, 112));
		location.setFont(new Font("Tahoma", Font.PLAIN, 14));
		location.setBounds(60, 310, 100, 30);
		add(location);
		
		t5=new TextField();
		t5.setBounds(200, 310, 150, 30);
		add(t5);
		
		b1=new JButton("Add Driver");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		b1.setBounds(60, 370, 130, 30);
		add(b1);
		
		b2=new JButton("Cancel");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		b2.setBounds(200, 370, 130, 30);
		add(b2);
		
		 ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem/icons/eleven.jpg"));
		 Image i2=i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		 ImageIcon i3=new ImageIcon(i2);
		 JLabel l1=new JLabel(i3);
		 l1.setBounds(400,80,500,300);
		 add(l1);
      
         
         
		
		getContentPane().setBackground(Color.WHITE);
		
		setLayout(null);
		setBounds(350, 200, 970, 470);
		setVisible(true);
		
		
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	      if(e.getSource()==b1) {
	    	  
	    	  String name = t1.getText();
              String age = t2.getText();
              String gender = (String)c1.getSelectedItem();
              String car  = t3.getText();
              String model= t4.getText();
              String available = (String)c2.getSelectedItem();
              String location = t5.getText();
              
              conn c=new conn();
              
              String str = "INSERT INTO driver values( '"+name+"', '"+age+"', '"+gender+"','"+car+"', '"+model+"', '"+available+"','"+location+"')";
	    	  try {
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "Driver successfully Added");
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	  
	      }else if(e.getSource()==b2) {
	    	  setVisible(false);
	    	  
	      }
		
	}



	public static void main(String[] args) {
		new AddDriver().setVisible(true);;
	}
	

}
