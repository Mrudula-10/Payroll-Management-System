package connection;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class login_page extends JFrame implements ActionListener{
 
    JLabel l1,l2,l3;  //username password image   //label for button
    JButton btn1,btn2; //for login cancel
    JTextField tf1;   //for username 
    JPasswordField pf;  //for password
    JPanel p1;   // one to store image and one to store all above buttons,etc 
    Font f;
    
    login_page()
    {
        super("login page"); //super("title for main panel
        setSize(380,180);
        setLocation(500,200);
        setResizable(false);
        
        f=new Font("arial",Font.BOLD,14);
        
        l1=new JLabel("Username"); //obj creation of Jlabel
        l2=new JLabel("Password");
        
        l1.setFont(f);
        l2.setFont(f);
        
        btn1=new JButton("Login");
        btn2=new JButton("Cancel");
        btn1.setBackground(Color.BLACK);
       btn1.setForeground(Color.WHITE);
        btn2.setBackground(Color.BLACK);
       btn2.setForeground(Color.WHITE);
       
        tf1=new JTextField();
        tf1.setFont(f);
        pf=new JPasswordField();
        pf.setFont(f);
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn1.setFont(f);
        btn2.setFont(f);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(3,2,10,10)); //rows,columns,space b/w rows,space b/w columns
        
        p1.add(l1);
        p1.add(tf1);
        p1.add(l2);
        p1.add(pf);
        p1.add(btn1);
        p1.add(btn2);
        
       // ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("payroll_project/icons/login 2.png"));
       // Image image=img.getImage().getScaledInstance(120,120,Image.SCALE_DEFAULT);
       // ImageIcon img1=new ImageIcon(image);
       // l3=new JLabel(img1);
        
        setLayout(new BorderLayout(30,30));
        
        //add(l3,"West");
        add(p1,"Center");
    }
        
        public void actionPerformed(ActionEvent e)
        {
        if(e.getSource()==btn1)
        {
            
          String u_name=tf1.getText();
          String p_name=pf.getText();
          try{
              connectionclass obj=new connectionclass();
              String q="select * from login where username='"+u_name+"'and password='"+p_name+"'";
              ResultSet res=obj.stm.executeQuery(q);
              if(res.next()){
                  new home_page().setVisible(true);
                  this.setVisible(false);
              }
              else{
                  JOptionPane.showMessageDialog(null,"invalid username or password");
                  this.setVisible(false);
                  
    }
}
          catch(Exception ex){
              ex.printStackTrace();
}
        }
        if(e.getSource()==btn2)
        {
            JOptionPane.showMessageDialog(null,"Are you sure");
            setVisible(false);
        }
        }
        public static void main(String[]args)
        {
            new login_page().setVisible(true);
        }
        }