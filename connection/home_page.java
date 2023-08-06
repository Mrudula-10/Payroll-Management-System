package connection;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class home_page extends JFrame implements ActionListener {
    JLabel l1;
    Font f;
    home_page()
    {
      super("Home Page");
      setSize(1000,690);
      setLocation(1,1);
      
      f=new Font("arial",Font.BOLD,14);
      
      JMenuBar mb=new JMenuBar();
      JMenu m1=new JMenu("Employee");
      JMenu m2=new JMenu("Attendence");
      JMenu m3=new JMenu("Payslip");
      JMenu m4=new JMenu("Exit");
      
      m1.setFont(f);
      m2.setFont(f);
      m3.setFont(f);
      m4.setFont(f);
      
      JMenuItem mt1=new JMenuItem("New Employee");
      mt1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));
      mt1.addActionListener(this);
      
      JMenuItem mt2=new JMenuItem("Salary");
      mt2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));
      mt2.addActionListener(this);
      
      JMenuItem mt3=new JMenuItem("List Employee");
      mt3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));
      mt3.addActionListener(this);
      
      //JMenuItem mt4=new JMenuItem("Update Employee");
      //mt4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));
      //mt4.addActionListener(this);
      
      //JMenuItem mt5=new JMenuItem("Update Salary");
      //mt5.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));
      //mt5.addActionListener(this);
      
      JMenuItem mt6=new JMenuItem("Take Attendance");
      mt6.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));
      mt6.addActionListener(this);
      
      JMenuItem mt7=new JMenuItem("List Attendance");
      mt7.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));
      mt7.addActionListener(this);
      
      JMenuItem mt8=new JMenuItem("Generate Payslip");
      mt8.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));
      mt8.addActionListener(this);
      
      JMenuItem mt9=new JMenuItem("Exit");
      mt9.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y,ActionEvent.CTRL_MASK));
      mt9.addActionListener(this);
      
      mt1.setFont(f);
      mt2.setFont(f);
      mt3.setFont(f);
      //mt4.setFont(f);
      //mt5.setFont(f);
      mt6.setFont(f);
      mt7.setFont(f);
      mt8.setFont(f);
      mt9.setFont(f);
      
      m1.add(mt1);
      m1.add(mt2);
      m1.add(mt3);
      
      m2.add(mt6);
      m2.add(mt7);
      
      m3.add(mt8);
      
      m4.add(mt9);
      
      mb.add(m1);
      mb.add(m2);
      mb.add(m3);
      mb.add(m4);
      
      ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("connection/icons/home.png"));
      Image i2=i1.getImage().getScaledInstance(1000, 600, Image.SCALE_DEFAULT);
      ImageIcon i3=new ImageIcon(i2);
      l1=new JLabel(i3);
      
      setJMenuBar(mb);
      add(l1);
      
      
}
    public void actionPerformed(ActionEvent e){
        
       String comnd=e.getActionCommand();
       if(comnd.equals("New Employee"))
       {
           new new_employee().setVisible(true);
       }
       else if(comnd.equals("Salary"))
       {
           new salary().setVisible(true);
       }
       else if(comnd.equals("List Employee"))
       {
           new list_employee().setVisible(true);
       }
       //else if(comnd.equals("Update Employee"))
       //{
         //  new update_employee().setVisible(true);
       //}
       //else if(comnd.equals("Update Salary"))
       //{
        //   new update_salary().setVisible(true);
       //}
       else if(comnd.equals("Take Attendance"))
       {
           new take_attendance().setVisible(true);
       }
       else if(comnd.equals("List Attendance"))
       {
           new list_attendance().setVisible(true);
       }
       else if(comnd.equals("Generate Payslip"))
       {
           new generate_payslip().setVisible(true);
       }
       else if(comnd.equals("Exit"))
       {
           System.exit(0);
       }
       else
       {
           JOptionPane.showMessageDialog(null,"sorry you pressed wrong button");
           setVisible(false);
       }
    }
    public static void main(String[]args)
    {
        new home_page().setVisible(true);
    }
    }
