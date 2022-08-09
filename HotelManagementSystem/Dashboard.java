package HotelManagementSystem;
import java.awt.*;


import javax.swing.*;
import java.awt.event.*;


public class Dashboard extends JFrame implements ActionListener{
             
	JMenuBar mb;
	JMenu m1,m2;
	JMenuItem i1,i2,i3,i4;
	
	
	
	public Dashboard() {
		mb=new JMenuBar();
		add(mb);
		
		m1=new JMenu("Hotel Management");
		m1.setForeground(Color.RED);
		mb.add(m1);
		
		m2=new JMenu("Admin");
		m2.setForeground(Color.BLUE);
		mb.add(m2);
		
		i1=new JMenuItem("RECEPTION");
		i1.addActionListener(this);
		m1.add(i1);
		
		i2=new JMenuItem("ADD EMPLOYEE");
		i2.addActionListener(this);
		m2.add(i2);
		
		i3=new JMenuItem("ADD ROOMS");
		i3.addActionListener(this);
		m2.add(i3);
		
		i4=new JMenuItem("ADD DRIVERS");
		i4.addActionListener(this);
		m2.add(i4);
		
		mb.setBounds(0, 0, 1950, 30);
		
		ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem/icons/third.jpg"));
		Image i2=i1.getImage().getScaledInstance(1900, 1000, Image.SCALE_DEFAULT);
		ImageIcon i3=new ImageIcon(i2);
		JLabel l1=new JLabel(i3);
		l1.setBounds(0, 0, 1900, 1000);
		add(l1);
		
		JLabel l2=new JLabel("Hotel Blue Diamond Welcomes you");
		l2.setBounds(500, 80, 1000, 50);
		l2.setForeground(Color.WHITE);
		l2.setFont(new Font("Tahoma",Font.PLAIN,40));
		l1.add(l2);
		
		
		setLayout(null);
		setBounds(0, 0, 1950, 1000);
		setVisible(true);
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("RECEPTION")){
			new Reception().setVisible(true);
			
		}else if(e.getActionCommand().equals("ADD EMPLOYEE")) {
			new AddEmployee().setVisible(true);
		}else if(e.getActionCommand().equals("ADD ROOMS")) {
			new AddRooms().setVisible(true);
		}else if(e.getActionCommand().equals("ADD DRIVERS")) {
			new AddDriver().setVisible(true);
		}
		
	}



	public static void main(String[] args) {
		new Dashboard().setVisible(true);
	}
}
