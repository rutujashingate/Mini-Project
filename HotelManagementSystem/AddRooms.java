package HotelManagementSystem;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class AddRooms extends JFrame implements ActionListener {
	
	JTextField t1,t2;
	JComboBox c1,c2,c3;
	JButton b1,b2;
	
	AddRooms(){
		
		//LABEL ADD ROOMS
		JLabel l1=new JLabel("ADD ROOMS");
		l1.setFont(new Font("Tahoma", Font.BOLD,18));
		l1.setBounds(130, 20, 140, 20);
		add(l1);
		
		//ROOM NUMBER
		JLabel room=new JLabel("Room Number");
		room.setFont(new Font("Tahoma",Font.PLAIN,16));
		room.setBounds(60, 80, 120, 30);
		add(room);
		
		t1=new JTextField();
		t1.setBounds(200, 80, 150, 30);
		add(t1);
			
		//AVAILABLE
		JLabel available=new JLabel("Available");
		available.setFont(new Font("Tahoma",Font.PLAIN,16));
		available.setBounds(60, 130, 120, 30);
		add(available);
		
		c1=new JComboBox(new String[] { "Available", "Occupied" });
		c1.setBounds(200, 130, 150, 30);
		c1.setBackground(Color.WHITE);
		add(c1);
		
		
		//CLEANING STATUS
		JLabel status=new JLabel("Cleaning Status");
		status.setFont(new Font("Tahoma",Font.PLAIN,16));
		status.setBounds(60, 180, 120, 30);
		add(status);
		
		c2 = new JComboBox(new String[] { "Cleaned", "Dirty" });
		c2.setBounds(200, 180, 150 ,30);
		c2.setBackground(Color.WHITE);
		add(c2);
		
        //PRICE
		JLabel price=new JLabel("Price");
		price.setFont(new Font("Tahoma",Font.PLAIN,16));
		price.setBounds(60, 230, 120, 30);
		add(price);
		
		t2=new JTextField();
		t2.setBounds(200, 230, 150, 30);
		add(t2);
		
		//BED TYPE
		JLabel type=new JLabel("Bed Type");
		type.setFont(new Font("Tahoma",Font.PLAIN,16));
		type.setBounds(60, 280, 120, 30);
		add(type);
		
		c3 = new JComboBox(new String[] { "Single Bed", "Double Bed"});
		c3.setBounds(200, 280, 150, 30);
		c3.setBackground(Color.WHITE);
		add(c3);
		
		//BUTTON ADD ROOM
		b1=new JButton("Add Room");
		b1.setBounds(60, 350, 130, 30);
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		add(b1);
		
		//BUTTON CANCEL
		b2=new JButton("Cancel");
		b2.setBounds(220, 350, 130, 30);
		b2.addActionListener(this);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		add(b2);
		
		//Image
		ImageIcon i1  = new ImageIcon(ClassLoader.getSystemResource("hotelmanagementsystem/icons/twelve.jpg"));
        Image i3 = i1.getImage().getScaledInstance(500, 300,Image.SCALE_DEFAULT);
        ImageIcon i2 = new ImageIcon(i3);
        JLabel l5 = new JLabel(i2);
        l5.setBounds(400,30,500,350);
        add(l5);
		
		getContentPane().setBackground(Color.WHITE);
		
		setBounds(350,200,940,470);
		setLayout(null);
		setVisible(true);
	}
       
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		try {
		if(e.getSource() == b1){
            try{
            conn c = new conn();
            String room = t1.getText();
            String available = (String)c1.getSelectedItem();
            String status = (String)c2.getSelectedItem();
            String price  = t2.getText();
            String type = (String)c3.getSelectedItem();
            String str = "INSERT INTO room values( '"+room+"', '"+available+"', '"+status+"','"+price+"', '"+type+"')";
          
            
	c.s.executeUpdate(str);
	JOptionPane.showMessageDialog(null, "Room Successfully Added");
            this.setVisible(false);
           
            }catch(Exception ee){
                System.out.println(ee);
            }
        }
        else if(e.getSource() == b2){
            this.setVisible(false);
        }
    }catch(Exception eee){
        
    }
		
	}



	public static void main(String[] args) {
		new AddRooms().setVisible(true);
	}
	
}
