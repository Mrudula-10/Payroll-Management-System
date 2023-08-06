package connection;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class new_employee extends JFrame implements ActionListener {
     JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    Choice ch1;
    JButton btn1,btn2;
    JPanel p1;
    Font f;
    
    new_employee()
    {
      super("Add New Employee");
      setSize(740,447);
      setLocation(70,70);
      setResizable(false);
      
      f=new Font("Arial",Font.BOLD,14);
      
      l1=new JLabel("Name");
      l2=new JLabel("Gender");
      l3=new JLabel("Address");
      l4=new JLabel("State");
      l5=new JLabel("City");
      l6=new JLabel("Email");
      l7=new JLabel("Phone");
      l8=new JLabel("Employee Id");
 
      l1.setFont(f);
      l2.setFont(f);
      l3.setFont(f);
      l4.setFont(f);
      l5.setFont(f);
      l6.setFont(f);
      l7.setFont(f);
      l8.setFont(f);
      
      t1=new JTextField();
      t2=new JTextField();
      t3=new JTextField();
      t4=new JTextField();
      t5=new JTextField();
      t6=new JTextField();
      t7=new JTextField();
      
      t1.setFont(f);
      t2.setFont(f);
      t3.setFont(f);
      t4.setFont(f);
      t5.setFont(f);
      t6.setFont(f);
      t7.setFont(f);
      
      ch1=new Choice();
      ch1.add("Male");
      ch1.add("Female");
      
      ch1.setFont(f);
      
      btn1=new JButton("Submit");
      btn2=new JButton("Close");
      
      btn1.setFont(f);
      btn2.setFont(f);
      
      btn1.setBackground(Color.BLACK);
      btn1.setForeground(Color.WHITE);
      btn2.setBackground(Color.BLACK);
      btn2.setForeground(Color.WHITE);
      
      btn1.addActionListener(this);
      btn2.addActionListener(this);
      
      p1=new JPanel();
      p1.setLayout(new GridLayout(9,2,5,5));
      p1.add(l1);
      p1.add(t1);
      p1.add(l2);
      p1.add(ch1);
      p1.add(l3);
      p1.add(t2);
      p1.add(l4);
      p1.add(t3);
      p1.add(l5);
      p1.add(t4);
      p1.add(l6);
      p1.add(t5);
      p1.add(l7);
      p1.add(t6);
      p1.add(l8);
      p1.add(t7);
      p1.add(btn1);
      p1.add(btn1); 
      
      setLayout(new GridLayout(1,1,10,10));
      add(p1,"Center");
}
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btn1)
        {
            String name=t1.getText();
            String gender=ch1.getSelectedItem();
            String address=t2.getText();
            String state=t3.getText();
            String city=t4.getText();
            String email=t5.getText();
            String phone=t6.getText();
            int eid=Integer.parseInt(t7.getText());
            try
            {
                connectionclass obj=new connectionclass();
                String q="insert into new_employee values('"+eid+"','"+name+"','"+gender+"','"+address+"','"+state+"','"+city+"','"+email+"','"+phone+"')";
                obj.stm.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Record");
                setVisible(false);
            }
            catch(Exception ex)
            {
                ex.printStackTrace();
            }
        }
            if(e.getSource()==btn2)
            {
                JOptionPane.showMessageDialog(rootPane, "Are you sure");
                setVisible(false);
            }
        }
    public static void main(String[]args)
    {
        new new_employee().setVisible(true);
    }
}

