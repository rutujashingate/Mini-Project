package HotelManagementSystem;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;

public class AddEmployee extends JFrame implements ActionListener{ //Third Frame

    
	JTextField t1,t2,t3,t4,t5,t6;
        JComboBox c1;
        JRadioButton r1,r2;
        JButton b1;

        public AddEmployee(){
        	
           //NAME
           JLabel name=new JLabel("NAME");
           name.setFont(new Font("Tahoma",Font.PLAIN,17));
           name.setBounds(60,30,120,30);
           add(name);
           
           t1=new JTextField();
           t1.setBounds(200, 30, 150, 30);
           add(t1);
           
           
           //AGE
           JLabel age=new JLabel("AGE");
           age.setFont(new Font("Tahoma",Font.PLAIN,17));
           age.setBounds(60,80,120,30);
           add(age);
           
           t2=new JTextField();
           t2.setBounds(200, 80, 150, 30);
           add(t2);
           
           
           //GENDER
           JLabel gender=new JLabel("GENDER");
           gender.setFont(new Font("Tahoma",Font.PLAIN,17));
           gender.setBounds(60,130,120,30);
           add(gender);
           
           r1=new JRadioButton("Male");
           r1.setFont(new Font("Tahoma",Font.PLAIN,14));
           r1.setBounds(200, 130, 70, 30);
           r1.setBackground(Color.WHITE);
           add(r1);
           
           r2=new JRadioButton("Female");
           r2.setFont(new Font("Tahoma",Font.PLAIN,14));
           r2.setBounds(270, 130, 70, 30);
           r2.setBackground(Color.WHITE);
           add(r2);
           
           
           //JOB
           JLabel job=new JLabel("JOB");
           job.setFont(new Font("Tahoma",Font.PLAIN,17));
           job.setBounds(60,180,120,30);
           add(job);
           
           String str[]= {"Front Desk Clerks","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
           c1=new JComboBox(str);       
           c1.setBounds(200, 180, 150, 30);
           c1.setBackground(Color.WHITE);
           add(c1);
           
           //SALARY
           JLabel sal=new JLabel("SALARY");
           sal.setFont(new Font("Tahoma",Font.PLAIN,17));
           sal.setBounds(60,230,120,30);
           add(sal);
           
           t3=new JTextField();
           t3.setBounds(200, 230, 150, 30);
           add(t3);
           
           
           //PHONE
           JLabel phn=new JLabel("PHONE");
           phn.setFont(new Font("Tahoma",Font.PLAIN,17));
           phn.setBounds(60,280,120,30);
           add(phn);
           
           t4=new JTextField();
           t4.setBounds(200, 280, 150, 30);
           add(t4);
           
           //AADHAR
           JLabel adhar=new JLabel("AADHAR");
           adhar.setFont(new Font("Tahoma",Font.PLAIN,17));
           adhar.setBounds(60,330,120,30);
           add(adhar);
           
           t5=new JTextField();
           t5.setBounds(200, 330, 150, 30);
           add(t5);
           
           //EMAIL
           JLabel email=new JLabel("EMAIL");
           email.setFont(new Font("Tahoma",Font.PLAIN,17));
           email.setBounds(60,380,120,30);
           add(email);
           
           t6=new JTextField();
           t6.setBounds(200, 380, 150, 30);
           add(t6);
           
           b1 =new JButton("Submit");
           b1.setBackground(Color.BLACK);
           b1.setForeground(Color.WHITE);
           b1.setBounds(200, 430, 150, 30);
           b1.addActionListener(this);
           add(b1);
           
           //IMAGE
           ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("HotelManagementSystem/icons/tenth.jpg"));
           Image i2=i1.getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT);
           ImageIcon i3=new ImageIcon(i2);
           
           JLabel l1=new JLabel(i3);
           l1.setBounds(380, 60, 450, 450);
           add(l1);
           
           //LABEL
           JLabel l2=new JLabel("ADD EMPLOYEE DETAILS");
           l2.setForeground(Color.BLACK);
           l2.setBounds(420, 30, 400, 30);
           l2.setFont(new Font("Tahoma",Font.PLAIN,30));
           add(l2);
           
           
           
           getContentPane().setBackground(Color.WHITE);
           setLayout(null);
           setBounds(380, 200, 850, 530);
           setVisible(true);
        }
        
        
    @Override
		public void actionPerformed(ActionEvent e) {
    	 String name = t1.getText();
         String age = t2.getText();
         String sal = t3.getText();
         String phn = t4.getText();
         String adhar = t5.getText();
         String email = t6.getText();
         
         String gender=null;
         
         if(r1.isSelected()) {
        	 gender="Male";
         }else if(r2.isSelected())
         {
        	 gender="Female";
         }
         
         String job = (String)c1.getSelectedItem();
         
         
             try {
				conn c = new conn();
				 String str = "INSERT INTO employee values( '"+name+"', '"+age+"', '"+gender+"','"+job+"', '"+sal+"', '"+phn+"','"+adhar+"', '"+email+"')";
				 
				 c.s.executeUpdate(str);
				 JOptionPane.showMessageDialog(null,"Employee Added");
				 this.setVisible(false);
			} catch (HeadlessException e1) {
				
				e1.printStackTrace();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
         
       
			
		}


	public static void main(String[] args){
        new AddEmployee();
    }   
}
